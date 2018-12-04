
 
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
@WebServlet("/add_player")

public class add_player extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection                con       = null;
       
        String e = request.getParameter("first_name");
        String c = request.getParameter("last_name");
        String a = request.getParameter("club");
        String b = request.getParameter("country");
        String d = request.getParameter("position");
 
        try {
        	
            ConnectionPool pool = ConnectionPool.getInstance("database");
            con = pool.getConnection();
            String query = "SELECT * FROM PLAYER";
            System.out.println("houni1");
            
            Statement s = con.createStatement();
            ResultSet rs1 = s.executeQuery(query);
            
            
            System.out.println("houni2");
            int size =0;
            while(rs1.next())
            {

            size++;
            }
            System.out.println(size);

            PreparedStatement ps = con
                    .prepareStatement("insert into PLAYER values(?,?,?,?,?,?)");
 
            ps.setInt(1, size+109);
            ps.setString(2, e);
            ps.setString(3, c);
            ps.setString(4, a);
            ps.setString(5, b);
            ps.setString(6, d);
 
            int i = ps.executeUpdate();
            if (i > 0)
            {  
            //out.print("it is successfully added...");
            request.setAttribute("Message", "it is successfully added...");
            getServletContext().getRequestDispatcher("/PlayersManipulations.jsp").forward(request, response);

            }
            if (i==0)
            {
                //out.print("it is successfully added...");
                request.setAttribute("Message", "add country and club first");
            	getServletContext().getRequestDispatcher("/PlayersManipulations.jsp").forward(request, response);

            	//out.print("add country and club first");
            }
        } catch (Exception e2) {
            System.out.println(e2);
            request.setAttribute("Message", "add country and club first");
        	getServletContext().getRequestDispatcher("/PlayersManipulations.jsp").forward(request, response);

        }
 
        out.close();
    }
 
}
