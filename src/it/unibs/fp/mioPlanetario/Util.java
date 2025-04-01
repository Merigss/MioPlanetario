import it.kibo.fp.lib.InputData;

public class Util {

    private static final String INSERISCI_NOME_LUNA = "Inserisci il nome della luna che vuoi aggiungere";
    private static final String INSERISCI_MASSA_LUNA = "Inserisci la massa della luna";
    private static final String INSERISCI_COORD_X = "Inserisci la coordinata x";
    private static final String INSERISCI_COORD_Y = "Inserisci la coordinata y";
    private static final String INSERISCI_ID_LUNA = "Inserisci l'id della luna";
    private static final String INSERISCI_ID_PIANETA_RIF = "Inserisci l'id del pianeta di riferimento della luna";
    private static final String INSERISCI_NOME_PIANETA = "Inserisci il nome del pianeta che vuoi aggiungere";
    private static final String INSERISCI_MASSA_PIANETA = "Inserisci la massa del pianeta";
    private static final String INSERISCI_ID_PIANETA = "Inserisci l'id del pianeta";
    private static final String INSERISCI_ID_RIMOZIONE = "Inserisci l'id dell'elemento da cercare: ";
    private static final String INSERISCI_ID_LUNA_RIMOZIONE = "Inserisci l'id della luna che vuoi rimuovere";
    private static final String INSERISCI_ID_PIANETA_RIMOZIONE = "Inserisci l'id del pianeta che vuoi rimuovere";
    private static final String INSERISCI_ID_PERCORSO_LUNA = "Inserisci l'id della luna di cui vuoi conoscere il percorso: ";
    private static final String INSERISCI_ID_PIANETA_RIF_LUNA = "Inserisci l'id della luna di cui vuoi conoscere il pianeta di riferimento: ";
    private static final String ERRORE_ID_PRESENTE = "Errore: ID già presente. Operazione annullata.";
    private static final String LUNA_AGGIUNTA = "Luna aggiunta con successo.";
    private static final String LUNA_RIMOSSA = "Luna rimossa con successo.";
    private static final String LUNA_NON_TROVATA = "Luna non trovata.";
    private static final String PIANETA_RIMOSSO = "Pianeta rimosso con successo.";
    private static final String PIANETA_NON_TROVATO = "Pianeta non trovato.";
    private static final String ELEMENTO_TROVATO_PIANETA = "Elemento trovato: Pianeta ";
    private static final String ELEMENTO_TROVATO_LUNA = "Elemento trovato: Luna ";
    private static final String ELEMENTO_NON_TROVATO = "Elemento non trovato.";

    public void aggiungiLuna(Stella stella) {
        String nome = InputData.readNonEmptyString(INSERISCI_NOME_LUNA, false);
        double massa = InputData.readDoubleWithMinimum(INSERISCI_MASSA_LUNA, 0);
        double coordx = InputData.readDouble(INSERISCI_COORD_X);
        double coordy = InputData.readDouble(INSERISCI_COORD_Y);
        int id = InputData.readInteger(INSERISCI_ID_LUNA);

        if (!controllaId(id, stella)) {
            System.out.println(ERRORE_ID_PRESENTE);
            return;
        }

        int idPianetaRif = InputData.readInteger(INSERISCI_ID_PIANETA_RIF);
        for (Pianeta pianeta : stella.getListaPianeti()) {
            if (pianeta.getId() == idPianetaRif) {
                pianeta.aggiungiLuna(new Luna(nome, massa, coordx, coordy, id, pianeta));
                System.out.println(LUNA_AGGIUNTA);
                return;
            }
        }
    }

    public void rimuoviLuna(Stella stella) {
        int id = InputData.readInteger(INSERISCI_ID_LUNA_RIMOZIONE);

        for (Pianeta pianeta : stella.getListaPianeti()) {
            for (Luna luna : pianeta.getListaLune()) {
                if (luna.getId() == id) {
                    pianeta.getListaLune().remove(luna);
                    System.out.println(LUNA_RIMOSSA);
                    return;
                }
            }
        }
        System.out.println(LUNA_NON_TROVATA);
    }

    public void aggiungiPianeta(Stella stella) {
        String nome = InputData.readNonEmptyString(INSERISCI_NOME_PIANETA, false);
        double massa = InputData.readDouble(INSERISCI_MASSA_PIANETA);
        double coordx = InputData.readDouble(INSERISCI_COORD_X);
        double coordy = InputData.readDouble(INSERISCI_COORD_Y);
        int id = InputData.readInteger(INSERISCI_ID_PIANETA);

        if (!controllaId(id, stella)) {
            System.out.println(ERRORE_ID_PRESENTE);
            return;
        }

        Pianeta pianeta = new Pianeta(nome, massa, coordx, coordy, id, stella);
        stella.addPianeta(pianeta);
    }

    public void rimuoviPianeta(Stella stella) {
        int id = InputData.readInteger(INSERISCI_ID_PIANETA_RIMOZIONE);

        for (Pianeta pianeta : stella.getListaPianeti()) {
            if (pianeta.getId() == id) {
                stella.rimuoviPianeta(pianeta);
                System.out.println(PIANETA_RIMOSSO);
                return;
            }
        }
        System.out.println(PIANETA_NON_TROVATO);
    }

    public double calcCDM(Stella stella) {
        double cdm = 0;
        for (Pianeta pianeta : stella.getListaPianeti()) {
            cdm += pianeta.getMassa() * Math.sqrt(Math.pow(pianeta.getCoordX(), 2) + Math.pow(pianeta.getCoordY(), 2));
            for (Luna luna : pianeta.getListaLune()) {
                cdm += luna.getMassa() * Math.sqrt(Math.pow(luna.getCoordX(), 2) + Math.pow(luna.getCoordY(), 2));
            }
        }
        return cdm;
    }

    public int èPresente(Stella stella) {
        int id = InputData.readInteger(INSERISCI_ID_RIMOZIONE);
        for (Pianeta pianeta : stella.getListaPianeti()) {
            if (pianeta.getId() == id) {
                System.out.println(ELEMENTO_TROVATO_PIANETA + pianeta.getNome());
                return 1;
            }
            for (Luna luna : pianeta.getListaLune()) {
                if (luna.getId() == id) {
                    System.out.println(ELEMENTO_TROVATO_LUNA + luna.getNome());
                    return 2;
                }
            }
        }
        System.out.println(ELEMENTO_NON_TROVATO);
        return 0;
    }

    public int ritornaPercorsoLuna(Stella stella) {
        int id = InputData.readInteger(INSERISCI_ID_PERCORSO_LUNA);
        for (Pianeta pianeta : stella.getListaPianeti()) {
            for (Luna luna : pianeta.getListaLune()) {
                if (luna.getId() == id) {
                    System.out.println(luna.getPercorso());
                    return 1;
                }
            }
        }
        System.out.println(LUNA_NON_TROVATA);
        return 0;
    }

    public int pianetarifLuna(Stella stella) {
        int id = InputData.readInteger(INSERISCI_ID_PIANETA_RIF_LUNA);
        for (Pianeta pianeta : stella.getListaPianeti()) {
            for (Luna luna : pianeta.getListaLune()) {
                if (luna.getId() == id) {
                    System.out.println(luna.getPianetaRif().getNome());
                    return 1;
                }
            }
        }
        System.out.println(LUNA_NON_TROVATA);
        return 0;
    }

    public boolean controllaId(int id, Stella stella) {
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
}
