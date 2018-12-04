

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Country;
import model.Users;
import controllers.ConnectionPool;
import controllers.UsersController;
/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/checklogin2")
public class checklogin2 extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String userName = request.getParameter("id");
        String password = request.getParameter("password");
        Users user = null;
        user=login(userName, password);
        if (user.getFirst_name().isEmpty())
        {
        	 System.out.println("Did not find user");
             request.setAttribute("errorMessage", "Invalid user or password");
             getServletContext().getRequestDispatcher("/login_page.jsp").forward(request, response);
        }
        else
        {
           
            
            System.out.println("Found user");
            request.setAttribute("successMessage", "Congratulations, You are now logged in!");
           
           
            request.setAttribute("successMessage", user.getFirst_name()+" "+user.getSecond_name());
            getServletContext().getRequestDispatcher("/application_page.jsp").forward(request, response);
        }
    }
    private Users login(String userId, String password)
    {
        boolean rc = false;
        Connection connection = null;
        ConnectionPool pool = ConnectionPool.getInstance("database");
        connection = pool.getConnection();
        UsersController Ucc = new UsersController(connection);
        Users user = new Users("","","","");
        if (Ucc.findUser(userId, password))
        {
            rc = true;
            
            UsersController Ucc1 = new UsersController(connection);
            ResultSet rs;
            rs=Ucc1.getUserRecord(userId, password);
            int Nb1 = 0;
            
			
				try {
					while (rs.next()) {
						user = new Users(rs.getString("ID"),rs.getString("PASSWORD"),rs.getString("FIRST_NAME"),rs.getString("SECOND_NAME"));
						++Nb1;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
        } // end if
        pool.freeConnection(connection);
        return user;
    }
}
