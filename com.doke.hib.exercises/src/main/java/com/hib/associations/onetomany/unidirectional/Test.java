package com.hib.associations.onetomany.unidirectional;

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

				Item itm = new Item();
				itm.setName("sachins bat");
				
				session.save(itm);
				tx.commit();
				
				
				Bid bd1 = new Bid();
				bd1.setName("100rs");
				
				Bid bd2 = new Bid();
				bd2.setName("10000rs");
				
				itm.getBids().add(bd1);
				itm.getBids().add(bd2);
				
				
				Transaction tx2 = session.beginTransaction();
				session.save(bd1);
				session.save(bd2);
				session.save(itm);
				tx2.commit();
				System.out.println("Done");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
