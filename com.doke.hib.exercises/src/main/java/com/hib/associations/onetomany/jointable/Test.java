package com.hib.associations.onetomany.jointable;

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
				User usr1= new User("satish");
				session.save(usr1);
				tx.commit();
				/********************************************************************/
				tx = session.beginTransaction();
				User usr1rd = (User)session.get(User.class, usr1.getId());
				Item itm1 = new Item("bat", usr1rd);
				Item itm2 = new Item("ball",usr1rd);
				Item itm3 = new Item("stump", null);
				usr1rd.getItemsbought().add(itm1);
				usr1rd.getItemsbought().add(itm2);
				session.save(itm1);
				session.save(itm2);
				session.save(itm3);
				tx.commit();
				/********************************************/
				/**imp: owner of relationship i.e item can update the association
				 * itm2rd assigned to another user and saved,and its association with previous user is changed to new user
				tx = session.beginTransaction();
				User usr2= new User("raju");
				session.save(usr2);
				tx.commit();
				
				tx = session.beginTransaction();
				User usr2rd = (User)session.get(User.class, usr2.getId());
				Item itm2rd = usr1rd.getItemsbought().get(0);
				itm2rd.setOwner(usr2rd);
				session.save(itm2rd);
				tx.commit();*/
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
