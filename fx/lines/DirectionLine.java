package lines;


import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


class DirectionLine extends Line {
   double initX;
   double initY;
   private double nextX;
   private double nextY;
   
   public DirectionLine(double initX, double initY) {
      super();
      this.initX = initX;
      this.initY = initY;
      this.nextX = 0;
      this.nextY = 0;
      setStroke(Color.SILVER);
   }
   
   public DirectionLine(DirectionLine line) {
      super(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
      this.initX = line.nextX;
      this.initY = line.nextY;
      this.nextX = 0;
      this.nextY = 0;
      setStroke(Color.SILVER);
   }
   
   public DirectionLine(LineEntity entity) {
        super();
        this.setStartX(entity.getStartX());
        this.setStartY(entity.getStartY());
        this.setEndX(entity.getEndX());
        this.setEndY(entity.getEndY());
        this.nextX = entity.getNextX();
        this.nextY = entity.getNextY();
        setStroke(Color.SILVER);
   }
   
   public void goDown() {
        this.setStartX(this.initX);
        this.setStartY(this.initY + 1);
        this.setEndX(this.initX);
        this.setEndY(this.initY + 21);       
        this.nextX = this.initX;
        this.nextY = this.initY + 22;
   }
   
   public void goUp() {
        this.setStartX(this.initX);
        this.setStartY(this.initY - 1);
        this.setEndX(this.initX);
        this.setEndY(this.initY - 21);
        this.nextX = this.initX;
        this.nextY = this.initY - 22;
   }
   
   public void goLeft() {
        this.setStartX(this.initX - 1);
        this.setStartY(this.initY);
        this.setEndX(this.initX - 21);
        this.setEndY(this.initY);
        this.nextX = this.initX - 22;
        this.nextY = this.initY;
   }
   
   public void goRight() {
        this.setStartX(this.initX + 1);
        this.setStartY(this.initY);
        this.setEndX(this.initX + 21);
        this.setEndY(this.initY);
        this.nextX = this.initX + 22;
        this.nextY = this.initY;
   }

    public double getNextX() {
        return nextX;
    }

    public double getNextY() {
        return nextY;
    }
   
}