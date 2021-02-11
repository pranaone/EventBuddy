package com.eb.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eb.model.Seat;

public class SeatDAO {

public Seat getSeat(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Seat seat = null;
		//Event e = null; 
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("select * from seats where seat_id=?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			String c = "";
	        boolean isBooked = false;
	           while(rs.next()) {
	            c = rs.getString(3);
	            	if(c.equalsIgnoreCase("y")) {
	            		isBooked = true;
	            	} else {
	            		isBooked = false;
	            	}
	            seat = new Seat(rs.getInt(1),rs.getString(2),isBooked);	
	            }
			return seat;
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
		return seat;
		
	}

	public List<Seat> getAllSeatsByEvent(int eventID)
    {
        Connection con =null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Seat> list = new ArrayList<>();
        Seat seat = null;
        try
        {
            con = DBConnection.getConnection();
            stmt =con.prepareStatement("select * from seats where event_id=?");
            stmt.setInt(1,eventID);
            rs=stmt.executeQuery();
            String c = "";
            boolean isBooked = false;
            while(rs.next()) {
            	c = rs.getString(3);
            	if(c.equalsIgnoreCase("y")) {
            		isBooked = true;
            	} else {
            		isBooked = false;
            	}
            	seat = new Seat(rs.getInt(1),rs.getString(2),isBooked);	
                list.add(seat);
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
	
	public boolean deleteSeat(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("delete from seats where seat_id=?");
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
	
	
	public boolean updateSeat(Seat s){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("update seats set seat_no=?,status=? where seat_id=?");
			stmt.setString(1, s.getSeatNo());
			stmt.setBoolean(2, s.isSeatStatus());
			stmt.setInt(3, s.getSeatId());
		
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
	
	public boolean createSeat(Seat s){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("insert into seats values(seats_sequence.nextval,?,?,?)");
			stmt.setString(1,s.getSeatNo());
			stmt.setBoolean(2, s.isSeatStatus());
			stmt.setInt(3, s.getEvent().getEventId());
			
			
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
	
	public boolean updateSeatStatus(int seatId){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("update seats set status=? where seat_id=?");
			
			stmt.setString(1, "y");
			stmt.setInt(2, seatId);
		
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
	
	public boolean batchCreateSeats(int number,int eventID){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("insert into seats values(seats_sequence.nextval,?,?,?)");
			for(int i=1;i<=number;i++)
			{
				stmt.setString(1,eventID+"-"+i);
				stmt.setString(2,"N");
				stmt.setInt(3,eventID);
				stmt.addBatch();
			}
			
			int[] n = stmt.executeBatch();
		    return n.length > 0?true:false;
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
