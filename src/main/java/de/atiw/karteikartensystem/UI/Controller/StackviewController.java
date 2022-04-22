package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.LinkedList;
import java.util.List;

public class StackviewController {

    public StackviewController(){
        //TODO: Liste der Stacks muss links angezeigt werden
        // --> Durch auswahl des Stapels wird aktueller Stapel gesetzt
        // --> Scene stack wird gezeigt
    }

    @FXML
    public void newstack(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.NewStack);
    }

    @FXML
    public void csv_import(ActionEvent actionEvent) {
        SystemController.import_csv();
    }

    @FXML
    public void csv_export(ActionEvent actionEvent) {
        SystemController.export_csv();
    }
}
