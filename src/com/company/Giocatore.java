package JBriscola;
/**
 * classe astratta generico partecipante alla partita che gioca ad ogni turno una delle carte che ha in mano
 *
 */
public abstract class Giocatore {
    protected String nome;
    protected Mazzo mano;
    protected Mazzo prese;
    protected int punti;
    /**
     * metodo costruttore il valore dell'attributo punti è settato a 0 al momento della creazione
     * ed entrambi gli attributi di tipo Mazzo vengono inizializzati automaticamente all'interno del costruttore
     * @param s nome del giocatore
     */
    public Giocatore(String s){
        this.nome=s;
        this.punti=0;
        mano=new Mazzo();
        prese=new Mazzo();

    }
    /**
     * il giocatore aggiunge la carta fornitagli dalla partita alla propria mano
     * @param c carta da aggiungere alla mano
     */

    public void pesca(Carta c){
        this.mano.aggiungi(c);

    }
    /**
     * il giocatore aggiunge la carta fornitagli dalla partita alla propria presa
     * @param c carta da aggiungere alle prese
     */
    public void presa(Carta c){

        this.prese.aggiungi(c);
    }
    /**
     * restituisce il valore dell'attributo nome
     * @return il valore dell'attributo nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * modifica il valore dell'attributo nome
     * @param nome nuovo valore che assumerà l'attributo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * restituisce il valore dell'attributo mano
     * @return il valore dell'attributo mano
     */
    public Mazzo getMano() {
        return new Mazzo(this.mano);
    }
    /**
     * imposta il valore dell'attributo mano
     * @param mano nuovo valore che assumerà l'attributo mano
     */
    public void setMano(Mazzo mano) {
        this.mano =new Mazzo(mano);
    }
    /**
     * restituisce il valore dell'attributo prese
     * @return il valore dell'attributo prese
     */
    public Mazzo getPrese() {
        return new Mazzo (this.prese);
    }
    /**
     * imposta il valore dell'attributo prese
     * @param prese nuovo valore che assumerà l'attributo prese
     */
    public void setPrese(Mazzo prese) {
        this.prese =new Mazzo(prese);
    }
    /**
     * restituisce il valore dell'attributo punti
     * @return il valore dell'attributo punti
     */
    public int getPunti() {
        return punti;
    }
    /**
     * imposta il valore dell'attributo punti
     * @param punti nuovo valore che assumerà l'attributo punti
     */
    public void setPunti(int punti) {
        this.punti = punti;
    }
    /**
     * metodo astratto definisce la giocata del generico giocatore
     * @param t carta giocata dal primo giocatore
     * @param q carta giocata dal secondo giocatore
     * @param l carta giocata dal terzo giocatore
     * @param c briscola
     * @return la carta da giocare scelta tra quelle in mano
     */
    public abstract Carta gioca(Carta t,Carta q,Carta l, Carta c);


}
