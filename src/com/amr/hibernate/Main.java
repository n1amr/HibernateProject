package com.amr.hibernate;

import com.amr.hibernate.entities.*;
import com.amr.hibernate.views.OrderView;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.Date;
import java.util.List;

public class Main {
	public static final String table_prefix = "AMR_";

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session;

		User[] users = new User[10];
		Place[] places = new Place[10];
		Item[][] items = new Item[places.length][10];
		Order[] orders = new Order[10];
		int MAX_ITEMS_PER_ORDER = 10;
		int MAX_COUNT_PER_ITEM = 10;

		for (int i = 0; i < users.length; i++) {
			User user = new User();
			user.setName("user " + i);
			user.setPassword("pass" + i);
			user.setPhoneNo("123456" + i);
			user.setUsername("n1amr" + i + "." + System.currentTimeMillis());
			users[i] = user;
		}

		for (int i = 0; i < places.length; i++) {
			Place place = new Place();
			place.setName("place" + i);
			place.setPhoneNo("9876500" + i);
			places[i] = place;

			for (int j = 0; j < items[0].length; j++) {
				Item item = new Item();
				item.setName("item" + i + ":" + j);
				item.setDescription("description " + j + " in place " + i);
				item.setPrice((float) Math.random() * 10);
				item.setPlace(place);
				items[i][j] = item;
			}
		}

		for (int i = 0; i < orders.length; i++) {
			Order order = new Order();
			int ownerUserIndex = (int) (Math.random() * users.length);
			order.setOwner(users[ownerUserIndex]);
			int placeIndex = (int) (Math.random() * places.length);
			order.setPlace(places[placeIndex]);
			order.setDate(new Date());
			order.setStatus("NEW");
			orders[i] = order;

			int item_count = (int) (Math.random() * MAX_ITEMS_PER_ORDER);
			for (int j = 0; j < item_count; j++) {
				OrderItem orderItem = new OrderItem();
				orderItem.setCount((int) (Math.random() * MAX_COUNT_PER_ITEM));
				int itemIndex = (int) (Math.random() * items[0].length);
				orderItem.setItem(items[placeIndex][itemIndex]);
				int userIndex = (int) (Math.random() * users.length);
				orderItem.setUser(users[userIndex]);
				orderItem.setOrder(orders[i]);
				order.getOrderItems().add(orderItem);
			}
		}

		session = sessionFactory.openSession();
		session.beginTransaction();

		for (User user : users)
			session.save(user);

		for (int i = 0; i < places.length; i++) {
			session.save(places[i]);
			for (int j = 0; j < items[i].length; j++) {
				session.save(items[i][j]);
			}
		}

		for (Order order : orders)
			session.save(order);

		session.getTransaction().commit();
		session.close();

		session = sessionFactory.openSession();

		Query query = session.createQuery("from " + table_prefix + "ORDERS");
		List orders2 = query.list();
		for (Object obj : orders2) {
			Order order1 = (Order) obj;
			System.out.println();
			System.out.println(order1.getDate());
			System.out.println("Order:");
			for (OrderItem orderItem1 : order1.getOrderItems()) {
				System.out.println("  " + orderItem1.getItem().getName() + " (x" + orderItem1.getCount() + ")" + " = $" + orderItem1.getItem().getPrice());
			}
			System.out.println("  Total = $" + order1.getTotalPrice());
		}

		query = session.createQuery("from " + table_prefix + "PLACES");
		List places1 = query.list();
		for (Object obj : places1) {
			Place place = (Place) obj;
			System.out.println();
			System.out.println("Place " + place.getName() + ":");
			for (Item item : place.getItems()) {
				System.out.println("  " + item.getName());
			}
		}

		session.close();

		session = sessionFactory.openSession();

		OrderView orderView = new OrderView();
		query = session.createQuery("from " + Main.table_prefix + "ORDER_VIEW");
		List orderViews = query.list();
		for (Object obj : orderViews) {
			OrderView overview1 = (OrderView) obj;
			System.out.println(overview1);
		}

		session.close();
	}
}
