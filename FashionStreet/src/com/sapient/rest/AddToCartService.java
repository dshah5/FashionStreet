package com.sapient.rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/cart")
public class AddToCartService {
	 @PUT
	 @Path("/add")
	 @Produces(MediaType.TEXT_PLAIN)
	 public String addToCart(@QueryParam("price") float price, @QueryParam("name") String name){
		 return "http://localhost:8081/FashionStreet/cart.html";
	 }
}
