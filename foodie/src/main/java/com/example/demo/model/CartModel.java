package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@SuppressWarnings("deprecation")
@Entity
@Table(name="Cart")
@EntityListeners(AuditingEntityListener.class)

public class CartModel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)

	private int id ;
	@NotNull
	private String product_img ;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	public String getProduct_details() {
		return product_details;
	}
	public void setProduct_details(String product_details) {
		this.product_details = product_details;
	}
	public int getProduct_quality() {
		return product_quality;
	}
	public void setProduct_quality(int product_quality) {
		this.product_quality = product_quality;
	}
	@NotNull
	private String product_name;
	@NotNull
	private int product_price ;
	@NotNull
	private String product_details ;
    @NotNull
	private int product_quality ;
}	
	
	
