 
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

 
public class Main extends Application {
 
   @Override
   public void start(Stage stage) {
       Group root = new Group();
       Scene scene = new Scene(root, 500, 700, Color.BLACK);
       stage.setTitle("FX harjoitus");
       stage.setScene(scene);
       stage.show();
   }
 
   public static void main(String[] args) {
       launch(args);
   }
}