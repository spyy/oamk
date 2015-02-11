package tietokanta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] argh) {
        System.out.println("main");
        try {
            Main.initDB();
            
        } catch (SQLException e) {
            System.out.println(e);
        }        
    }
        
    public static void initDB() throws SQLException {  
        System.out.println("initDB");
        Connection c = null;
        
        try {
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/mc", "db", "db");
            Main.dropTables(c);
            Main.createTables(c);            
        } finally {
            if (c != null) c.close();
        }                
    }
    
    private static void createTables(Connection c ) throws SQLException {
        String createTableTuote = "create table tuote (id int, ryhma int, nimi varchar(255), koko varchar(255), hinta decimal(10,2), primary key (id), foreign key (ryhma) references tuote_ryhma (id) )";
        String createTableTuoteRyhma = "create table tuote_ryhma (id int primary key, nimi varchar(255))";
        
        try (Statement statement = c.createStatement()) {
            statement.execute(createTableTuoteRyhma);
        }       
        try (Statement statement = c.createStatement()) {
            statement.execute(createTableTuote);
        }
    }
    
    private static void dropTables(Connection c ){
        System.out.println("dropTables");
        String dropTableTuote = "drop table tuote";
        String dropTableTuoteRyhma = "drop table tuote_ryhma";                
        
        try (Statement statement = c.createStatement()) {
            statement.execute(dropTableTuote);
        } catch (Exception e) {}
                
        try (Statement statement = c.createStatement()) {
            statement.execute(dropTableTuoteRyhma);
        } catch (Exception e) {}
    }
}
