package de.atiw.karteikartensystem.UI;

import de.atiw.karteikartensystem.Logic.SystemController;
import javafx.event.ActionEvent;

public class ReadBackController {
    public void edit(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Edit);
    }

    public void newcard(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.NewCard);
    }

    public void wrong(ActionEvent actionEvent) {


    }

    public void right(ActionEvent actionEvent) {
    }

    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }
}