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
	
	public static List<String> productNameList;
	
	public static List<String>  productCategoryList;
	
	public static List<Integer> productPriceList;
	
	public ArrayList<Integer> getProductPriceList() {
		return (ArrayList<Integer>) productPriceList;
	}

	public static void setProductPriceList(List<Integer> productPriceList2) {
		AddCart.productPriceList = productPriceList2;
	}

	public ArrayList<String> getProductCategoryList() {
		return (ArrayList<String>) productCategoryList;
	}

	public static void setProductCategoryList(List<String> productCategoryList1) {
		AddCart.productCategoryList = productCategoryList1;
	}

	public static ArrayList<String> getProductNameList() {
		return (ArrayList<String>) productNameList;
	}

	public static void setProductNameList(List<String> productNameList1) {
		AddCart.productNameList = productNameList1;
	}

	public static int price=0;
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
			
			
	//		displayCart();
		}
		catch (HibernateException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
    }	
		public ArrayList<Integer>  getIDAllItems() {
		Integer productId=0,quant=0;
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx=null;
			try {
				
				
			   
				ArrayList<Integer> list=new ArrayList<Integer>();
				String SQL_QUERY = "select productID, quantity from AddCart";
				Query query = session.createQuery(SQL_QUERY);
				List items= query.list();
			  
				for(Iterator it=items.iterator();it.hasNext();) {
				
					
					Object[] row = (Object[]) it.next();
					
				list.add((Integer) row[0]);
					
				}
				return list;
		
		}
			catch (HibernateException e) {

				// TODO Auto-generated catch block
				
				    e.printStackTrace();
				
			} finally {
				session.close();
			}
			return null;
		
		
		
		
	
    	
    }
		
		public ArrayList<Integer>  getQuantityOfIndividualItem() {
			
			
			Integer productId=0,quant=0;
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx=null;
			try {
				
				
			   
				ArrayList<Integer> list=new ArrayList<Integer>();
				String SQL_QUERY = "select productID, quantity from AddCart";
				Query query = session.createQuery(SQL_QUERY);
				List items= query.list();
			  
				for(Iterator it=items.iterator();it.hasNext();) {
				
					
					Object[] row = (Object[]) it.next();
					
				list.add((Integer) row[1]);
					
				}
				return list;
		
		}
			catch (HibernateException e) {

				// TODO Auto-generated catch block
				
				    e.printStackTrace();
				
			} finally {
				session.close();
			}
			return null;
		
		
		
		
	/*
			Integer productId=0,quant=0;
				SessionFactory factory = new Configuration().configure()
						.buildSessionFactory();
				Session session = factory.openSession();
				Transaction tx=null;
				try {
					
					
				   
					ArrayList<Integer> list=new ArrayList<Integer>();
					String SQL_QUERY = "select quantity from AddCart";
					Query query = session.createQuery(SQL_QUERY);
					List items= query.list();
				  
					for(Iterator it=items.iterator();it.hasNext();) {
					
						
						Object[] row = (Object[]) it.next();
						
					list.add((Integer) row[0]);
						
					}
					return list;
			
			}
				catch (HibernateException e) {

					// TODO Auto-generated catch block
					
					    e.printStackTrace();
					
				} finally {
					session.close();
				}
				return null;
			
			
			*/
			
		
	    	
	    }
		
		
	public int  getTotalPrice() {
		Integer productId=0,quant=0,price=0;
			int totalprice=0;
				SessionFactory factory = new Configuration().configure()
						.buildSessionFactory();
				Session session = factory.openSession();
				Transaction tx=null;
				try {
					
					String SQL_QUERY = "select productID, quantity from AddCart";
					Query query = session.createQuery(SQL_QUERY);
					List items= query.list();
				  
					for(Iterator it=items.iterator();it.hasNext();) {
						
						Object[] row = (Object[]) it.next();
						
						productId =(Integer) row[0];
						quant = (Integer) row[1];
					
					SQL_QUERY = "select price from Inventory where productId=:para1";
					query = session.createQuery(SQL_QUERY);
					query.setInteger("para1", productId);
					List item= query.list();
					Iterator it1=item.iterator();
					Object[] row2 = (Object[]) it1.next();
					price=((Integer) row2[0]);
					
					totalprice+=price*quant;
						
					}
					return totalprice;
			
			}
				catch (HibernateException e) {

					// TODO Auto-generated catch block
					
					    e.printStackTrace();
					
				} finally {
					session.close();
				}
				return 0;
			
			
			
			
		
	    	
	    }
		

}
