package de.atiw.karteikartensystem.UI.Example;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;

import java.util.List;
import java.util.Random;

public class ExampleAbfrageManager {
     public static Stapel aktuellerStapel;
     public static Karteikarte aktuelleKarteikarte;
     public static List<Karteikarte> boxSet;
     public static byte boxNummer;



    public static void updateKarte() {

    }


    public static void setAktuellerStapel(Stapel aktuellerStapel) {
        ExampleAbfrageManager.aktuellerStapel = aktuellerStapel;
    }

    public static Stapel getAktuellerStapel() {
        return aktuellerStapel;
    }

    /**
     * Setzt die Nummer der Box der Klasse auf den übergebenen Wert. Falls dieser nicht 0 ist sondern 1-5 wird der entsprechende
     * Kasten der Karteikarten geladen und die aktuelle Karteikarte wird auf die erste Karte dieses Sets gesetzt.
     * @param boxNummer Nummer des Kastens der geladen werden soll
     */
    public static void setBoxNummer(byte boxNummer) {
        ExampleAbfrageManager.boxNummer = boxNummer;
        if (boxNummer != 0) {
            boxSet = aktuellerStapel.getBoxSet(boxNummer);
            aktuelleKarteikarte = boxSet.get(0);
        }
    }

    /**
     * setter aktuelleKarteikarte
     * @param aktuelleKarteikarte die Karte, die gesetzt werden soll.
     */
    public static void setAktuelleKarteikarte(Karteikarte aktuelleKarteikarte) {
        ExampleAbfrageManager.aktuelleKarteikarte = aktuelleKarteikarte;
    }

    /**
     * BoxNummer=0 (Alle Karten): aktuelle Karteikarte wird erhöht sofern sie kleiner als das KartenSet des aktuellen
     *                            Stapels ist. Ansonsten wird sie null gesetzt weil alle Karten durchgesehen worden.
     * BoxNummer!=0 (Nur ein Set): aktuelle Karteikarte wird auf das nächste Objekt der Liste boxSet gesetzt. Sind alle Karten
     *                             durchgesehen worden wird sie ebenfalls auf null gesetzt.
     */
    public static void setNextKarteikarte() {
        if (boxNummer == 0) {
            if (aktuellerStapel.getKartenSet().indexOf(aktuelleKarteikarte) < aktuellerStapel.getKartenSet().size() - 1) {
                aktuelleKarteikarte = aktuellerStapel.getKartenSet().get(aktuellerStapel.getKartenSet().indexOf(aktuelleKarteikarte) + 1);
            } else {
                aktuelleKarteikarte = null;
            }
        } else {
            if (boxSet.indexOf(aktuelleKarteikarte) < boxSet.size() -1) {
                aktuelleKarteikarte = boxSet.get(boxSet.indexOf(aktuelleKarteikarte)+1);
            } else {
                aktuelleKarteikarte = null;
            }
        }
    }

    /**
     *
     * @return Wirft die aktuelle Karteikarte zurück
     */
    public static Karteikarte getaktuelleKarteikarte() {
        return aktuelleKarteikarte;
    }

    /**
     *
     * @return Wirft solange zufällige Karteikarten zurück bis der Kasten (die Box) leer ist.
     */
    public static Karteikarte getRandomKarte() {
        Random random = new Random();
        return boxSet.get(random.nextInt(0, boxSet.size()));
                //aktuellerStapel.getBox(boxNummer).get(random.nextInt(aktuellerStapel.getBox(boxNummer).size()));
    }

    /**
     *
     * @param input Text der zum Vergleich mit der Karteikarte eingegeben wurde
     * @return Boolean, ob die Eingabe richtig oder falsch wahr.
     */
    public static boolean vergleicheInhaltUndInput(String input) {
        return aktuelleKarteikarte.getRueckseite().equals(input);
    }

}
