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
	@SequenceGenerator(name = "id_gen", sequenceName = "ID_SEQ_INCREMENT", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
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
}
