package de.atiw.karteikartensystem.Datas;

public class Karteikarte {
    private int karteiKartenID;
    private String voderseite;
    private String rueckseite;
    private byte box;

    /**
     *
     * @param vorderseite Stellt die Vorderseite der Karteikarte dar.
     * @param rueckseite Stellt die Rückseite der Karteikarte dar.
     * @param box Die Zuordnung in jeweiligen den Kasten.
     */
    public Karteikarte(String vorderseite, String rueckseite, byte box) {
        this.voderseite = vorderseite;
        this.rueckseite = rueckseite;
        this.box = box;
    }

    /**
     *
     * @param id Die ID der Karteikarte.
     * @param vorderseite Sellt die Vorderseite der Karteikarte dar.
     * @param rueckseite Stellt die Rückseite der Karteikarte dar.
     * @param box Die Zuordnung in jeweiligen den Kasten.
     */
    public Karteikarte(int id, String vorderseite, String rueckseite, byte box) {
        this.karteiKartenID = id;
        this.voderseite = vorderseite;
        this.rueckseite = rueckseite;
        this.box = box;
    }

    /**
     *
     * @return Die ID der Karteikarte.
     */
    public int getKarteiKartenID() {
        return karteiKartenID;
    }

    /**
     *
     * @return Die Vorderseite der Karteikarte.
     */
    public String getVoderseite() {
        return voderseite;
    }

    /**
     *
     * @param voderseite Die Vorderseite der Karteikarte.
     */
    public void setVoderseite(String voderseite) {
        this.voderseite = voderseite;
    }

    /**
     *
     * @return Die Rückseite der Karteikarte.
     */
    public String getRueckseite() {
        return rueckseite;
    }

    /**
     *
     * @param rueckseite Die Vorderseite der Karteikarte.
     */
    public void setRueckseite(String rueckseite) {
        this.rueckseite = rueckseite;
    }

    /**
     *
     * @return Liefert den Kasten, indem sich die Kartei befindet.
     */
    public byte getBox() {
        return box;
    }

    /**
     *
     * @param box Der Kasten in dem sich die Karteikarte befindet.
     */
    public void setBox(byte box) {
        this.box = box;
    }

    public void erhoeheBox(Karteikarte karte) {
        if (karte.getBox() < 5) {
            karte.setBox((byte) (karte.getBox() + 1));
        }
    }

    public void verringereBox(Karteikarte karte) {
            karte.setBox((byte) (1));

    }

    @Override
    public String toString() {
        return "Karteikarte{" +
                "karteiKartenID=" + karteiKartenID +
                ", voderseite='" + voderseite + '\'' +
                ", rueckseite='" + rueckseite + '\'' +
                ", box=" + box +
                '}';
    }
}
