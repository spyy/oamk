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

class DirectionLine extends Line {
   KeyCode direction;
   
   public DirectionLine(double startX, double startY, double endX, double endY, KeyCode keyCode) {
      super(startX, startY, endX, endY);
      this.direction = keyCode;
   }
   public DirectionLine(DirectionLine line, KeyCode keyCode) throws Exception{
      super();
      this.direction = keyCode;
      this.setDirection(line);
   }
   private void setDirection(DirectionLine line) throws Exception{
       switch (this.direction) {
            case DOWN:
                if (line.direction == KeyCode.RIGHT) {
                    this.setStartX(line.getEndX() + 1);
                    this.setStartY(line.getEndY());
                    this.setEndX(line.getEndX() + 1);
                    this.setEndY(line.getEndY() + 19);
                }
                else if (line.direction == KeyCode.DOWN) {
                    this.setStartX(line.getEndX());
                    this.setStartY(line.getEndY() + 1);
                    this.setEndX(line.getEndX() + 19);
                    this.setEndY(line.getEndY());
                }
                break;
            default:
                break;                
        }
   }
   
   
}