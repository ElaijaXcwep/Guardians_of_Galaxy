package Objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AirCraft extends Rectangle {


    double posX;
    double posY;
    double speed;


    public AirCraft(double posX,double posY,double width,double height){
        this.posX = posX;
        this.posY=posY;
        this.speed=0;
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(Color.RED);
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
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
    public void move(double x,double y){
        setPosX(this.posX+x);
        setPosY(this.posY+y);
    }
}
