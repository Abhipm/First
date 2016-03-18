
import java.io.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try{
			System.out.println("hello ");
			String name = request.getParameter("name");
			out.println("Welcome "+name);
		}finally{
			out.close();
		}
		
		String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String pass = request.getParameter("pass");
        try{
        	System.out.println("Connection ");
        //loading drivers for mysql
       Class.forName("com.mysql.jdbc.Driver");
        
        System.out.println("Driver success");
	//creating connection with the database 
        	Connection  con=DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/stud","root","Abhi@1987");
        	System.out.println("Connection success");

       PreparedStatement ps=con.prepareStatement
                 ("insert into Student values(?)");
       System.out.println("Prepared success");
       System.out.println("start setstring");
       ps.setString(1, name);
       System.out.println("in name");
  //     ps.setString(2, email);
  //     ps.setString(3, pass);
       System.out.println("After setstring");
         int i=ps.executeUpdate();
       
         if(i>0)
         {
           out.println("You are sucessfully registered");
         }
       
//        	Statement myStmt = con.createStatement();
//        	System.out.println("Trying to insert");
//        	String sql = "insert into world.mytab" +"(number,name)"+"values(4,s)";
//        	String sql = "insert into stud.student " 
//		             +"(SID,S_FIRST,S_LAST)"
//		             +"values('15','z','x')";
//			myStmt.executeUpdate(sql);
//			System.out.println("Insertion complete");
       }
       catch(Exception se)
       {
           se.printStackTrace();
       }
	//	doGet(request, response);
	}

}
