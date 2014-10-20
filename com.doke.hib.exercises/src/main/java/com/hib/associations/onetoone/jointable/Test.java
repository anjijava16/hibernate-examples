package com.hib.associations.onetoone.jointable;

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
				Item itm = new Item();
				itm.setItem("bat");
				session.save(itm);
				tx.commit();
				
				tx = session.beginTransaction();
				Item itmrd = (Item)session.get(Item.class, itm.getId());
				Shipment shp = new Shipment();
				shp.setShipMentName("batshipment");
				shp.setItem(itm);
				
				/*assigning same item to another shipment wont work because unique=true
				Shipment shp2 = new Shipment();
				shp2.setShipMentName("batshipment");
				shp2.setItem(itm);
				session.save(shp2);
				*/
								
				tx.commit();
				
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
