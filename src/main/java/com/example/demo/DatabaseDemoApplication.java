package com.example.demo;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.PersonDao;
import com.example.demo.entity.Person;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonDao personDao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		LOG.info("Person info -> {}", personDao.retriveAll());
		LOG.info("Person by ID info -> {}", personDao.ListById(1001));
		LOG.info("Person by ID info -> {}", personDao.ListByName("NEERAJ"));
		LOG.info("Delete row by id -> {}",personDao.deleteById(1001));
		LOG.info("Insert row  -> {}",personDao.insertPerson(new Person(1007,"Anirudh","USA",new Date())));
		
		LOG.info("Update row  -> {}",personDao.updatePerson(new Person(1002,"SARIKA","USA",new Date())));
	}
}
