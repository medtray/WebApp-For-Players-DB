package controllers;

import java.io.IOException;
import java.sql.Connection;

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
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String userName = request.getParameter("user");
        String password = request.getParameter("password");
        if (login(userName, password))
        {
            System.out.println("Found user");
            getServletContext().getRequestDispatcher("/DisplayUsers.jsp").forward(request, response);
        }
        else
        {
            System.out.println("Did not find user");
            getServletContext().getRequestDispatcher("/UserLogin.jsp").forward(request, response);
        }
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.doPost(request, response);
    }
    private boolean login(String userId, String password)
    {
        boolean rc = false;
        Connection connection = null;
        ConnectionPool pool = ConnectionPool.getInstance("jdbc/COMPANY");
        connection = pool.getConnection();
        UsersController Ucc = new UsersController(connection);
        if (Ucc.findUser(userId, password))
        {
            rc = true;
        } // end if
        pool.freeConnection(connection);
        return rc;
    }
}
