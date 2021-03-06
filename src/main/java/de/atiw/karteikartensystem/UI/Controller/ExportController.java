package de.atiw.karteikartensystem.UI.Controller;

import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.UI.Example.ExampleSystemController;
import de.atiw.karteikartensystem.UI.GUIController;
import de.atiw.karteikartensystem.UI.SceneName;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ExportController implements Initializable {
    @FXML
    private VBox vboxStackview;

    @FXML
    private VBox vboxTOP;

    @FXML
    private Button btnTeststapel;
    @FXML
    private Label stapelname;
    @FXML
    private Label pfad;

    public LinkedList<Button> liste_stapelButtons = new LinkedList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vboxStackview.getChildren().clear();
        LinkedList<String> stapel = (LinkedList<String>) SystemController.readStapelList();
        for (String s :
                stapel) {
            Button button = new Button(s);
            button.setMinWidth(vboxStackview.getPrefWidth());

            GUIController.stapelnamen.addLast(s);
            vboxStackview.getChildren().add(button);

            EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    GUIController.stapel_gewählt = s;
                    SystemController.readStapel(s);
                    DirectoryChooser dc = new DirectoryChooser();
                    File file = dc.showDialog(GUIController.stage);
//                    FileChooser fc = new FileChooser();
//                    File file = fc.showOpenDialog(GUIController.stage);
                    pfad.setText(file.getAbsolutePath());
                    stapelname.setText(SystemController.getAktuellerStapel().getName());
//                    GUIController.switchScene(SceneName.Stack);
//                    SystemController.readStapel(s);
                }
            };

            button.setOnAction(buttonHandler);
        }

    }


    @FXML
    public void newstack(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.NewStack);
    }



    public void back(ActionEvent actionEvent) {
        GUIController.switchScene(SceneName.Stackview);
    }

    public void export(ActionEvent actionEvent) {
    }
}
