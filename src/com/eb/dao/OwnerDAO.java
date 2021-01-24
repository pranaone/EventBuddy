package com.eb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eb.model.Owner;

public class OwnerDAO {
	
	public Owner getOwnerbById(int id) {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Owner owner = null;
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("select * from owners where owner_id=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			while (rs.next()) {
				owner = new Owner(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
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

}