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
 * Servlet implementation class AddDep
 */
public class AddDep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDep() {
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
		String demail=request.getParameter("deemail");
		String dpass=request.getParameter("depassword");
		String dname=request.getParameter("dename");
		String dtaluka=request.getParameter("detaluka");
		String ddistrict=request.getParameter("dedistrict");
		String daddress=request.getParameter("deaddress");
		int dmobile=Integer.parseInt(request.getParameter("demobile"));
		
			PreparedStatement stm2=con.prepareStatement("Insert into department values(?,?,?,?,?,?,?)");
			stm2.setString(1, demail);
			stm2.setString(2, dpass);
			stm2.setString(3, dname);
			stm2.setString(4, dtaluka);
			stm2.setString(5, ddistrict);
			stm2.setString(6,daddress);
			stm2.setInt(7, dmobile);
			int i=stm2.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("department.html");
			}
			else
			{
				response.sendRedirect("404.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
