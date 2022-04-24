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
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class StackviewController implements Initializable {
    @FXML
    private VBox vboxStackview;

    @FXML
    private VBox vboxTOP;

    @FXML
    private Button btnTeststapel;

    public LinkedList<Button> liste_stapelButtons = new LinkedList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vboxStackview.getChildren().clear();
        LinkedList<String> stapel = ExampleSystemController.readStapelList();
        for (String s :
                stapel) {
            Button button = new Button(s);
            GUIController.stapelnamen.addLast(s);
            vboxStackview.getChildren().add(button);

            EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    GUIController.stapel_gewählt = s;
                    GUIController.switchScene(SceneName.Stack);
                    SystemController.readStapel(s);
                }
            };

            button.setMinWidth(vboxStackview.getPrefWidth());
            button.setOnAction(buttonHandler);

        }

//        btnTeststapel.setText("New Text");

    }

    public StackviewController(){
        //TODO: Liste der Stacks muss links angezeigt werden
        // --> Durch auswahl des Stapels wird aktueller Stapel gesetzt
        // --> Scene stack wird gezeigt


    }




    @FXML
    public void newstack(ActionEvent actionEvent) {

//        GUIController.switchScene(SceneName.NewStack);
//        LinkedList<String> stapel = ExampleSystemController.readStapelList();
//        for (String s :
//                stapel) {
//            vboxStackview.getChildren().add(new Button(s));
//        }


        vboxTOP.getChildren().clear();
    }

    @FXML
    public void csv_import(ActionEvent actionEvent) {

//        SystemController.import_csv();
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(GUIController.stage);
    }

    @FXML
    public void csv_export(ActionEvent actionEvent) {

//        SystemController.export_csv();
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(GUIController.stage);
    }


}
