

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

class LineNode extends Line {
   KeyCode keyCode;
   
   public LineNode(double startX, double startY, double endX, double endY, KeyCode keyCode) {
      super(startX, startY, endX, endY);
      this.keyCode = keyCode;
   }

}