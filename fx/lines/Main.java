package lines;


import java.util.List;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
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
        if (entities == null || entities.isEmpty()) {
            System.out.println("ihka eka startti");
        } else {
            for (LineEntity e: entities) {
                DirectionLine line = new DirectionLine(e); 
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
        
        DirectionLine line;
        ObservableList<Node> nodes = this.root.getChildren();
        
        if (nodes.isEmpty()) {
            line = new DirectionLine(100.0f, 340.0f);            
        } else {
            DirectionLine latestLine = (DirectionLine)nodes.get(nodes.size() - 1);
            line = new DirectionLine(latestLine);
        }        
        
        switch (event.getCode()) {
            case DOWN:
                line.goDown();
                break;
            case UP:
                line.goUp();
                break;
            case LEFT:
                line.goLeft();
                break;
            case RIGHT:
                line.goRight();
                break;
            default:
                System.out.println("meni pieleen");
                break;                
        }
        
        if (this.em.getTransaction().isActive() == false) {
            this.em.getTransaction().begin();
        }
        
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
    
    private void keyReleased(KeyEvent event) {                
        if (this.em.getTransaction().isActive()) {
            this.em.getTransaction().commit();
        }
        event.consume();
    }
    
    private void insertEntity(DirectionLine line) {
        LineEntity entity = new LineEntity();
        entity.setStartX(line.getStartX());
        entity.setStartY(line.getStartY());
        entity.setEndX(line.getEndX());
        entity.setEndY(line.getEndY());
        entity.setNextX(line.getEndX());
        entity.setNextY(line.getEndY());
            
        this.em.persist(entity);        
    }
    
    public List getEntities() {
        List resultList = null;
        
        try {
            Query query = this.em.createQuery("SELECT e FROM LineEntity e");
            resultList = query.getResultList();
        } catch(IllegalArgumentException e) {
            System.out.println(e);
        }
        
        return resultList;
    }
 
   @Override
   public void start(Stage stage) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LinesPU");
        this.em = emf.createEntityManager();
        
        this.root = new Group();
       
        this.scene = new Scene(root, 500, 700, Color.BLACK);
        this.scene.getStylesheets().add("/lines/tyylit.css");       
        this.scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> keyPressed(event) );
        this.scene.addEventFilter(KeyEvent.KEY_RELEASED, event -> keyReleased(event) );

        this.startingText = new Text(50, 320, "Käytä nuolinäppäimiä");
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