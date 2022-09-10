package com.software.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private int quantity;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CartItem(Integer quantity, Product product, User user) {
		super();
		this.quantity = quantity;
		this.product = product;
		this.user = user;
	}
	public CartItem(Integer id, Integer quantity, Product product, User user) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.product = product;
		this.user = user;
	}
	public CartItem() {
		super();
	}
	

}
