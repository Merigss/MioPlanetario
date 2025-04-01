

public class CorpoCeleste {
    private String nome;
    private double massa; 
    private double coordX; 
    private double coordY; 
    private int id;

    public CorpoCeleste(String _nome, double _massa, double _coordX, double _coordY, int _id) {
        this.nome = _nome;
        this.massa = _massa;
        this.coordX = _coordX;
        this.coordY = _coordY;
        this.id = _id;
    }

    public String getNome() {
        return nome;
    }

    public double getMassa() {
        return massa;
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public int getId() {
        return id;
    }

    public int calcoloPosRelativa(CorpoCeleste altroCorpo) {
        return 0;
    }

    public int calcoloPosAssoluta() {
        return 0;
    }
}

