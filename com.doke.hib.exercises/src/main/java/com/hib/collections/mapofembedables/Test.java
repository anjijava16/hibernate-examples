package com.hib.collections.mapofembedables;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                            Map<Filename,Image> images = new HashMap<Filename,Image>();
                           
                            images.put(new Filename("file1"), 
                            		new Image("img1", "1"));
                            images.put(new Filename("file2"), 
                            		new Image("img2", "2"));
                            images.put(new Filename("file3"), 
                            		new Image("img3", "3"));
                            
                            
                            
                            Item itm = new Item();
                            itm.setItemName("item1");
                            itm.setImages(images);
                            
                            System.out.println("Inserting Record");
                            Transaction tx = session.beginTransaction();
                            session.save(itm);
                            tx.commit();
                            
                            
//                            tx = session.beginTransaction();
//                            Query qry = (Query) session.createQuery("from Item as itm inner join itm.images as imgc where imgc.imagename = 'img2' ");
//                            List<Item> itmlist = qry.list();
//                            System.out.println(itmlist.size());
//                              
                            
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

