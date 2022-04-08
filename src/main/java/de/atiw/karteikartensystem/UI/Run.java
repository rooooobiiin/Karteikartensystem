package de.atiw.karteikartensystem.UI;

import de.atiw.karteikartensystem.Datas.Karteikarte;
import de.atiw.karteikartensystem.Datas.Stapel;
import de.atiw.karteikartensystem.Logic.SystemController;

public class Run {
    public static void main(String[] args) {
        SystemController controller = new SystemController();
        Stapel stapel = new Stapel("test");
        stapel.addKarteikarte(new Karteikarte(1, "a", "a", (byte) 1));
        stapel.addKarteikarte(new Karteikarte(2, "b", "b", (byte) 1));
        stapel.addKarteikarte(new Karteikarte(3, "c", "c", (byte) 1));
        stapel.addKarteikarte(new Karteikarte(4, "d", "d", (byte) 1));

        controller.durchschauen(stapel);


        Karteikarte kk;
        while ((kk = controller.getKarteikarte()) != null) {
            System.out.println(kk.getVoderseite());
        }

        controller.abfrageFuenfKaesten(stapel, (byte) 1);

        Karteikarte karte;
        while((karte = controller.getRandomkarte()) != null) {
            System.out.println(karte.getVoderseite());
        }

        controller.getRandomkarte();


    }

}
