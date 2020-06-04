package com.company;

import java.util.*;

 public class Mazzo {
    //attributi
    private int Size;

     public ArrayList<Carta> el = new ArrayList<>();

     //Costruttore di default: istanzia un oggetto di classe Mazzo settando la grandezza a "40" e inizializzando L'arraylist di carte presenti nel mazzo. Chiama infine il metodo per inizializzare e popolare l'arraylist di carte.}

     public Mazzo(){
        for (Seme s : Seme.values()){
            for (Valore v : Valore.values())

                el.add(new Carta(v,s));
        }
    }

    //get di Size
    public int GetSize(){
         return Size;
    }

    //Metodo Per mischiare il mazzo
    public void mescola(){
        Collections.shuffle(el);
    }

    //metodo per rimuovere una carta dal mazzo
     public void rimuoviCarta(Carta c){

     }

    // override del metodo toString
    @Override
    public String toString(){
        String s="";
        for (Carta c :  el){

            s = s+ c+ "\n";
        }
        return s;
    }




}