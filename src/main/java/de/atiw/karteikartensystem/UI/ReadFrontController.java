package de.atiw.karteikartensystem.UI;

import javafx.event.ActionEvent;

public class ReadFrontController {
    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void flip(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.ReadBack);
    }

    public void edit(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Edit);
    }

    public void newcard(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.NewCard);
    }
}
