import it.kibo.fp.lib.Menu;

public class InputOutput {

    private int scelta;

    Util util = new Util();

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

    public void inizializza() 
    {
        Util util = new Util();

        System.out.println("Benvenuto nel sistema di gestione del sistema solaere!");
        System.out.println("Iniziamo inserendo i dati della stella");
        util.creaStella();       
    }
    public void iniziaMenu(){
    do {
        scelta = menu.choose();
        switch (scelta) {

            case 1:
                util.aggiungiPianeta();
                // Aggiungi Pianeta
                break;

            case 2:
                util.rimuoviPianeta();
                // Rimuovi Pianeta
                break;

            case 3:
                util.aggiungiLuna();

                // Aggiungi Luna
                break;

            case 4:
                util.rimuoviLuna();
                // Rimuovi Luna
                break;

            case 5:
                util.calcCDM();
                // Calcola CDM
                break;

            case 6:
                util.pianetarifLuna();
                // Identifica Pianeta di Riferimento di una luna
                break;

            case 7:
                util.ritornaPercorsoLuna();

                // Identifica percorso luna
                break;

            case 8:
                util.èPresente();
                // Controlla Presenza Oggetto
                break;
            
        }

    }while(scelta !=0);
}

    
}