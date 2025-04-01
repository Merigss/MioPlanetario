import it.kibo.fp.lib.InputData;

public class Util {
  
    


    public void aggiungiLuna(Stella stella){
        String nome=InputData.readNonEmptyString("Inserisci il nome della luna che vuoi aggiungere", false);
        double massa=InputData.readDoubleWithMinimum("Inserisci la massa della luna", 0);
        double coordx=InputData.readDouble("Inserisci la coordinata x");
        double coordy = InputData.readDouble("Inserisci la coordinata y");
        int id= InputData.readInteger("Inserisci l'id della luna");
        if (!controllaId(id, stella)) {
            System.out.println("Errore: ID già presente. Operazione annullata.");
            return;
        }
        int idPianetaRif=InputData.readInteger("Inserisci l'id del pianeta di riferimento della luna");
        for (Pianeta pianeta : stella.getListaPianeti()) {
            if (pianeta.getId() == idPianetaRif) {
                pianeta.aggiungiLuna(new Luna(nome, massa, coordx, coordy, id, pianeta));
                System.out.println("Luna aggiunta con successo.");
                return;
            }
        }
        
        
    }
    public void rimuoviLuna(Stella stella){
        int id=InputData.readInteger("Inserisci l'id della luna che vuoi rimuovere");

        for (Pianeta pianeta : stella.getListaPianeti()) {
            for (Luna luna : pianeta.getListaLune()) {
                if (luna.getId() == id) {
                    pianeta.getListaLune().remove(luna);
                    System.out.println("Luna rimossa con successo.");
                    return;
                }
            }
        }
        System.out.println("Luna non trovata.");
    }

    public void aggiungiPianeta(Stella stella){
       String nome=InputData.readNonEmptyString("Inserisci il nome del pianeta che vuoi aggiungere", false);
        double massa=InputData.readDouble("Inserisci la massa del pianeta");
        double coordx=InputData.readDouble("Inserisci la coordinata x");
       double coordy = InputData.readDouble("Inserisci la coordinata y");
        int id= InputData.readInteger("Inserisci l'id del pianeta");
        if (!controllaId(id, stella)) {
            System.out.println("Errore: ID già presente. Operazione annullata.");
            return;
        }

        Pianeta pianeta = new Pianeta(nome, massa, coordx, coordy, id, stella);
        stella.addPianeta(pianeta);
        
    }
    public void rimuoviPianeta(Stella stella){

        int id=InputData.readInteger("Inserisci l'id del pianeta che vuoi rimuovere");

        for (Pianeta pianeta : stella.getListaPianeti()) {
            if (pianeta.getId() == id) {
                stella.rimuoviPianeta(pianeta);
                System.out.println("Pianeta rimosso con successo.");
                return;
            }
        }
        System.out.println("Pianeta non trovato.");

        
    }

    public double calcCDM(Stella stella){
        double cdm = 0;
        for (Pianeta pianeta : stella.getListaPianeti()) {
            cdm += pianeta.getMassa() * Math.sqrt(Math.pow(pianeta.getCoordX(), 2) + Math.pow(pianeta.getCoordY(), 2));
            for (Luna luna : pianeta.getListaLune()) {
                cdm += luna.getMassa() * Math.sqrt(Math.pow(luna.getCoordX(), 2) + Math.pow(luna.getCoordY(), 2));
            }
        }
        return cdm;
    }

    public int èPresente(Stella stella){
        int id = InputData.readInteger("Inserisci l'id dell'elemento da cercare: ");
        for (Pianeta pianeta : stella.getListaPianeti()) {
            if (pianeta.getId() == id) {
            System.out.println("Elemento trovato: Pianeta " + pianeta.getNome());
            return 1;
            }
            for (Luna luna : pianeta.getListaLune()) {
            if (luna.getId() == id) {
                System.out.println("Elemento trovato: Luna " + luna.getNome());
                return 2;
            }
            }
        }
        System.out.println("Elemento non trovato.");
        return 0;
    }




    public int ritornaPercorsoLuna(Stella stella){

        int id = InputData.readInteger("Inserisci l'id della luna di cui vuoi conoscere il percorso: ");
        for (Pianeta pianeta : stella.getListaPianeti()) {
            for (Luna luna : pianeta.getListaLune()) {
                if (luna.getId() == id) {
                    System.out.println(luna.getPercorso());
                    return 1;
                }
            }
        }
        System.out.println("Luna non trovata.");
        return 0;

    }

    public int pianetarifLuna(Stella stella){
        int id = InputData.readInteger("Inserisci l'id della luna di cui vuoi conoscere il pianeta di riferimento: ");
        for (Pianeta pianeta : stella.getListaPianeti()) {
            for (Luna luna : pianeta.getListaLune()) {
                if (luna.getId() == id) {
                    System.out.println(luna.getPianetaRif().getNome());
                    return 1;
                }
            }
        }
        System.out.println("Luna non trovata.");
        return 0;
    }

    public boolean controllaId(int id,Stella stella){
        for (Pianeta pianeta : stella.getListaPianeti()) {
            if (pianeta.getId() == id) {
            return false; // ID già presente in un pianeta
            }
            for (Luna luna : pianeta.getListaLune()) {
            if (luna.getId() == id) {
                return false; // ID già presente in una luna
            }
            }
        }
        return true; // ID non presente
        

    }

    
    //limite di 26000 pianeti

    // limite di 5000 lune



}
