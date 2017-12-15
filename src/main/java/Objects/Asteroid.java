package Objects;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Asteroid extends Circle {

    double posX;
    double posY;
    double speed;
    int size;  //size is radius of bullet
    Random random;
    public Asteroid(double size){

        random = new Random();
        int i = random.nextInt((int)size*9);
        this.size = random.nextInt(12)+6;
        this.posX = size*16+8;
        this.posY = i;
        if (this.size==0){size++;}
        this.setRadius(this.size);
        this.setFill(Color.GREEN);

    }
    public void setPosX(double x){
        this.posX=x;
    }

    public void setPosY(double Y){
        this.posY=Y;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setSpeed(double speed){
        this.speed=speed;
    }

    public void move(double x,double y){
        setPosX(this.posX+x);
        setPosY(this.posY+y);
    }

}
