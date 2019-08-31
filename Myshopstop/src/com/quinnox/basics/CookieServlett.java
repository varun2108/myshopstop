package com.quinnox.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlett
 */
@WebServlet("/CookieServlett")
public class CookieServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlett() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			String user=request.getParameter("userName");
			String pass=request.getParameter("userpassword");
			pw.print("Hello here:"+user);
			pw.print("The password is: "+pass);
			
			Cookie c1=new Cookie("username",user);
			Cookie c2=new Cookie("password",pass);
			
			response.addCookie(c1);
			response.addCookie(c2);
			
			pw.print("<a href='WelcomeCookie'>View Details</a>");
			pw.close();
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
