import java.util.ArrayList;

public class ElencoTelefonico {
    private ArrayList<Contatto> contatti;

    public ElencoTelefonico() {

        contatti = new ArrayList<>();

    }

    // Aggiungi contatto
    public void aggiungiContatto(Contatto contatto) {

        contatti.add(contatto);

    }

    // Rimuovi contatto
    public boolean rimuoviContatto(String nome) {

        for (int i = 0; i < contatti.size(); i++) {

            if (contatti.get(i).getNome().equalsIgnoreCase(nome)) {
                contatti.remove(i);
                return true;
            }

        }

        return false;

    }

    // Cerca contatto
    public Contatto cercaContatto(String nome) {

        for (int i = 0; i < contatti.size(); i++) {

            if (contatti.get(i).getNome().equalsIgnoreCase(nome)) {
                return contatti.get(i);
            }
        }

        return null;
    }

    // Stampa contatti
    public void stampaContatti() {

        if (contatti.isEmpty()) {
            System.out.println("Nessun contatto disponibile.");

        } else {

            for (int i = 0; i < contatti.size(); i++) {
                System.out.println(contatti.get(i));
            }

        }

    }

}
