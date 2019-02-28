package com.lyr.online.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="caketype")
public class CakeType {

	private int tnum;
	private String name;
	private int state;
	private Set<CakeType> childTypes = new HashSet<CakeType>();
	private CakeType parentType;
	private Set<Cake> childCakes = new HashSet<Cake>();
	@Id
	@GenericGenerator(name="myincre", strategy="increment")
	@GeneratedValue(generator="myincre")
	public int getTnum() {
		return tnum;
	}
	public void setTnum(int tnum) {
		this.tnum = tnum;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="state")
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@OneToMany(mappedBy="parentType",
			targetEntity=CakeType.class,
			cascade= {CascadeType.REMOVE})
	public Set<CakeType> getChildTypes() {
		return childTypes;
	}
	public void setChildTypes(Set<CakeType> childTypes) {
		this.childTypes = childTypes;
	}
	@ManyToOne()
	@JoinColumn(name="prenum")
	public CakeType getParentType() {
		return parentType;
	}
	public void setParentType(CakeType parentType) {
		this.parentType = parentType;
	}
	@OneToMany(mappedBy="parentType",
			targetEntity=Cake.class,
			cascade= {CascadeType.REMOVE})	
	public Set<Cake> getChildCakes() {
		return childCakes;
	}
	public void setChildCakes(Set<Cake> childCakes) {
		this.childCakes = childCakes;
	}
	
	
	
}
