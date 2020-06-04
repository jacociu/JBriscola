package com.company;

public class Carta {
    //Attributi di com.company.Carta
    private Valore val;
    private Seme sem;

    //Costruttore di com.company.Carta
    public Carta(Valore v, Seme s) {
        this.val = v;
        this.sem =s;
    }
    //Costruttore vuoto
    public Carta() {
    }
    //Metodo get di com.company.Valore
    public Valore getValore() {
        return val;
    }
    //Metodo get di com.company.Seme
    public Seme getSeme() {
        return sem;
    }
    //Metodo toString
    public String toString() {
        return val + " di "+ sem.toString();
    }
    //Metodo booleano che ci controlla se due carte sono uguali(Stesso seme e stesso valore)
    //"java.lang.Object obj" serve per far confrontare due oggetti
    public boolean equals(java.lang.Object obj)     //(?)

    //Metodo toString che ritorna una string di seme e valore come carta
    public String toString() {
        return val + " di "+ sem.toString();
    }
    //Metodo compareTo Confronta due carte in base al loro com.company.Valore e il loro com.company.Seme
    public int compareTo(Object o){
        Carta c = (Carta) o;
        if (this.sem.ordinal() < c.sem.ordinal()) return -1;
        if (this.sem.ordinal() > c.sem.ordinal()) return 1;
        if (this.val < c.val) return -1;
        if (this.val > c.val) return 1;
        else return 0;
    }
}
