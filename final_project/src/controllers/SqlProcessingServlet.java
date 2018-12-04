package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.ConnectionPool;
@WebServlet("/SqlProcessingServlet")
public class SqlProcessingServlet extends HttpServlet
{
    public ResultSet          resultSet        = null;
    public Statement          statement        = null;
    public String             sqlResult        = "";
    private static final long serialVersionUID = 1L;
    Connection                connection       = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String sqlStatement = request.getParameter("sqlStatement");
        ConnectionPool pool = ConnectionPool.getInstance("");
        connection = pool.getConnection();
        parseAndExecute(sqlStatement, connection);
        pool.freeConnection(connection);
        HttpSession session = request.getSession();
        session.setAttribute("sqlResult", sqlResult);
        session.setAttribute("sqlStatement", sqlStatement);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/SQLProcessor.jsp");
        dispatcher.forward(request, response);
    }
    private void parseAndExecute(String sqlStatement, Connection connection)
    {
        try
        {
            statement = connection.createStatement();
            sqlStatement = sqlStatement.trim();
            if (sqlStatement.length() >= 6)
            {
                String sqlType = sqlStatement.substring(0, 6);
                if (sqlType.equalsIgnoreCase("select"))
                {
                    try
                    {
                        resultSet = statement.executeQuery(sqlStatement);
                        sqlResult = SqlUtil.getHtmlTable(resultSet);
                        resultSet.close();
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Cannot execute query");
                        e.printStackTrace();
                    }
                }
                else
                {
                    try
                    {
                        int i = -1;
                        i = statement.executeUpdate(sqlStatement);
                        if (i == 0)
                        {
                            sqlResult = "The statement executed successfully.";
                        }
                        else
                        {
                            sqlResult = "The statement executed successfully.<br>" + i + " row(s) affected.";
                        } // end if
                    }
                    catch (SQLException e)
                    {
                        System.out.println("Cannot execute query");
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println("Could not create statment: " + e.getMessage());
        }
    }
}
