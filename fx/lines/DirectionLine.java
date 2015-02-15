package lines;


import javafx.scene.input.KeyCode;
import javafx.scene.shape.Line;


class DirectionLine extends Line {
   KeyCode direction;
   
   public DirectionLine(double startX, double startY, double endX, double endY, KeyCode keyCode) {
      super(startX, startY, endX, endY);
      this.direction = keyCode;
   }
   public DirectionLine(DirectionLine line, KeyCode keyCode) {
      super();
      this.direction = keyCode;
      this.setDirection(line);
   }
   public DirectionLine(LineEntity entity) {
        super();
        this.direction = entity.getKeyCode();
        this.setStartX(entity.getStartX());
        this.setStartY(entity.getStartY());
        this.setEndX(entity.getEndX());
        this.setEndY(entity.getEndY());
   }
   private void setDirection(DirectionLine line) {
       switch (this.direction) {
            case DOWN:
                if (line.direction == KeyCode.RIGHT) {
                    this.setStartX(line.getEndX() + 1);
                    this.setStartY(line.getEndY() + 1);
                    this.setEndX(line.getEndX() + 1);
                    this.setEndY(line.getEndY() + 21);
                }
                else if (line.direction == KeyCode.DOWN) {
                    this.setStartX(line.getEndX());
                    this.setStartY(line.getEndY() + 2);
                    this.setEndX(line.getEndX());
                    this.setEndY(line.getEndY() + 22);
                }
                else if (line.direction == KeyCode.UP) {
                    this.Toggle(line);
                }
                else if (line.direction == KeyCode.LEFT) {
                    this.setStartX(line.getEndX() - 1);
                    this.setStartY(line.getEndY() + 1);
                    this.setEndX(line.getEndX() - 1);
                    this.setEndY(line.getEndY() + 21);
                }                
                break;
            case RIGHT:
                if (line.direction == KeyCode.RIGHT) {
                    this.setStartX(line.getEndX() + 2);
                    this.setStartY(line.getEndY());
                    this.setEndX(line.getEndX() + 22);
                    this.setEndY(line.getEndY());
                }
                else if (line.direction == KeyCode.DOWN) {
                    this.setStartX(line.getEndX() + 1);
                    this.setStartY(line.getEndY() + 1);
                    this.setEndX(line.getEndX() + 21);
                    this.setEndY(line.getEndY() + 1);
                }
                else if (line.direction == KeyCode.LEFT) {
                    this.Toggle(line);
                }
                else if (line.direction == KeyCode.UP) {
                    this.setStartX(line.getEndX() + 1);
                    this.setStartY(line.getEndY() - 1);
                    this.setEndX(line.getEndX() + 21);
                    this.setEndY(line.getEndY() - 1);
                }                
                break;
            case UP:
                if (line.direction == KeyCode.RIGHT) {
                    this.setStartX(line.getEndX() + 1);
                    this.setStartY(line.getEndY() - 1);
                    this.setEndX(line.getEndX() + 1);
                    this.setEndY(line.getEndY() - 21);
                }
                else if (line.direction == KeyCode.DOWN) {
                    this.Toggle(line);
                }
                else if (line.direction == KeyCode.UP) {
                    this.setStartX(line.getEndX());
                    this.setStartY(line.getEndY() - 2);
                    this.setEndX(line.getEndX());
                    this.setEndY(line.getEndY() - 22);
               
                }
                else if (line.direction == KeyCode.LEFT) {
                    this.setStartX(line.getEndX() - 1);
                    this.setStartY(line.getEndY() - 1);
                    this.setEndX(line.getEndX() - 1);
                    this.setEndY(line.getEndY() - 21);
                }                
                break;
            case LEFT:
                if (line.direction == KeyCode.RIGHT) {
                    this.Toggle(line);
                }
                else if (line.direction == KeyCode.DOWN) {
                    this.setStartX(line.getEndX() - 1);
                    this.setStartY(line.getEndY() + 1);
                    this.setEndX(line.getEndX() - 21);
                    this.setEndY(line.getEndY() + 1);
                }
                else if (line.direction == KeyCode.LEFT) {
                    this.setStartX(line.getEndX() - 2);
                    this.setStartY(line.getEndY());
                    this.setEndX(line.getEndX() - 22);
                    this.setEndY(line.getEndY());                    
                }
                else if (line.direction == KeyCode.UP) {
                    this.setStartX(line.getEndX() - 1);
                    this.setStartY(line.getEndY() - 1);
                    this.setEndX(line.getEndX() - 21);
                    this.setEndY(line.getEndY() - 1);
                }                
            default:
                break;                
        }
   }   
   private void Toggle(DirectionLine line) {
        this.setStartX(line.getEndX());
        this.setStartY(line.getEndY());
        this.setEndX(line.getStartX());
        this.setEndY(line.getStartY());
   }     
}