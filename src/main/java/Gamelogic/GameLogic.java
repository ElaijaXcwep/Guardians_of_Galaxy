package Gamelogic;

import Objects.AirCraft;
import Objects.Bullet;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import javax.xml.datatype.Duration;
import java.util.ArrayList;

public class GameLogic extends Pane{


            ArrayList<Bullet>bullets=new ArrayList<>();
    public Timeline t;
    public AirCraft plane;
    public boolean UP;
    public boolean DOWN;
    public boolean FIRE;
    public GameLogic(double size){
        this.setPrefSize(size*16,size*9);
        this.plane = new AirCraft(10,30,size,size);
        this.getChildren().add(plane);
        plane.setLayoutX(plane.getPosX());
        plane.setLayoutY(plane.getPosY());

        this.UP=false;
        this.DOWN=false;
        this.FIRE=false;
        Timeline t = new Timeline(new KeyFrame(javafx.util.Duration.millis(30), event -> {

               if (UP){
                   plane.move(0, -5);
               }
               if (DOWN){
                   plane.move(0,5);
               }
                if (FIRE){
                   Bullet bullet = new Bullet(plane.getPosX()+11,plane.getPosY()+15);
                   this.getChildren().add(bullet);
                   bullet.setLayoutX(bullet.getPosX());
                   bullet.setLayoutY(bullet.getPosY());
                   bullets.add(bullet);
                }
                if (!bullets.isEmpty()){
                    for (int i=0;i<bullets.size();i++){
                        bullets.get(i).move(10,0);
                    }
                }
            refresh();

        }));
        t.setCycleCount(Timeline.INDEFINITE);
        this.t =t;
    }

    public void refresh(){
        plane.setLayoutX(plane.getPosX());
        plane.setLayoutY(plane.getPosY());
        UP=false;
        DOWN=false;
        FIRE = false;
        if (!bullets.isEmpty()){
            for (int i =0;i<bullets.size();i++){
                bullets.get(i).setLayoutX(bullets.get(i).getPosX());
            }
        }
    }
    public Timeline getT() {
        return t;
    }

}
