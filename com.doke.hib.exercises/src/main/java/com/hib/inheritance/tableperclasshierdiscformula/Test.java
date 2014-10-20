package com.hib.inheritance.tableperclasshierdiscformula;

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
                            CreditCard cd = new CreditCard("doke", "3213", "May", "2004");
                            BankAccount bak = new BankAccount("doke", "3443", "parsik", "test");
                            System.out.println("Inserting Record");
                            Transaction tx = session.beginTransaction();
                            session.save(cd);
                            session.save(bak);
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

