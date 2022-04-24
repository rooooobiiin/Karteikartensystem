package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.Example.ExampleSystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ReadBackController implements Initializable {
    @FXML
    private Label card;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        card.setText(ExampleSystemController.getaktuelleKarteikarte().getRueckseite());
        GUIController.lastScene = SceneName.ReadBack;
    }

    public void edit(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Edit);
    }

    public void newcard(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.NewCard);
    }

    public void wrong(ActionEvent actionEvent) {

//        SystemController.changeBox(false);

        ExampleSystemController.changeBox(false);
        if (ExampleSystemController.getaktuelleKarteikarte() == null){
            GUIController.message = "Alle Karten bearbeitet.";
            GUIController.lastScene = SceneName.Stack;
            GUIController.switchScene(SceneName.Successful);
        }
        else{
            if (ExampleSystemController.getaktuelleKarteikarte() == null){
                GUIController.switchScene(SceneName.Stack);
            }
            else{
                GUIController.switchScene(SceneName.ReadFront);
            }
        }


    }

    public void right(ActionEvent actionEvent) {

//        SystemController.changeBox(true);
        ExampleSystemController.changeBox(true);
        if (ExampleSystemController.getaktuelleKarteikarte() == null){
            GUIController.message = "Alle Karten bearbeitet.";
            GUIController.lastScene = SceneName.Stack;
            GUIController.switchScene(SceneName.Successful);
        }
        else{
            if (ExampleSystemController.getaktuelleKarteikarte() == null){
                GUIController.switchScene(SceneName.Stack);
            }
            else{
                GUIController.switchScene(SceneName.ReadFront);
            }
        }


    }

    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }


    public void back(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stack);
    }
}
