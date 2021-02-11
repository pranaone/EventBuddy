package com.eb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eb.model.Owner;

public class OwnerDAO {

	public Owner getOwnerbById(int id) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Owner owner = null;

//		UserDAO udao = new UserDAO()

		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("select * from owners where owner_id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				owner = new Owner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
			return owner;
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
		return owner;

	}
	
	public Owner getOwnerbByUserId(int id) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Owner owner = null;

//		UserDAO udao = new UserDAO()

		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("select * from owners where user_id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				owner = new Owner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
			return owner;
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
		return owner;

	}

	public boolean createOwner(Owner o) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBConnection.getConnection();

			stmt = con.prepareStatement("insert into owners values(owners_sequence.nextval,?,?,?,?,?,?)");
			stmt.setString(1, o.getFirstName());
			stmt.setString(2, o.getLastName());
			stmt.setString(3, o.getEmail());
			stmt.setString(4, o.getMobile());
			stmt.setString(5, o.getBrNo());
			stmt.setInt(6, o.getUser().getUserId());

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

	public List<Owner> getAllOwners() {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		List<Owner> list = new ArrayList<>();
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from owners");
			while (rs.next()) {
				Owner owner = new Owner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7));
				list.add(owner);
			}
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
		return list;
	}

	public boolean updateOwner(Owner o) {

		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement(
					"update owners set first_name=?,last_name=?,email=?,mobile=?,br_no=? where owner_id=?");
			stmt.setString(1, o.getFirstName());
			stmt.setString(2, o.getLastName());
			stmt.setString(3, o.getEmail());
			stmt.setString(4, o.getMobile());
			stmt.setString(5, o.getBrNo());
			stmt.setInt(6, o.getOwnerId());
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