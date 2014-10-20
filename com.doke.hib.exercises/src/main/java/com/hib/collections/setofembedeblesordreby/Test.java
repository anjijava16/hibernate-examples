package com.hib.collections.setofembedeblesordreby;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

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
                            Set<Image> imSet  = new LinkedHashSet<Image>();
                           
                            imSet.add(new Image("img1", "image1.txt",2));
                            imSet.add(new Image("img2", "image2.txt",4));
                            imSet.add(new Image("img3", "image3.txt",1));
                            imSet.add(new Image("img4", "image4.txt",8));
                            
                            
                            
                            
                            Item itm = new Item();
                            itm.setItemName("item1");
                            itm.setImages(imSet);
                            
                            System.out.println("Inserting Record");
                            Transaction tx = session.beginTransaction();
                            session.save(itm);
                            tx.commit();
                            
                            tx = session.beginTransaction();
                            Item itmout = (Item) session.get(Item.class, 1L);
                            
                              for(Image img:itmout.getImages()){
                            	  System.out.println(img.toString());
                              }
                            
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

