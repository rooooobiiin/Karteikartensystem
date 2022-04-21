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
                break;
            case Stackview:
                stackview();
                break;
            case Stack:
                stack();
                break;
            case ReadFront:
                readFront();
                break;
            case ReadBack:
                readBack();
                break;
            case WriteFront:
                writeFront();
                break;
            case WriteBack:
                writeBack();
                break;
            case Edit:
                edit();
                break;
            case NewCard:
                newCard();
                break;
            case NewStack:
                newStack();
                break;
        }
    }

    public static void newStack() {
        fxmlLoader = new FXMLLoader(Run.class.getResource("newStack.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void newCard() {
        fxmlLoader = new FXMLLoader(Run.class.getResource("newcard.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void welcome(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("welcome.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void stackview(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("stackview.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void stack(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("stack.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void readFront(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("readfront.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void readBack(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("readback.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void writeFront(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("readfront.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void writeBack(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("writeback.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    public static void edit(){
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
