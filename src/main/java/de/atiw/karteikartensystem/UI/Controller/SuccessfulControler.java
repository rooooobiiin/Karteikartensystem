package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;

public class SuccessfulControler implements Initializable{

    @FXML
    private Label message_box;
    @FXML
    private Button btn_ok;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        message_box.setText(GUIController.message);

        
    }

    public void stackview(ActionEvent actionEvent) {
    }

    public void ok(ActionEvent actionEvent) {

        GUIController.switchScene(GUIController.lastScene);
    }


    public void keypressed (KeyEvent k){
            if (k.getCode().equals(KeyCode.ENTER)) {
                System.out.println("HALLO");
            }
    }

}
