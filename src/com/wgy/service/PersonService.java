package com.wgy.service;

import java.util.List;

import com.wgy.entity.Person;

public interface PersonService {

	public void save(Person person);

	public void delete(int id);

	public void update(Person person);

	public Person getPerson(int id);

	public List<Person> getPersons();
}
