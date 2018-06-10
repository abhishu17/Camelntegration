package com.integration.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.model.Person;
import com.integration.service.ManagerService;
import com.integration.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService ps;
	
	@Autowired
	ManagerService ms;

	@RequestMapping("/version")
	public String getVersion() {
		return ms.getVersion();
	}
	
	@RequestMapping("/start")
	public String start() {		
		try {
			ms.boot();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "exception occured "+ e.getMessage();
		}
		return "camel started";
	}
	
	@RequestMapping("/info")
	public String info() {		
		try {
			ms.information();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "exception occured "+ e.getMessage();
		}
		return "camel started";
	}
	
	@RequestMapping("/all")
	public Hashtable<String, Person> getAll() {
		return ps.getAll();
	}

	@RequestMapping("{id}")
	public Person getPerson(@PathVariable("id") String id) {
		return ps.getPerson(id);
	}
}

