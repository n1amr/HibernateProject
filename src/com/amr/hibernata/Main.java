package com.amr.hibernata;

import com.amr.hibernata.entities.Place;
import com.amr.hibernata.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Main {
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
		user.setUsername("n1amr");
		session.save(user);

		Place place = new Place();
		place.setName("place1");
		place.setPhoneNo("9876541");
		session.save(place);


		session.getTransaction().commit();
		session.close();
	}
}
