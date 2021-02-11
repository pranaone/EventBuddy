package com.eb.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eb.model.Customer;

public class CustomerDAO {

public Customer getCustomerbyId(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Customer customer = null;
		//Event e = null; 
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("select * from customers where customer_id=?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			while(rs.next()) {
				
				customer = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));	
			}
			return customer;
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
		return customer;
		
	}

public Customer getCustomerbByUserId(int id) {

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Customer customer = null;
	try {
		con = DBConnection.getConnection();
		stmt = con.prepareStatement("select * from customers where user_id=?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();
		while (rs.next()) {
			customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		}
		return customer;
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
	return customer;
}

	public List<Customer> getAllCustomers()
    {
        Connection con =null;
        ResultSet rs = null;
        Statement stmt = null;
        List<Customer> list = new ArrayList<>();
        Customer customer = null;
        try
        {
            con = DBConnection.getConnection();
            String query = "select * from customers";
            stmt =con.createStatement();
            
            rs=stmt.executeQuery(query);
            while(rs.next()) {
            	customer = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));	
                list.add(customer);
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
	
	public boolean deleteCustomer(int id){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("delete from customers where customer_id=?");
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
	
	
	public boolean updateCustomer(Customer c){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("update customers set first_name=?,last_name=?,email=?,mobile=?,nic_no=? where customer_id=?");
			stmt.setString(1, c.getFirstName());
			stmt.setString(2,c.getLastName());
			stmt.setString(3,c.getEmail());
			stmt.setString(4,c.getMobile());
			stmt.setString(5,c.getNicNo());

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
	
	public boolean createCustomer(Customer c){
		
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DBConnection.getConnection();
			stmt = con.prepareStatement("insert into customers values(customers_sequence.nextval,?,?,?,?,?,?)");
			stmt.setString(1, c.getFirstName());
			stmt.setString(2,c.getLastName());
			stmt.setString(3,c.getEmail());
			stmt.setString(4,c.getMobile());
			stmt.setString(5,c.getNicNo());
			stmt.setInt(6,c.getUser().getUserId());
			
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
