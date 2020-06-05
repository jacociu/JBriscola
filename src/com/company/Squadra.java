package com.company;

public class Squadra {
    //Attributi

    private String Nome;
    private int PartiteVinte;

    //Metodi

    public String getNome() {
        return Nome;
    }

    public int getPartiteVinte() {
        return PartiteVinte;
    }

    public void setPartiteVinte(int partiteVinte) {
        PartiteVinte = partiteVinte;
    }

    @Override
    public String toString() {
        return "Squadra{" +
                "Nome='" + Nome + '\'' +
                ", PartiteVinte=" + PartiteVinte +
                '}';
    }
}
