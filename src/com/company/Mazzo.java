package JBriscola;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/**
 * Aggrega istanze della classe Carta
 *
 */

public class Mazzo {
    private ArrayList<Carta> mazzo;
    /**
     * Metodo Costruttore crea un mazzo vuoto
     */
    public Mazzo(){mazzo=new ArrayList<>();}
    /**
     * Costruttore di copia
     * @param m mazzo di cui verrà generata una copia
     */
    public Mazzo(Mazzo m){mazzo=new ArrayList<>(m.getMazzo());}
    /**
     * procedura che inserisce in un mazzo le 40 carte necessarie per una partita di briscola
     */
    public void reset(){
        int i=0;
        int v=0;
        int p=0;
        for(Seme s:Seme.values()){
            for(i=1;i<=10;i++){
                switch(i){
                    case(1):v=11;p=11; //se inizializzo un asso il suo valore e il suo punteggio sono pari a 11
                        break;
                    case(3):v=10;p=10;
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
     * @return true se il mazzo è vuoto altrimenti false
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
     * restituisce una carta che occupa la i-esima posizione nel mazzo
     * @param i posizione occupata dalla carta che si vuole estrarre all'interno del mazzo
     * @return la carta in posizione i nel mazzo
     */
    public Carta estrai(int i) throws IndexOutOfBoundsException {
        if(i<0||i>=this.mazzo.size()) throw new IndexOutOfBoundsException();
        return this.mazzo.get(i);
    }
    /**
     * rimuova la carta che occupa la i-esima posizone nel mazzo
     * @param i posizione che occupa la carta da rimuovere all interno del mazzo
     */
    public void scarta(int i) throws IndexOutOfBoundsException{
        if(i<0||i>=this.mazzo.size()) throw new IndexOutOfBoundsException();
        this.mazzo.remove(i);
    }
    /**
     * ordina le carte nel mazzo in base alle priorità definite dal metodo compareTo della classe Carta
     */
    public void ordina(){
        Collections.sort(this.mazzo);
    }
    /**restituisce sottoforma di stringa lo stato di tutte le istanze della classe Carta contenute nell'oggetto di invocazione
     * @return stringa contente lo stato di tutte le istanze della classe Carta contenute nell'oggetto di invocazione
     */
    public String toString() {String s="";
        for(Carta c:mazzo){
            s=s.concat(c.toString());
            s=s.concat("\n");
        }
        return s;
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
     * @param mazzo  nuovo valore che assumerà l'attributo mazzo
     */
    public void setMazzo(ArrayList<Carta> mazzo) {
        this.mazzo = mazzo;
    }
    /**
     * ordina in maniera pseudo-casuale le istanze della classe Carta presenti nell'oggetto di invocazione
     */
    public void mischia(){
        Collections.shuffle(this.mazzo);

    }


}
