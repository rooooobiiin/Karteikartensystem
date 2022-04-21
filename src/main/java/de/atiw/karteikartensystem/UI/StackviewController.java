package de.atiw.karteikartensystem.UI;

import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Logic.SystemController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.util.LinkedList;
import java.util.List;

public class StackviewController {
    List<Stapel> stapel;

    public StackviewController(){
        stapel = SystemController.readStapelList();
    }

    @FXML
    public void newstack(ActionEvent actionEvent) {

    }

    @FXML
    public void csv(ActionEvent actionEvent) {

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
