package Objects;

import javafx.scene.shape.Circle;

public class Asteroid extends Circle {

    double posX;
    double posY;
    double speed;
    double size;  //size is radius of bullet

    public Asteroid(double posX,double posY){
        this.posX = posX;
        this.posY=posY;
        this.speed=0;
        this.size=1;
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
    public void setSize(double r){
        this.size = r;
    }
    public void move(double x,double y){
        setPosX(this.posX+x);
        setPosY(this.posY+y);
    }

}
