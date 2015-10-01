package com.sapient.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reg")
public class RegisterService {
	 @PUT
	 @Path("/check")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String regCheck(@FormParam("cpassword") String cpassword, @FormParam("password") String password){
		 if (cpassword.equals(password)){
			 if (password.length()<6){
				 return "Password must be 6 characters or more.";
			 } 
			 return "Valid Password";
		 } else {
			 return "Passwords do not match.";
		 }
		
	 }
}
