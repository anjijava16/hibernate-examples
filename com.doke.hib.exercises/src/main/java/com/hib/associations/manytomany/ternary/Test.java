package com.hib.associations.manytomany.ternary;

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
				Category cat1 = new Category("cat1");
				Category cat2 = new Category("cat2");
				Item itm1 = new Item("item1");
				Item itm2 = new Item("item2");
				User usr1 = new User("user1");
				session.save(cat1);
				session.save(cat2);
				session.save(itm1);
				session.save(itm2);
				session.save(usr1);
				tx.commit();
				
				tx = session.beginTransaction();
			
				cat1.getCategorizedItems().add(new CategorizedItem(usr1, itm1));
				cat1.getCategorizedItems().add(new CategorizedItem(usr1, itm2));
				session.save(cat1);
				tx.commit();

			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
