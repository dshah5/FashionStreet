package com.sapient.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddCart {
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	private Integer productID;
	private Integer quantity;
	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	
    public void addtoCart(Integer pID){
    	Integer quant=1;

		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=null;
    	
		try {
			
			
			
			
			
			
			String SQL_QUERY = "select productID,quantity from AddCart where productID = :para1";
			Query query = session.createQuery(SQL_QUERY);
			query.setInteger("para1", pID);
			Iterator iterator = query.iterate();
			if (iterator.hasNext()) {
				Object[] row = (Object[]) iterator.next();
			
			

			int quants = (int) row[1];
			quant=quants+1;
			
			
		

			
			
			tx= session.beginTransaction();
		String hql = "UPDATE AddCart set quantity=:para1 where productID=:para2";
		Query query1 = session.createQuery(hql);
		query1.setInteger("para1",quant);
		query1.setInteger("para2",pID);
		
	    query1.executeUpdate();
		
	   tx.commit();
			

				
			}
		
			else {	
				
				
				Transaction tx2=null;
				
		tx2= session.beginTransaction();

	   AddCart cart= new AddCart();
	   cart.setProductID(pID);
	  
       cart.setQuantity(quant);
   
	   session.saveOrUpdate(cart);
	   
	   tx2.commit();
			}
			
			
			displayCart();
		}
		catch (HibernateException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
    }	
		public void displayCart() {
		Integer productId=0,quant=0;
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx=null;
			try {
				
			   
				
				String SQL_QUERY = "select productID, quantity from AddCart";
				Query query = session.createQuery(SQL_QUERY);
				List items= query.list();
				
				for(Iterator iterator = items.iterator();iterator.hasNext();) {
					Object[] row = (Object[]) iterator.next();
				
				
        
				productId = (Integer) row[0];
				quant = (Integer) row[1];
				
				SQL_QUERY = "select pName,category,price from Inventory where productId=:para1";
				Query query1 = session.createQuery(SQL_QUERY);
				query1.setInteger("para1", productId);
				
				List items1= query1.list();
				
				List productNameList =new  ArrayList();
				List productCategoryList =new  ArrayList();
				List productList =new  ArrayList();
				
				Iterator iterator1=items1.iterator();
		      if(iterator1.hasNext()) {
					Object[] row1 = (Object[]) iterator1.next();
					
					
				
				System.out.println(row1[0]);
				System.out.println(row1[1]);
				System.out.println(row1[2]);
				}
				else {
					
				}
				}
			
		}
			catch (HibernateException e) {

				// TODO Auto-generated catch block
				if(tx!=null) {
					tx.rollback();
				    e.printStackTrace();
				}
			} finally {
				session.close();
			}
		
		
		
		
	
    	
    }

}
