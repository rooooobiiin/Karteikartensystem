package de.atiw.karteikartensystem.Logic;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Persistenz.DatenbankVerwaltung;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SystemController {
    private static Stapel aktuellerStapel;


    /**
     *
     * @return Wirft den aktuell ausgewählten Stapel zurück.
     */
    public static Stapel getAktuellerStapel() {
        return aktuellerStapel;
    }

    /**
     *
     * @param stapel Stapel, auf den der aktuelle Stapel gesetzt werden soll.
     */
    public static void setAktuellerStapel(Stapel stapel) {
        aktuellerStapel = stapel;
    }

    //DATENBANKCONNECTION

    /**
     *
     * @param username Username für die Datenbankverbindung
     * @param password Passwort für die Datenbankverbindung
     */
    public static void connectToDB(String username, String password) {
        DatenbankVerwaltung.createInstance(username, password);
    }

    //KARTEIKARTEN AUS DER DB BEKOMMEN

    /**
     *
     * @return Wirft eine Liste aller Karteikartenstapel zurück die in der Datenbank existieren.
     */
    public static List<String> readStapelList() {
        List<Stapel> liste;
        List<String> returnList = new LinkedList<>();
        try {
             liste = DatenbankVerwaltung.readStapelliste();
        } catch (SQLException e) {
            e.printStackTrace();
            liste = null;
        }
        for (Stapel stapel : liste) {
            returnList.add(stapel.getName());
        }

        return returnList;
    }

    /**
     *Erstellt einen neuen Karteikartenstapel
     * @param stapel Das "Rohobjekt" des Stapels
     */
    //TODO: RICO ÜBERGIBT NUR STRING
    public static void createStapel(Stapel stapel) {
        DatenbankVerwaltung.createStapel(stapel);
    }

    /**
     *
     * @param name die Bezeichnung des Stapels
     * @return Wirft den Stapel zurück, der unter dem Namen zu finden ist.
     */
    public static Stapel readStapel(String name) {
        List<Stapel> alleStapel = null;

        try {
            alleStapel = DatenbankVerwaltung.readStapelliste();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int id = 0;

        for (int i = 0; i < alleStapel.size(); i++) {
            if (alleStapel.get(i).getName().equals(name)) {
                id = i;
            }
        }

      //  try {
            //TODO: FEHLER SOLLTE BEHOBEN SEIN WENN DU DEN STAPEL ZURÜCKGIBST
            //TODO: DANACH NOCH VON ZEILE 96 BIS ZEILE 102 WIEDER EINKOMMENTIEREN
      //      aktuellerStapel = DatenbankVerwaltung.readStapel(id);
       // } catch (SQLException e) {
         //   e.printStackTrace();
       // }
        return aktuellerStapel;
    }

    /**
     *
     * @param stapel Stapel der aktualisiert werden soll
     */
    public static void updateStapel(Stapel stapel) {
        DatenbankVerwaltung.updateStapel(stapel);
    }

    /**
     *
     * Der aktuelle Stapel wird gelöscht.
     */
    public static void deleteStapel() {
        DatenbankVerwaltung.deleteStapel(aktuellerStapel);
        aktuellerStapel = null;
    }

    /**
     * Fügt eine Karteikarte dem Stapel und der Datenbank nacheinander hinzu.
     *
     * @param karte Karteikartenobjekt hinzugefügt werden soll
     */
    public static void createKarteikarte(Karteikarte karte) {
        aktuellerStapel.addKarteikarte(karte);
        //DatenbankVerwaltung.createKarteikarte(karte);
    }

    /**
     * Updatet eine Übergebene Karteikarte erst in dem aktuellen Stapel und dann in der Datenbank
     *
     * @param karte Karteikarte die geupdatet werden soll
     * @param vorderseiteNEW Text auf der Vorderseite der geupdatet werden soll
     * @param rueckseiteNEW Text auf der Rückseite der geupdatet werden soll
     */
    public static void updateKarteikarte(Karteikarte karte, String vorderseiteNEW, String rueckseiteNEW) {
        aktuellerStapel.updateKarteikarte(karte, vorderseiteNEW, rueckseiteNEW);
        DatenbankVerwaltung.updateKarteikarte(karte, vorderseiteNEW, rueckseiteNEW);
    }

    /**
     * Löscht eine Karte aus dem aktuellen Stapel und dann aus der Datenbank
     *
     * @param karte Karteikarte die gelöscht werden soll
     */
    public static void deleteKarteikarte(Karteikarte karte) {
        aktuellerStapel.deleteKarteikarte(karte);
        DatenbankVerwaltung.deleteKarteikarte(karte);
    }

    //AB HIER DURCHSEHEN

    /**
     * Wenn es keine Karteikarten zum zurückgeben mehr gibt wirft die Methode NULL zurück.
     * @return Die nächste Karteikarte des Stapels der dem Abfragemanager übergebene wurde
     */
    public static Karteikarte getNextKarteikarte() {
        return AbfrageManager.getNextKarteikarte();
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
     * @param karte Zu vergleichende Karteikarte
     * @param input Zu vergleichender eingegebener Text
     * @return Wirft einen boolean zurück ob die Eingabe und der Text Karteikartenrückseite gleich sind (true) oder nicht (false)
     */
    public static boolean vergleicheInhaltUndInput(Karteikarte karte, String input) {
        return SystemController.vergleicheInhaltUndInput(karte, input);
    }

    /**
     * Wechselt den Kasten der Karteikarte
     *
     * @param karte Karteikarte die einem anderem Kasten hinzugefügt werden soll
     * @param eingabeRichtig Boolean der aussagt, ob die Eingabe richtig war oder falsch.
     */
    public static void changeBox(Karteikarte karte, boolean eingabeRichtig) {
        if (eingabeRichtig) {
            if (karte.getBox() < 5) {
                karte.setBox((byte) (karte.getBox() + 1));
            }
        } else {
            if (karte.getBox() > 1) {
                karte.setBox((byte) (karte.getBox() - 1));
            }
        }
        DatenbankVerwaltung.updateKarteikarte(karte, karte.getVoderseite(), karte.getRueckseite());
    }


    public static void durchschauenInitialisieren(byte box) {
        AbfrageManager.setStapel(aktuellerStapel);
        AbfrageManager.setBoxNummer(box);
        AbfrageManager.setAktuelleKarteikarte(AbfrageManager.getStapel().getKartenSet().get(0));
    }

    /**
     *
     * Vom aktuellen Stapel wird die übergebene Box durchgeschaut.
     * @param box Die Nummer des Kastens der innerhalb dieser Box durchgesehen werden soll
     */
    public static void abfrageMitInputInitialisieren(Byte box) {
        AbfrageManager.setStapel(aktuellerStapel);
        AbfrageManager.setBoxNummer(box);
        AbfrageManager.setAktuelleKarteikarte(AbfrageManager.getStapel().getKartenSet().get(0));
    }

    public static void import_csv(){

    }

    public static void export_csv(){

    }
}
