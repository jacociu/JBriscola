package com.company;

import java.util.*;

 public class Mazzo {
    //attributi
    private int size;

    //rivedere

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
         return size;
    }

    //Metodo Per mischiare il mazzo
    public void mescola(){
        Collections.shuffle(el);
    }



    // override del metodo toString
    @Override
    public String toString(){
        StringBuilder s= new StringBuilder();
        for (Carta c :  el){

            s.append(c).append("\n");
        }
        return s.toString();
    }
}