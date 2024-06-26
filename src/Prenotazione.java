public class Prenotazione {

    private boolean[] posti;

    public Prenotazione(int numeroPosti) {

        posti = new boolean[numeroPosti];
        
    }
    
// Prenoto un posto
    public boolean prenotaPosto(int numeroPosto) {

        if (numeroPosto >= 0 && numeroPosto < posti.length) {

            if (!posti[numeroPosto]) {
                posti[numeroPosto] = true;
                return true;
            }

        }

        return false;
    }

    // Annullo prenotazione
    public boolean annullaPrenotazione(int numeroPosto) {

        if (numeroPosto >= 0 && numeroPosto < posti.length) {

            if (posti[numeroPosto]) {
                posti[numeroPosto] = false;
                return true;
            }

        }

        return false;
    }

    // Verifico se un posto è disponibile
    public boolean verificaDisponibilita(int numeroPosto) {

        if (numeroPosto >= 0 && numeroPosto < posti.length) {

            return !posti[numeroPosto];
        }

        return false;
    }

    // Verifico se più posti sono disponibili
    public boolean verificaDisponibilitaMultipla(int[] numeriPosti) {
        
        for (int i = 0; i < numeriPosti.length; i++) {

            int numeroPosto = numeriPosti[i];

            if (numeroPosto < 0 || numeroPosto >= posti.length || posti[numeroPosto]) {
                return false;
            }

        }

        return true;
    }
}

