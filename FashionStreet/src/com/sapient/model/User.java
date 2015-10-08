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

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String firstName;
	private String lastName;

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

	public boolean validateLogin(String email, String password) {
		
SessionFactory factory;
		
		factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = null;
		//Integer employeeID = null;
		/*Logger Log = Logger.getLogger(MainApp.class.getName());
		BasicConfigurator.configure();*/
		try{
			tx = session.beginTransaction();
			String SQL_QUERY = "select * from Users users where users.email=:email and users.password=:password";
			
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter("email", email);
			query.setParameter("password", password);
			
			Iterator iterator = query.iterate();
			
			if(iterator.hasNext())
			{
				
				
				return true;
			}
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
return false;
		
	}

	public boolean isEmailRegistered(String email) {

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

			ps = con.prepareStatement("SELECT EMAIL FROM USERS WHERE EMAIL=?");

			ps.setString(1, email);

			rs = ps.executeQuery();
			if (rs.next()) {
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
		
	}

	public void updateUser(String email, String password, String firstName,
			String lastName) {

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

			ps = con.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?)");

			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);

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

	}

	public boolean validateName(String fname, String lname) {
		if (fname.matches("[a-zA-Z]+") && lname.matches("[a-zA-Z]+")) {
			return true;
		} else
			return false;
	}

}
