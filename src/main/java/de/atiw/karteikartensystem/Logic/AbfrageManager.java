package de.atiw.karteikartensystem.Logic;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;

import java.util.List;
import java.util.Random;

public class AbfrageManager {
    private static Stapel aktuellerStapel;
    private static Karteikarte aktuelleKarteikarte;
    private static List<Karteikarte> boxSet;
    private static byte boxNummer;


    public static void setAktuellerStapel(Stapel aktuellerStapel) {
        AbfrageManager.aktuellerStapel = aktuellerStapel;
    }

    public static Stapel getAktuellerStapel() {
        return aktuellerStapel;
    }

    public static void setBoxNummer(byte boxNummer) {
        AbfrageManager.boxNummer = boxNummer;
        if (boxNummer != 0) {
            boxSet = aktuellerStapel.getBoxSet(boxNummer);
        }
        synchronisiereBox();
    }

    public static void setAktuelleKarteikarte(Karteikarte aktuelleKarteikarte) {
        AbfrageManager.aktuelleKarteikarte = aktuelleKarteikarte;
    }

    public static void setNextKarteikarte() {
        if (boxNummer == 0) {
            if (aktuellerStapel.getKartenSet().indexOf(aktuelleKarteikarte) < aktuellerStapel.getKartenSet().size() - 1) {
                aktuelleKarteikarte = aktuellerStapel.getKartenSet().get(aktuellerStapel.getKartenSet().indexOf(aktuelleKarteikarte) + 1);
            } else {
                aktuelleKarteikarte = null;
            }
        } else {
            if (boxSet.indexOf(aktuelleKarteikarte) <= boxSet.size() -1) {
                aktuelleKarteikarte = boxSet.get(boxSet.indexOf(aktuelleKarteikarte)+1);
            } else {
                aktuelleKarteikarte = null;
            }
        }
    }

    private static void synchronisiereBox() {
        if (boxNummer != 0) {
            aktuelleKarteikarte = boxSet.get(0);
        }
    }

    /**
     *
     * @return Wirft die aktuelle Karteikarte zurück und setzt sie anschließend auf die nächste in der Liste
     */
    public static Karteikarte getaktuelleKarteikarte() {
        return aktuelleKarteikarte;
    }

    /**
     *
     * @return Wirft solange zufällige Karteikarten zurück bis der Kasten leer ist.
     */
    public static Karteikarte getRandomKarte() {
        //TODO: implementieren
        Random random = new Random();
        return null;
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
