
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
 


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ConnectionPool;
@WebServlet("/register")

public class register extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection                con       = null;
        String n = request.getParameter("userName");
        String p = request.getParameter("password");
        String e = request.getParameter("first_name");
        String c = request.getParameter("last_name");
 
        try {
        	String sqlStatement = request.getParameter("sqlStatement");
            ConnectionPool pool = ConnectionPool.getInstance("database");
            con = pool.getConnection();
            
            PreparedStatement ps = con
                    .prepareStatement("insert into USERS values(?,?,?,?)");
 
            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(3, e);
            ps.setString(4, c);
 
            int i = ps.executeUpdate();
            if (i > 0)
                
            getServletContext().getRequestDispatcher("/Welcome_page.jsp").forward(request, response);
            out.print("You are successfully registered...");
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
    }
 
}
