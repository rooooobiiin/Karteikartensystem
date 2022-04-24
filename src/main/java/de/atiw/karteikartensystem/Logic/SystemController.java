package de.atiw.karteikartensystem.Logic;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Persistenz.DatenbankVerwaltung;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SystemController {

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
     * Erhält eine Liste mit Stapeln und wandelt die in eine String-Liste um die zurückgegeben wird.
     * @return Wirft eine String-Liste aller Karteikartenstapel zurück, die in der Datenbank existieren.
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
     */
    public static void createStapel(String nameStapel) {
    //TODO: Wenn Kevin die Methode umgeschrieben hat, einkommentieren!
        //DatenbankVerwaltung.createStapel(nameStapel);
    }

    /**
     *
     * @param name die Bezeichnung des Stapels
     * @return Wirft den Stapel zurück, der in der Datenbank unter dem Namen zu finden ist.
     */
    public static Stapel readStapel(String name) {
        List<Stapel> alleStapel;

        try {
            alleStapel = DatenbankVerwaltung.readStapelliste();

            int id = 0;

            for (int i = 0; i < alleStapel.size(); i++) {
                if (alleStapel.get(i).getName().equals(name)) {
                    id = i;
                }
            }

            AbfrageManager.setAktuellerStapel(DatenbankVerwaltung.readStapel(id));
            AbfrageManager.setAktuelleKarteikarte(AbfrageManager.getAktuellerStapel().getKartenSet().get(0));

        } catch (SQLException e) {
                e.printStackTrace();
            }
        return AbfrageManager.getAktuellerStapel();
    }

    /**
     * Der aktuelle Stapel wird aktualisiert
     */
    public static void updateStapel() {
        //TODO: Soll hier noch etwas geschehen?
        DatenbankVerwaltung.updateStapel(AbfrageManager.getAktuellerStapel());
    }

    /**
     *
     * Der aktuelle Stapel wird gelöscht. Sowohl im Abfragemanager als auch in der Datenbank.
     */
    public static void deleteStapel() {
        DatenbankVerwaltung.deleteStapel(AbfrageManager.getAktuellerStapel());
        AbfrageManager.setAktuellerStapel(null);
    }

    /**
     * Fügt eine Karteikarte dem Stapel und der Datenbank nacheinander hinzu.
     *
     */
    public static void createKarteikarte(String vorderseite, String rueckseite) {
        //TODO: Frage an Kevin: passt das so die ohne ID zu schreiben, also wird die dann generiert?
        Karteikarte karte = new Karteikarte(vorderseite, rueckseite, (byte)(1));
        Stapel stapel = AbfrageManager.getAktuellerStapel();
        stapel.addKarteikarte(karte);
        AbfrageManager.setAktuellerStapel(stapel);
        DatenbankVerwaltung.createKarteikarte(karte, AbfrageManager.getAktuellerStapel().getStapelID());
    }

    /**
     * Updatet eine übergebene Karteikarte erst in dem aktuellen Stapel und dann in der Datenbank
     *
     * @param vorderseiteNEW Text auf der Vorderseite der aktualisiert werden soll
     * @param rueckseiteNEW Text auf der Rückseite der aktualisiert werden soll
     */
    public static void updateKarteikarte(String vorderseiteNEW, String rueckseiteNEW) {
        Stapel stapel = AbfrageManager.getAktuellerStapel();
        Karteikarte karte = AbfrageManager.getaktuelleKarteikarte();

        karte.setVoderseite(vorderseiteNEW);
        karte.setRueckseite(rueckseiteNEW);
        stapel.zweiKartenTauschen(AbfrageManager.getaktuelleKarteikarte(), karte);
        AbfrageManager.setAktuelleKarteikarte(karte);
        DatenbankVerwaltung.updateKarteikarte(karte, vorderseiteNEW, rueckseiteNEW);
    }

    /**
     * Löscht eine Karte aus dem aktuellen Stapel und dann aus der Datenbank
     *
     */
    public static void deleteKarteikarte() {
        Stapel stapel = AbfrageManager.getAktuellerStapel();
        stapel.deleteKarteikarte(AbfrageManager.getaktuelleKarteikarte());
        DatenbankVerwaltung.deleteKarteikarte(AbfrageManager.getaktuelleKarteikarte());
        AbfrageManager.setAktuelleKarteikarte(null);
        AbfrageManager.setAktuellerStapel(stapel);
    }


    /**
     * Wirft die aktuelle Karteikarte zurück
     * @return Die nächste Karteikarte des Stapels der dem Abfragemanager übergebene wurde
     */
    public static Karteikarte getaktuelleKarteikarte() {
        return AbfrageManager.getaktuelleKarteikarte();
    }

    /**
     * Diese Methode kann nur bei der Abfrage bei einer bestimmten Box angewendet werden.
     * Grund dafür ist die implementierung im AbfrageManager!
     * @return Wirft eine zufällige Karteikarte aus dem übergebenen Stapel des Abfragemanagers zurück.
     */
    public static Karteikarte getRandomKarteikarte() {
        return AbfrageManager.getRandomKarte();
    }

    /**
     *
     * @param input Zu vergleichender eingegebener Text
     * @return Wirft einen boolean zurück, ob die Eingabe und die Karteikartenrückseite gleich sind (true) oder nicht (false)
     */
    public static boolean vergleicheInhaltUndInput(String input) {
        return AbfrageManager.vergleicheInhaltUndInput(input);
    }

    /**
     * Wechselt den Kasten der Karteikarte und setzt die aktuelle Karteikarte aus dem Abfragemanager auf die nächste im Stapel
     *
     * @param eingabeRichtig Boolean der aussagt, ob die Eingabe richtig war oder falsch.
     */
    public static void changeBox(boolean eingabeRichtig) {
        Karteikarte karte = AbfrageManager.getaktuelleKarteikarte();
        Stapel stapel = AbfrageManager.getAktuellerStapel();

        if (eingabeRichtig) {
            karte.erhoeheBox(karte);
        } else {
            karte.verringereBox(karte);
        }

        stapel.zweiKartenTauschen(AbfrageManager.getaktuelleKarteikarte(), karte);
        AbfrageManager.setAktuellerStapel(stapel);

        DatenbankVerwaltung.updateKarteikarte(karte, karte.getVoderseite(), karte.getRueckseite());

        AbfrageManager.setNextKarteikarte();
    }


    public static void abfrageInitialisieren(byte box) {
        AbfrageManager.setBoxNummer(box);
    }

    public static void import_csv(){

    }

    public static void export_csv(){

    }
}

