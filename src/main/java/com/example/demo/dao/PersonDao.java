package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Person;

@Repository
public class PersonDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int arg1) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setBirthDate(rs.getDate("birth_date"));
			person.setLocation(rs.getString("location"));
			return person;
		}

	}

	public List<Person> retriveAll() {
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
		// new BeanPropertyRowMapper<Person>(Person.class));
	}

	public Person ListById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public List<Person> ListByName(String name) {
		return jdbcTemplate.query("select * from person where name=?", new Object[] { name },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id = ?", new Object[] { id });
	}

	public int insertPerson(Person person) {
		return jdbcTemplate.update("insert into person(id,name,location,birth_date) values (?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(), person.getbirthDate() });
	}

	public int updatePerson(Person person) {
		return jdbcTemplate.update("update person set name=?, location=?, birth_date=? where id=?",
				new Object[] { person.getName(), person.getLocation(), person.getbirthDate(), person.getId() });
	}

}
