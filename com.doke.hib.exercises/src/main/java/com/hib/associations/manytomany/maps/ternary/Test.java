package com.hib.associations.manytomany.maps.ternary;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {

	private static SessionFactory sessionFactory = null;

	public static void main(String[] args) {
		Session session = null;
		try {
			try {

				sessionFactory = HibFactory.getSessionFactory();
				session = sessionFactory.openSession();
				Transaction tx = session.beginTransaction();
				Category cat = new Category("cricket");
				Item itm1 = new Item("bat");
				Item itm2 = new Item("ball");
				User usr1 = new User("adidas");
				User usr2 = new User("kokabura");
				session.save(cat);
				session.save(itm1);
				session.save(itm2);
				session.save(usr1);
				session.save(usr2);
				tx.commit();
				
				tx = session.beginTransaction();
				cat.getItemAddedBy().put(itm1, usr1);
				cat.getItemAddedBy().put(itm2, usr2);
				session.save(cat);
				tx.commit();
				
				
				
				tx = session.beginTransaction();
				Category catread = (Category)session.get(Category.class, cat.getId());
				System.out.println(catread.getItemAddedBy().size());
				tx.commit();
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
