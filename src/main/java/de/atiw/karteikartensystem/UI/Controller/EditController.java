package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;

public class EditController {
    public void stackview(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void delete(ActionEvent actionEvent) {
        //TODO: insert command after Robin corrected parameter
    }

    public void right(ActionEvent actionEvent) {
    }
}
