package de.atiw.karteikartensystem.Datas;

public class Karteikarte {
    private int karteiKartenID;
    private String voderseite;
    private String rueckseite;
    private byte box;

    public Karteikarte(String vorderseite, String rueckseite, byte box) {
        this.voderseite = vorderseite;
        this.rueckseite = rueckseite;
        this.box = box;
    }

    public Karteikarte(int id, String vorderseite, String rueckseite, byte box) {
        this.karteiKartenID = id;
        this.voderseite = vorderseite;
        this.rueckseite = rueckseite;
        this.box = box;
    }

    public int getKarteiKartenID() {
        return karteiKartenID;
    }

    public void setKarteiKartenID(int karteiKartenID) {
        this.karteiKartenID = karteiKartenID;
    }

    public String getVoderseite() {
        return voderseite;
    }

    public void setVoderseite(String voderseite) {
        this.voderseite = voderseite;
    }

    public String getRueckseite() {
        return rueckseite;
    }

    public void setRueckseite(String rueckseite) {
        this.rueckseite = rueckseite;
    }

    public byte getBox() {
        return box;
    }

    public void setBox(byte box) {
        this.box = box;
    }
}
