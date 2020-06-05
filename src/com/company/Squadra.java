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
    //DA RIVISIONARE
    void aggiungiGiocatore(Giocatore nuovoGiocatore) {
        Calciatore[] nuovoArrayGiocatori = new Calciatore[this.giocatori.length + 1];
        // copio i giocatori dal vecchio array al nuovo, verificando che non ce ne sia gia' uno con lo stesso nome
        // inizio dalla posizione 1, lasciando la 0 libera per inserire il nuovo giocatore in prima posizione
        for (int i=1; i < nuovoArrayGiocatori.length; i++) {
            int numeroNuovoGiocatore = nuovoCalciatore.numero();
            int numero = this.giocatori[i-1].numero();
            if (numero == numeroNuovoGiocatore)
                throw new RuntimeException("Esiste gia' un giocatore col numero " + numero +"! Inserimento annullato");
            nuovoArrayGiocatori[i] = this.giocatori[i-1];
        }
        // copio il nuovo giocatore nella prima posizione del nuovo array
        nuovoArrayGiocatori[0] = nuovoCalciatore;
        // sostituisco il vecchio array con il nuovo array contenente il nuovo giocatore
        this.giocatori = nuovoArrayGiocatori;
    }
}
