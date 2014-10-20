package com.hib.associations.manytomany.biderectional;

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
				Category cat = new Category("cat1");
				Item itm = new Item("itm1");
				cat.getItems().add(itm);
				itm.getCategories().add(cat);
				session.save(cat);
				tx.commit();
				
				tx = session.beginTransaction();
				Category catread = (Category)session.get(Category.class, cat.getId());
				Item itm2 = new Item("item2");
				itm2.getCategories().add(catread);
				catread.getItems().remove(itm);
				cat.getItems().add(itm2);
				session.save(cat);
				tx.commit();

			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
