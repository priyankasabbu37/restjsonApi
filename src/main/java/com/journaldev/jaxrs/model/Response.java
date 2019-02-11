package com.journaldev.jaxrs.model;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlRootElement;
//@XmlRootElement
@Consumes(MediaType.APPLICATION_JSON)
public class Response {

	private boolean status;
	private String message;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
