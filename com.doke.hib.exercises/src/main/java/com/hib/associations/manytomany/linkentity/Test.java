package com.hib.associations.manytomany.linkentity;

import java.util.Date;

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
				session.save(cat1);
				session.save(cat2);
				session.save(itm1);
				session.save(itm2);
				tx.commit();
				
				tx = session.beginTransaction();
				CategoryItem link1 = new CategoryItem(new Date(), 
						"user1", 
						(Category)session.load(Category.class, cat1.getId()), 
						(Item)session.load(Item.class, itm1.getId())
						);
				
				CategoryItem link2 = new CategoryItem(new Date(), 
						"user2", 
						(Category)session.load(Category.class, cat2.getId()), 
						(Item)session.load(Item.class, itm1.getId())
						);
				
				session.save(link1);
				session.save(link2);
				tx.commit();

			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
