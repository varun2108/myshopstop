package com.quinnox.basics.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.quinnox.basics.model.Customer;
import com.sun.crypto.provider.RSACipher;

public class CustomerDAO {
	public static Connection getConnection()
	{
		Connection con=null;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");//registering the driver
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","varunky","redhat");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	public static int insertCustomer(Customer c) {
		int status=0;
		try {
				Connection con = getConnection();
			    PreparedStatement ps = con.prepareStatement("insert into users100 values"
			    		+ "(User_id100.NEXTVAL,?,?,?,?)");
			    ps.setString(1, c.getName());
			    ps.setString(2, c.getPassword());
			    ps.setString(3, c.getEmail());
			    ps.setString(4, c.getCountry());
			   
			  status = ps.executeUpdate();
			   

			    con.close();
			} catch (Exception e) {
			    e.printStackTrace();
			  
			}
		 return status;
	}
	public static List<Customer> getAllEmployees(){
		List<Customer> list=new ArrayList<Customer>();
		try{
			Connection con = CustomerDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("Select * from users100");
			ResultSet rs=ps.executeQuery();
			System.out.println(rs.next());
		while(rs.next()){
			Customer c=new Customer();
			c.setId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setPassword(rs.getString(3));
			c.setEmail(rs.getString(4));
			c.setCountry(rs.getString(5));
			
			list.add(c);
			
		}
		con.close();

		}
		catch(Exception e){
			System.out.println(e);
		}
		return list;

	}
	public static Customer getCustomerById(long id){
		Customer c=new Customer();
		try{
			Connection con=CustomerDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users100 where id=?");
			ps.setLong(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				c.setId(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setCountry(rs.getString(5));
			}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return c;
	}
	public static int deleteCustomer(long id){
		int status=0;
		try{
			Connection con=CustomerDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from users100 where id=?");
			ps.setLong(1, id);
			status=ps.executeUpdate();
			
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	public static int updateCustomer(Customer e){  
        int status=0;  
        try{  
            Connection con=CustomerDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
      "update users100 set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setLong(5,e.getId());  
              
            status=ps.executeUpdate();  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    } 
}
