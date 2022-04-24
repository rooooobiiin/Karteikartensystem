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

public class NewCardController implements Initializable {
    @FXML
    private Label vorderseite;
    @FXML
    private Label rueckseite;

    public void stackview(ActionEvent actionEvent) {
    }

    public void add(ActionEvent actionEvent) {
        ExampleSystemController.createKarteikarte(vorderseite.getText(), rueckseite.getText());
    }

    public void close(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
