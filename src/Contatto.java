public class Contatto {

    private String nome;
    private String numeroDiTelefono;

    public Contatto(String nome, String numeroDiTelefono) {

        if (!numeroDiTelefono.matches("\\d{10}")) {

            throw new IllegalArgumentException("Numero di telefono non valido. Deve contenere esattamente 10 cifre.");
        }

        this.nome = nome;
        this.numeroDiTelefono = numeroDiTelefono;

    }

    public String getNome() {

        return nome;
        
    }


    public String getNumeroDiTelefono() {

        return numeroDiTelefono;

    }
    @Override
    public String toString() {

        return nome + ": " + numeroDiTelefono;
        
    }
}
