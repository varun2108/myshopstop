package com.quinnox.basics.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quinnox.basics.DAO.CustomerDAO;
import com.quinnox.basics.model.Customer;

/**
 * Servlet implementation class EditServ
 */
@WebServlet("/EditServ")
public class EditServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int status=0;
		long id=Long.parseLong(request.getParameter("id"));
		String name=request.getParameter("name");
		String password=(String)request.getParameter("psw");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		Customer c=new Customer();
		c.setId(id);
		c.setName(name);
		c.setPassword(password);
		c.setEmail(email);
		c.setCountry(country);
		
		status=CustomerDAO.updateCustomer(c);

		if(status>0){
			request.getRequestDispatcher("viewcustomer.jsp").forward(request, response);

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
