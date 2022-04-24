package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
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

public class EditController implements Initializable {
    @FXML
    public TextField txtFront;

    @FXML
    public TextField txtBack;

    @FXML
    public Label card1;

    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void delete(ActionEvent actionEvent) {
        //TODO: insert command after Robin corrected parameter
//        SystemController.deleteKarteikarte();
        ExampleSystemController.deleteKarteikarte();
    }

    public void confirm(ActionEvent actionEvent) {
        //TODO: insert command after Robin corrected parameter
        card1.setText(txtFront.getText());

    }

    public void cancel(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
