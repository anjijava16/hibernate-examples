package com.hib.associations.onetomany.cascadepersist;

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
				
				
				Bid bd1 = new Bid();
				Bid bd2 = new Bid();
				bd1.setName("bid1");
				bd2.setName("bid2");
				bd1.setItem(itm);
				bd2.setItem(itm);
				itm.getBids().add(bd1);
				itm.getBids().add(bd2);
				session.save(itm);
				tx.commit();
				/********************************************************************/
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
