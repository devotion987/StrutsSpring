package com.wgy.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wgy.service.PersonService;

@Controller
public class PersonAction {

	@Resource
	PersonService personService;

	public String execute() throws Exception {
		ActionContext.getContext().put("persons", personService.getPersons());
		return "list";
	}
}
