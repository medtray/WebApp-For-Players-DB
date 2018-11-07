
 
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
@WebServlet("/add_club")

public class add_club extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection                con       = null;
       
        String e = request.getParameter("club_name");
        String c = request.getParameter("country_name");
       
 
        try {
        	
            ConnectionPool pool = ConnectionPool.getInstance("m0trab01");
            con = pool.getConnection();
            

            PreparedStatement ps = con
                    .prepareStatement("insert into CLUB values(?,?)");
 
            
            ps.setString(1, e);
            ps.setString(2, c);
            
 
            int i = ps.executeUpdate();
            if (i > 0)
            {  
            //out.print("it is successfully added...");
            request.setAttribute("Message", "it is successfully added...");
            getServletContext().getRequestDispatcher("/ClubsManipulations.jsp").forward(request, response);

            }
            if (i==0)
            {
                //out.print("it is successfully added...");
                request.setAttribute("Message", "add country and club first");
            	getServletContext().getRequestDispatcher("/ClubsManipulations.jsp").forward(request, response);

            	//out.print("add country and club first");
            }
        } catch (Exception e2) {
            System.out.println(e2);
            request.setAttribute("Message", "add country and club first");
        	getServletContext().getRequestDispatcher("/ClubsManipulations.jsp").forward(request, response);

        }
 
        out.close();
    }
 
}
