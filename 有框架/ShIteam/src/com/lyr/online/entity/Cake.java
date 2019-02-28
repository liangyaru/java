package com.lyr.online.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cake")
public class Cake {
	private int cnum;
	private String name;
	private String description;
	private int size;
	private int price;
	private int discount;
	private String bigpic;
	private String smallpic1;
	private String smallpic2;
	private String smallpic3;
	private int star;
	private String tag;
	private CakeType parentType;
	private Set<Uorder> childUorder = new HashSet<Uorder>();
	@Id
	@GenericGenerator(name="myincre", strategy="increment")
	@GeneratedValue(generator="myincre")
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="size")
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Column(name="price")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Column(name="discount")
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Column(name="bigpic")
	public String getBigpic() {
		return bigpic;
	}
	public void setBigpic(String bigpic) {
		this.bigpic = bigpic;
	}
	@Column(name="smallpic1")
	public String getSmallpic1() {
		return smallpic1;
	}
	public void setSmallpic1(String smallpic1) {
		this.smallpic1 = smallpic1;
	}
	@Column(name="smallpic2")
	public String getSmallpic2() {
		return smallpic2;
	}
	public void setSmallpic2(String smallpic2) {
		this.smallpic2 = smallpic2;
	}
	@Column(name="smallpic3")
	public String getSmallpic3() {
		return smallpic3;
	}
	public void setSmallpic3(String smallpic3) {
		this.smallpic3 = smallpic3;
	}
	@Column(name="star")
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	@Column(name="tag")
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	@ManyToOne()
	@JoinColumn(name="type")
	public CakeType getParentType() {
		return parentType;
	}
	public void setParentType(CakeType parentType) {
		this.parentType = parentType;
	}
	@ManyToMany(mappedBy="childcake")
	public Set<Uorder> getChildUorder() {
		return childUorder;
	}
	public void setChildUorder(Set<Uorder> childUorder) {
		this.childUorder = childUorder;
	}
	
}
