package com.hib.associations.onetoone.foreignkeybidirectional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
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

				User usr = new User();
				usr.setUserName("misut ozil");
				Transaction tx = session.beginTransaction();
				session.save(usr);
				tx.commit();
				
				Transaction tx1 = session.beginTransaction();
				User usrrd = (User) session.get(User.class, usr.getId());
				Address addr = new Address();
				addr.setAddress("china");
				addr.setUser(usrrd);
				usrrd.setAddress(addr);
				session.save(addr);
				//session.save(usr);//comment this and association wont be saved
				tx1.commit();
				

		
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
