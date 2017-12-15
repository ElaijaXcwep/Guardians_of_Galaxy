import Gamelogic.GameLogic;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    GameLogic gameLogic;

    public static void main(String args[]){launch(args);}

    public void start(Stage primaryStage) throws Exception {

        HBox field = new HBox();
        field.setPrefSize(1200,400);
        GameLogic gameLogic = new GameLogic(70);
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
