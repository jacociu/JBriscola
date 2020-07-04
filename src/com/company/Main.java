package JBriscola;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {Giocatore g1=null,g2=null,g3=null,g4=null;
        String sel=" ";
        String n1=" ";
        String n2=" ";
        String n3=" ";
        String n4=" ";

        do{
            sel=JOptionPane.showInputDialog("INSERISCI IN 1 PER GIOCARE CONTRO TRE GIOCATORI AUTOMATICI, 2 PER AVVIARE UNA PARTITA"
                    + " CON DUE GIOCATORI  REALI E 2 AUTOMATICI , 3 PER SIMULARE UNA PARTITA CON QUATTRO GIOCATORI AUTOMATICI o 4 PER GIOCARE CON QUATTRO GI0CATORI REALI");
            if(sel==null){sel="";}

        }

        while(!(sel.equals("1")||sel.equals("2")||sel.equals("3")||sel.equals("4")));
        switch(sel){
            case("1"):n1=JOptionPane.showInputDialog("inserisci il nome del giocatore");
                n2="CPU A";
                n3="CPU B";
                n4="CPU C";
                g1=new GiocatoreReale(n1);
                g2=new GiocatoreCpu(n2);
                g3=new GiocatoreCpu(n3);
                g4=new GiocatoreCpu(n4);
                break;
            case("2"):n1=JOptionPane.showInputDialog("inserisci il nome del primo giocatore");
                n2=JOptionPane.showInputDialog("inserisci il nome del secondo giocatore");
                n3="CPU A";
                n4="CPU B";
                g1=new GiocatoreReale(n1);
                g2=new GiocatoreReale(n2);
                g3=new GiocatoreCpu(n3);
                g4=new GiocatoreCpu(n4);
                break;
            case("3"):n1="CPU A ";
                n2="CPU B ";
                n3="CPU C";
                n4="CPU D";
                g1=new GiocatoreCpu(n1);
                g2=new GiocatoreCpu(n2);
                g3=new GiocatoreCpu(n3);
                g4=new GiocatoreCpu(n4);
                break;
            case("4"):n1=JOptionPane.showInputDialog("inserisci il nome del primo giocatore");
                n2=JOptionPane.showInputDialog("inserisci il nome del secondo giocatore");
                n3=JOptionPane.showInputDialog("inserisci il nome del terzo giocatore");
                n4=JOptionPane.showInputDialog("inserisci il nome del quarto giocatore");
                g1=new GiocatoreReale(n1);
                g2=new GiocatoreReale(n2);
                g3=new GiocatoreReale(n3);
                g4=new GiocatoreReale(n4);
                break;
        }
        Tavolo t=new Tavolo(g1,g2,g3,g4);
        t.start();}



}
