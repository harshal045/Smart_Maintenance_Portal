package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
		Connection con=DatabaseConnect.connect();
		String name=request.getParameter("urname");
		String email=request.getParameter("uremail");
		String password=request.getParameter("urpassword");
		String address=request.getParameter("uraddress");
		int mobile=Integer.parseInt(request.getParameter("urmobile"));
		
			PreparedStatement stm6=con.prepareStatement("Insert into user values(?,?,?,?,?)");
			stm6.setString(1, name);
			stm6.setString(2,email);
			stm6.setString(3,password);
			stm6.setInt(4,mobile);
			stm6.setString(5, address);
			int j=stm6.executeUpdate();
			if(j>0)
			{
				response.sendRedirect("userRegister.html");
			}
			else{
				response.sendRedirect("404.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
