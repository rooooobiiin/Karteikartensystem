package de.atiw.karteikartensystem.Datas;

public class Karteikarte {
    private int karteiKartenID;
    private String voderseite;
    private String rueckseite;
    private byte box;

    public Karteikarte(int id, String vorderseite, String rueckseite, byte box) {
        karteiKartenID = id;
        this.voderseite = vorderseite;
        this.rueckseite = rueckseite;
        this.box = box;
    }


}
