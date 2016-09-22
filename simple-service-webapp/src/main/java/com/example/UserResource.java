package com.example;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.example.pojo.UserDO;
/**
 * An example of returning resource in XML
 * @author zhoum
 *
 */
/*
 *  If it is required that a user name must only consist of lower and upper case numeric characters 
 *  then it is possible to declare a particular regular expression, 
 *  which overrides the default regular expression, "[^/]+"
 *  
 *  A @Path value may or may not begin with a '/', it makes no difference. 
 *  Likewise, by default, a @Path value may or may not end in a '/', 
 *  it makes no difference, and thus request URLs that end or do not end in a '/' will both be matched.
 */
@Path("user/{username: [a-zA-Z][a-zA-Z_0-9]*}")
public class UserResource {
	
	/**
	 * Getting a user's information
	 * URL example: http://0.0.0.0:8080/webapi/user/mizhou?age=26&hobbies=badminton&hobbies=swimming
	 * @param userName
	 * @param age
	 * @param hobbies
	 * @return
	 */
	@GET
	@Consumes("text/plain")
	@Produces({"application/xml"})
	public UserDO getUser(@DefaultValue("willy") @PathParam("username") String userName, @DefaultValue("18") @QueryParam("age") int age, @QueryParam("hobbies") List<String> hobbies) {
		UserDO userDO = new UserDO();
		userDO.setName(userName);
		userDO.setAge(age);
		userDO.setId((long) 11111);
		userDO.setHobbies(hobbies);
		return userDO;
	}
}
