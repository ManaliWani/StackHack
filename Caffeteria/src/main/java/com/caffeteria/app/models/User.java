package com.caffeteria.app.models;

import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(
		name = "users",
		uniqueConstraints = {
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email")
		})
public class User {

	//ONly name, email and password storing currently later 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;
	
	@NotBlank
	@Size(max=20)
	private String organization;
	
	@NotNull
	private Long empid;
	
	@NotBlank
	@Size(max=11)
	private String mobileno;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 120)
	private String password;
	

	
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
				name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id")
			  )
	private Set<Role> roles = new HashSet<>();

	//Default const
	public User() {}
	
	// Constructor
	public User(String username, String organization,Long empid, String mobileno,String email, String password) {
		super();
		this.username = username;
		this.organization = organization;
		this.empid = empid;
		this.mobileno = mobileno;
		this.email = email;
		this.password = password;
	}

	/*//Constructor
	public User(String username,String email,String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}*/

	
	
	//Getters and Setters
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
	
	
	
}
