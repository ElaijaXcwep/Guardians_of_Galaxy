package Objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Bullet extends Circle {

    double posX;
    double posY;
    double speed;
    double size;  //size is radius of bullet

    public Bullet(double posX,double posY){
        this.posX = posX;
        this.posY=posY;
        this.speed=0;
        this.size=10;
        this.setRadius(3);
        this.setFill(Color.RED);
    }
    public void setPosX(double x){
        this.posX=x;
    }

    public void setPosY(double Y){
        this.posY=Y;
    }
    public void setSpeed(double speed){
        this.speed=speed;
    }
    //public void setSize(double r){
      //  this.size = r;
    //}
    public void move(double x,double y){
        setPosX(this.posX+x);
        setPosY(this.posY+y);
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
}
