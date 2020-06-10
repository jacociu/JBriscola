package com.company;

/**
 * Giocatore automatico sceglie la sua mossa in base situazioni predefinite
 */
public class GiocatoreCpu extends Giocatore{
    /**
     * metodo cotruttore che richiama il costruttore della superclasse passando solo il nome della cpu
     * @param s nome giocatore automatico
     */
    public GiocatoreCpu(String s) {
        super(s);

    }


    /**in base alla situazione attuale del gioco il giocatore Cpu sceglie quale mossa effettuare
     * @return la carta da giocare scelta tra quelle nella mano
     */
    public Carta gioca(Carta t, Carta bri) {
        System.out.println("MANO "+this.getNome()+":\n"+this.mano.toString()+"\n");
        if(t==null)return this.basso(bri);
        else{
            if(t.getSeme()!=bri.getSeme())
            {
                if(t.getPunti()==11||t.getPunti()==10)return this.briscola_bassa(bri);
                else{return this.alto_basso(t,bri);}
            }

            if(t.getSeme()==bri.getSeme()&&t.getPunti()!=0){return this.alto_basso(t,bri);}
            else{return this.basso(bri);}

        }

    }

    /**
     * metodo di utilit° per la decisione del giocatore Cpu individua la carta più bassa
     *  privilegiando quelle del
     * seme diverso dalla briscola
     * @param bri briscola
     * @return carta più bassa , a parità di punti predilige le non briscole
     */
    private Carta basso(Carta bri){
        System.out.println("STO GIOCANDO BASSO\n");
        int pos=0;int cont=0;
        Carta ret=this.mano.estrai(0);
        for(Carta it:this.mano.getMazzo()){cont++;
            if(ret.compareTo(it)==1||(ret.compareTo(it)==0&&it.getSeme()!=bri.getSeme())){
                ret=it;
                pos=cont-1;}}
        this.mano.scarta(pos);
        System.out.println("gioco "+ret.toString()+"\n");

        return ret;
    }

    /**
     * metodo di utilit� per il giocatore Cpu data la carta giocata dall'avversario si individua o la carta dello
     * stesso seme di quella giocata ma con valore superiore tra quelle in mano o la carta più bassa
     * @param t carta giocata dal giocatore avversario
     * @param bri briscola
     * @return Carta dello stesso seme di quella a terra ma con valore  superiore tra quelle in mano o
     * se non presente carta più bassa  tra quelle in mano
     */
    private Carta alto_basso(Carta t,Carta bri){
        System.out.println("Sto giocando in alto basso");

        boolean coincide=false;
        int pos=0;int cont=0;
        Carta ret=this.mano.estrai(0);
        for(Carta it:this.mano.getMazzo()){cont++;
            //la prima carta può non essere dello stesso seme della carta a terra quindi ogni possibile carta
            //con lo stesso seme della carta a terra sostituisce la prima, dopo di che solo le carta corrente
            // � dello stesso seme di quella a terra ed è superiore a quella puntata da ret prende il suo posto
            // bisogna considerare il caso in cui la prima carta è già la più alta tra quelle in mano con
            //lo stesso seme di quella a terra ed accedere comunque nell if per settare coincide su true
            if((ret.getSeme()!=t.getSeme()&&it.getSeme()==t.getSeme())||(it.getSeme()==t.getSeme()&&(it.compareTo(ret)==1||it.compareTo(ret)==0))){
                coincide=true;
                pos=cont-1;
                ret=it;
            }
        }
        if(!coincide){System.out.println("PASSO A BASSO");ret=this.basso(bri);}
        else{
            if(ret.compareTo(t)==1){this.mano.scarta(pos);
                System.out.println("gioco: "+ret.toString()+"\n");
            }

            else{System.out.println("NON HO CARTE ALTE PASSO A BASSO\n");ret=this.basso(bri);}
        }

        return ret;}



    /**
     * metodo di utlità per il giocatore Cpu individua se presente la briscola più bassa in mano
     * @param bri briscola attuale
     * @return carta più bassa , ma con lo stesso seme della briscola, se non presente
     * carta più bassa
     */
    private Carta briscola_bassa(Carta bri){
        System.out.println("BRISCOLA BASSA\n");
        int pos=0;int cont=0;boolean coincide=false;
        Carta ret=this.mano.estrai(0);
        for(Carta it:this.mano.getMazzo()){
            cont++;
            if((ret.getSeme()!=bri.getSeme()&&it.getSeme()==bri.getSeme())||(it.getSeme()==bri.getSeme()&&(ret.compareTo(it)==1||ret.compareTo(it)==0))){
                ret=it;
                pos=cont-1;
                coincide=true;
            }
        }
        if(!coincide){System.out.println("Passo a basso\n");ret=this.basso(bri);}
        else{System.out.println("gioco: "+ret.toString()+"\n");
            this.mano.scarta(pos);}
        return ret;
    }
}
