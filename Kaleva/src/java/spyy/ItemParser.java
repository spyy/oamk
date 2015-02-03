
package spyy;

import java.net.URL;
import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;



class ItemParser extends DefaultHandler {
    boolean inItem;
    PrintWriter out;
        
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        this.out.println("Value: " + value);        
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
        if (this.inItem) {
            //System.out.println("uri: " + uri);
            //System.out.println("localName: " + localName);
            //System.out.println("qName: " + qName);
            //System.out.println("attributes: " + Integer.toString(attrs.getLength()));
            this.out.println("localName: " + localName);            
        }
        if (localName.equals("item")) {
            this.inItem = true;
        } 
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {        
        if (localName.equals("item")) {
            this.inItem = false;
        }
    }
    
    public void parseStream(InputStream stream, PrintWriter out) throws IOException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser parser = factory.newSAXParser();

            this.inItem = false;
            this.out = out;
            parser.parse(stream, this);
        }
        catch (Exception e) {
            throw new IOException(e);
        }
                
    } 
    
}