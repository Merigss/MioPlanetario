import it.kibo.fp.lib.InputData;
import it.kibo.fp.lib.Menu;

public class InputOutput {

    private static final String WELCOME_MESSAGE = "Benvenuto nel sistema di gestione del sistema solare!";
    private static final String STAR_DATA_PROMPT = "Iniziamo inserendo i dati della stella";
    private static final String STAR_NAME_PROMPT = "Inserisci il nome della stella: ";
    private static final String STAR_MASS_PROMPT = "Inserisci la massa della stella: ";
    private static final String STAR_ID_PROMPT = "Inserisci l'id della stella: ";

    private static final String MENU_TITLE = "Menu Stellare";
    private static final String[] MENU_OPTIONS = {
        "Aggiungi Pianeta",
        "Rimuovi Pianeta",
        "Aggiungi Luna",
        "Rimuovi Luna",
        "Calcola CDM",
        "Identifica Pianeta di Riferimento di una luna",
        "Identifica percorso luna",
        "Controlla Presenza Oggetto"
    };

    private int scelta;
    private Util util = new Util();

    public Stella inizializza() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(STAR_DATA_PROMPT);
        String nome = InputData.readNonEmptyString(STAR_NAME_PROMPT, true);
        double massa = InputData.readDouble(STAR_MASS_PROMPT);
        double coordX = 0;
        double coordY = 0;
        int id = InputData.readInteger(STAR_ID_PROMPT);
        return new Stella(nome, massa, coordX, coordY, id);
    }

    private Menu menu = new Menu(MENU_TITLE, MENU_OPTIONS, true, true, true);

    public void iniziaMenu(Stella stella) {
        do {
            scelta = menu.choose();
            switch (scelta) {
                case 1:
                    util.aggiungiPianeta(stella);
                    break;
                case 2:
                    util.rimuoviPianeta(stella);
                    break;
                case 3:
                    util.aggiungiLuna(stella);
                    break;
                case 4:
                    util.rimuoviLuna(stella);
                    break;
                case 5:
                    util.calcCDM(stella);
                    break;
                case 6:
                    util.pianetarifLuna(stella);
                    break;
                case 7:
                    util.ritornaPercorsoLuna(stella);
                    break;
                case 8:
                    util.èPresente(stella);
                    break;
            }
        } while (scelta != 0);
    }
}
