package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;
    @FXML
    private Label messageBox;

    @FXML
    public void login(ActionEvent actionEvent) {

//        SystemController.connectToDB(user.getText(), password.getText());
        GUIController.switchScene(SceneName.Stackview);

        // TODO: Überprüfe, wenn nicht Fehlermeldung und nochmal veruschen
        // TODO: AMIN: --> Brauchen Textfeld für Fehlermeldung
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
