
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Player;
import controllers.ConnectionPool;
import controllers.SqlUtil;
import controllers.UsersController;
/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/GetPlayersByClub")
public class GetPlayersByClub extends HttpServlet
{
	
	public String             sqlResult        = "";
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	Connection connection = null;
        ConnectionPool pool = ConnectionPool.getInstance("database");
        connection = pool.getConnection();
        String userName = request.getParameter("club");
        
        System.out.println(userName);
        
        UsersController Ucc = new UsersController(connection);
        ResultSet aa= Ucc.GetPlayerbyClub(userName);
        //request.setAttribute("players", aa);
        try {
			sqlResult = SqlUtil.getHtmlTable(aa);
			request.setAttribute("sqlResult", sqlResult);
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/DisplayPlayersByClub.jsp");
		        dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
}
}
