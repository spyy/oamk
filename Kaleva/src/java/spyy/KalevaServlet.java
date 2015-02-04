/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spyy;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sami
 */
public class KalevaServlet extends HttpServlet {

    private void processRss(PrintWriter out) throws IOException {        
        URL kaleva = new URL("http://www.kaleva.fi/rss/show/");        
        InputStream stream = kaleva.openStream();                
        ItemParser parser = new ItemParser();
        parser.parseStream(stream, out);        
        stream.close();
    }
        
    private void generateResponse(PrintWriter out) throws IOException {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet KalevaServlet</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>http://www.kaleva.fi/rss/show/</h1>");
        processRss(out);       
        out.println("</body>");
        out.println("</html>");        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        response.setContentType("text/html;charset=UTF-8");
        this.generateResponse(response.getWriter());
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
