package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class SuccessfulControler implements Initializable {

    @FXML
    private Label message_box;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        message_box.setText("Stapel erfolgreich hinzugefügt.");
        
    }

    public void stackview(ActionEvent actionEvent) {
    }

    public void ok(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }
}
