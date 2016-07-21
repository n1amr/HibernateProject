package com.amr.hibernate.views;

import com.amr.hibernate.Main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = Main.table_prefix + "ORDER_VIEW")
public class OrderView {
	private long id;
	private String ownerName;
	private String status;
	private String placeName;
	private Date orderDate;


	@Id
	@Column(name = "ORDER_ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "OWNER_NAME")
	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "PLACE_NAME")
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	@Column(name = "ORDER_DATE")
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderView:" +
			"\n\tID: " + id +
			"\n\tOwner Name: " + ownerName +
			"\n\tStatus: " + status +
			"\n\tPlace Name: " + placeName +
			"\n\tOrder Date: " + orderDate;
	}
}
