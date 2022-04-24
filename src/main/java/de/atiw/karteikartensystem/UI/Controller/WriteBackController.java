package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class WriteBackController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void edit(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Edit);
    }

    public void newcard(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.NewCard);
    }

    public void wrong(ActionEvent actionEvent) {
        SystemController.changeBox(false);
    }

    public void right(ActionEvent actionEvent) {
        SystemController.changeBox(true);
    }


}
