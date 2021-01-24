package com.eb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eb.model.User;

public class UserDAO {

	public User getUser(String username) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("select * from users where user_name=?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			return user;
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return user;

	}

	public boolean registerUser(User u) {

		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = DBConnection.getConnection();
			
			stmt = con.prepareStatement("insert into users values(users_sequence.nextval,?,?,?)");
			stmt.setString(1, u.getUserName());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getUserType());

			int n = stmt.executeUpdate();
			return n > 0 ? true : false;
			
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return false;

	}

}