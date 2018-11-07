

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
@WebServlet("/option_choice")
public class option_choice extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String item = request.getParameter("item");
    	
    	if (item.equals("4"))
    	{
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UsersManipulations.jsp");
            dispatcher.forward(request, response);
    	}
    	
    	if (item.equals("1"))
    	{
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PlayersManipulations.jsp");
            dispatcher.forward(request, response);
    	}
    	
    	if (item.equals("3"))
    	{
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CountriesManipulations.jsp");
            dispatcher.forward(request, response);
    	}
    	
    	if (item.equals("2"))
    	{
    		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ClubsManipulations.jsp");
            dispatcher.forward(request, response);
    	}
       
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
}
}
