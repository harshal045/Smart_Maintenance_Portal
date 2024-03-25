package com.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartmentLogin
 */
public class DepartmentLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentLogin() {
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
		String Demail=request.getParameter("depemail");
        String Dpassword=request.getParameter("deppassword");
		PreparedStatement pstm=con.prepareStatement("Select * from department where Demail=? and Dpassword=?");
		pstm.setString(1, Demail);
		pstm.setString(2, Dpassword);
		ResultSet rs=pstm.executeQuery();
		if(rs.next())
		{
			GetSet3.setDepname(rs.getString(3));
			response.sendRedirect("departmentComplain.html");
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
