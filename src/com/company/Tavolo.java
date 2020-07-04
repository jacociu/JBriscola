package JBriscola;

import javax.swing.*;

/**
 * Classe principale gestisce l'intera partita
 *
 */
public class Tavolo {
    private static final int max_punti = 3;
    private static final int n_turni = 10;
    private Giocatore g1;
    private Giocatore g2;
    private Giocatore g3;
    private Giocatore g4;
    private Mazzo mazzo;
    private Mazzo scoperte;
    private Carta briscola;
    private boolean giocata;
    private boolean play;
    private boolean controllo;
    private boolean verifica;

    /**
     * metodo costruttore riceve in ingresso i quattro giocatori
     *
     * @param g1 primo giocatore
     * @param g2 secondo giocatore
     * @param g3 terzo giocatore
     * @param g4 quarto giocatore
     */
    public Tavolo (Giocatore g1, Giocatore g2, Giocatore g3, Giocatore g4) {
        this.g1 = g1;
        this.g2 = g2;
        this.g3 = g3;
        this.g4 = g4;
        this.mazzo = new Mazzo();
        this.scoperte = new Mazzo();
        this.giocata = true;
        this.play = true;
        this.controllo=true;
        this.verifica=true;
        this.briscola = null;

    }

    /**
     * metodo principale in esecuzione finché una delle due squadre non vince un numero di mani
     * necessarie a vincere la partita
     */

    public void start() {
        while (this.g1.getPunti() != max_punti && this.g2.getPunti() != max_punti) {
            this.inizio();

            System.out.println("///////////////////////////////////////////////////////////////// \n");
            System.out.println("Risultato parziale: " + this.g1.getNome() + " e " + this.g3.getNome() + " hanno " + this.g1.getPunti() + " punti\n"
                    + this.g2.getNome() + " e " + this.g4.getNome() + " hanno " + this.g2.getPunti() + " punti ");
            this.mano();
            System.out.println("///////////////////////////////////////////////////////////////// \n");
        }
        if (g1.getPunti() == max_punti) {
            JOptionPane.showMessageDialog(null, g1.getNome() + " E " + g3.getNome() + " VINCONO");
            System.out.println("\n " + this.g1.getNome() + " e " + this.g3.getNome() + " vincono la partita\n");
        }
        if (g2.getPunti() == max_punti) {
            JOptionPane.showMessageDialog(null, g2.getNome() + " E " + g4.getNome() + " VINCONO");
            System.out.println("\n " + this.g2.getNome() + " e " + this.g4.getNome() + " vincono la partita\n");
        }
    }

    /**
     * metodo che consiste in un susseguirsi di turni fino ad aver giocato tutte le carte disponibili
     * presenti nel mazzo
     */
    private void mano() {

        for (int i = 0; i < n_turni; i++) {
            System.out.println("Turno " + (i + 1) + "\n");
            this.turno();
        }

        this.punteggio();
        System.out.println("la mano è finita");


    }

    /**
     * metodo richiamato prima dell'inizio di ogni mano utilizza il metodo reset e il metodo mischia per
     * preparare il mazzo, fa pescare ad ogni giocatore 3 carte e ad ogni nuova mano svuota il mazzo delle prese
     * di tutti i giocatori
     *
     */
    private void inizio() {
        g1.setPrese(new Mazzo());
        g2.setPrese(new Mazzo());
        g3.setPrese(new Mazzo());
        g4.setPrese(new Mazzo());

        this.mazzo.reset();
        this.mazzo.mischia();

        this.briscola = this.mazzo.prima();
        System.out.println("Briscola :" + this.briscola.toString() + "\n");
        this.mazzo.togli();
        this.mazzo.getMazzo().add(0, this.briscola);
        if (giocata && play) {
            for (int i = 0; i < 3; i++) {
                g1.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g2.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g3.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g4.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            this.giocata = true;
            this.play = true;
        }
        if (!giocata && play) {
            for (int i = 0; i < 3; i++) {
                g2.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g3.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g4.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g1.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            this.giocata = true;
            this.play = false;
        }
        if (giocata && !play) {
            for (int i = 0; i < 3; i++) {
                g3.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g4.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g1.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g2.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            this.giocata = false;
            this.play = true;
        }
        if (!giocata && !play) {
            for (int i = 0; i < 3; i++) {
                g4.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g1.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g2.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            for (int i = 0; i < 3; i++) {
                g3.pesca(this.mazzo.prima());
                this.mazzo.togli();
            }
            this.giocata = false;
            this.play = false;
        }
    }

    /**
     * gestisce la giocata di una carta da parte di tutti i giocatori, la presa da parte di uno
     * e si conclude con la pescata dal mazzo di una carta per ogni giocatore se il mazzo
     * non è terminato
     */
    private void turno() {

        //giocatore 1
        if (giocata && play) {

            this.scoperte.aggiungi(g1.gioca(null, null, null, this.briscola));
            this.scoperte.aggiungi(g2.gioca(this.scoperte.prima(), null, null, this.briscola));
            this.scoperte.aggiungi(g3.gioca(this.scoperte.estrai(0), this.scoperte.prima(), null, this.briscola));
            this.scoperte.aggiungi(g4.gioca(this.scoperte.estrai(0), this.scoperte.estrai(1), this.scoperte.prima(), this.briscola));

            this.check();
            //se prende g1
            if (controllo && verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g1.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(0) + " SU " + this.scoperte.getMazzo().get(1) + this.scoperte.getMazzo().get(2) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
            }
            //se prende g2
            if (controllo && !verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g2.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(1) + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(2) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=true;
                play=false;
            }
            //se prende g3
            if (!controllo && verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g3.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(2) + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(1) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=false;
                play=true;
            }
            // se prende g4
            if (!controllo && !verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g4.getNome() + " CHE HA GIOCATO" + this.scoperte.prima() + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(1) + this.scoperte.getMazzo().get(2) + "\n");
                /////////////////////////////////////
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=false;
                play=false;
            }




        }
        //giocatore 2
        else if (giocata && !play) {
            this.scoperte.aggiungi(g2.gioca(null, null, null, this.briscola));
            this.scoperte.aggiungi(g3.gioca(this.scoperte.prima(), null, null, this.briscola));
            this.scoperte.aggiungi(g4.gioca(this.scoperte.estrai(0), this.scoperte.prima(), null, this.briscola));
            this.scoperte.aggiungi(g1.gioca(this.scoperte.estrai(0), this.scoperte.estrai(1), this.scoperte.prima(), this.briscola));
            this.check();
            if (!controllo && !verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g1.getNome() + " CHE HA GIOCATO" + this.scoperte.prima() + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(1) + this.scoperte.getMazzo().get(2) + "\n");
                /////////////////////////////////////
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();

                }
                giocata=true;
                play=true;
            }
            if (controllo && verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g2.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(0) + " SU " + this.scoperte.getMazzo().get(1) + this.scoperte.getMazzo().get(2) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }

            }
            if (controllo && !verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g3.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(1) + " SU " + this.scoperte.getMazzo().get(2) + this.scoperte.prima() + this.scoperte.getMazzo().get(0)+ "\n");
                /////////////////////////////////////
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=false;
                play=true;
            }
            if (!controllo && verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g4.getNome() + " CHE HA GIOCATO" + this.scoperte.prima() + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(1) + this.scoperte.getMazzo().get(2) + "\n");
                /////////////////////////////////////
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=false;
                play=false;
            }


        }
        //giocatore3
        else if (!giocata && play) {
            this.scoperte.aggiungi(g3.gioca(null,  null, null, this.briscola));
            this.scoperte.aggiungi(g4.gioca(this.scoperte.prima(), null, null, this.briscola));
            this.scoperte.aggiungi(g1.gioca(this.scoperte.estrai(0), this.scoperte.prima(), null, this.briscola));
            this.scoperte.aggiungi(g2.gioca(this.scoperte.estrai(0), this.scoperte.estrai(1), this.scoperte.prima(), this.briscola));
            this.check();
            if (!controllo && verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g1.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(2) + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(1) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();

                }
                giocata=true;
                play=true;
            }
            if (!controllo && !verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g2.getNome() + " CHE HA GIOCATO" + this.scoperte.prima() + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(1) + this.scoperte.getMazzo().get(2) + "\n");
                /////////////////////////////////////
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=true;
                play=false;
            }
            if (controllo && verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g3.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(0) + " SU " + this.scoperte.getMazzo().get(1) + this.scoperte.getMazzo().get(2) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }

            }
            if (controllo && !verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g4.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(1) + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(2) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=false;
                play=false;
            }


        }
        //giocatore4
        else if (!giocata && !play) {
            this.scoperte.aggiungi(g4.gioca(null, null, null, this.briscola));
            this.scoperte.aggiungi(g1.gioca(this.scoperte.prima(), null, null, this.briscola));
            this.scoperte.aggiungi(g2.gioca(this.scoperte.estrai(0), this.scoperte.prima(), null, this.briscola));
            this.scoperte.aggiungi(g3.gioca(this.scoperte.estrai(0), this.scoperte.estrai(1), this.scoperte.prima(), this.briscola));
            this.check();
            if (controllo && !verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g1.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(1) + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(2) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                g1.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=true;
                play=true;
            }
            if (!controllo && verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g2.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(2) + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(1) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                g2.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=true;
                play=false;
            }
            if (!controllo && !verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g3.getNome() + " CHE HA GIOCATO" + this.scoperte.prima() + " SU " + this.scoperte.getMazzo().get(0) + this.scoperte.getMazzo().get(1) + this.scoperte.getMazzo().get(2) + "\n");
                /////////////////////////////////////
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                g3.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
                giocata=false;
                play=true;
            }
            if (controllo && verifica) {
                // CONTROLLO CONSOLE
                System.out.println("PRENDE " + this.g4.getNome() + " CHE HA GIOCATO" + this.scoperte.getMazzo().get(0) + " SU " + this.scoperte.getMazzo().get(1) + this.scoperte.getMazzo().get(2) + this.scoperte.prima() + "\n");
                /////////////////////////////////////
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                g4.presa(this.scoperte.prima());
                this.scoperte.togli();
                if (!this.mazzo.vuoto()) {
                    g4.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g1.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g2.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                    g3.pesca(this.mazzo.prima());
                    this.mazzo.togli();
                }
            }

        }
    }

    /**
     * verifica chi dei quattro giocatori prende alla fine del turno
     * setta controllo e verifica se la presa è effettuata dal primo a giocare il turno,
     * controllo e !verifica se la  presa è effettuata dal secondo a giocare il turno,
     * !controllo e verifica se la presa è effettuata dal terzo a giocare il turno e
     * !controllo e !verifica se la presa è effettuata dal quarto a giocare il turno.
     *
     */
    private void check () {
        Carta p = this.scoperte.estrai(0);
        Carta s = this.scoperte.estrai(1);
        Carta t = this.scoperte.estrai(2);
        Carta q = this.scoperte.estrai(3);

        //La prima carta giocata è di briscola le altre no
        if (p.getSeme() == this.briscola.getSeme() && s.getSeme() != this.briscola.getSeme() && t.getSeme() != this.briscola.getSeme() && q.getSeme() != this.briscola.getSeme()) {
            controllo = true;
            verifica = true;
        }
        //la seconda carta è di briscola le altre no
        if (p.getSeme() != this.briscola.getSeme() && s.getSeme() == this.briscola.getSeme() && t.getSeme() != this.briscola.getSeme() && q.getSeme() != this.briscola.getSeme()) {
            controllo= true;
            verifica = false;
        }
        //Tutte di briscola
        else if (p.getSeme() == this.briscola.getSeme() && s.getSeme() == this.briscola.getSeme() && t.getSeme() == this.briscola.getSeme() && q.getSeme() == this.briscola.getSeme()) {
            if (p.compareTo(s) == 1 && p.compareTo(t) == 1 && p.compareTo(q) == 1) {
                //Prende il primo che ha giocato la briscola
                controllo= true;
                verifica= true;
            }
            else if (s.compareTo(p) == 1 && s.compareTo(t) == 1 && s.compareTo(q) == 1) {
                //Prende il secondo che ha giocato la briscola
                controllo= true;
                verifica= false;
            }
            else if (t.compareTo(p) == 1 && t.compareTo(s) == 1 && t.compareTo(q) == 1) {
                //Prende il terzo che ha giocato la briscola
                controllo = false;
                verifica = true;
            }
            else if (q.compareTo(p) == 1 && q.compareTo(s) == 1 && q.compareTo(t) == 1) {
                //Prende il quarto che ha giocato la briscola
                controllo= false;
                verifica = false;
            }
        }
        //Se il primo e il secondo giocano briscola e gli altri no
        else if (p.getSeme() == this.briscola.getSeme() && s.getSeme() == this.briscola.getSeme() && t.getSeme() != this.briscola.getSeme() && q.getSeme() != this.briscola.getSeme()) {
            if (p.compareTo(s) == 1) {
                controllo= true;
                verifica = true;
            } else {
                controllo = true;
                verifica = false;
            }
        }
        //se il primo e il terzo hanno giocato briscola e gli altri no
        else if (p.getSeme() == this.briscola.getSeme() && s.getSeme() != this.briscola.getSeme() && t.getSeme() == this.briscola.getSeme() && q.getSeme() != this.briscola.getSeme()) {
            if (p.compareTo(t) == 1) {
                controllo = true;
                verifica = true;
            } else {
                controllo = false;
                verifica = true;
            }
        }
        //se il primo e il quarto hanno giocato briscola e gli altri no
        else if (p.getSeme() == this.briscola.getSeme() && s.getSeme() != this.briscola.getSeme() && t.getSeme() != this.briscola.getSeme() && q.getSeme() == this.briscola.getSeme()) {
            if (p.compareTo(q) == 1) {
                controllo = true;
                verifica = true;
            } else {
                controllo = false;
                verifica = false;
            }
        }
        //se il secondo e il terzo hanno giocato briscola e gli altri no
        else if (p.getSeme() != this.briscola.getSeme() && s.getSeme() == this.briscola.getSeme() && t.getSeme() == this.briscola.getSeme() && q.getSeme() != this.briscola.getSeme()) {
            if (s.compareTo(t) == 1) {
                controllo= true;
                verifica = false;
            } else {
                controllo= false;
                verifica= true;
            }
        }
        //se il secondo e il quarto hanno giocato briscola e gli altri no
        else if (p.getSeme() != this.briscola.getSeme() && s.getSeme() == this.briscola.getSeme() && t.getSeme() != this.briscola.getSeme() && q.getSeme() == this.briscola.getSeme()) {
            if (s.compareTo(q) == 1) {
                controllo= true;
                verifica = false;
            } else {
                controllo = false;
                verifica = false;
            }
        }
        //se il terzo e il quarto hanno giocato la briscola e gli altri no
        else if (p.getSeme() != this.briscola.getSeme() && s.getSeme() != this.briscola.getSeme() && t.getSeme() == this.briscola.getSeme() && q.getSeme() == this.briscola.getSeme()) {
            if (t.compareTo(q) == 1) {
                controllo = false;
                verifica = true;}
            else {
                controllo = false;
                verifica = false;
            }
        }
        //se primo secondo e terzo briscola e quattro no
        else if (p.getSeme() == this.briscola.getSeme() && s.getSeme() == this.briscola.getSeme() && t.getSeme() == this.briscola.getSeme() && q.getSeme() != this.briscola.getSeme()) {
            if (p.compareTo(s) == 1 && p.compareTo(t) == 1) {
                controllo = true;
                verifica = true;
            }
            else if (s.compareTo(p) == 1 && s.compareTo(t) == 1) {
                controllo = true;
                verifica  = false;
            }
            else if (t.compareTo(p) == 1 && t.compareTo(s) == 1) {
                controllo = false;
                verifica  = true;
            }
        }
        //se primo secondo e quarto briscola e terzo no
        else if (p.getSeme() == this.briscola.getSeme() && s.getSeme() == this.briscola.getSeme() && t.getSeme() != this.briscola.getSeme() && q.getSeme() == this.briscola.getSeme()) {
            if (p.compareTo(s) == 1 && p.compareTo(q) == 1) {
                controllo = true;
                verifica  = true;
            }
            else if (s.compareTo(p) == 1 && s.compareTo(q) == 1) {
                controllo = true;
                verifica  = false;
            }
            else if (q.compareTo(p) == 1 && q.compareTo(s) == 1) {
                controllo = false;
                verifica  = false;
            }
        }
        //se primo terzo e quarto brisccola  e secondo no
        else if (p.getSeme() == this.briscola.getSeme() && s.getSeme() != this.briscola.getSeme() && t.getSeme() == this.briscola.getSeme() && q.getSeme() == this.briscola.getSeme()) {
            if (p.compareTo(t) == 1 && p.compareTo(q) == 1) {
                controllo = true;
                verifica  = true;
            }
            else if (t.compareTo(p) == 1 && t.compareTo(q) == 1) {
                controllo = false;
                verifica  = true;
            }
            else if (q.compareTo(p) == 1 && q.compareTo(t) == 1) {
                controllo= false;
                verifica = false;
            }
        }
        //se secondo terzo e quarto briscola e primo no
        else if (p.getSeme() != this.briscola.getSeme() && s.getSeme() == this.briscola.getSeme() && t.getSeme() == this.briscola.getSeme() && q.getSeme() == this.briscola.getSeme()) {
            if (s.compareTo(t) == 1 && s.compareTo(q) == 1) {
                controllo = true;
                verifica  = false;
            }
            else if (t.compareTo(s) == 1 && t.compareTo(q) == 1) {
                controllo = false;
                verifica = true;
            }
            else if (q.compareTo(s) == 1 && q.compareTo(t) == 1) {
                controllo = false;
                verifica = false;
            }
        }

        //la terza carta è di briscola le altre no
        else if (p.getSeme() != this.briscola.getSeme() && s.getSeme() != this.briscola.getSeme() && t.getSeme() == this.briscola.getSeme() && q.getSeme() != this.briscola.getSeme()) {
            controllo= false;
            verifica = true;
        }
        //la quarta carta è di briscola le altre no
        else if (p.getSeme() != this.briscola.getSeme() && s.getSeme() != this.briscola.getSeme() && t.getSeme() != this.briscola.getSeme() && q.getSeme() == this.briscola.getSeme()) {
            controllo = false;
            verifica = false;
        }
        //se il primo ha giocato un  seme e gli altri diverso
        else if (p.getSeme() != s.getSeme() && p.getSeme() != t.getSeme() && p.getSeme() != q.getSeme()) {
            controllo = true;
            verifica = true;
        }


        //se il primo e il secondo hanno giocato lo stesso seme
        else if (p.getSeme() == s.getSeme() && p.getSeme() != t.getSeme() && p.getSeme() != q.getSeme()) {
            if (p.compareTo(s) == 1) {
                controllo = true;
                verifica = true;
            } else {
                controllo = true;
                verifica = false;
            }
        }

        //se il primo e il terzo hanno giocato lo stesso seme
        else if (p.getSeme() != s.getSeme() && p.getSeme() == t.getSeme() && p.getSeme() != q.getSeme()) {
            if (p.compareTo(t) == 1) {
                controllo = true;
                verifica = true;
            } else {
                controllo = false;
                verifica = true;
            }
        }

        //se il primo e il quarto hanno giocato lo stesso seme
        else if (p.getSeme() != s.getSeme() && p.getSeme() != t.getSeme() && p.getSeme() == q.getSeme()) {
            if (p.compareTo(q) == 1) {
                controllo = true;
                verifica = true;
            } else {
                controllo = false;
                verifica = false;
            }
        }

        //se il primo e il secondo e il terzo hanno giocato lo stesso seme
        else if (p.getSeme() == s.getSeme() && p.getSeme() == t.getSeme() && p.getSeme() != q.getSeme()) {
            if (p.compareTo(s) == 1 && p.compareTo(t) == 1) {
                controllo = true;
                verifica = true;
            }
            else if (s.compareTo(p) == 1 && s.compareTo(t) == 1) {
                controllo = true;
                verifica = false;
            }
            else if (t.compareTo(p) == 1 && t.compareTo(s) == 1) {
                controllo = false;
                verifica = true;
            }

        }
        //se il primo e il secondo e il quarto hanno giocato lo stesso seme
        else if (p.getSeme() == s.getSeme() && p.getSeme() != t.getSeme() && p.getSeme() == q.getSeme()) {
            if (p.compareTo(s) == 1 && p.compareTo(q) == 1) {
                controllo = true;
                verifica = true;
            }
            else if (s.compareTo(p) == 1 && s.compareTo(q) == 1) {
                controllo = true;
                verifica = false;
            }
            else if (q.compareTo(p) == 1 && q.compareTo(s) == 1) {
                controllo = false;
                verifica = false;
            }

        }
        //se il primo , il terzo e il quarto hanno giocato lo stesso seme
        else if (p.getSeme() != s.getSeme() && p.getSeme() == t.getSeme() && p.getSeme() == q.getSeme()) {
            if (p.compareTo(t) == 1 && p.compareTo(q) == 1) {
                controllo = true;
                verifica = true;
            }
            else if (t.compareTo(p) == 1 && t.compareTo(q) == 1) {
                controllo = false;
                verifica = true;
            }
            else if (q.compareTo(p) == 1 && q.compareTo(t) == 1) {
                controllo = false;
                verifica = false;
            }

        }

        //se hanno giocato tutti lo stesso seme
        else if (p.getSeme() == s.getSeme() && p.getSeme() == t.getSeme() && p.getSeme() == q.getSeme()) {
            if (p.compareTo(s) == 1 && p.compareTo(t) == 1 && p.compareTo(q) == 1) {
                controllo = true;
                verifica = true;
            }
            else if (s.compareTo(p) == 1 && s.compareTo(t) == 1 && s.compareTo(q) == 1) {
                controllo = true;
                verifica= false;
            }
            else if (t.compareTo(p) == 1 && t.compareTo(s) == 1 && t.compareTo(q) == 1) {
                controllo = false;
                verifica = true;
            }
            else if (q.compareTo(p) == 1 && q.compareTo(s) == 1 && q.compareTo(t) == 1) {
                controllo = false;
                verifica = false;
            }
        }
    }

    /**
     * al termine della mano calcola il punteggio relativo alle carte prese, le somma per le 2 squadre e  ed aggiorna il punteggio totale
     */
    private void punteggio () {
        int p1 = 0, p2 = 0, p3 = 0, p4 = 0;
        for (Carta c : this.g1.getPrese().getMazzo()) p1 = p1 + c.getPunti();
        for (Carta c : this.g2.getPrese().getMazzo()) p2 = p2 + c.getPunti();
        for (Carta c : this.g3.getPrese().getMazzo()) p3 = p3 + c.getPunti();
        for (Carta c : this.g4.getPrese().getMazzo()) p4 = p4 + c.getPunti();
        if ((p1 + p3) > (p2 + p4)) g1.setPunti(g1.getPunti() + 1);
        if ((p2 + p4) > (p1 + p3)) g2.setPunti(g2.getPunti() + 1);
        this.g1.prese.ordina();
        this.g2.prese.ordina();
        this.g3.prese.ordina();
        this.g4.prese.ordina();
        System.out.println("Prese " + g1.getNome() + ":\n" + this.g1.getPrese().toString() + "\n");
        System.out.println("\n Prese " + this.g2.getNome() + ": \n" + this.g2.getPrese().toString() + "\n");
        System.out.println("\n Prese " + this.g3.getNome() + ": \n" + this.g3.getPrese().toString() + "\n");
        System.out.println("\n Prese " + this.g4.getNome() + ": \n" + this.g4.getPrese().toString() + "\n");

        JOptionPane.showMessageDialog(null, "la squadra" + g1.getNome() + "," + g3.getNome() + "ha totalizzato " + (p1 + p3) + "punti\n" + "la squadra" + g2.getNome() + "," + g4.getNome() + "ha totalizzato" + (p2 + p4) + "punti");
        System.out.println("la squadra" + g1.getNome() + "," + g3.getNome() + "ha totalizzato " + (p1 + p3) + "punti\n" + "la squadra" + g2.getNome() + "," + g4.getNome() + "ha totalizzato" + (p2 + p4) + "punti");
    }

    /**
     * restituisce il valore dell'attributo g1
     * @return valore dell'attributo g1
     */
    public Giocatore getG1 () {
        return this.g1;
    }
    /**
     * imposta un nuovo valore per l'attributo g1
     * @param g1 nuovo valore che verrà assunto dall'attributo g1
     */
    public void setG1 (Giocatore g1){
        this.g1 = g1;
    }
    /**
     * restituisce il valore dell'attributo g2
     * @return valore dell'attributo g2
     */
    public Giocatore getG2 () {
        return this.g2;
    }
    /**
     * imposta un nuovo valore per l'attibuto g2
     * @param g2 nuovo valore che verrà assunto dall'attributo g2
     */
    public void setG2 (Giocatore g2){
        this.g2 = g2;
    }

    /**
     * restituisce il valore dell'attributo g3
     * @return valore dell'attributo g3
     */
    public Giocatore getG3 () {
        return this.g3;
    }
    /**
     * imposta un nuovo valore per l'attibuto g3
     * @param g3 nuovo valore che verrà assunto dall'attributo g3
     */
    public void setG3 (Giocatore g3){
        this.g3 = g3;
    }

    /**
     * restituisce il valore dell'attributo g4
     * @return valore dell'attributo g4
     */
    public Giocatore getG4 () {
        return this.g4;
    }
    /**
     * imposta un nuovo valore per l'attibuto g4
     * @param g4 nuovo valore che verrà assunto dall'attributo g4
     */
    public void setG4 (Giocatore g4){
        this.g4 = g4;
    }
    /**
     * restituisce il valore dell'attributo mazzo
     * @return valore dell'attributo mazzo
     */
    public Mazzo getMazzo () {
        return new Mazzo(this.mazzo);
    }
    /**
     * imposta un nuovo valore per l'attibuto mazzo
     * @param mazzo nuovo valore che verrà assunto dall'attributo mazzo
     */
    public void setMazzo (Mazzo mazzo){
        this.mazzo = new Mazzo(mazzo);
    }

    /**
     * restituisce il valore dell'attributo scoperte
     * @return valore dell'attributo scoperte
     */
    public Mazzo getScoperte () {
        return new Mazzo(this.getScoperte());
    }
    /**
     * imposta un nuovo valore per l'attributo scoperte
     * @param scoperte nuovo valore che verrà assunto dall'attributo scoperte
     */
    public void setScoperte (Mazzo scoperte){
        this.scoperte = new Mazzo(this.scoperte);
    }
    /**
     * restituisce il valore dell'attributo briscola
     * @return valore dell'attributo briscola
     */
    public Carta getBriscola () {
        return briscola;
    }
    /**
     * imposta un nuovo valore per l'attributo briscola
     * @param briscola nuovo valore che verrà assunto dall'attributo briscola
     */
    public void setBriscola (Carta briscola){
        this.briscola = briscola;
    }

}

