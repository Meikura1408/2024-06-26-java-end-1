public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Es: 1");
        prenotazione();
        System.out.println();
        System.out.println("Es: 2");
        registroStudenti();
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

        //verifico disponibilità di più posti
        int[] postiDaVerificare = {10, 20, 30};
        System.out.println(teatro.verificaDisponibilitaMultipla(postiDaVerificare));
    }

    public static void registroStudenti() {

        Studente studente = new Studente("Felice Mastronzo", "123456");

        try {

            studente.aggiungiVoto(7);
            studente.aggiungiVoto(4);
            studente.aggiungiVoto(10);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }

        studente.stampaDettagli();
    }
}

/*
 * 
 * ES3: Simulatore di Banca
 * 
 * Definisci una classe ContoBancario con metodi per depositare denaro,
 * prelevare denaro e ottenere il saldo. Assicurati di gestire il caso in cui si
 * tenta di prelevare più denaro di quanto disponibile con un'eccezione.
 * 
 * ---------------------------------------------------------------------------
 * 
 * ES4: Elenco Telefonico
 * 
 * Implementa una classe Contatto che rappresenti un contatto telefonico con
 * nome e numero di telefono (stringa). Crea una classe ElencoTelefonico che gestisca una
 * lista di contatti. Includi metodi per aggiungere, rimuovere e cercare
 * contatti. Gestisci eventuali eccezioni relative all'inserimento di numeri di
 * telefono non validi.
 * 
 */