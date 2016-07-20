package com.amr.hibernate.entities;

import com.amr.hibernate.Main;
import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity(name = Main.table_prefix + "place_items_menu")
@Check(constraints = "price >= 0")
public class Item {
	private long id;
	private Place place;
	private String name;
	private String description;
	private float price;

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
	@JoinColumn(name = "PlaceID")
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Lob
	@Column(name = "\"Desc\"")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
