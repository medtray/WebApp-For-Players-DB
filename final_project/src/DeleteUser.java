

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.ConnectionPool;
import controllers.UsersController;
/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	Connection connection = null;
        ConnectionPool pool = ConnectionPool.getInstance("database");
        connection = pool.getConnection();
        String userName = request.getParameter("id");
        String password = request.getParameter("password");
        UsersController Ucc = new UsersController(connection);
        Ucc.deleteUser(userName, password);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListOfUsers.jsp");
        dispatcher.forward(request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
}
}
