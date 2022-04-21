package de.atiw.karteikartensystem.UI;

import de.atiw.karteikartensystem.Logic.SystemController;
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
        GUIController.switchScene(SceneName.Welcome);

        // TODO: Überprüfe, wenn nicht Fehlermeldung und nochmal veruschen
        // TODO: AMIN: --> Brauchen Textfeld für Fehlermeldung
    }

}
