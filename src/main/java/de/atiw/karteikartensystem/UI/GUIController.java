package de.atiw.karteikartensystem.UI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIController {
    private static FXMLLoader fxmlLoader;
    private static Stage stage;
    private static Scene scene;
    private static SceneName name;

    public static String username;
    public static String password;

    public static void start(){
        stage = new Stage();
        switchScene(SceneName.Welcome);
        stage.show();
    }

    public static void switchScene(SceneName name){
        switch (name){
            case Welcome:
                fxmlLoader = new FXMLLoader(Run.class.getResource("welcome.fxml"));
                setScene();
                break;
            case Stackview:
                fxmlLoader = new FXMLLoader(Run.class.getResource("stackview.fxml"));
                setScene();
                break;
            case Stack:
                fxmlLoader = new FXMLLoader(Run.class.getResource("stack.fxml"));
                setScene();
                break;
            case ReadFront:
                fxmlLoader = new FXMLLoader(Run.class.getResource("readfront.fxml"));
                setScene();
                break;
            case ReadBack:
                fxmlLoader = new FXMLLoader(Run.class.getResource("readback.fxml"));
                setScene();
                break;
            case WriteFront:
                fxmlLoader = new FXMLLoader(Run.class.getResource("writefront.fxml"));
                setScene();
                break;
            case WriteBack:
                fxmlLoader = new FXMLLoader(Run.class.getResource("writeback.fxml"));
                setScene();
                break;
            case Edit:
                fxmlLoader = new FXMLLoader(Run.class.getResource("edit.fxml"));
                setScene();
                break;
            case NewCard:
                fxmlLoader = new FXMLLoader(Run.class.getResource("newcard.fxml"));
                setScene();
                break;
            case NewStack:
                fxmlLoader = new FXMLLoader(Run.class.getResource("newStack.fxml"));
                setScene();
                break;
        }
    }

    private static void setScene(){
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }
}
