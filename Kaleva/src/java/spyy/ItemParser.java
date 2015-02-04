
package spyy;

import java.net.URL;
import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;



class ItemParser extends DefaultHandler {
    boolean inItem;
    PrintWriter out;
    String title;
    String description;
    String link; 
    String qName;
    
        
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        
        if (this.qName.equals("title")) {
            this.title = value;
        }
        else if (this.qName.equals("description")) {
            this.description = value;
        }
        else if (this.qName.equals("link")) {
            this.link = value;
        }
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if (this.inItem) {
            this.qName = qName;            
        }
        if (localName.equals("item")) {
            this.inItem = true;
        } 
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {        
        if (localName.equals("item")) {
            this.inItem = false;
            this.out.println("<dl>");
            this.out.println("<dt><a href='" + this.link + "'>" + this.title + "</a></dt>");
            this.out.println("<dd>" + this.description  + "</dd>");
            this.out.println("</dl>");
        }
    }
    
    public void parseStream(InputStream stream, PrintWriter out) throws IOException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();

            this.inItem = false;
            this.out = out;
            this.qName = "";
            this.description = "";
            this.link = "";
            this.title = "";
            
            parser.parse(stream, this);
        }
        catch (Exception e) {
            throw new IOException(e);
        }                
    }     
}