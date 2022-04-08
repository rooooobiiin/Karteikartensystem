package de.atiw.karteikartensystem.Persistenz;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;

import java.io.File;
import java.util.List;

public class DatenbankVerwaltung {

    private DatenbankVerwaltung instance = new DatenbankVerwaltung();

    public void connectToDB() {
        //TODO: implementieren
    }

    public List<Stapel> readStapelliste() {
        //TODO: implementieren
        return null;
    }

    public void createStapel(Stapel stapel) {
        //TODO: implementieren
    }

    public List<Stapel> readStapel(int stapelID) {
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
        //TODO: implementieren
    }

    public void updateKarteikarte(Karteikarte karte, String vorderseiteNeu, String rueckseiteNeu) {
        //TODO: implementieren
    }

    public void deleteKarteikarte(Karteikarte karte) {
        //TODO: implementieren
    }

    public void stapelSynchronisieren(Stapel stapel) {
        //TODO: implementieren
    }


    public Stapel readCSV(File file) {
        //TODO: implementieren
        return null;
    }

    public void writeCSV(File file) {
        //TODO: implementieren
    }
}
