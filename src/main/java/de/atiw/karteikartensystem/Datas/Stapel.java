package de.atiw.karteikartensystem.Datas;

import java.util.List;

public class Stapel {
    private int stapelID;
    private List<Karteikarte> kartenSet;
    private String name;

    public Stapel(String name) {
        this.name = name;
    }
}
