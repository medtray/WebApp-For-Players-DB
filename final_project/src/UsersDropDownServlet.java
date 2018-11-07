

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.DatabaseConnectionController;
import controllers.UsersController;
/**
 * Servlet implementation class UsersDropdownServlet
 */
@WebServlet("/UsersDropDownServlet")
public class UsersDropDownServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersDropDownServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int columnCount = 0;
        ResultSetMetaData metaData;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<BR>");
        out.println("<BODY>");
        // out.println("<input type=hidden name = \"mem_id\" velue = \"\">");
        out.println("<table cellpadding=\"5\" border=\"2\">");
        out.println("<tr>");
        DatabaseConnectionController dbCC = new DatabaseConnectionController("m0trab01");
        dbCC.establishDBConnection();
        UsersController Ucc = new UsersController(dbCC.getDbConnection());
        ResultSet rs = Ucc.getUsersList();
        try
        {
            metaData = rs.getMetaData();
            columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++)
            {
                out.println("<td><b>" + metaData.getColumnName(i) + "</td>");
            }
            out.println("</tr>");
            while (rs.next())
            {
                out.println("<tr>");
                for (int i = 1; i <= columnCount; i++)
                {
                    out.println("<td>" + rs.getString(i) + "</td>");
                } // end for
            } // end while
        }
        catch (SQLException sqle)
        {
            System.out.println("Could not read result set");
            sqle.printStackTrace();
        }
        out.println("</tr>");
        out.println("</table>");
        out.println("<FORM METHOD=POST>");
        out.println("<select name=\"mydropdown\">");
        try
        {
            rs = Ucc.getUsersList();
            while (rs.next())
            {
                String fullName = rs.getString(3) + " " + rs.getString(4);
                String myOption = "<option value=\"" + rs.getString(1) + "\">" + fullName + "</option>";
                out.println(myOption);
            } // end while
        }
        catch (Exception e)
        {
            System.out.println("Could not read result set");
            e.printStackTrace();
        } // end try catch
        out.println("</select>");
        out.println("<BR>");
        out.println("<input type=\"submit\" value=\"Select\">");
        out.println("</FORM>");
        out.println("</BODY>");
        dbCC.disconnectFromDatabase();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String member = "";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (session != null)
        {
            member = (String) session.getAttribute("member_id");
            out.println("<BR>");
            out.println("Member: " + member + "<BR>");
            request.setAttribute("mem_id", request.getParameter("mydropdown"));
        }
        else
        {
            System.out.println("Session is null");
        }
        session.setAttribute("member_id", request.getParameter("mydropdown"));
        // out.println("<BR>");
        // out.println("User: " + request.getParameter("mydropdown") + "<BR>");
        // out.println("<BR>");
        // out.println("User: " + session.getAttribute("member_id") + "<BR>");
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/userInsert.jsp");
        dispatcher.include(request, response);
    }
}
