package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.Example.ExampleSystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class StackController implements Initializable {

    public boolean viewMode = true;
    public byte viewBox = 0;

    @FXML
    private Label stapel_name;

    @FXML
    private SplitMenuButton auswahlfeld;

    @FXML
    private Label modus;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        auswahlfeld.setText("Alle");
        modus.setText("Lesemodus");
        stapel_name.setText(ExampleSystemController.getAktuellerStapel().getName());
    }

    @FXML
    public void quiz(ActionEvent actionEvent) {
        if (viewMode) {
            SystemController.abfrageInitialisieren(viewBox);
            GUIController.switchScene(SceneName.ReadFront);
        }
        else {
            SystemController.abfrageInitialisieren(viewBox);
            GUIController.switchScene(SceneName.WriteFront);
        }

    }

    @FXML
    public void delete(ActionEvent actionEvent) {
        SystemController.deleteStapel();
    }

    @FXML
    public void wechsel(ActionEvent actionEvent) {
        if (viewMode) {
            viewMode = false;
            modus.setText("Eingabemodus");
        }
        else {
            viewMode = true;
            modus.setText("Lesemodus");
        }
    }

    @FXML
    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void alle(ActionEvent actionEvent) {
        viewBox = 0;
        auswahlfeld.setText("Alle");
    }

    public void box1(ActionEvent actionEvent) {

        viewBox = 1;
        auswahlfeld.setText("Box 1");
    }

    public void box2(ActionEvent actionEvent) {
        viewBox = 2;
        auswahlfeld.setText("Box 2");
    }

    public void box3(ActionEvent actionEvent) {
        viewBox = 3;
        auswahlfeld.setText("Box 3");
    }

    public void box4(ActionEvent actionEvent) {
        viewBox = 4;
        auswahlfeld.setText("Box 4");
    }

    public void box5(ActionEvent actionEvent) {
        viewBox = 5;
        auswahlfeld.setText("Box 5");
    }


    public void addCard(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.NewCard);
    }
}
