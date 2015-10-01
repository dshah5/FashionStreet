package com.sapient.rest;

import java.net.URISyntaxException;

import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/search")
public class SearchService {
	 @PUT
	 @Path("/do")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String search(@FormParam("searchText") String searchText){
		if (searchText.equalsIgnoreCase("shoes")){
			return "http://localhost:8081/FashionStreet/shoes.jsp";
		} else if (searchText.equalsIgnoreCase("belts")){
			return "http://localhost:8081/FashionStreet/belts.jsp";
		}
		else return "http://localhost:8081/FashionStreet/register.jsp";
	 }
}