package com.quinnox.basics.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quinnox.basics.model.LoginModl;
import com.quinnox.basics.DAO.*;

/**
 * Servlet implementation class SessionServelet
 */
@WebServlet("/SessionServelet")
public class SessionServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{PrintWriter pw=response.getWriter();
		//response.setContentType("text/html");
		String user=request.getParameter("u");
		String pass=request.getParameter("p");
		
		LoginModl c=new LoginModl();
		c.setName(user);
		c.setPassword(pass);

		int status= LoginDAO.getcustomer(c);
		if(status>0){
			pw.print("Login successfull</p>");
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			request.getRequestDispatcher("viewcustomer.jsp").forward(request, response);
			
		}
		else{
			pw.print("Error in login");
		}
	}catch(Exception e){
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
