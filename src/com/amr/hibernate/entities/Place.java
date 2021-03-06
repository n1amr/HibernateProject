package com.amr.hibernate.entities;

import com.amr.hibernate.Main;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = Main.table_prefix + "PLACES")
public class Place {
	private long id;
	private String name;
	private String phoneNo;
	private Collection<Item> items = new ArrayList<>();

	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "sequence_generator"
	)
	@SequenceGenerator(
		name = "sequence_generator",
		sequenceName = "AMR_PLACES_ID_SEQUENCE",
		allocationSize = 1
	)
	@Column(name = "ID", length = 32, columnDefinition = "NUMBER(32)")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PHONE_NO", length = 50)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Place:" +
			"\n\tID: " + id +
			"\n\tName: " + name +
			"\n\tPhone No.: " + phoneNo;
	}
}
