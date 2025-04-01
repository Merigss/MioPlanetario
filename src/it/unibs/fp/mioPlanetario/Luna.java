

public class Luna
extends CorpoCeleste  {

    private  Pianeta pianetaRif;
    private String percorso;
    
    public Luna(String _nome, double _massa, double _coordX, double _coordY, int _id, Pianeta _pianetaRif) {
        super(_nome, _massa, _coordX, _coordY, _id);
        this.pianetaRif = _pianetaRif;
        this.percorso = "Il percorso della luna "+_nome+" è "+_pianetaRif.getStellaRif()+"->"+_pianetaRif.getNome()+"->"+_nome; ;
    
    }
    public Pianeta getPianetaRif() {
        return pianetaRif;
    
    }

    public String getPercorso() {
        return percorso;
    }
    
}
