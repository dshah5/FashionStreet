package com.sapient.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sun.javafx.webkit.KeyCodeMap.Entry;

public class User {
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Map<String,String> getUsers() {
		Map<String,String> map= new HashMap<String,String>();
		map.put("gunjan", "123");
		map.put("divya", "123");
		map.put("danielle", "123");
		map.put("nimisha","123");
		return map;
	}
	
	public boolean validateLogin(String username,String password) {
		
		
		
	  if(this.getUsers().containsKey(username)&&this.getUsers().containsValue(password)) {
		  
		  return true;
	  }
		
	  else return false;
		
		
		
	}
	

}
