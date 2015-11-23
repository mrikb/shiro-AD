package com.cidx.rest.dto;

public class Person {
	private String username;
	private String password;
	private String code;
	public Person() {
		
	}
	public Person(String username, String password, String code) {
		this.setUsername(username);
		this.setPassword(password);
		this.setCode(code);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return new StringBuffer(" Username : ").append(this.username).toString();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
