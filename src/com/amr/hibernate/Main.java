package com.amr.hibernate;

import com.amr.hibernate.entities.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.Date;
import java.util.List;

public class Main {
	public static final String prefix = "amr_";

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session;

		session = sessionFactory.openSession();
		session.beginTransaction();

		User user = new User();
		user.setId(1);
		user.setName("Amr Alaa");
		user.setPassword("password");
		user.setPhoneNo("123456");
		user.setUsername("n1amr" + Math.random());
		session.save(user);

		Place place = new Place();
		place.setName("place1");
		place.setPhoneNo("9876541");
		session.save(place);

		Item item = new Item();
		item.setName("item1");
		item.setDescription("description 1");
		item.setPrice((float) 1.23);
		item.setPlace(place);
		session.save(item);

		Order order = new Order();
		order.setOwner(user);
		order.setPlace(place);
		order.setDate(new Date());
		order.setStatus("NEW");
		session.save(order);

		OrderItem orderItem = new OrderItem();
		orderItem.setCount(2);
		orderItem.setItem(item);
		orderItem.setUser(user);
		orderItem.setOrder(order);
		session.save(orderItem);


		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();

		Query query = session.createQuery("from " + prefix + "orders");
		List orders = query.list();
		for (Object obj : orders) {
			Order order1 = (Order) obj;
			System.out.println(order1.getDate());
			OrderItem orderItem1 = (OrderItem) order1.getOrderItems().toArray()[0];
			System.out.println(orderItem1.getCount());
			System.out.println(order1.getTotalPrice());
		}

		session.close();
	}
}
