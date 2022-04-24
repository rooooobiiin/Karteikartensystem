package de.atiw.karteikartensystem.UI.Example;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Logic.AbfrageManager;
import de.atiw.karteikartensystem.Persistenz.DatenbankVerwaltung;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ExampleSystemController {


    private static LinkedList<Stapel> stapelListe;

    public static void initController() {
        stapelListe = new LinkedList<>();
        Stapel stapel1 = new Stapel(1, "Robin");
        Stapel stapel2 = new Stapel(2, "Kevin");

        stapel1.addKarteikarte(new Karteikarte("A", "A", (byte) 1));
        stapel1.addKarteikarte(new Karteikarte("B", "B", (byte) 1));
        stapel1.addKarteikarte(new Karteikarte("C", "C", (byte) 1));

        stapel2.addKarteikarte(new Karteikarte("D", "D", (byte) 1));
        stapel2.addKarteikarte(new Karteikarte("E", "E", (byte) 1));
        stapel2.addKarteikarte(new Karteikarte("F", "F", (byte) 1));

        stapelListe.add(stapel1);
        stapelListe.add(stapel2);
    }



    /**
     *
     * @return Wirft den aktuell ausgewählten Stapel zurück.
     */
    public static Stapel getAktuellerStapel() {
        return ExampleAbfrageManager.aktuellerStapel;
    }

    //DATENBANKCONNECTION

    /**
     *
     * @param username Username für die Datenbankverbindung
     * @param password Passwort für die Datenbankverbindung
     */
    public static void connectToDB(String username, String password) {
//        DatenbankVerwaltung.createInstance(username, password);
    }

    //KARTEIKARTEN AUS DER DB BEKOMMEN

    /**
     *
     * @return Wirft eine Liste aller Karteikartenstapel zurück die in der Datenbank existieren.
     */
    public static LinkedList<String> readStapelList() {
        LinkedList<String> stapelNamen = new LinkedList<>();

        for (int i = 0; i < stapelListe.size(); i++) {
            stapelNamen.add(stapelListe.get(i).getName());
        }

        return stapelNamen;
    }


    /**
     *
     * @param name die Bezeichnung des Stapels
     * @return Wirft den Stapel zurück, der unter dem Namen zu finden ist.
     */
    public static Stapel readStapel(String name) {
        int id = 0;

        for (int i = 0; i < stapelListe.size(); i++) {
            if (stapelListe.get(i).getName().equals(name)) {
                id = i;
            }
        }

            ExampleAbfrageManager.aktuellerStapel = stapelListe.get(id);
            ExampleAbfrageManager.aktuelleKarteikarte = ExampleAbfrageManager.aktuellerStapel.getKartenSet().get(0);

        return ExampleAbfrageManager.aktuellerStapel;
    }



    /**
     *
     * Der aktuelle Stapel wird gelöscht.
     */
    public static void deleteStapel() {
        ExampleAbfrageManager.setAktuellerStapel(null);
    }

    /**
     * Fügt eine Karteikarte dem Stapel und der Datenbank nacheinander hinzu.
     *
     */
    public static void createKarteikarte(String vorderseite, String rueckseite) {
        ExampleAbfrageManager.aktuellerStapel.addKarteikarte(new Karteikarte(vorderseite, rueckseite, (byte) 1));
    }


    public static void updateKarteikarte(String vorderseiteNEW, String rueckseiteNEW) {
        Karteikarte karte = ExampleAbfrageManager.aktuelleKarteikarte;
        ExampleAbfrageManager.aktuelleKarteikarte.setVoderseite(vorderseiteNEW);
        ExampleAbfrageManager.aktuelleKarteikarte.setRueckseite(rueckseiteNEW);
        ExampleAbfrageManager.aktuellerStapel.zweiKartenTauschen(karte, ExampleAbfrageManager.aktuelleKarteikarte);
    }

    /**
     * Löscht eine Karte aus dem aktuellen Stapel und dann aus der Datenbank
     *
     */
    public static void deleteKarteikarte() {
        Karteikarte karte = ExampleAbfrageManager.aktuelleKarteikarte;
        ExampleAbfrageManager.setNextKarteikarte();
        ExampleAbfrageManager.aktuellerStapel.deleteKarteikarte(karte);
    }

    //AB HIER DURCHSEHEN

    /**
     * Wenn es keine Karteikarten zum zurückgeben mehr gibt wirft die Methode NULL zurück.
     * @return Die nächste Karteikarte des Stapels der dem Abfragemanager übergebene wurde
     */
    public static Karteikarte getaktuelleKarteikarte() {
        return ExampleAbfrageManager.aktuelleKarteikarte;
    }

    /**
     *
     * @return Wirft eine Zufällige Karteikarte aus dem übergebenen Stapel des Abfragemanagers zurück
     */
    public static Karteikarte getRandomKarteikarte() {
        //TODO: implementieren
        return null;
    }

    /**
     *
     * @param input Zu vergleichender eingegebener Text
     * @return Wirft einen boolean zurück ob die Eingabe und der Text Karteikartenrückseite gleich sind (true) oder nicht (false)
     */
    public static boolean vergleicheInhaltUndInput(String input) {
        return ExampleSystemController.vergleicheInhaltUndInput(input);
    }

    /**
     * Wechselt den Kasten der Karteikarte und setzt die aktuelle Karteikarte aus dem Abfragemanager auf die nächste im Stapel
     *
     * @param eingabeRichtig Boolean der aussagt, ob die Eingabe richtig war oder falsch.
     */
    public static void changeBox(boolean eingabeRichtig) {
        if (eingabeRichtig) {
            if (ExampleAbfrageManager.aktuelleKarteikarte.getBox() < 5) {
                ExampleAbfrageManager.aktuelleKarteikarte.setBox((byte) (ExampleAbfrageManager.aktuelleKarteikarte.getBox() + 1));
            }
        } else {
            if (ExampleAbfrageManager.aktuelleKarteikarte.getBox() > 1) {
                ExampleAbfrageManager.aktuelleKarteikarte.setBox((byte) (ExampleAbfrageManager.aktuelleKarteikarte.getBox() - 1));
            }
        }
        ExampleAbfrageManager.setNextKarteikarte();
    }


    public static void durchschauenInitialisieren(byte box) {
        AbfrageManager.setBoxNummer(box);
    }


    public static void import_csv(){

    }

    public static void export_csv(){

    }
}
