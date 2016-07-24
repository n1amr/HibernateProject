package com.amr.hibernate.entities;

import com.amr.hibernate.Main;
import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity(name = Main.table_prefix + "PLACE_ITEMS_MENU")
@Check(constraints = "price >= 0")
public class Item {
	private long id;
	private Place place;
	private String name;
	private String description;
	private float price;

	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "sequence_generator"
	)
	@SequenceGenerator(
		name = "sequence_generator",
		sequenceName = "AMR_PLACE_ITEMS_ID_SEQUENCE"
	)
	@Column(name = "ID")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PLACE_ID")
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Lob
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "PRICE")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item: " +
			"\n\tID: " + id +
			"\n\tPlace Name: " + place.getName() +
			"\n\tName: " + name +
			"\n\tDescription: " + description +
			"\n\tPrice: " + price;
	}
}
