package com.eb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.eb.model.Event;
import com.eb.model.Hall;

public class EventDAO {

public Event getEventByID(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Event event = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("select * from events where event_id=?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getTime(6).toLocalTime(),rs.getTime(7).toLocalTime(),rs.getDouble(8),rs.getString(9));	
			}
			return event;
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
		return event;
		
	}
	public Event getEventByName(String name){
	
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Event event = null;
	try
	{
		con = DBConnection.getConnection();
		stmt = con.prepareStatement("select * from events where event_name=?");
		stmt.setString(1,name);
		rs=stmt.executeQuery();
		while(rs.next()) {
			event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getTime(6).toLocalTime(),rs.getTime(7).toLocalTime(),rs.getDouble(8),rs.getString(9));	
		}
		return event;
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
	return event;
	
	}
	
	public int getEventCountByOwner(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("select count (*) as total from events inner join halls on events.hall_id = halls.hall_id where halls.owner_id=?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt("total");
			}
			return count;
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
		return count;
		
	}

	public List<Event> getEventListByHall(int hallID)
    {
        Connection con =null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Event> list = new ArrayList<>();
        try
        {
            con = DBConnection.getConnection();
            stmt = con.prepareStatement("select * from events where hall_id=? order by event_date");
            stmt.setInt(1,hallID);
            rs=stmt.executeQuery();
            while(rs.next()) {
            	Event event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getTime(6).toLocalTime(),rs.getTime(7).toLocalTime(),rs.getDouble(8),rs.getString(9));
                list.add(event);
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
	
	
	public List<Event> getEventListByToday()
    {
		LocalDate today = LocalDate.now();
        Connection con =null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        List<Event> list = new ArrayList<>();
        try
        {
            con = DBConnection.getConnection();
            stmt = con.prepareStatement("select * from events where event_date >= ? order by event_date");
            stmt.setDate(1,Date.valueOf(today));
            rs=stmt.executeQuery();
            while(rs.next()) {
            	Event event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getTime(6).toLocalTime(),rs.getTime(7).toLocalTime(),rs.getDouble(8),rs.getString(9));
                list.add(event);
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
	
	public boolean deleteEvent(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("delete from events where event_id=?");
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
	
	
	public boolean updateEvent(Event e){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("update events set event_name=?,event_type=?,event_description=?,event_date=?,start_time=?,end_time=?,ticket_price=?,event_image=? where event_id=?");
			stmt.setString(1,e.getEventName());
			stmt.setString(2,e.getEventType());
			stmt.setString(3,e.getEventDescription());
			stmt.setDate(4,Date.valueOf(e.getEventDate()));
			stmt.setTime(5,Time.valueOf(e.getStartTime()));
			stmt.setTime(6,Time.valueOf(e.getEndTime()));
			stmt.setDouble(7,e.getTicketPrice());
			stmt.setString(8,e.getEventImage());
			stmt.setInt(9,e.getEventId());
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
	
public boolean updateEventWithoutImage(Event e){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("update events set event_name=?,event_type=?,event_description=?,event_date=?,start_time=?,end_time=?,ticket_price=? where event_id=?");
			stmt.setString(1,e.getEventName());
			stmt.setString(2,e.getEventType());
			stmt.setString(3,e.getEventDescription());
			stmt.setDate(4,Date.valueOf(e.getEventDate()));
			stmt.setTime(5,Time.valueOf(e.getStartTime()));
			stmt.setTime(6,Time.valueOf(e.getEndTime()));
			stmt.setDouble(7,e.getTicketPrice());
			stmt.setInt(8,e.getEventId());
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
	
	public boolean createEvent(Event e, int hallID){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("insert into events values(events_sequence.nextval,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1,e.getEventName());
			stmt.setString(2,e.getEventType());
			stmt.setString(3,e.getEventDescription());
			stmt.setDate(4,Date.valueOf(e.getEventDate()));
			stmt.setTime(5,Time.valueOf(e.getStartTime()));
			stmt.setTime(6,Time.valueOf(e.getEndTime()));
			stmt.setDouble(7,e.getTicketPrice());
			stmt.setString(8,e.getEventImage());
			stmt.setInt(9,hallID);

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
	
	public List<Event> getAllEvents()
    {
		
        Connection con =null;
        ResultSet rs = null;
        Statement stmt = null;
        List<Event> list = new ArrayList<>();
        Event event = null;
        try
        {
            con = DBConnection.getConnection();
            String query = "select * from events order by event_date";
            stmt = con.createStatement();
            rs=stmt.executeQuery(query);
           
            while(rs.next()) {
                event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getTime(6).toLocalTime(),rs.getTime(7).toLocalTime(),rs.getDouble(8),rs.getString(9));
                list.add(event);
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
	
	public Event getEventByIDwithHall(int id){
	       
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Event event = null;
        Hall hall = null;
        HallDAO hallDAO = new HallDAO();
       
        try
        {
            con = DBConnection.getConnection();
            stmt = con.prepareStatement("select * from events where event_id=?");
            stmt.setInt(1,id);
            rs=stmt.executeQuery();
            while(rs.next()) {
                hall = hallDAO.getHallByID(rs.getInt(10));
                event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),rs.getTime(6).toLocalTime(),rs.getTime(7).toLocalTime(),rs.getDouble(8),rs.getString(9),hall);   
            }
            return event;
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
        return event;
       
    }
	
	
	
}
