package com.amr.hibernate.entities;

import com.amr.hibernate.Main;

import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

@Entity(name = Main.table_prefix + "USER")
@Table(
	uniqueConstraints = @UniqueConstraint(columnNames = {"username"})
)
public class User {
	private long id;
	private String username;
	private String password;
	private String name;
	private String phoneNo;
	private Collection<Order> orders;

	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "sequence_generator"
	)
	@SequenceGenerator(
		name = "sequence_generator",
		sequenceName = "AMR_ID_SEQUENCE"
	)
	@Column(name = "ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username.toLowerCase();
	}

	@Column(name = "PASS")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PHONE_NO")
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	public Collection<Order> getOrders() {
		return orders;
	}

	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}
}
