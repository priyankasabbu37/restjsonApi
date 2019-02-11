package com.journaldev.jaxrs.model;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.Produces;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlRootElement;

//import com.fasterxml.jackson.annotation.JsonProperty;


//@XmlRootElement (name="person")
@Consumes(MediaType.APPLICATION_JSON)
public class Person {
	// @JsonProperty("id")
	private int id;
	// @JsonProperty
	private String name;
	// @JsonProperty
	private int age;

	public Person() {
		super();
	}


	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id+"::"+name+"::"+age;
	}

}
