package com.hib.associations.onetoone.sharedprimarykey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
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
                            
                            sessionFactory = HibFactory.getSessionFactory();
                            session = sessionFactory.openSession();
                            
                           Heart ht = new Heart(); 
                           ht.setHeartName("heart1");
                           Body bd = new Body();
                         
                           bd.setBodyName("bodyname1");
                           bd.setHeart(ht);
                           ht.setBody(bd);
                            
                            System.out.println("Inserting Record");
                            Transaction tx = session.beginTransaction();
                            session.save(bd);
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

