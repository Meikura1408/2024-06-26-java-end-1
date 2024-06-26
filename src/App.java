import java.time.LocalDate;

public class App {
    /*
     * 
     * ES8: Sistema di Prenotazione Alberghiera
     * 
     * Progetta una classe astratta CameraAlbergo con metodi come calcolaCosto() e
     * numeroLetti(). Deriva da questa diverse classi specifiche come CameraSingola,
     * CameraDoppia e Suite. Implementa calcolaCosto in modo diverso per ogni tipo
     * di camera. Utilizza una collezione per gestire tutte le camere disponibili in
     * un albergo.
     * 
     * ---------------------------------------------------------------------------
     */
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
        System.out.println();
        System.out.println("Es: 5");
        votazione();
        System.out.println();
        System.out.println("Es: 6");
        prenotaCamera();
        System.out.println();
        System.out.println("Es: 7");
        salario();

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
        Contatto trovato = elenco.cercaContatto("Perla Madonna");

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

    public static void votazione() throws Exception {

        SistemaDiVotazione sistema = new SistemaDiVotazione();

        // Candidati
        Candidato candidato1 = new Candidato("Giovanni");
        Candidato candidato2 = new Candidato("Lia");
        sistema.aggiungiCandidato(candidato1);
        sistema.aggiungiCandidato(candidato2);

        // Elettori
        Elettore elettore1 = new Elettore("Carlo");
        Elettore elettore2 = new Elettore("Michele");
        sistema.aggiungiElettore(elettore1);
        sistema.aggiungiElettore(elettore2);

        // Votazione
        try {

            sistema.vota("Carlo", "Giovanni");
            sistema.vota("Michele", "Lia");
            sistema.vota("Carlo", "Lia"); // doppio voto

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        sistema.stampaRisultati();

    }

    public static void prenotaCamera() {

        SistemaDiPrenotazioneHotel sistema = new SistemaDiPrenotazioneHotel();

        // Aggiunta Camere
        Camera camera1 = new Camera(101, "Singola");
        Camera camera2 = new Camera(102, "Doppia");
        sistema.aggiungiCamera(camera1);
        sistema.aggiungiCamera(camera2);

        // Aggiunta Clienti
        Cliente cliente1 = new Cliente("Felice Limonta");
        Cliente cliente2 = new Cliente("Speranza Persa");

        // Prenotazioni
        try {

            sistema.effettuaPrenotazione(cliente1, camera1, LocalDate.of(2024, 7, 1), LocalDate.of(2024, 7, 10));
            sistema.effettuaPrenotazione(cliente2, camera2, LocalDate.of(2024, 7, 5), LocalDate.of(2024, 7, 15));

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        // Mostra camere e prenotazioni disponibili
        sistema.stampaPrenotazioni();
        sistema.stampaCamereDisponibili();

        // Modifica prenotazione
        try {

            sistema.modificaPrenotazione(cliente1, LocalDate.of(2024, 7, 2), LocalDate.of(2024, 7, 12));

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        // Cancella prenotazione
        try {

            sistema.cancellaPrenotazione(cliente2);

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        // Mostra aggiornamenti dopo modifiche
        sistema.stampaPrenotazioni();
        sistema.stampaCamereDisponibili();
    }

    public static void salario() {

        Impiegato[] impiegati = new Impiegato[3];
      
        impiegati[0] = new Impiegato("Gustavo Lafava", 30000);
        impiegati[1] = new Impiegato("Massimo Dellapena", 32000);
        impiegati[2] = new Manager("Benedetta Cappella", 50000, 10000);
        
    
        for (int i = 0; i < impiegati.length; i++) {

            impiegati[i].aumentaSalario(10);
            System.out.println(impiegati[i]);

        }

    }

}