package com.company;

import java.util.*;

public class Giocatore {

    //attributi
    private String nome;
    private Mazzo mano;
    private Mazzo prese;
    private Carta cartaGiocata;
    private Posizione Seduta;

    //costruttore
    public Giocatore(String nome, Posizione seduta) {
        this.nome = nome;
        Seduta = seduta;
    }


    //metodi get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Mazzo getMano() {
        return mano;
    }

    public void setMano(Mazzo mano) {
        this.mano = mano;
    }

    public Mazzo getPrese() {
        return prese;
    }

    public void setPrese(Mazzo prese) {
        this.prese = prese;
    }

    public Carta getCartaGiocata() {
        return cartaGiocata;
    }

    public void setCartaGiocata(Carta cartaGiocata) {
        this.cartaGiocata = cartaGiocata;
    }

    public Posizione getSeduta() {
        return Seduta;
    }

    public void setSeduta(Posizione seduta) {
        Seduta = seduta;
    }


}
