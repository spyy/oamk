package tietokanta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    Connection cnn;
    PreparedStatement tuoteStatement;
    PreparedStatement ryhmäStatement;
    long ryhmäId = 0;
    long tuoteId = 0;
    
    public static void main(String[] argh) {
        System.out.println("main");
        Main main = new Main();        
        try {
            main.main();                       
        } catch (SQLException e) {
            System.out.println(e);
        }        
    }
    
    public void main() throws SQLException {
        this.cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/mc", "db", "db");
        this.initDB();
        McReader.lueHinnasto(this);
        this.cnn.close();    
    }
        
    private void initDB() throws SQLException {  
        System.out.println("initDB");
      
        this.dropTables();
        this.createTables();
        this.tuoteStatement = this.cnn.prepareStatement("insert into tuote values (?, ?, ?, ?, ?)");
        this.ryhmäStatement = this.cnn.prepareStatement("insert into tuote_ryhma values (?, ?)");
               
    }
    
    private void createTables() throws SQLException {
        System.out.println("createTables");
        String createTableTuote = "create table tuote (id int, ryhma int, nimi varchar(255), koko varchar(255), hinta varchar(255), primary key (id), foreign key (ryhma) references tuote_ryhma (id) )";
        String createTableTuoteRyhma = "create table tuote_ryhma (id int primary key, nimi varchar(255))";
        
        try (Statement statement = this.cnn.createStatement()) {
            statement.execute(createTableTuoteRyhma);
        }       
        try (Statement statement = this.cnn.createStatement()) {
            statement.execute(createTableTuote);
        }
    }
    
    private void dropTables(){
        System.out.println("dropTables");
        String dropTableTuote = "drop table tuote";
        String dropTableTuoteRyhma = "drop table tuote_ryhma";                
        
        try (Statement statement = this.cnn.createStatement()) {
            statement.execute(dropTableTuote);
        } catch (Exception e) {}
                
        try (Statement statement = this.cnn.createStatement()) {
            statement.execute(dropTableTuoteRyhma);
        } catch (Exception e) {}
    }
    
    public long lisääTuoteryhmä(String[] kentät) throws SQLException {
        this.ryhmäId++;
        this.ryhmäStatement.setInt(1, (int)this.ryhmäId);
        this.ryhmäStatement.setString(2, kentät[0]);
        this.ryhmäStatement.execute();
        return this.ryhmäId;
    }

    public void lisääTuote(String[] kentät) throws SQLException {
        this.tuoteId++;
        this.tuoteStatement.setInt(1, (int)this.tuoteId);
        this.tuoteStatement.setInt(2, (int)this.ryhmäId);
        this.tuoteStatement.setString(3, kentät[0]);
        this.tuoteStatement.setString(4, kentät[1]);
        this.tuoteStatement.setString(5, kentät[2]);        
        this.tuoteStatement.execute();        
    }
        
}
