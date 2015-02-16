/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lines;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author sami
 */
@Entity
@Table (name="Line")
public class LineEntity implements Serializable {
    //private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double startX;
    private double startY;
    private double endX;
    private double endY;
    private double nextX;
    private double nextY;    
        
    
    public double getStartX() {
        return startX;
    }

    public void setStartX(double startX) {
        this.startX = startX;
    }

    public double getStartY() {
        return startY;
    }

    public void setStartY(double startY) {
        this.startY = startY;
    }

    public double getEndX() {
        return endX;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public double getEndY() {
        return endY;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    public double getNextX() {
        return nextX;
    }

    public void setNextX(double nextX) {
        this.nextX = nextX;
    }

    public double getNextY() {
        return nextY;
    }

    public void setNextY(double nextY) {
        this.nextY = nextY;
    }
    
}
