package com.company;

import javax.swing.JOptionPane;
/**
 * giocatore associato all'utente che utilizza il software
*/
public class GiocatoreReale extends Giocatore {

    /**
     * metodo costruttore richiama il costruttore della superclasse passando il nome del giocatore
     * @param s nome del giocatore
     */
    public GiocatoreReale(String s) {
        super(s);

    }

    /**
     * l'utente effettua la scelta attraverso un input guidato
     * @return la carta scelta tra quelle presenti in mano
     *
     */

    public Carta gioca(Carta t , Carta c){String r="";int a=0;boolean mossa;
        do{mossa=true;
            String text=this.nome+"  la Briscola é"+c.toString()+"\n";
            if(t==null){
                text=text.concat("non � ancora stata giocata alcuna carta");}
            else{text=text.concat("il tuo avversario ha giocato"+t.toString());}
            text=text.concat("\n in mano hai:\n"+ this.mano.toString()+"Scegli quale carta giocare ");
            if(this.mano.getMazzo().size()==1){
                text=text.concat("scrivi 1 per la prima");
                r=JOptionPane.showInputDialog(text);
                if(r==null)mossa=false;
                else{
                    if(!(r.equals("1")))mossa=false;}
            }
            if(this.mano.getMazzo().size()==2){
                text=text.concat("scrivi 1 per la prima o 2 per la seconda");
                r=JOptionPane.showInputDialog(text);
                if(r==null)mossa=false;
                else{
                    if(!(r.equals("1")||r.equals("2")))mossa=false;}
            }
            if(this.mano.getMazzo().size()==3){text=text.concat("scrivi 1 per la prima,2 per la seconda o 3 per la terza");
                r=JOptionPane.showInputDialog(text);
                if(r==null) mossa=false;
                else{
                    if(!(r.equals("1")||r.equals("2")||r.equals("3"))){mossa=false; }
                }
            }


            if(!mossa)
                JOptionPane.showMessageDialog(null, "LA SCELTA FATTA NON é VALIDA RIPROVA");

        }
        while(!mossa);

        a=Integer.parseInt(r);
        Carta ret=this.mano.estrai(a-1);
        this.mano.scarta(a-1);
        System.out.println("la carta giocata é:"+ret.toString());
        return ret;

    }

}
