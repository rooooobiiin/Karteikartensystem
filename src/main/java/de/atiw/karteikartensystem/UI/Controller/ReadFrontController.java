package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.UI.Example.ExampleSystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ReadFrontController implements Initializable {

    @FXML
    private Label card;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (ExampleSystemController.getaktuelleKarteikarte() == null){
            GUIController.switchScene(SceneName.Stack);
        }
        else{
            card.setText(ExampleSystemController.getaktuelleKarteikarte().getVoderseite());
        }

    }



    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void flip(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.ReadBack);
    }

    public void edit(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Edit);
    }

    public void newcard(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.NewCard);
    }


}
