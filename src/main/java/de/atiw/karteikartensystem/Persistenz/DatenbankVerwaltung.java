package de.atiw.karteikartensystem.Persistenz;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;

import java.io.File;
import java.util.List;

public class DatenbankVerwaltung {

    public static void connectToDB() {
        //TODO: implementieren
    }

    public static List<Stapel> readStapelliste() {
        //TODO: implementieren
        return null;
    }

    public static void createStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public static List<Stapel> readStapel(int stapelID) {
        //TODO: implementieren
        return null;
    }

    public static void updateStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public static void deleteStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public static void createKarteikarte(Karteikarte karte) {
        //TODO: implementieren
    }

    public static void updateKarteikarte(Karteikarte karte, String vorderseiteNeu, String rueckseiteNeu) {
        //TODO: implementieren
    }

    public static void deleteKarteikarte(Karteikarte karte) {
        //TODO: implementieren
    }

    public static void stapelSynchronisieren(Stapel stapel) {
        //TODO: implementieren
    }


    public static Stapel readCSV(File file) {
        //TODO: implementieren
        return null;
    }

    public static void writeCSV(File file) {
        //TODO: implementieren
    }
}
