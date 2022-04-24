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

public class NewCardController implements Initializable {
    @FXML
    private TextField vorderseite;
    @FXML
    private TextField rueckseite;
    @FXML
    private Label messageBox;

    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void add(ActionEvent actionEvent) {
        ExampleSystemController.createKarteikarte(vorderseite.getText(), rueckseite.getText());
        vorderseite.clear();
        rueckseite.clear();
        messageBox.setText("Karteikarte erfolgreich hinzugefügt.");

    }

    public void close(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stack);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
