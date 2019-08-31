package com.quinnox.basics.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class LoginModl  {
	String name,password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		/*Base64.Encoder encoder=Base64.getEncoder();
		String normalString=password;
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));*/
		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
