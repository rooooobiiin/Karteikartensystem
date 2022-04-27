package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ImportController implements Initializable {
    @FXML
    private TextField import_stapelname;
    @FXML
    private Label import_pfad;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        import_pfad.setText(GUIController.pfad_import);
        GUIController.pfad_import = "";
    }


    public void back(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }



    public void btnImport(ActionEvent actionEvent) {
        SystemController.import_csv(GUIController.import_file);
        GUIController.message = "Stapel erfolgreich importiert.";
        GUIController.lastScene = SceneName.Stackview;
        GUIController.switchScene(SceneName.Successful);
    }


}
