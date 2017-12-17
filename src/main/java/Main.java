import Gamelogic.GameLogic;
import Objects.AirCraft;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    GameLogic gameLogic;

    public static void main(String args[]){launch(args);}

    public void start(Stage primaryStage) throws Exception {

        HBox field = new HBox();
        field.setPrefSize(1200,400);
        GameLogic gameLogic = new GameLogic(70);
        gameLogic.setBackground(new Background(new BackgroundImage(new Image(String.valueOf(getClass().getResource("/Images/Space.jpg")),70*16,70*9,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
        Scene gameScene = new Scene(gameLogic);
        Scene scene = new Scene(field);
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnKeyReleased(event->{
            if (event.getCode()== KeyCode.ENTER){
                primaryStage.setScene(gameScene);
                primaryStage.show();
                gameLogic.t.play();
            }

        });
        gameScene.setOnKeyPressed(event ->{
            if (event.getCode()== KeyCode.ENTER){
                this.gameLogic = new GameLogic(70);
                Scene scene1 = new Scene(gameLogic);
                primaryStage.setScene(scene1);
                primaryStage.show();
            }
            if (event.getCode()==KeyCode.DOWN){
                gameLogic.DOWN=true;
            }
            if (event.getCode()==KeyCode.UP){
                gameLogic.UP=true;
            }
            if (event.getCode()==KeyCode.SPACE){
                gameLogic.FIRE=true;
            }

        });
        gameScene.setOnKeyReleased(event1 -> {
            if (event1.getCode() == KeyCode.DOWN) {
                gameLogic.DOWN=true;
            }
            if (event1.getCode() == KeyCode.UP) {
                gameLogic.UP=true;
            }
            if (event1.getCode()==KeyCode.SPACE){
                gameLogic.FIRE=true;
            }
        });
    }
}
