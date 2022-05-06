package de.atiw.karteikartensystem.Persistenz;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DataHandler {
    /**
     * Bekommt eine CSV-Datei übergeben und wandelt diese in einen Liste von Karteikarten um.
     * @param file CSV-Datei mit den enthaltenen Daten.
     * @return Liste an Karteikarten.
     * @throws IOException wird geworfen, sobald das Laden der Datei fehlschlägt.
     */
    public static List<Karteikarte> readCSV(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        LinkedList<Karteikarte> karten = new LinkedList<>();
        String[] tempArr;
        while ((line = br.readLine()) != null) {
            tempArr = line.split(";");
            karten.add(new Karteikarte(tempArr[0],tempArr[1],(byte) 1));
        }
        br.close();
        return karten;
    }

    public static void writeCSV(File file) {
        //TODO: implementieren
    }
}
