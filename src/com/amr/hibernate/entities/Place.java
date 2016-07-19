package com.amr.hibernate.entities;

import com.amr.hibernate.Main;

import javax.persistence.*;

@Entity(name = Main.table_prefix + "places")
public class Place {
	private long id;
	private String name;
	private String phoneNo;

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

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PhoneNo", length = 50)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
