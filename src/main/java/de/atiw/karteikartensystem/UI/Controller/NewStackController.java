package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.Example.ExampleSystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class NewStackController implements Initializable {
    @FXML
    public TextField tf_input;

    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void input(ActionEvent actionEvent) {
    }

    public void add(ActionEvent actionEvent) {
        if (!tf_input.getText().isBlank()){
            SystemController.createStapel(tf_input.getText());
            GUIController.message = "Stapel erfolgreich hinzugefügt.";
            GUIController.lastScene = SceneName.Stackview;
            GUIController.switchScene(SceneName.Successful);
        }
        else{
            GUIController.message = "Bitte Stapelnamen eingeben.";
            GUIController.lastScene = SceneName.NewStack;
            GUIController.switchScene(SceneName.Successful);
        }

    }

    public void close(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
