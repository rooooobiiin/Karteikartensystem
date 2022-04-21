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
        GUIController.username = user.getText();
        GUIController.password = password.getText();
        SystemController.connectToDB(user.getText(), password.getText());
        GUIController.switchScene(SceneName.Stackview);
    }

}
