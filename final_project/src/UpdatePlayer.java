
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;
import controllers.ConnectionPool;
import controllers.UsersController;
/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UpdatePlayer")
public class UpdatePlayer extends HttpServlet
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
        
        System.out.println(userName);
        Player NewUser = null;
        UsersController Ucc = new UsersController(connection);
        NewUser=Ucc.selectPlayer(userName);
        request.setAttribute("a",NewUser.getId());
        request.setAttribute("b",NewUser.getFirst_name());
        request.setAttribute("c",NewUser.getSecond_name());
        request.setAttribute("d",NewUser.getClub());
        request.setAttribute("e",NewUser.getCountry());
        request.setAttribute("f",NewUser.getPosition());
        
        getServletContext().getRequestDispatcher("/UpdatePlayers.jsp").forward(request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
}
}
