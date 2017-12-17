package Objects;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Asteroid extends Circle {

    Image image;
    double posX;
    double posY;
    double speed;
    double HitPoints;
    int size;  //size is radius of bullet
    int dangerous;
    Random random;



    public Asteroid(double size){

        random = new Random();
        int i = random.nextInt((int)size*9);
        this.size = random.nextInt(32)+6;


        this.HitPoints = (size-6)*0.1;
        this.posX = size*16+8;
        this.posY = i;
        if (this.size==0){size++;}
        this.setRadius(this.size);

        this.image = new Image(String.valueOf(getClass().getResource("/Images/Asteroid1.png")));
        ImageView imageView = new ImageView(image);

        this.setFill(new ImagePattern(image));
        //this.setFill(Color.GREEN);

    }
    public Image getImage() {
        return image;
    }
    public void getDamage(double dam){
        this.HitPoints-=dam;
    }
    public double getHitPoints(){
        return this.HitPoints;
    }

    public int getSize() {
        return size;
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
