package de.atiw.karteikartensystem.Logic;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Persistenz.DatenbankVerwaltung;

import java.util.List;

public class SystemController {
    private Stapel aktuellerStapel;
    private AbfrageManager abfrageManager;
    private DatenbankVerwaltung dbVerwaltung = new DatenbankVerwaltung();

    public Stapel getAktuellerStapel() {
        return aktuellerStapel;
    }

    public void setAktuellerStapel(Stapel aktuellerStapel) {
        this.aktuellerStapel = aktuellerStapel;
    }

    //DATENBANKCONNECTION
    public void connectToDB(String username, String password) {
        //TODO: implementieren
    }

    //KARTEIKARTEN AUS DER DB BEKOMMEN
    public List<Karteikarte> readStapelList() {
        //TODO: implementieren
        return null;
    }

    public void createStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public Stapel readStapel(String name) {
        //TODO: implementieren
        return null;
    }

    public void updateStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public void deleteStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public void createKarteikarte(Karteikarte karte) {
        aktuellerStapel.addKarteikarte(karte);
        dbVerwaltung.createKarteikarte(karte);
    }

    public void updateKarteikarte(Karteikarte karte, String vorderseiteNEW, String rueckseiteNEW) {
        aktuellerStapel.updateKarteikarte(karte, vorderseiteNEW, rueckseiteNEW);
        dbVerwaltung.updateKarteikarte(karte, vorderseiteNEW, rueckseiteNEW);
    }

    public void deleteKarteikarte(Karteikarte karte) {
        aktuellerStapel.deleteKarteikarte(karte);
        dbVerwaltung.deleteKarteikarte(karte);
    }

    //AB HIER DURCHSEHEN

    public Karteikarte getKarteikarte() {
        return abfrageManager.getNextKarteikarte();
    }

    public Karteikarte getRandomkarte() {
        return abfrageManager.getRandomKarte();
    }

    public void changeBox(Karteikarte karte, boolean eingabeRichtig) {
        if (eingabeRichtig) {
            karte.setBox((byte) (karte.getBox() + 1));
        } else if (!eingabeRichtig) {
            karte.setBox((byte) (karte.getBox() - 1));
        }
    }

    public void durchschauen(Stapel stapel) {
        abfrageManager = new AbfrageManager(stapel);
    }

    public void abfrageFuenfKaesten(Stapel stapel, Byte box) {
        abfrageManager = new AbfrageManager(stapel, box);
    }






}
