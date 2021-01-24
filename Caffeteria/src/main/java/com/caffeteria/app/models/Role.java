package com.caffeteria.app.models;


import javax.persistence.*;


@Entity
@Table(name  = "roles")
public class Role {

	/*
	 * ID - use to indicate primary key (should be java primary datatype or wrapper or BIG)
	 * GeneratedValue = generation strategies for primary key
	 */
	@Id   
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private ERole name;


	//Default Constructor
	public Role() {
		super();
	}

	//Constructor for name
	public Role(ERole name) {
		super();
		this.name = name;
	}

	//Getters and Setters
 	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}
}
