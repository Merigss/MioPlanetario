import it.kibo.fp.lib.InputData;

public class Util {

    public int aggiungiLuna(){
        return 0;
    }
    public int rimuoviLuna(){
        return 0;
    }
    public int aggiungiPianeta(){
        return 0;
    }
    public int rimuoviPianeta(){
        return 0;
    }

    public double calcCDM(){
        return 0;
    }

    public int èPresente(){
        return 0;
    }


    public void creaStella(){
        String nome = InputData.readNonEmptyString("Inserisci il nome della stella: ",true);
        double massa = InputData.readDouble("Inserisci la massa della stella: ");
        double coordX = 0;
        double coordY = 0;
        int id = InputData.readInteger("Inserisci l'id della stella: ");
        Stella stella = new Stella(nome, massa, coordX, coordY, id);

        
    }

    public int ritornaPercorsoLuna(){

        return 0;

    }

    public int pianetarifLuna(){
        return 0;
    }

    //limite di 26000 pianeti
    // limite di 5000 lune



}
