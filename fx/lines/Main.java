package lines;


import java.util.List;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main extends Application {
    Group root;
    Scene scene;
    Boolean notStarted = true;
    Text startingText;
    EntityManager em;
    
    private void initLines() {        
        List<LineEntity> entities = this.getEntities();
        if (entities.isEmpty()) {
            DirectionLine line = new DirectionLine(100.0f, 340.0f, 120.0f, 340.0f, KeyCode.RIGHT);
            line.setStroke(Color.SILVER);        
            this.root.getChildren().add(line);
        } else {
            for (LineEntity e: entities) {
                DirectionLine line = new DirectionLine(e);
                line.setStroke(Color.SILVER);        
                this.root.getChildren().add(line);
            }
        }
    }
    
    private void arrowPressed(KeyEvent event) {        
        if (this.notStarted) {
            this.notStarted = false;
            this.root.getChildren().remove(this.startingText);
            this.initLines();
            System.out.println("Ruutukone starttasi");
        }
        
        ObservableList<Node> nodes = this.root.getChildren();
        DirectionLine latestLine = (DirectionLine)nodes.get(nodes.size() - 1);
            
        DirectionLine line = new DirectionLine(latestLine, event.getCode());
        line.setStroke(Color.SILVER);
        
        this.insertEntity(line);        
        
        this.root.getChildren().add(line);
    }
    
    private void keyPressed(KeyEvent event) {                
        switch (event.getCode()) {
            case DOWN:
            case UP:
            case LEFT:
            case RIGHT:
                this.arrowPressed(event);
                break;
            default:
                break;                
        }
        
        event.consume();
    }
    
    public void insertEntity(DirectionLine line) {
        LineEntity entity = new LineEntity();
        entity.setKeyCode(line.direction);
        entity.setStartX(line.getStartX());
        entity.setStartY(line.getStartY());
        entity.setEndX(line.getEndX());
        entity.setEndY(line.getEndY());
    
        this.em.getTransaction().begin();
        this.em.persist(entity);
        this.em.getTransaction().commit();
    }
    
    public List getEntities() {
        Query query = this.em.createQuery("SELECT e FROM LineEntity e");
        return query.getResultList();
    }
 
   @Override
   public void start(Stage stage) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaFXProject2PU");
        this.em = emf.createEntityManager();
        
        this.root = new Group();
       
        this.scene = new Scene(root, 500, 700, Color.BLACK);
        this.scene.getStylesheets().add("tyylit.txt");       
        this.scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> keyPressed(event) );

        this.startingText = new Text(50, 320, "Aloita painamalla nuolinäppäintä");
        this.startingText.setId("aloitusteksti");
        
        this.root.getChildren().add(this.startingText);

        stage.setTitle("Manuaalinen ruutukone");
        stage.setScene(scene);
        stage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
}