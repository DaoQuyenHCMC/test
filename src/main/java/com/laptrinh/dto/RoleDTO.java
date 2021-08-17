package com.laptrinh.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO {

	private List<User> users = new ArrayList<>();
	private String name;
	private String code;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
