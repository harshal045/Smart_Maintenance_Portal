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
 * Servlet implementation class Road
 */
public class Road extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Road() {
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
		String rname=request.getParameter("rdname");
		String rlocation=request.getParameter("rdlocation");
		String rdepartment=request.getParameter("rddepartment");
		String rdate=request.getParameter("rddate");
		PreparedStatement stm4=con.prepareStatement("Insert into road values(?,?,?,?)");
		stm4.setString(1,rname);
		stm4.setString(2, rlocation);
		stm4.setString(3, rdepartment);
		stm4.setString(4, rdate);
	int y=stm4.executeUpdate();
	if(y>0)
	{
		response.sendRedirect("index.html");
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
