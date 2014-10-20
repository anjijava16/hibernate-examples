package com.hib.collections.bagofembedebles;

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
                            Collection<Image> imSet  = new ArrayList<Image>();
                           
                            imSet.add(new Image("img1", "image1.txt"));
                            imSet.add(new Image("img2", "image2.txt"));
                            imSet.add(new Image("img3", "image3.txt"));
                            imSet.add(new Image("img4", "image4.txt"));
                            
                            
                            
                            
                            Item itm = new Item();
                            itm.setItemName("item1");
                            itm.setImages(imSet);
                            
                            System.out.println("Inserting Record");
                            Transaction tx = session.beginTransaction();
                            session.save(itm);
                            tx.commit();
                            
                            tx = session.beginTransaction();
                            Query qry = (Query) session.createQuery("from Item as itm inner join itm.images as imgc where imgc.imagename = 'img2' ");
                            List<Item> itmlist = qry.list();
                            System.out.println(itmlist.size());
                              
                            
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

