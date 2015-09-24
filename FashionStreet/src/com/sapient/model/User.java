package com.sapient.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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

			ps = con.prepareStatement("SELECT EMAIL,PASSWORD,FIRST_NAME,LAST_NAME FROM USERS WHERE EMAIL=? AND PASSWORD=?");

			ps.setString(1, email);
			ps.setString(2, password);

			rs = ps.executeQuery();

			if (rs.next()) {

				firstName = rs.getString(3);
				lastName = rs.getString(4);
				return true;
			} else
				return false;
		} catch (NamingException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		return false;
	}

}
