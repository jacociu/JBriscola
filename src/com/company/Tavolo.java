package com.company;

public class Tavolo {
    //ATTRIBUTI
    private Carta Briscola;
    private Seme SemeManoCorrente;
    private Mazzo CarteGiocate;
    private Mazzo MazzoSulTavolo;

    //METODI
    //Costruttore


    //Metodo get&setBriscola
    public Carta getBriscola() {
        return Briscola;
    }
    public void setBriscola(Carta briscola) {
        Briscola = briscola;
    }

    //Metodo get&setSemeManoCorrente
    public Seme getSemeManoCorrente() {
        return SemeManoCorrente;
    }
    public void setSemeManoCorrente(Seme semeManoCorrente) {
        SemeManoCorrente = semeManoCorrente;
    }

    //Costruttore del MazzoSulTavolo
    public Tavolo(Mazzo mazzoSulTavolo) {
        MazzoSulTavolo = mazzoSulTavolo;
    }
}
