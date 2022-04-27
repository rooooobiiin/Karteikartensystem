package de.atiw.karteikartensystem.UI;

import de.atiw.karteikartensystem.UI.Controller.StackviewController;
import de.atiw.karteikartensystem.UI.Example.ExampleSystemController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class GUIController {
    public static FXMLLoader fxmlLoader;
    public static Stage stage;
    public static Scene scene;

    public static SceneName lastScene;

    public static String username;
    public static String password;

    public static LinkedList<String> stapelnamen = new LinkedList<>();
    public static String stapel_gewählt = "";
    public static String message = "";

    public static String answer_write = "";
    public static String input_write = "";
    public static String antwort_write = "";
    public static String eingabe_write = "";
    public static boolean allCardsDone = false;
    public static String error = "";
    public static String pfad_import = "";
    public static File import_file;


    public static void start(Stage stage_main){
        ExampleSystemController.initController();
        stage = stage_main;
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
            case Successful:
                fxmlLoader = new FXMLLoader(Run.class.getResource("successful.fxml"));
                setScene();
                break;
            case Export:
                fxmlLoader = new FXMLLoader(Run.class.getResource("export.fxml"));
                setScene();
                break;
            case Import:
                fxmlLoader = new FXMLLoader(Run.class.getResource("import.fxml"));
                setScene();
                break;
        }
    }

    private static void setScene(){
        scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 910, 615);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(scene);
    }
}
