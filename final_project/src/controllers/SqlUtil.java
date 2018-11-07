package controllers;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
public class SqlUtil
{
    public static String getHtmlTable(ResultSet results) throws SQLException
    {
        StringBuffer htmlRows = new StringBuffer();
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();
        htmlRows.append("<table cellpadding=\"5\" border=\"1\">");
        htmlRows.append("<tr>");
        for (int i = 1; i <= columnCount; i++)
            htmlRows.append("<td><b>" + metaData.getColumnName(i) + "</td>");
        htmlRows.append("</tr>");
        while (results.next())
        {
            htmlRows.append("<tr>");
            for (int i = 1; i <= columnCount; i++)
            {
                htmlRows.append("<td>" + results.getString(i) + "</td>");
            } // end for
        }
        htmlRows.append("</tr>");
        htmlRows.append("</table>");
        return htmlRows.toString();
    }
}
