

import java.util.ArrayList;

public class Pianeta extends CorpoCeleste{

    private ArrayList<Luna> listaLune = new ArrayList<Luna>();
    private Stella stellaRif;


    public Pianeta(String _nome, double _massa, double _coordX, double _coordY, int _id, Stella _stellaRif) {
        super(_nome, _massa, _coordX, _coordY, _id);
        this.stellaRif = _stellaRif;
        
    }

    public void aggiungiLuna(Luna luna) {
        listaLune.add(luna);
    }

    public ArrayList<Luna> getListaLune() {
        return listaLune;
    }
    public String  getStellaRif() {
        return stellaRif.getNome();
    }


    
}
