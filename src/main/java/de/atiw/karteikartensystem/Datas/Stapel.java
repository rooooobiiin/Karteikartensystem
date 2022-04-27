package de.atiw.karteikartensystem.Datas;

import java.util.LinkedList;
import java.util.List;

public class Stapel {
    private int stapelID;
    private final List<Karteikarte> kartenSet;
    private String name;

    /**
     * @param name Name bzw. bezeichnung des Stapels
     */
    public Stapel(String name) {
        this.name = name;
        kartenSet = new LinkedList<>();
    }

    public Stapel(int ID, String name) {
        this.stapelID = ID;
        this.name = name;
        this.kartenSet = new LinkedList<>();
    }

    public int getStapelID() {return this.stapelID;}
    /**
     * @return Wirft eine Liste mit in dem Stapel gespeicherten <Karteikarten> zurück.
     */
    public List<Karteikarte> getKartenSet() {
        return kartenSet;
    }

    /**
     *
     * @return Gibt den Namen bzw. die Bezeichnung des Stapels zurück
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Name des Stapels
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Fügt dem Kartenset des Stapels eine Karteikarte hinzu
     * @param karte Hinzuzufügende Karte
     */
    public void addKarteikarte(Karteikarte karte) {
        kartenSet.add(new Karteikarte(karte.getVoderseite(), karte.getRueckseite(), karte.getBox()));
    }

    /**
     * Löscht eine Karte aus dem Kartenset des Stapels
     * @param karte Karte die aus dem Stapel gelöscht werden soll
     */
    public void deleteKarteikarte(Karteikarte karte) {
        kartenSet.remove(karte);
    }

    /**
     *
     * @param alteKarte Die alte Karte
     * @param neueKarte Die neue Karte
     */
    public void zweiKartenTauschen(Karteikarte alteKarte, Karteikarte neueKarte) {
        kartenSet.set(kartenSet.indexOf(alteKarte), neueKarte);
    }

    /**
     *
     * @param boxnummer Nummer vom zurückzuliefernden Kasten
     * @return liefert eine bestimmte Box zurück
     */
    public List<Karteikarte> getBoxSet(byte boxnummer) {
        List<Karteikarte> box = new LinkedList<>();

        for (Karteikarte karteikarte : kartenSet)
            if (karteikarte.getBox() == boxnummer) {
                box.add(karteikarte);
            }
        return box;
    }

    public int anzahlKarteninBox(byte boxnummer) {
        int zaehler = 0;

        for (int i = 0; i < kartenSet.size(); i++) {
            if (kartenSet.get(i).getBox() == boxnummer) {
                zaehler++;
            }
        }

        return zaehler;
    }


    @Override
    public String toString() {
        return "Stapel{" +
                "stapelID=" + stapelID +
                ", kartenSet=" + kartenSet +
                ", name='" + name + '\'' +
                '}';
    }
}
