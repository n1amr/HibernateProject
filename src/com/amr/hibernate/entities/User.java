package com.amr.hibernate.entities;

import com.amr.hibernate.Main;
import sun.security.provider.SHA;

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
	@Column(name = "ID")
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "id_seq_generator"
	)
	@SequenceGenerator(
		name = "id_seq_generator",
		sequenceName = "AMR_ID_SEQUENCE",
		allocationSize = 1

	)
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

	public void setPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
		this.password = new String(sha256.digest(password.getBytes()));
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
