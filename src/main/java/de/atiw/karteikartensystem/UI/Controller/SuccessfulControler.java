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
    @FXML
    private Label answer;
    @FXML
    private Label input;
    @FXML
    private Label says_antwort;
    @FXML
    private Label says_ihreeingabe;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        message_box.setText(GUIController.message);
        answer.setText(GUIController.answer_write);
        input.setText(GUIController.input_write);
        says_antwort.setText(GUIController.antwort_write);
        says_ihreeingabe.setText(GUIController.eingabe_write);

        
    }

    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void ok(ActionEvent actionEvent) {
        if(!GUIController.allCardsDone){
            GUIController.switchScene(GUIController.lastScene);
        }
        else{
            GUIController.message = "Alle Karten bearbeitet.";
            GUIController.lastScene = SceneName.Stack;
            GUIController.answer_write = "";
            GUIController.input_write = "";
            GUIController.eingabe_write = "";
            GUIController.antwort_write = "";
            GUIController.allCardsDone = false;
            GUIController.switchScene(SceneName.Successful);
        }

    }

    public void keypressed(KeyEvent keyEvent) {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                GUIController.switchScene(GUIController.lastScene);
            }
    }
}
