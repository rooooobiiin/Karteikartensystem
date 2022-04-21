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
            case ReadFront:
                readFront();
            case ReadBack:
                readBack();
            case WriteFront:
                writeFront();
            case WriteBack:
                writeBack();
            case Edit:
                edit();
            case NewCard:
                newCard();
            case NewStack:
                newStack();
        }
    }

    private static void newStack() {
        fxmlLoader = new FXMLLoader(Run.class.getResource("newStack.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void newCard() {
        fxmlLoader = new FXMLLoader(Run.class.getResource("newcard.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
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

    private static void readFront(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("readfront.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void readBack(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("readback.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void writeFront(){
        fxmlLoader = new FXMLLoader(Run.class.getResource("readfront.fxml"));
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }

    private static void writeBack(){
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
