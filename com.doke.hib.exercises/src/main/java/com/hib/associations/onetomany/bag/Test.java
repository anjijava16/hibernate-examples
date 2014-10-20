package com.hib.associations.onetomany.bag;

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
				
				Bid bd1 = new Bid("100rs", itm);
				itm.getBids().add(bd1);
				
				Bid bd2 = new Bid("1000rs", itm);
				itm.getBids().add(bd2);
				
				session.save(bd1);
				session.save(bd2);
				tx.commit();
				session.close();
				
				Long itmid = itm.getId();
				
				session = sessionFactory.openSession();
				tx = session.beginTransaction();
				Item itmRead = (Item) session.get(Item.class, itmid);
				Bid bd3 = new Bid("200rs", itmRead);
				System.out.println("fetching bag start");
				itmRead.getBids().add(bd3);//no select query is executed
				System.out.println("fetching bag "
						+ "end");
				session.save(bd3);
				
				
				tx.commit();
				
				System.out.println("Done");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
