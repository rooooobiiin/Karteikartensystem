package de.atiw.karteikartensystem.Logic;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Persistenz.DatenbankVerwaltung;

import java.util.List;

public class SystemController {
    private Stapel aktuellerStapel;
    private AbfrageManager abfrageManager;

    /**
     *
     * @return Wirft den aktuell ausgewählten Stapel zurück.
     */
    public Stapel getAktuellerStapel() {
        return aktuellerStapel;
    }

    /**
     *
     * @param aktuellerStapel Stapel, auf den der aktuelle Stapel gesetzt werden soll.
     */
    public void setAktuellerStapel(Stapel aktuellerStapel) {
        this.aktuellerStapel = aktuellerStapel;
    }

    //DATENBANKCONNECTION

    /**
     *
     * @param username Username für die Datenbankverbindung
     * @param password Passwort für die Datenbankverbindung
     */
    public void connectToDB(String username, String password) {
        //TODO: implementieren
    }

    //KARTEIKARTEN AUS DER DB BEKOMMEN

    /**
     *
     * @return Wirft eine Liste aller Karteikartenstapel zurück die in der Datenbank existieren.
     */
    public List<Karteikarte> readStapelList() {
        //TODO: implementieren
        return null;
    }

    /**
     *Erstellt einen neuen Karteikartenstapel
     * @param stapel Das "Rohobjekt" des Stapels
     */
    public void createStapel(Stapel stapel) {
        //TODO: implementieren
    }

    /**
     *
     * @param name die Bezeichnung des Stapels
     * @return Wirft den Stapel zurück der unter dem Namen zu finden ist.
     */
    public Stapel readStapel(String name) {
        //TODO: implementieren
        return null;
    }

    /**
     *
     * @param stapel Stapel der aktualisiert werden soll
     */
    public void updateStapel(Stapel stapel) {
        //TODO: implementieren
    }

    /**
     *
     * @param stapel Stapel der gelöscht werden soll
     */
    public void deleteStapel(Stapel stapel) {
        //TODO: implementieren
    }

    /**
     * Fügt eine Karteikarte dem Stapel und der Datenbank nacheinander hinzu.
     *
     * @param karte Karteikartenobjekt hinzugefügt werden soll
     */
    public void createKarteikarte(Karteikarte karte) {
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
    public void updateKarteikarte(Karteikarte karte, String vorderseiteNEW, String rueckseiteNEW) {
        aktuellerStapel.updateKarteikarte(karte, vorderseiteNEW, rueckseiteNEW);
        DatenbankVerwaltung.updateKarteikarte(karte, vorderseiteNEW, rueckseiteNEW);
    }

    /**
     * Löscht eine Karte aus dem aktuellen Stapel und dann aus der Datenbank
     *
     * @param karte Karteikarte die gelöscht werden soll
     */
    public void deleteKarteikarte(Karteikarte karte) {
        aktuellerStapel.deleteKarteikarte(karte);
        DatenbankVerwaltung.deleteKarteikarte(karte);
    }

    //AB HIER DURCHSEHEN

    /**
     *
     * @return Die nächste Karteikarte des Stapels der dem Abfragemanager übergebene wurde
     */
    public Karteikarte getKarteikarte() {
        return abfrageManager.getNextKarteikarte();
    }

    /**
     *
     * @return Wirft eine Zufällige Karteikarte aus dem übergebenen Stapel des Abfragemanagers zurück
     */
    public Karteikarte getRandomkarte() {
        return abfrageManager.getRandomKarte();
    }

    /**
     *
     * @param karte Zu vergleichende Karteikarte
     * @param input Zu vergleichender eingegebener Text
     * @return Wirft einen boolean zurück ob die Eingabe und der Text Karteikartenrückseite gleich sind (true) oder nicht (false)
     */
    public boolean vergleicheInhaltUndInput(Karteikarte karte, String input) {
        return abfrageManager.vergleicheInhaltUndInput(karte, input);
    }

    /**
     * Wechselt den Kasten der Karteikarte
     *
     * @param karte Karteikarte die einem anderem Kasten hinzugefügt werden soll
     * @param eingabeRichtig Boolean der aussagt, ob die Eingabe richtig war oder falsch.
     */
    public void changeBox(Karteikarte karte, boolean eingabeRichtig) {
        if (eingabeRichtig) {
            karte.setBox((byte) (karte.getBox() + 1));
        } else if (!eingabeRichtig) {
            karte.setBox((byte) (karte.getBox() - 1));
        }
        DatenbankVerwaltung.updateKarteikarte(karte, karte.getVoderseite(), karte.getRueckseite());
    }

    /**
     *
     * @param stapel Der Stapel, der durchgeschaut werden soll
     */
    public void durchschauen(Stapel stapel) {
        abfrageManager = new AbfrageManager(stapel);
    }

    /**
     *
     * @param stapel Der Stapel, der durchgeschaut werden soll
     * @param box Die Nummer des Kastens der innerhalb dieser Box durchgesehen werden soll
     */
    public void abfrageFuenfKaesten(Stapel stapel, Byte box) {
        abfrageManager = new AbfrageManager(stapel, box);
    }






}
