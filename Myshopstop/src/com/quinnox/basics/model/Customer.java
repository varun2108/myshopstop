package com.quinnox.basics.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Customer {
	private long id;
	private String name,password,email,country;
	public long getId(){
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		/*Base64.Encoder encoder=Base64.getEncoder();
		String normalString=password;
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));*/
		
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String decoder(String password1){
		Base64.Decoder decoder=Base64.getDecoder();
		String decodedString=password1;
		byte[] decodedByteArray = decoder.decode(decodedString);
		return decodedByteArray.toString();
	}
	

}
