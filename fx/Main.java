
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.InputEvent;
import javafx.scene.shape.Line;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Main extends Application {
    Group root;
    Scene scene;
    Boolean notStarted = true;
    Text startingText;
    
    private void arrowPressed(KeyEvent event) {        
        if (this.notStarted) {
            this.notStarted = false;
            this.root.getChildren().remove(this.startingText);
            System.out.println("Terminator started");
        }
        
        ObservableList<Node> nodes = this.root.getChildren();
        Line latestLine = (Line)nodes.get(nodes.size() - 1);
        System.out.println(latestLine.toString());
        
        Double startX = latestLine.getStartX();
        Double startY = latestLine.getStartY();
        Double endX = latestLine.getEndX();
        Double endY = latestLine.getEndY();
        
        switch (event.getCode()) {
            case DOWN:
                startX = endX + 1;
                startY = endY;
                endX = startX;
                endY = endY + 19;
                System.out.println("DOWN event ");
                break;
            default:
                break;                
        }
        
        Line line = new Line();
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.setStroke(Color.SILVER);
        
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
 
   @Override
   public void start(Stage stage) {
        this.root = new Group();
       
        this.scene = new Scene(root, 500, 700, Color.BLACK);
        this.scene.getStylesheets().add("tyylit.txt");       
        this.scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> keyPressed(event) );

        this.startingText = new Text(50, 320, "Aloita painamalla nuolinäppäintä");
        this.startingText.setId("aloitusteksti");

        LineNode line = new LineNode(100.0f, 340.0f, 120.0f, 340.0f, KeyCode.RIGHT);
        //line.setStartX(100.0f);
        //line.setStartY(340.0f);
        //line.setEndX(120.0f);
        //line.setEndY(340.0f);
        //line.setFill(Color.SILVER);
        line.setStroke(Color.SILVER);
       
        this.root.getChildren().add(this.startingText);
        this.root.getChildren().add(line);

        stage.setTitle("Terminator");
        stage.setScene(scene);
        stage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
}