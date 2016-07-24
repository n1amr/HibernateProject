package com.amr.hibernate.views;

import com.amr.hibernate.Main;

import javax.persistence.*;
import java.util.Date;

@Entity(name = Main.table_prefix + "ORDER_VIEW")
public class OrderView {
	private long id;
	private long ownerId;
	private long placeId;
	private String name;
	private String ownerName;
	private String status;
	private String placeName;
	private Date orderDate;

	@Id
	@Column(name = "ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "OWNER_ID")
	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	@Column(name = "PLACE_ID")
	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	@Column(name = "ORDER_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
			"\n\tOwner ID: " + ownerId +
			"\n\tPlace ID: " + placeId +
			"\n\tOrder Name: " + name +
			"\n\tOwner Name: " + ownerName +
			"\n\tStatus: " + status +
			"\n\tPlace Name: " + placeName +
			"\n\tOrder Date: " + orderDate;
	}
}
