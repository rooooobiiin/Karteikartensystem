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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtFront.setText(SystemController.getaktuelleKarteikarte().getVoderseite());
        txtBack.setText(SystemController.getaktuelleKarteikarte().getRueckseite());

    }

    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void delete(ActionEvent actionEvent) {
        SystemController.deleteKarteikarte();
    }

    public void confirm(ActionEvent actionEvent) {
        card1.setText(txtFront.getText());

    }

    public void cancel(ActionEvent actionEvent) {
        GUIController.switchScene(GUIController.lastScene);
    }


}
