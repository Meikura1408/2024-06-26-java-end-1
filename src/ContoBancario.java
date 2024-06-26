public class ContoBancario {

    private double saldo;

    public ContoBancario(double saldoIniziale) {

        if (saldoIniziale < 0) {

            throw new IllegalArgumentException("Il saldo iniziale non può essere negativo.");
        }

        this.saldo = saldoIniziale;
    }

    // Deposito soldi
    public void deposita(double importo) {

        if (importo < 0) {
            throw new IllegalArgumentException("L'importo da depositare non può essere negativo.");
        }

        saldo += importo;

    }

    // Prelevo soldi
    public void preleva(double importo) throws IllegalArgumentException {

        if (importo < 0) {

            throw new IllegalArgumentException("L'importo da prelevare non può essere negativo.");

        }

        if (importo > saldo) {

            throw new IllegalArgumentException("Fondi insufficienti per il prelievo.");

        }

        saldo -= importo;

    }

    // Saldo
    public double getSaldo() {

        return saldo;
    }

    public void stampaSaldo() {

        System.out.println("Saldo corrente: " + saldo + "€");

    }
}
