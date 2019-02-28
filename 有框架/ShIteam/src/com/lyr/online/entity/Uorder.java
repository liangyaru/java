package com.lyr.online.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="uorder")
public class Uorder {
	private int onum;
	private String time;
	private String user ;
	private String tel;
	private String address;
	private String state;
	private Set<Cake> childcake = new HashSet<Cake>();
	@Id
	@GenericGenerator(name="myincre", strategy="increment")
	@GeneratedValue(generator="myincre")
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	@Column(name="time")
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Column(name="user")	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	@Column(name="tel")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="state")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@ManyToMany
	@JoinTable(name="orderdetails", 
	    joinColumns=@JoinColumn(name="onum"),
	    inverseJoinColumns=@JoinColumn(name="cnum"))
	public Set<Cake> getChildcake() {
		return childcake;
	}
	public void setChildcake(Set<Cake> childcake) {
		this.childcake = childcake;
	}
}
