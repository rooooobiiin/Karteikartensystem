package de.atiw.karteikartensystem.Logic;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import java.util.Random;

public class AbfrageManager {
    private static Stapel stapel;
    private static Karteikarte aktuelleKarteikarte;
    private static byte boxNummer;


    public static void setStapel(Stapel stapel) {
        AbfrageManager.stapel = stapel;
    }

    public static Stapel getStapel() {
        return stapel;
    }

    public static void setBoxNummer(byte boxNummer) {
        AbfrageManager.boxNummer = boxNummer;
    }

    public static void setAktuelleKarteikarte(Karteikarte aktuelleKarteikarte) {
        AbfrageManager.aktuelleKarteikarte = aktuelleKarteikarte;
    }

    /**
     *
     * @return Wirft die aktuelle Karteikarte zurück und setzt sie anschließend auf die nächste in der Liste
     */
    public static Karteikarte getNextKarteikarte() {

        Karteikarte returnKarte = aktuelleKarteikarte;

        if (stapel.getKartenSet().indexOf(aktuelleKarteikarte) < stapel.getKartenSet().size()-1) {
            aktuelleKarteikarte = stapel.getKartenSet().get(stapel.getKartenSet().indexOf(aktuelleKarteikarte)+1);
        } else {
            aktuelleKarteikarte = null;
        }
        return returnKarte;
    }

    /**
     *
     * @return Wirft solange zufällige Karteikarten zurück bis der Kasten leer ist.
     */
    public static Karteikarte getRandomKarte() {
        Random random = new Random();
        return stapel.getBox(boxNummer).get(random.nextInt(stapel.getBox(boxNummer).size()));
    }

    /**
     *
     * @param karteikarte Karteikarte die verglichen werden soll
     * @param input Text der zum Vergleich mit der Karteikarte eingegeben wurde
     * @return Boolean, ob die Eingabe richtig oder falsch wahr.
     */
    public static boolean vergleicheInhaltUndInput(Karteikarte karteikarte, String input) {
        return karteikarte.getRueckseite().equals(input);
    }
}
