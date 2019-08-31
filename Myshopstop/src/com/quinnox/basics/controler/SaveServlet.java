package com.quinnox.basics.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.quinnox.basics.model.Customer;
import com.quinnox.basics.DAO.CustomerDAO ;

/**
 * Servlet implementation class SaveServelet
 */
@WebServlet("/SaveServelet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String name=request.getParameter("name");
		String password=(String)request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		Customer c=new Customer();
		c.setName(name);
		c.setPassword(password);
		c.setEmail(email);
		c.setCountry(country);

		int status= CustomerDAO.insertCustomer(c);
		if(status>0){
			pw.print("record saved successfully</p>");

			request.getRequestDispatcher("login.html").include(request, response);
			
		}
		else{
			pw.print("Error in insertng");
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
