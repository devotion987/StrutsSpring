package com.wgy.service.impl;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wgy.entity.Person;
import com.wgy.service.PersonService;

@Transactional
public class PersonMgr implements PersonService {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void save(Person person) {
		jdbcTemplate.update("insert into TB_PERSON(ID, NAME) values (?, ?)",
				new Object[] { person.getId(), person.getName() }, new int[] {
						Types.INTEGER, Types.VARCHAR });
	}

	public void delete(int id) {
		jdbcTemplate.update("delete from TB_PERSON where ID = ?",
				new Object[] { id }, new int[] { Types.INTEGER });

		throw new RuntimeException("运行期例外！");
	}

	public void update(Person person) {
		jdbcTemplate.update("update TB_PERSON set NAME = ? where ID = ?",
				new Object[] { person.getName(), person.getId() }, new int[] {
						Types.VARCHAR, Types.INTEGER });
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Person getPerson(int id) {
		return (Person) jdbcTemplate.queryForObject(
				"select * from TB_PERSON where ID = ?", new Object[] { id },
				new PersonRowMapper());
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		return jdbcTemplate.query("select * from TB_PERSON",
				new PersonRowMapper());
	}

}
