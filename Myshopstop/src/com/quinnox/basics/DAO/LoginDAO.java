package com.quinnox.basics.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.basics.model.LoginModl;

public class LoginDAO  {
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
	public static int getcustomer(LoginModl c) {
		 int status=0;
		try {
				Connection con = getConnection();
			    PreparedStatement ps = con.prepareStatement("select * from users100 where name=? and password=?");
			    ps.setString(1, c.getName());
			    ps.setString(2, c.getPassword());
			   
			  ResultSet rs= ps.executeQuery();
			   
			  while(rs.next())
				  status=rs.getInt(1);
			    con.close();
			} catch (Exception e) {
			    e.printStackTrace();
			  
			}
		 return status;
	}


}
