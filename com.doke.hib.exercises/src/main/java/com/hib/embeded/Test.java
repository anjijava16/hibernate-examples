package com.hib.embeded;

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
                            Address address = new Address();
                            address.setLine1("line1");
                            address.setLine2("line2");
                            address.setLine3("line3");
                            Person person = new Person();
                            person.setFirstname("trushant");
                            person.setLastname("doke");
                            person.setId(1L);
                            person.setAddress(address);
                            ContactDetails ctd = new ContactDetails();
                            ctd.setEmail("trushant.doke@gmail.com");
                            ctd.setMobileno("9967690087");
                            person.setCdetails(ctd);
                            Transaction tx = session.beginTransaction();
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

