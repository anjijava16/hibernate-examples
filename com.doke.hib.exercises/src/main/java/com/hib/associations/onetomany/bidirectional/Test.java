package com.hib.associations.onetomany.bidirectional;

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
				/********************************************************************/
				tx = session.beginTransaction();
				Item readitem = (Item) session.get(Item.class, itm.getId());
				Bid bd1 = new Bid();
				bd1.setName("100rs");
				bd1.setItem(readitem);
				readitem.getBids().add(bd1);
				
				Bid bd2 = new Bid();
				bd2.setName("10000rs");
				bd2.setItem(readitem);
				readitem.getBids().add(bd2);
				
				
				
				session.save(bd1);
				session.save(bd2);
				
				
			

				System.out.println("Inserting Record");
				
				
				session.save(bd1);
				session.save(bd2);
				
				
				System.out.println("Done");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
