import java.net.*;
import java.io.*;
import java.util.regex.*;




public class Main {
   static void println(String line, int lineNumber) {
      Pattern pattern = Pattern.compile("href=\"[^\"]*\"");
      
      Matcher matcher = pattern.matcher(line);
      if(matcher.find()) {
         System.out.println(matcher.group());
      }
      
   }
      
   public static void main(String[] args) throws Exception {
      URL oracle = new URL("http://www.oracle.com/");
      BufferedReader in = new BufferedReader(
      new InputStreamReader(oracle.openStream()));
      
      String inputLine;
      int i = 0;
      while ((inputLine = in.readLine()) != null) {
         i++;
         println(inputLine, i);
      }
      in.close();
   }
}