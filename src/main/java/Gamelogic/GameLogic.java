package Gamelogic;

import Objects.AirCraft;
import Objects.Asteroid;
import Objects.Bullet;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import javax.xml.datatype.Duration;
import java.util.ArrayList;
import java.util.Timer;

public class GameLogic extends Pane{

    ArrayList<Asteroid>asteroids;
    ArrayList<Bullet>bullets=new ArrayList<>();
    public long cooldown;
    public long TimeToEnemy;
    public Timeline t;
    double size;
    public AirCraft plane;
    public boolean UP;
    public boolean DOWN;
    public boolean FIRE;
    Bullet bullet;
    Asteroid asteroid;

    public GameLogic(double size){
        this.asteroids=new ArrayList<>();
        this.cooldown = System.currentTimeMillis();
        this.TimeToEnemy = System.currentTimeMillis();
        this.setPrefSize(size*16,size*9);
        this.plane = new AirCraft(10,30,20,20);
        this.getChildren().add(plane);

        plane.setLayoutX(plane.getPosX());
        plane.setLayoutY(plane.getPosY());
        this.size=size;
        this.UP=false;
        this.DOWN=false;
        this.FIRE=false;
        Timeline t = new Timeline(new KeyFrame(javafx.util.Duration.millis(30), event -> {

               if (UP){
                   plane.move(0, -20);
               }
               if (DOWN){
                   plane.move(0,20);
               }
                if (FIRE){
                   if (System.currentTimeMillis()-cooldown>100){
                       //nowTime=System.currentTimeMillis();
                   Bullet bullet = new Bullet(plane.getPosX()+plane.getWidth(),plane.getPosY()+plane.getHeight()/2);
                   this.getChildren().add(bullet);
                   bullet.setLayoutX(bullet.getPosX());
                   bullet.setLayoutY(bullet.getPosY());
                   bullets.add(bullet);
                   this.cooldown=System.currentTimeMillis();
                   }
               }
                if (!bullets.isEmpty() && !asteroids.isEmpty()){

                    for (int i=0;i<bullets.size();i++){
                        bullets.get(i).move(10,0);
                        for(int j=0;j<asteroids.size();j++){
                            bullet = bullets.get(i);
                            asteroid = asteroids.get(j);
                            if (bullet.getPosX()>asteroid.getPosX()-asteroid.getSize() &&
                                    (bullet.getPosY()<asteroid.getPosY()+asteroid.getSize()&&bullet.getPosY()>asteroid.getPosY()-asteroid.getSize())){
                                //System.out.print("keek");
                                asteroid.getDamage(1);
                                this.getChildren().remove(bullets.get(i));
                                bullets.remove(i);

                                if (asteroid.getHitPoints()<0) {
                                    this.getChildren().remove(asteroids.get(j));
                                    asteroids.remove(j);
                                    break;
                                }
                                break;
                            }
                        }
                        //bullets.get(i).move(10,0);
                    }
                }
                if (System.currentTimeMillis()-TimeToEnemy>1000){
                    TimeToEnemy=System.currentTimeMillis();
                    Asteroid asteroid = new Asteroid(size);
                    asteroids.add(asteroid);
                    this.getChildren().add(asteroid);
                    asteroid.setLayoutX(asteroid.getPosX());
                    asteroid.setLayoutY(asteroid.getPosY());
                }
                if (!asteroids.isEmpty()){
                    for (int i = 0;i<asteroids.size();i++){
                        Asteroid aster = asteroids.get(i);
                        if (aster.getPosX()<0){
                            this.getChildren().remove(asteroids.get(i));
                            asteroids.remove(i);
                            continue;
                        }
                        if ((aster.getPosX()-aster.getSize()<plane.getPosX()+plane.getWidth() &&
                                (aster.getPosY()+aster.getSize()>plane.getPosY() &&
                                aster.getPosY()-aster.getSize()<plane.getPosY()+plane.getHeight()))){
                            this.getChildren().removeAll(asteroids.get(i),plane);
                            asteroids.remove(i);
                        }

                        asteroids.get(i).move(-size*0.16,0);
                        asteroids.get(i).setLayoutX(asteroids.get(i).getPosX());
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
                if (bullets.get(i).getPosX()>size*16){
                    this.getChildren().remove(bullets.get(i));
                    bullets.remove(i);
                }

            }
        }
    }
    public Timeline getT() {
        return t;
    }

}
