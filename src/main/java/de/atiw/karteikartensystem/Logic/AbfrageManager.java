package de.atiw.karteikartensystem.Logic;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import java.util.Random;

public class AbfrageManager {
    private final Stapel stapel;
    private Karteikarte aktuelleKarteikarte;
    private byte boxNummer;

    /**
     *
     * @param stapel Stapelobjekt das durchgeschaut werden soll
     */
    public AbfrageManager(Stapel stapel) {
        this.stapel = stapel;
        aktuelleKarteikarte = stapel.getKartenSet().get(0);
    }

    /**
     *
     * @param stapel Stapelobjekt das durchgeschaut werden soll
     * @param box Der Karteikartenkasten der behandelt werden soll
     */
    public AbfrageManager(Stapel stapel, Byte box){
        this.stapel = stapel;
        this.boxNummer = box;
    }

    /**
     *
     * @return Wirft die aktuelle Karteikarte zurück und setzt sie anschließend auf die nächste in der Liste
     */
    public Karteikarte getNextKarteikarte() {

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
    public Karteikarte getRandomKarte() {
        Random random = new Random();
        return stapel.getBox(boxNummer).get(random.nextInt(stapel.getBox(boxNummer).size()));
    }

    /**
     *
     * @param karteikarte Karteikarte die verglichen werden soll
     * @param input Text der zum Vergleich mit der Karteikarte eingegeben wurde
     * @return Boolean, ob die Eingabe richtig oder falsch wahr.
     */
    public boolean vergleicheInhaltUndInput(Karteikarte karteikarte, String input) {
        return karteikarte.getRueckseite().equals(input);
    }
}
