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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        messageBox.setText(GUIController.error);
    }

    @FXML
    public void login(ActionEvent actionEvent) {
        boolean correct = SystemController.connectToDB(user.getText(), password.getText());
//        boolean correct = SystemController.connectToDB("cardtiw", "cardtiwpassword");
        if (correct){
            GUIController.error = "";
            GUIController.switchScene(SceneName.Stackview);
        }
        else{
            GUIController.error = "Anmeldedaten falsch!";
            GUIController.switchScene(SceneName.Welcome);

        }
    }
}
