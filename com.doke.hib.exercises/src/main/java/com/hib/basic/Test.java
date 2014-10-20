package com.hib.basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Test {

	private static SessionFactory sessionFactory = null;
    public static void main(String[] args)
    {               
            Session session = null;
            try 
             {
                    try
                    {
                            HibFactory factory = new HibFactory();
                            sessionFactory = factory.getSessionFactory();
                            session = sessionFactory.openSession();
                            Person person = new Person();
                            System.out.println("Inserting Record");
                            Transaction tx = session.beginTransaction();
                            person.setId(4);
                            person.setName("testacular");
                            session.save(person);
                            tx.commit();
                            System.out.println("Done");
                    }
                    catch (Exception e)
                    {
                            System.out.println(e.getMessage());
                    }
                    }
                    finally
                    {
                            session.close();
                    }
            }
    }

