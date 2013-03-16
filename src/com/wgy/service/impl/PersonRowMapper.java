package com.wgy.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wgy.entity.Person;

public class PersonRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		return new Person(rs.getInt("ID"), rs.getString("NAME"));
	}

}
