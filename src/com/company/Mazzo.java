package com.company;

import java.util.ArrayList;
import java.util.Collections;

//gli elementi contenuti sono di un solo tipo: Object.ArrayList è una classe come tutte le altre, non ha alcuna sintassi particolare
//fornisce una serie di metodi statici che operano sul set di collezioni definiti all'interno del Java Collections Framework.
//Alcuni di questi metodi vengono definiti wrapper, cioè operano sulle collezione modificandone il loro stato

/**La classe mazzo aggrega istanze della classe carta
 */
 public class Mazzo {
    //Attributi
    private ArrayList<Carta> mazzo;

    public ArrayList<Carta> el = new ArrayList<>();
     /**
      * Costruttore di default: istanzia un oggetto di classe Mazzo settando la grandezza a "40" e
      *inizializzando L'arraylist di carte presenti nel mazzo. Chiama infine il metodo per inizializzare e popolare l'arraylist di carte.}
      * Metodo Costruttore crea un mazzo vuoto
      */
    public Mazzo(){
        mazzo=new ArrayList<>();
    }
     /**
      * Costruttore di copia
      * @param m mazzo di cui verrà generata una copia
      */
    public Mazzo(Mazzo m) {
        mazzo=new ArrayList<>(m.getMazzo());
    }
    /**
     * procedura che inserisce in un mazzo le 40 carte necessarie per una partita di briscola
     * Se si tratta di un Asso,Tre e le figure, assumono il loro punteggio nel gioco
     */
    public void reset(){
        int i=0;
        int v=0;
        int p=0;
        for(Seme s:Seme.values()){
            for(i=1;i<=10;i++){
                switch(i){
                    case(1):v=11;p=11;      //se inizializzo un asso il suo valore e il suo punteggio sono pari a 11
                        break;              //Lo statement break (già visto nella sua forma più semplice e comune quando abbiamo parlato di switch-case ) serve per terminare
                    case(3):v=10;p=10;      // l'esecuzione di uno o più blocchi di codice. In altre parole serve per “saltare fuori” da costrutti iterativi o switch-case
                        break;
                    case(8):v=i;p=2;
                        break;
                    case(9):v=i;p=3;
                        break;
                    case(10):v=i;p=4;
                        break;
                    default:v=i;p=0;
                }
                this.mazzo.add(new Carta(i,s,v,p));
            }
        }

    }
    //Metodo Per mischiare il mazzo
    public void mescola(){
        Collections.shuffle(this.mazzo);
    }
    /**
     * rimuove la carta dalla cima del mazzo
     */
    public void togli() throws IndexOutOfBoundsException{
        if(this.mazzo.size()==0) throw new IndexOutOfBoundsException();
        this.mazzo.remove(this.mazzo.size()-1);
    }
    /**
     * aggiunge una carta in cima al mazzo
     * @param c carta da aggiungere
     */
    public void aggiungi(Carta c){
        this.mazzo.add(c);
    }
    /**
     * verifica se nel mazzo sono presenti carte
     * @return true se il mazzo � vuoto altrimenti false
     */
    public boolean vuoto(){
        return this.mazzo.isEmpty();
    }
    /**
     * restituisce la carta in cima al mazzo
     * @return la carta in cima al mazzo
     */
    public Carta prima()throws IndexOutOfBoundsException{
        if(this.mazzo.size()==0) throw new IndexOutOfBoundsException();
        return this.mazzo.get(this.mazzo.size()-1);
    }
    /**
     * restituisce il valore dell'attributo mazzo
     * @return il valore dell'attributo mazzo
     */
    public ArrayList<Carta> getMazzo() {
        return mazzo;
    }
    /**
     * imposta un nuovo valore per l'attributo mazzo
     * @param mazzo  nuovo valore che assumer� l'attributo mazzo
     */
    public void setMazzo(ArrayList<Carta> mazzo) {
        this.mazzo = mazzo;
    }

    /**
     * restituisce sottoforma di stringa lo stato di tutte le istanze della classe Carta contenute nell'oggetto di invocazione
     * @return stringa contente lo stato di tutte le istanze della classe Carta contenute nell'oggetto di invocazione
     */
    public String toString() {String s="";
        for(Carta c:mazzo){
            s=s.concat(c.toString());
            s=s.concat("\n");
        }
        return s;
    }
}