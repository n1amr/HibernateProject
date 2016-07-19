package com.amr.hibernate.entities;

import javax.persistence.*;

@Entity(name = "amr_2_order_items")
public class OrderItem {
//	CREATE TABLE amr_order_items (
//		ID                NUMBER(32) PRIMARY KEY,
//	OrderID           NUMBER(32) REFERENCES amr_orders,
//	Place_Item_MenuID NUMBER(32) REFERENCES amr_place_items_menu,
//	UserID            NUMBER(32) REFERENCES amr_user,
//	Count             NUMBER(3, 0) DEFAULT (1)
//		);

	private long id;
	private Order order;
	private Item item;
	private User user;
	private int count;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderID")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Place_Item_MenuID")
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "Count")
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
