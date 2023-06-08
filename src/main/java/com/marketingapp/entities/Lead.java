package com.marketingapp.entities;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="leads")
public class Lead {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="first_name",nullable =false )
	private String firstName;
	
	@Column(name="last_name",nullable =false )
	private String lastName;
	
	@Column(name="email",nullable =false ,unique = true)
	private String email;
	
	@Column(name="mobile",nullable =false ,unique = true)
	private long mobile;
	
}
