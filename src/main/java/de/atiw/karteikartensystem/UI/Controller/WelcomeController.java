package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class WelcomeController {
    @FXML
    private TextField user;
    @FXML
    private PasswordField password;

    @FXML
    public void login(ActionEvent actionEvent) {
//        SystemController.connectToDB(user.getText(), password.getText());
        GUIController.switchScene(SceneName.Stackview);

        // TODO: Überprüfe, wenn nicht Fehlermeldung und nochmal veruschen
        // TODO: AMIN: --> Brauchen Textfeld für Fehlermeldung
    }

}
