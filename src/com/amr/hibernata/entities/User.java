package com.amr.hibernata.entities;

import javax.persistence.*;

@Entity(name = "amr_2_user")
@Table(
	uniqueConstraints = @UniqueConstraint(columnNames = {"username"})
)
public class User {
	private long id;
	private String username;
	private String password;
	private String name;
	private String phoneNo;

	@Id
	@Column(name = "ID")
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "id_seq_generator"
	)
	@SequenceGenerator(
		name = "id_seq_generator",
		sequenceName = "AMR_ID_SEQUENCE",
		allocationSize = 10

	)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "Username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Pass")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PhoneNo")
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
