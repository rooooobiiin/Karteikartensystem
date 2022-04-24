package de.atiw.karteikartensystem.UI;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Logic.SystemController;
import de.atiw.karteikartensystem.Persistenz.DatenbankVerwaltung;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Run extends Application {
    public static void main(String[] args) throws IOException {
        launch();
//        SystemController controller = new SystemController();
//        Stapel stapel = new Stapel("test");
//        stapel.addKarteikarte(new Karteikarte(1, "a", "a", (byte) 1));
//        stapel.addKarteikarte(new Karteikarte(2, "b", "b", (byte) 1));
//        stapel.addKarteikarte(new Karteikarte(3, "c", "c", (byte) 1));
//        stapel.addKarteikarte(new Karteikarte(4, "d", "d", (byte) 1));
//
//        controller.durchschauen(stapel);
        /*
        //Test Datensatz Karteikarte
        Karteikarte testKarte = new Karteikarte(5, "Test Karte Vorderseit", "Test Karte Rückseite", (byte) 1);


        //Datenbankinstanz erstellen
        DatenbankVerwaltung.createInstance("FS202_knikol", "kevin");
        //Erhalte eine Liste an gespeicherten Stapel.
        List<Stapel> stapelList = DatenbankVerwaltung.readStapelliste();
        //Erstelle einen Stapel
        DatenbankVerwaltung.createStapel(stapel);
        //Update einen Stapel
        Stapel testStapel = stapelList.get(0);
        testStapel.setName("Erstes Set");
        DatenbankVerwaltung.updateStapel(testStapel);
        //Lösche einen Stapel
        DatenbankVerwaltung.deleteStapel(testStapel);
        //Erhalte eine Liste von Karteikarten in einem Stapel
        List<Karteikarte> karten = DatenbankVerwaltung.readStapel(testStapel.getStapelID());
        //Erstelle eine neue Karteikarte
        DatenbankVerwaltung.createKarteikarte(testKarte, testStapel.getStapelID());
        //Update eine Karteikarte
        DatenbankVerwaltung.updateKarteikarte(testKarte, "to persuade", "überzeugen, überreden");
        //Löschen einer Karteikarte aus der Datenbank
        DatenbankVerwaltung.deleteKarteikarte(testKarte);
        //Entfernen einer Karteikarte aus dem Stapel
        DatenbankVerwaltung.removeKarteVonStapel(testKarte, testStapel.getStapelID());
        
         */
        /*
        Karteikarte kk;
        while ((kk = controller.getKarteikarte()) != null) {
            System.out.println(kk.getVoderseite());
        }

        controller.abfrageFuenfKaesten(stapel, (byte) 1);

        Karteikarte karte;
        while((karte = controller.getRandomkarte()) != null) {
            System.out.println(karte.getVoderseite());
        }

        controller.getRandomkarte();
        */

    }

    @Override
    public void start(Stage stage) throws Exception {
        GUIController.start(stage);
    }

}
