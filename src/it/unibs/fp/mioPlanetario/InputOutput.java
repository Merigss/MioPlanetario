import it.kibo.fp.lib.InputData;
import it.kibo.fp.lib.Menu;

public class InputOutput {

    private int scelta;
    private Util util = new Util();
    
    public Stella inizializza(){
        System.out.println("Benvenuto nel sistema di gestione del sistema solare!");
        System.out.println("Iniziamo inserendo i dati della stella");
        String nome = InputData.readNonEmptyString("Inserisci il nome della stella: ",true);
        double massa = InputData.readDouble("Inserisci la massa della stella: ");
        double coordX = 0;
        double coordY = 0;
        int id = InputData.readInteger("Inserisci l'id della stella: ");
        Stella stella = new Stella(nome, massa, coordX, coordY, id);
        return stella;

    }
  
    

    Menu menu = new Menu("Menu Stellare", new String[] 
    {
        "Aggiungi Pianeta",
        "Rimuovi Pianeta",
        "Aggiungi Luna",
        "Rimuovi Luna",
        "Calcola CDM",
        "Identifica Pianeta di Riferimento di una luna",
        "Identifica percorso luna",
        "Controlla Presenza Oggetto",
    },true,true,true);

    
    public void iniziaMenu(Stella stella){
    do {
        scelta = menu.choose();
        switch (scelta) {

            case 1:
                util.aggiungiPianeta(stella);
                // Aggiungi Pianeta
                break;

            case 2:
                util.rimuoviPianeta(stella);
                // Rimuovi Pianeta
                break;

            case 3:
                util.aggiungiLuna(stella);

                // Aggiungi Luna
                break;

            case 4:
                util.rimuoviLuna(stella);
                // Rimuovi Luna
                break;

            case 5:
                util.calcCDM(stella);
                // Calcola CDM
                break;

            case 6:
                util.pianetarifLuna(stella);
                // Identifica Pianeta di Riferimento di una luna
                break;

            case 7:
                util.ritornaPercorsoLuna(stella);

                // Identifica percorso luna
                break;

            case 8:
                util.èPresente(stella);
                // Controlla Presenza Oggetto
                break;
            
        }

    }while(scelta !=0);
}

    
}