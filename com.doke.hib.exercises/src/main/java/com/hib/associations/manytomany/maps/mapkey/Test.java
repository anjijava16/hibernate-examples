package com.hib.associations.manytomany.maps.mapkey;

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
				Item itm = new Item("bat");
				session.save(itm);
				tx.commit();
				
				tx = session.beginTransaction();
				Bid bd1 = new Bid(new BigDecimal(100), itm);
				Bid bd2 = new Bid(new BigDecimal(200), itm);
				Bid bd3 = new Bid(new BigDecimal(300), itm);
				session.save(bd1);
				session.save(bd2);
				session.save(bd3);
				//itm.getBids().put(key, value)//optional,not required in case of entity.persist but for hibernate it is required
				tx.commit();
				
				tx = session.beginTransaction();
				itm.getBids().put(bd1.getId(), bd1);
				itm.getBids().put(bd2.getId(), bd2);
				itm.getBids().put(bd3.getId(), bd3);
				session.save(itm);
				tx.commit();
				
				tx = session.beginTransaction();
				Item itmread = (Item)session.get(Item.class, itm.getId());
				System.out.println(itmread.bids.size());
				tx.commit();
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
