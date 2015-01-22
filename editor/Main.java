import java.io.*;
import java.util.*;

class Editor {
   FileWriter writer;
   public Editor(String fileName){
      try{
         this.writer = new FileWriter(fileName);
      }
      catch(IOException e){
         System.out.println(e);
      }
   }
   public void save(ArrayList<String> lines){
      try{         
         for(String line: lines){            
            this.writer.write(line);
            this.writer.write("\r\n");
            System.out.println("Rivi tallentui: " + line);
         }
         this.writer.flush();
      }
      catch(IOException e){
         System.out.println(e);
      }      
   }  
}

class Main {
   public static void main(String[] foo){
      System.out.println("Piste lopettaa ja tallettaa.");
      
      Editor editor = new Editor("c:/temp/editor.txt");
      Scanner scanner = new Scanner(System.in);
      ArrayList<String> lines = new ArrayList<String>();
      
      while(true){
         String line = scanner.nextLine();
         if(line.compareTo(".") == 0){
            break;
         }
         lines.add(line);
      }
      
      editor.save(lines);      
   }   
}
