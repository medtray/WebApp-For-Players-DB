
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 


import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ConnectionPool;
@WebServlet("/UpdatePlayer2")

public class UpdatePlayer2 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection                con       = null;
       
        String e = request.getParameter("id");
        String c = request.getParameter("first");
        String a = request.getParameter("last");
        String b = request.getParameter("club");
        String d = request.getParameter("country");
        String f = request.getParameter("position");
        
        System.out.println(e);
        System.out.println(c);
        System.out.println(a);
 
        try {
        	
            ConnectionPool pool = ConnectionPool.getInstance("m0trab01");
            con = pool.getConnection();
            

            PreparedStatement ps = con
                    .prepareStatement("UPDATE PLAYER SET FIRST_NAME=?, SECOND_NAME=?, CLUB=?, COUNTRY=?, POSITION=? where ID=?");
 
            
            ps.setString(1, c);
            ps.setString(2, a);
            ps.setString(3, b);
            ps.setString(4, d);
            ps.setString(5, f);
            ps.setString(6, e);
            
            int i = ps.executeUpdate();
            System.out.println(i);
            if (i > 0)
            {  
            //out.print("it is successfully added...");
            request.setAttribute("Message", "it is successfully Updated...");
            getServletContext().getRequestDispatcher("/PlayersManipulations.jsp").forward(request, response);

            }
            if (i==0)
            {
                //out.print("it is successfully added...");
                request.setAttribute("Message", "add club and country first");
            	getServletContext().getRequestDispatcher("/PlayersManipulations.jsp").forward(request, response);

            	//out.print("add country and club first");
            }
        } catch (Exception e2) {
            System.out.println(e2);
            request.setAttribute("Message", "add club and country first");
        	getServletContext().getRequestDispatcher("/PlayersManipulations.jsp").forward(request, response);

        }
 
        out.close();
    }
 
}
