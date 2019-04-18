package com.lyr.online.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="personal")
public class Personal {
	private String email;
	private String first_name;
	private String last_name;
	private String registertime;
	private String password;
	private Set<Uorder> childUorders = new HashSet<Uorder>();
	@Id
	@GenericGenerator(name="myincre", strategy="assigned")
	@GeneratedValue(generator="myincre")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="first_name")	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	@Column(name="last_name")	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	@Column(name="registertime")	
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registime) {
		this.registertime = registime;
	}
	@Column(name="password")	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(mappedBy="user",
			targetEntity=Uorder.class,
			cascade= {CascadeType.REMOVE})
	public Set<Uorder> getChildUorders() {
		return childUorders;
	}
	public void setChildUorders(Set<Uorder> childUorders) {
		this.childUorders = childUorders;
	}
	
}
