import java.util.ArrayList;

public class Stella  extends CorpoCeleste{

    private ArrayList<Pianeta> listaPianeti = new ArrayList<Pianeta>();

    public Stella(String _nome, double _massa, double _coordX, double _coordY, int _id) {
        super(_nome, _massa, _coordX, _coordY, _id);
        //TODO Auto-generated constructor stub
    }
    
    public ArrayList<Pianeta> getListaPianeti() {
        return listaPianeti;
    }

    public void aggiungiPianeta(Pianeta pianeta) {
        listaPianeti.add(pianeta);
    }

    public void rimuoviPianeta(Pianeta pianeta) {
        listaPianeti.remove(pianeta);
    }
    
}
