package com.liferay.hackathon.users.web.controller;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.hackathon.users.service.UsersCreatedService;

@Component(immediate = true, service = Application.class)
@ApplicationPath("/users")
public class UsersController extends Application {
	
	// ==============
    // JAX-RS setup
    // ==============

	public Set<Object> getSingletons() {
		return Collections.<Object> singleton(this);
	}
	
	@GET
	@Path("/count")
	@Produces(MediaType.APPLICATION_JSON)
	public String count() {
		String result = usersCreateService.getUsersCount();
		return "{\"message\":\"" + result + "\"}";
	}
	
	// ==============
    // References
    // ==============
	
    @Reference
	public void setUsersCreatedService(UsersCreatedService usersCreateService) {
		this.usersCreateService = usersCreateService;
	}

	private UsersCreatedService usersCreateService;
	

}
