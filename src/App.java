public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Es: 1");
        prenotazione();
        System.out.println();
        System.out.println("Es: 2");
        registroStudenti();
        System.out.println();
        System.out.println("Es: 3");
        contoBancario();
        System.out.println();
        System.out.println("Es: 4");
        rubrica();
    }

    public static void prenotazione() {

        Prenotazione teatro = new Prenotazione(100);

        // prenoto posti
        System.out.println(teatro.prenotaPosto(10));
        System.out.println(teatro.prenotaPosto(10)); // false
        System.out.println(teatro.prenotaPosto(20));

        // verifico disponibilità dei posti
        System.out.println(teatro.verificaDisponibilita(10));
        System.out.println(teatro.verificaDisponibilita(15));

        // annullo prenotazione
        System.out.println(teatro.annullaPrenotazione(10));
        System.out.println(teatro.annullaPrenotazione(10)); // false

        // verifico disponibilità di più posti
        int[] postiDaVerificare = { 10, 20, 30 };
        System.out.println(teatro.verificaDisponibilitaMultipla(postiDaVerificare));
    }

    public static void registroStudenti() {

        Studente studente = new Studente("Felice Mastronzo", "123456");

        try {

            studente.aggiungiVoto(7);
            studente.aggiungiVoto(4);
            studente.aggiungiVoto(11);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

        studente.stampaDettagli();
    }

    public static void contoBancario() {

        ContoBancario conto = new ContoBancario(1000);

        // Deposito soldi
        try {

            conto.deposita(500);
            conto.stampaSaldo();

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        // Prelevo soldi
        try {

            conto.preleva(200);
            conto.stampaSaldo();

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        try {

            conto.preleva(2000);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

        conto.stampaSaldo();

    }

    public static void rubrica() {

        ElencoTelefonico elenco = new ElencoTelefonico();

        try {

            Contatto contatto1 = new Contatto("Gina Scorre", "1234567890");
            Contatto contatto2 = new Contatto("Dottor Bavaro", "0987654321");
            elenco.aggiungiContatto(contatto1);
            elenco.aggiungiContatto(contatto2);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());

        }

        // Stampo i contatti
        elenco.stampaContatti();

        // Cerco un contatto
        Contatto trovato = elenco.cercaContatto("Michael Jackson");

        if (trovato != null) {

            System.out.println("Contatto trovato: " + trovato);

        } else {

            System.out.println("Contatto non trovato.");
        }

        // Rimuovo un contatto
        boolean rimosso = elenco.rimuoviContatto("Gina Scorre");

        if (rimosso) {

            System.out.println("Contatto rimosso con successo.");

        } else {

            System.out.println("Contatto non trovato.");

        }

        // Stampa i contatti aggiornati
        elenco.stampaContatti();

    }

}