package com.eb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eb.model.Hall;

public class HallDAO {

public Hall getHallByID(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Hall hall = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("select * from halls where hall_id=?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				hall = new Hall(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));	
			}
			return hall;
		}
		catch(SQLException se){se.printStackTrace();}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se){se.printStackTrace();}
		}
		return hall;
		
	}

	public List<Hall> getHallListByOwner(int ownerID)
    {
        Connection con =null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Hall> list = new ArrayList<>();
        try
        {
            con = DBConnection.getConnection();
            stmt =con.prepareStatement("select * from halls where owner_id=?");
            stmt.setInt(1,ownerID);
            rs=stmt.executeQuery();
            while(rs.next()) {
            	Hall hall = new Hall(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));	
                list.add(hall);
            }
        }
        catch(SQLException se) {se.printStackTrace();}
        finally
        {
            try
            {
                if(stmt!=null)
                    stmt.close();
                if(rs!=null)
                    rs.close();
                if(con!=null)
                    con.close();
            }
            catch(SQLException se) {se.printStackTrace();}
        }
        return list;
    }
	
	public boolean deleteHall(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("delete from halls where hall_id=?");
			stmt.setInt(1,id);
			int n = stmt.executeUpdate();
		    return n>0?true:false;
		}
		catch(SQLException se){se.printStackTrace();}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se){se.printStackTrace();}
		}
		return false;
		
	}
	
	
	public boolean updateHall(Hall h){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("update halls set hall_name=?,hall_type=?,hall_location=?,hall_contact=?,no_of_seats=? where hall_id=?");
			stmt.setString(1,h.getHallName());
			stmt.setString(2,h.getHallType());
			stmt.setString(3,h.getHallLocation());
			stmt.setString(4,h.getHallContact());
			stmt.setInt(5,h.getNoOfSeats());
			stmt.setInt(6,h.getHallId());
			int n = stmt.executeUpdate();
		    return n>0?true:false;
		}
		catch(SQLException se){se.printStackTrace();}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se){se.printStackTrace();}
		}
		return false;
		
	}
	
	public boolean createHall(Hall h, int ownerID){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("insert into halls values(halls_sequence.nextval,?,?,?,?,?,?)");
			stmt.setString(1,h.getHallName());
			stmt.setString(2,h.getHallType());
			stmt.setString(3,h.getHallLocation());
			stmt.setString(4,h.getHallContact());
			stmt.setInt(5,h.getNoOfSeats());
			stmt.setInt(6,ownerID);
			int n = stmt.executeUpdate();
		    return n>0?true:false;
		}
		catch(SQLException se){se.printStackTrace();}
		finally
		{
			try
			{
				if(stmt!=null)
					stmt.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException se){se.printStackTrace();}
		}
		return false;
		
	}
}
