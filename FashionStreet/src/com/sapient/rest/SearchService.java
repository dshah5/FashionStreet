package com.sapient.rest;

import java.net.URISyntaxException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
		 System.out.println("here");
		if (searchText.equalsIgnoreCase("shoes")){
			return "http://localhost:8081/FashionStreet/shoes.jsp";
		} else if (searchText.equalsIgnoreCase("belts")){
			return "http://localhost:8081/FashionStreet/belts.jsp";
		} else if (searchText.equalsIgnoreCase("wallets")){
			return "http://localhost:8081/FashionStreet/wallets.jsp";
		} else if (searchText.equalsIgnoreCase("handbags")){
			return "http://localhost:8081/FashionStreet/handbags.jsp";
		} else if (searchText.equalsIgnoreCase("jewelry")){
			return "http://localhost:8081/FashionStreet/jewelry.jsp";
		} else if (searchText.equalsIgnoreCase("sale")){
			return "http://localhost:8081/FashionStreet/sale.jsp";
		} 
		else return "";
	 }
}