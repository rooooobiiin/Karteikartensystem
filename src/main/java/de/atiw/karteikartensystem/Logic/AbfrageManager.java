package de.atiw.karteikartensystem.Logic;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import java.util.Random;

public class AbfrageManager {
    private  boolean tasturEingabe;
    private Stapel stapel;
    private Karteikarte aktuelleKarteikarte;
    private byte boxNummer;


    public AbfrageManager(Stapel stapel) {
        this.stapel = stapel;
        aktuelleKarteikarte = stapel.getKartenSet().get(0);
    }

    public AbfrageManager(Stapel stapel, Byte box){
        this.stapel = stapel;
        this.boxNummer = box;
    }

    public  void setTasturEingabe(boolean tasturEingabe) {
        this.tasturEingabe = tasturEingabe;
    }

    public Karteikarte getNextKarteikarte() {

        Karteikarte returnKarte = aktuelleKarteikarte;

        if (stapel.getKartenSet().indexOf(aktuelleKarteikarte) < stapel.getKartenSet().size()-1) {
            aktuelleKarteikarte = stapel.getKartenSet().get(stapel.getKartenSet().indexOf(aktuelleKarteikarte)+1);
        } else {
            aktuelleKarteikarte = null;
        }
        return returnKarte;
    }

    public Karteikarte getRandomKarte() {
        Random random = new Random();
        return stapel.getBox(boxNummer).get(random.nextInt(stapel.getBox(boxNummer).size()));
    }

}
