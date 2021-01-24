package com.caffeteria.app.payload.response;

import java.util.List;

public class JwtResponse {

	//Characteristics
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String organization;
	private Long empid;
	private String mobileno;
	private String email;
	private List<String> roles;
	
	
	/*//COnstructor
	public JwtResponse(String token, Long id, String username, String email, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}*/


	

	public JwtResponse(String token, Long id, String username, String organization, Long empid, String mobileno,
			String email, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.organization = organization;
		this.empid = empid;
		this.mobileno = mobileno;
		this.email = email;
		this.roles = roles;
	}

	public String getToken() {
		return token;
	}

	public String getOrganization() {
		return organization;
	}


	public void setOrganization(String organization) {
		this.organization = organization;
	}


	public Long getEmpid() {
		return empid;
	}


	public void setEmpid(Long empid) {
		this.empid = empid;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}
}
