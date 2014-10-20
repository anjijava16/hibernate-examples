package com.hib.associations.onetoone.foreignkey;

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
				User usr = new User();
				usr.setUserName("trushant doke");
				session.save(usr);
				tx.commit();
								
				Transaction tx2 = session.beginTransaction();
				Address adr = new Address();
				adr.setAddress("germany");
				session.save(adr);
				User usrrd = (User) session.get(User.class, usr.getId());
				usrrd.setAddress(adr);
				session.save(usrrd);
				tx2.commit();
				
				Transaction tx3 = session.beginTransaction();
				User usr2 = new User();
				usr2.setUserName("misut ozil");
				session.save(usr2);
				tx3.commit();
				
				Transaction tx4 = session.beginTransaction();
				User usr2rd= (User) session.get(User.class, usr2.getId());
				User usr1rd = (User) session.get(User.class, usr.getId());
				usr2rd.setAddress(usr1rd.getAddress());
				session.save(usr2rd);//will not work because unique = true
				tx4.commit();
				
				

				

				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} finally {
			session.close();
		}
	}
}
