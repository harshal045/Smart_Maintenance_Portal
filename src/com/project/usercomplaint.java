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
 * Servlet implementation class usercomplaint
 */
public class usercomplaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usercomplaint() {
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
		String title=request.getParameter("utitle");
		String description=request.getParameter("udesc");
		String department=request.getParameter("udept");
		String image=request.getParameter("uimage");
		String name=request.getParameter("uname");	
		String comment=null;
		String status="pending";
		String dcomment=null;
		
			PreparedStatement stmp=con.prepareStatement("Insert into complaint values(?,?,?,?,?,?,?,?)");
			stmp.setString(1, title);
			stmp.setString(2,description);
			stmp.setString(3, department);
			stmp.setString(4,image);
			stmp.setString(5, name);
			stmp.setString(6, comment);
			stmp.setString(7, status);
			stmp.setString(8,dcomment);
			int k=stmp.executeUpdate();
			if(k>0)
					{
				
				response.sendRedirect("userchoice.html");
					}
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
