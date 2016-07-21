package com.amr.hibernate.views;

import com.amr.hibernate.Main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = Main.table_prefix + "ORDER_ITEM_VIEW")
public class OrderItemView {
	private long orderId;
	private String placeName;
	private String userName;
	private int count;
	private float price;
	private float total;

	@Id
	@Column(name = "ORDER_ID")
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "PLACE_NAME")
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "COUNT")
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Column(name = "PRICE", columnDefinition = "NUMBER(5, 2)")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "TOTAL", columnDefinition = "NUMBER(5, 2)")
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order Item View:" +
			"\n\tOrder ID: " + orderId +
			"\n\tPlace Name: " + placeName +
			"\n\tUser Name: " + userName +
			"\n\tCount: " + count +
			"\n\tPrice: " + price +
			"\n\tTotal: " + total;
	}
}
