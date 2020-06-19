package com.company;

import javax.swing.JOptionPane;

public class Tavolo {
    import JOptionPane;
    private static final int max_punti=3;
    private static final  int n_turni=10;
    private Giocatore g1;
    private Giocatore g2;
    private Giocatore g3;
    private Giocatore g4;
    private Mazzo mazzo;
    private Mazzo scoperte;
    private Carta briscola;
    private boolean giocata;

    public Partita(Giocatore g1,Giocatore g2,Giocatore g3,Giocatore g4){
        this.g1=g1;
        this.g2=g2;
        this.g3=g3;
        this.g4=g4;
        this.mazzo=new Mazzo();
        this.scoperte=new Mazzo();
        this.giocata=false;
        this.briscola=null;
    }
    /**
     * restituisce il valore dell'attributo g1
     * @return valore dell'attributo g1
     */
    public Giocatore getG1() {
        return this.g1;
    }
    /**
     * imposta un nuovo valore per l'attributo g1
     * @param g1 nuovo valore che verr� assunto dall'attributo g1
     */
    public void setG1(Giocatore g1) {
        this.g1=g1;
    }
    /**
     * restituisce il valore dell'attributo g2
     * @return valore dell'attributo g2
     */
    public Giocatore getG2() {
        return this.g2;
    }
    /**
     * imposta un nuovo valore per l'attibuto g2
     * @param g2 nuovo valore che verr� assunto dall'attributo g2
     */
    public void setG2(Giocatore g2) {
        this.g2=g2;
    }
    /**
    * restituisce il valore dell'attributo mazzo
    * @return valore dell'attributo mazzo
    */
    public Giocatore getG3() {
        return this.g3;
    }
    public void setG3(Giocatore g3) {
        this.g3=g3;
    }
    public Giocatore getG4(){return this.g4;}
    public void setG4(Giocatore g4){this.g4=g4;}

    /**
     * metodo principale in esecuzione finch� uno dei due giocatori non vince un numero di mani
     * necessarie a vincere la partita
     */
    public void start(){
        while(this.g1.getPunti()!=max_punti&&this.g2.getPunti()!=max_punti){
            boolean s=giocata;
            this.inizio();
            System.out.println("///////////////////////////////////////////////////////////////// \n");
            System.out.println("Risultato parziale: "+this.g1.getNome()+" "+this.g1.getPunti()+" punti\n"
                    +this.g2.getNome()+" "+this.g2.getPunti()+" punti");
            this.mano();
            giocata=(!s);
            System.out.println("///////////////////////////////////////////////////////////////// \n");
        }
        if(g1.getPunti()==max_punti){
            JOptionPane.showMessageDialog(null, g1.getNome()+"// e"+g3.getNome()+"VINCONO");
            System.out.println("\n "+this.g1.getNome()+"// e"+this.g3.getNome()+" vincono la partita\n");
        }
        if(g2.getPunti()==max_punti){
            JOptionPane.showMessageDialog(null, g2.getNome()+"// e"+ g4.getNome()+"VINCONO");
            System.out.println("\n "+this.g2.getNome()+"//e"+this.g4.getNome()+" vincono la partita\n");
        }


    }



}
