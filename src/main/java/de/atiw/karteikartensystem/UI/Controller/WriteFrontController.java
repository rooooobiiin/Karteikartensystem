package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.UI.Example.ExampleSystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class WriteFrontController implements Initializable {

    @FXML
    private Label card;
    @FXML
    private TextField tf_input;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        card.setText(ExampleSystemController.getaktuelleKarteikarte().getVoderseite());
        GUIController.lastScene = SceneName.WriteFront;

    }

    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void enter(ActionEvent actionEvent) {

        boolean correct = ExampleSystemController.vergleicheInhaltUndInput(tf_input.getText());
        ExampleSystemController.changeBox(correct);

        if (ExampleSystemController.getaktuelleKarteikarte() == null){
            GUIController.message = "Alle Karteikarten der Box wurden bearbeitet";
            GUIController.lastScene = SceneName.Stack;
            GUIController.switchScene(SceneName.Successful);
        }
        else{
            GUIController.lastScene = SceneName.WriteFront;
            if (correct){
                GUIController.message = "Korrekt!";
                GUIController.switchScene(SceneName.Successful);
            }
            else{
                GUIController.message = "Leider Falsch!";
                GUIController.switchScene(SceneName.Successful);
            }
        }




    }

    public void edit(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Edit);
    }

    public void newcard(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.NewCard);
    }

    public void input(ActionEvent actionEvent) {
    }


    public void back(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stack);
    }
}
