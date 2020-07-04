package JBriscola;
/**
 * Definisce l'oggetto Carta, le istanze di questa classe vengono raccolte all'interno delle istanze
 * di mazzo e usate dalle istanze di GiocatoreReale e GiocatoreCpu durante la partita
 *
 */
public class Carta implements Comparable<Object>{
    private int numero;
    private Seme seme;
    private int valore;
    private int punti;
    /**
     * Metodo costruttore della classe Carta
     * @param num valore numerico della carta
     * @param se  seme della carta
     * @param va  valore effettivo della carta nella briscola
     * @param pu  punti attribuiti alla carta nella briscola
     */
    public Carta(int num,Seme se,int va,int pu){
        this.numero=num;
        this.seme=se;
        this.valore=va;
        this.punti=pu;
    }


    /**genera  una stringa contente informazioni sullo stato dell'oggetto
     * @return stringa contente lo stato dell'oggetto
     */

    public String toString() {
        return " Carta [numero=" + numero + ", seme=" + seme + " ,valore= "+valore+" , punti= "+punti+"] ";
    }



    /**
     * definisce un ordine di grandezza interno alla classe
     * tra due carte viene considerata più grande quella con l'attributo valore più alto
     * a parità di valore si confronta l'attributo punti
     *@param o Oggetto con cui effettuare il confronto verrà forzato un passaggio al tipo Carta
     *@return 1 se l'oggetto di invocazione è più grande dell'oggetto passato come parametro
     *altrimenti -1 se i due oggetti sono uguali viene ritornato 0
     */

    public int compareTo(Object o) {
        Carta c=(Carta)o;

        if(this.valore>c.valore)return 1;
        if(this.valore<c.valore)return -1;
        if(this.punti>c.punti)return 1;
        if(this.punti<c.punti)return -1;

        return 0;

    }
    /**
     * restituisce  il valore numerico della carta
     * @return il valore numerico della Carta
     */
    public int getNumero() {
        return numero;
    }
    /**
     * modifica l'attributo numero della Carta
     * @param numero nuovo valore che assumerà l'attributo numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * restituisce il valore dell'attributo seme della carta
     * @return il valore dell'attributo seme della carta
     */
    public Seme getSeme() {
        return seme;
    }
    /**
     * modifica il valore dell'attributo seme della carta
     * @param seme nuovo valore che assumerà l'attributo seme
     */
    public void setSeme(Seme seme) {
        this.seme = seme;
    }
    /**
     * restituisce il valore effettivo della carta nella briscola
     * @return il valore effettivo nella briscola della carta
     */
    public int getValore() {
        return valore;
    }
    /**
     * modifica il valore effettivo nella briscola della carta
     * @param valore  nuovo valore che assumerà l'attributo
     */
    public void setValore(int valore) {
        this.valore = valore;
    }
    /**
     * restituisce i punti attribuiti alla carta nella briscola
     * @return punti attribuiti alla carta
     */
    public int getPunti() {
        return punti;
    }
    /**
     * modifica i punti attribuiti alla carta nella briscola
     * @param punti nuovo valore che assumerà l'attributo punti
     */
    public void setPunti(int punti) {
        this.punti = punti;
    }

}
