package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.Example.ExampleSystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.Run;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StackviewController {
    @FXML
    public static VBox vboxStackview;

    @FXML
    public static VBox vboxTOP;

    public StackviewController(){
        //TODO: Liste der Stacks muss links angezeigt werden
        // --> Durch auswahl des Stapels wird aktueller Stapel gesetzt
        // --> Scene stack wird gezeigt


//        try {
//            Parent root = GUIController.fxmlLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        vboxStackview = new VBox();
//        vboxStackview.getChildren().clear();

//
//         FXMLLoader fxmlLoader = new FXMLLoader(Run.class.getResource("newcard.fxml"));
//
//
//        List<Button> buttons = new ArrayList<>();
//
//        LinkedList<String> stapel = ExampleSystemController.readStapelList();
//        for (String s :
//                stapel) {
//            buttons.add(new Button(s));
//            vboxStackview.getChildren().add(new Button(s));
//        }
//
////
//        GUIController.scene = null;
//        GUIController.scene = new Scene(vboxStackview, 1000, 700);
//        GUIController.stage.setScene(GUIController.scene);
    }

    public static void reload() {
//        vboxStackview = new VBox();
//        LinkedList<String> stapel = ExampleSystemController.readStapelList();
//        for (String s :
//                stapel) {
//            vboxStackview.getChildren().add(new Button(s));
//        }
//
//        GUIController.stage.setScene(GUIController.scene);

        vboxTOP.getChildren().clear();
    }


    @FXML
    public void newstack(ActionEvent actionEvent) {

//        GUIController.switchScene(SceneName.NewStack);
//        LinkedList<String> stapel = ExampleSystemController.readStapelList();
//        for (String s :
//                stapel) {
//            vboxStackview.getChildren().add(new Button(s));
//        }


        vboxTOP.getChildren().clear();
    }

    @FXML
    public void csv_import(ActionEvent actionEvent) {
        SystemController.import_csv();
    }

    @FXML
    public void csv_export(ActionEvent actionEvent) {
        SystemController.export_csv();
    }
}
