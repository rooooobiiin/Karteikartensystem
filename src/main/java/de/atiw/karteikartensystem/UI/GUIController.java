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
        welcome();
        stage.show();
    }

    public static void switchScene(SceneName name){
        switch (name){
            case Welcome:
                welcome();
            case Stackview:
                stackview();
            case Stack:
                stack();
            case DurchschauenFront:
                durchschauenFront();
            case DurchschauenBack:
                durchschauenBack();
            case EingabeFront:
                eingabeFront();
            case EingabeBack:
                eingabeBack();
            case Bearbeiten:
                bearbeiten();
        }
    }

    private static void welcome(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("welcome.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void stackview(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("stackview.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void stack(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("stack.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void durchschauenFront(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("readfront.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void durchschauenBack(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("readback.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void eingabeFront(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("readfront.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void eingabeBack(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("writeback.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void bearbeiten(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("edit.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

}
