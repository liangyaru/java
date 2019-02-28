package com.lyr.online.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orderdetails")
public class Orderdetails {
	private int dnum;
	private int onum;
	private int cnum;
	@Id
	@GenericGenerator(name="myincre", strategy="increment")
	@GeneratedValue(generator="myincre")
	public int getDnum() {
		return dnum;
	}
	public void setDnum(int dnum) {
		this.dnum = dnum;
	}
	@Column(name="onum")	
	public int getOnum() {
		return onum;
	}
	public void setOnum(int onum) {
		this.onum = onum;
	}
	@Column(name="cnum")
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
}

