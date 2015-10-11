package com.sapient.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.Entity; 
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private Integer id;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean validateLogin(String emailID, String pword) {
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();

		String SQL_QUERY = "select user.firstName,user.lastName from User user where user.email=:para1 and user.password=:para2";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("para1", emailID);
		query.setParameter("para2", pword);
		Iterator iterator = query.iterate();

		try {
			if (iterator.hasNext()) {
				Object[] row = (Object[]) iterator.next();
				email = emailID;
				password = pword;

				firstName = (String) row[0];

				lastName = (String) row[1];

				return true;
			} else
				return false;
		} catch (HibernateException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		/*
		 * Context ctx = null; Connection con = null; PreparedStatement ps =
		 * null; ResultSet rs = null;
		 * 
		 * try {
		 * 
		 * // Lookup for dataSource ctx = new InitialContext(); DataSource ds =
		 * (DataSource) ctx .lookup("java:comp/env/jdbc/userDB");
		 * 
		 * // obtain a connection con = ds.getConnection();
		 * 
		 * ps =
		 * con.prepareStatement("SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?"
		 * );
		 * 
		 * ps.setString(1, email); ps.setString(2, password);
		 * 
		 * rs = ps.executeQuery(); if (rs.next()) { email= emailID;
		 * password=pword; firstName=rs.getString(3); lastName=rs.getString(4);
		 * return true; } else return false; } catch (NamingException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * } catch (SQLException e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * } finally { this.closer(ctx, con, ps, rs); }
		 */
		return false;

	}

	public boolean isEmailRegistered(String emailID) {
		
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();

		String SQL_QUERY = "select user.firstName,user.lastName from User user where user.email=:para1";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter("para1", emailID);

		Iterator iterator = query.iterate();

		try {
			if (iterator.hasNext()) {
				Object[] row = (Object[]) iterator.next();
				email = emailID;
			

			firstName = (String) row[0];

				lastName = (String) row[1];

				return true;
			} else
				return false;
		} catch (HibernateException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
/*
		Context ctx = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// Lookup for dataSource
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/userDB");

			// obtain a connection
			con = ds.getConnection();

			ps = con.prepareStatement("SELECT * FROM USERS WHERE EMAIL=?");

			ps.setString(1, emailID);

			rs = ps.executeQuery();
			if (rs.next()) {
				email = rs.getString(1);
				password = rs.getString(2);
				firstName = rs.getString(3);
				lastName = rs.getString(4);
				return true;
			} else
				return false;
		} catch (NamingException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			this.closer(ctx, con, ps, rs);
		}

		return false;
*/
		return false;
	}

	public void updateUser(String emailID, String pword, String fName,
			String lName) {
		
		
		SessionFactory factory = new Configuration().configure()
				.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx=null;
		try {
		tx= session.beginTransaction();

	   User user= new User();
	   user.setEmail(emailID);
       user.setPassword(pword);
       user.setFirstName(fName);
       user.setLastName(lName);
	   session.saveOrUpdate(user);
	   
	   tx.commit();
	   
		}
		catch (HibernateException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
        
/*
		Context ctx = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			// Lookup for dataSource
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx
					.lookup("java:comp/env/jdbc/userDB");

			// obtain a connection
			con = ds.getConnection();

			ps = con.prepareStatement("INSERT INTO USERS(EMAIL,PASSWORD,FIRST_NAME,LAST_NAME) VALUES(?,?,?,?)");

			ps.setString(1, emailID);
			ps.setString(2, pword);
			ps.setString(3, fName);
			ps.setString(4, lName);

			ps.executeQuery();

		} catch (NamingException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {
			this.closer(ctx, con, ps, rs);
		}

	}

	public void closer(Context ctx, Connection con, PreparedStatement ps,
			ResultSet rs) {

		try {
			if (ctx != null) {
				ctx.close();
			}
			if (con != null) {
				con.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}

	public boolean validateName(String fname, String lname) {
		if (fname.matches("[a-zA-Z]+") && lname.matches("[a-zA-Z]+")) {
			return true;
		} else
			return false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void editUser(String fName,String emailID,String password) {
		
			
			
			SessionFactory factory = new Configuration().configure()
					.buildSessionFactory();
			Session session = factory.openSession();
			Transaction tx=null;
			try {
			tx= session.beginTransaction();

		//   User user= new User();
		//   user.setEmail(emailID);
	  //     user.setPassword(pword);
	    //   user.setFirstName(fName);
	//       user.setLastName(lName);
		 //  session.saveOrUpdate(user);
				
				String hql = "UPDATE User set email=:para1,password=:para2 where firstName=:para3";
			Query query = session.createQuery(hql);
			query.setString("para1",emailID);
			query.setString("para2",password);
			query.setString("para3",fName);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
		   
		   tx.commit();
		   
			}
			catch (HibernateException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				session.close();
			}
	        
	/*
			Context ctx = null;
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;

			try {

				// Lookup for dataSource
				ctx = new InitialContext();
				DataSource ds = (DataSource) ctx
						.lookup("java:comp/env/jdbc/userDB");

				// obtain a connection
				con = ds.getConnection();

				ps = con.prepareStatement("INSERT INTO USERS(EMAIL,PASSWORD,FIRST_NAME,LAST_NAME) VALUES(?,?,?,?)");

				ps.setString(1, emailID);
				ps.setString(2, pword);
				ps.setString(3, fName);
				ps.setString(4, lName);

				ps.executeQuery();

			} catch (NamingException e) {

				e.printStackTrace();

			} catch (SQLException e) {

				e.printStackTrace();

			} finally {
				this.closer(ctx, con, ps, rs);
			}
*/
		}

	}


