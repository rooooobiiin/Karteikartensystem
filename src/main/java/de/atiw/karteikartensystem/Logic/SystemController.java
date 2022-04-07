package de.atiw.karteikartensystem.Logic;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;

import java.util.List;

public class SystemController {
    private Stapel aktuellerStapel;

    private SystemController instance = new SystemController();


    public Stapel getAktuellerStapel() {
        return aktuellerStapel;
    }

    public void setAktuellerStapel(Stapel aktuellerStapel) {
        this.aktuellerStapel = aktuellerStapel;
    }

    public static void connectToDB(String username, String password) {
        //TODO: implementieren
    }

    public static List<Karteikarte> readStapelList() {
        //TODO: implementieren
        return null;
    }

    public static void createStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public static Stapel readStapel(String name) {
        //TODO: implementieren
        return null;
    }

    public static void updateStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public static void deleteStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public static void updateKarteikarte(Karteikarte karte) {
        //TODO: implementieren
    }

    public static void deleteKarteikarte(Karteikarte karte) {
        //TODO: implementieren
    }

    public static void durchschauen(Stapel stapel) {
        //TODO: implementieren
    }

    public static void abfrageFuenfKaesten() {
        //TODO: implementieren
    }






}
