package controllers;

public class StringUtil
{
	/**
     * Encode an HTML tag so it will be displayed
     * as it is on the browser.
     * Particularly, this method searches the
     * passed in String and replace every occurrence
     * of the following character:
     * '<' with "&lt;"
     * '>' with "&gt;"
     * '&' with "&amp;"
     * //'"' with "&quot;"
     * ' ' with "&nbsp;"
     */
    public static String encodeHtmlTag(String tag)
    {
        if (tag == null)
            return null;
        int length = tag.length();
        StringBuffer encodedTag = new StringBuffer(2 * length);
        for (int i = 0; i < length; i++)
        {
            char c = tag.charAt(i);
            if (c == '<')
                encodedTag.append("&lt;");
            else if (c == '>')
                encodedTag.append("&gt;");
            else if (c == '&')
                encodedTag.append("&amp;");
            else if (c == '"')
                encodedTag.append("&quot;"); // when trying to output text as tag's value as in
            // values="???".
            else if (c == ' ')
                encodedTag.append("&nbsp;");
            else
                encodedTag.append(c);
        }
        return encodedTag.toString();
    }
    /**
     * This method replaces every occurrence of single quote character ' with two single quote characters ''
     */
    public static String fixSqlFieldValue(String value)
    {
        if (value == null)
            return null;
        int length = value.length();
        StringBuffer fixedValue = new StringBuffer((int) (length * 1.1));
        for (int i = 0; i < length; i++)
        {
            char c = value.charAt(i);
            if (c == '\'')
                fixedValue.append("''");
            else
                fixedValue.append(c);
        }
        return fixedValue.toString();
    }

}
