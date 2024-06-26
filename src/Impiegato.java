public class Impiegato {

    private String nome;
    private double salario;

    public Impiegato(String nome, double salario) {

        this.nome = nome;
        this.salario = salario;

    }

    public String getNome() {

        return nome;
    }

    public double getSalario() {

        return salario;
    }

    public void aumentaSalario(int percentuale) {

        salario += salario * percentuale / 100.0;
    }

    @Override
    public String toString() {
        
        return "Impiegato: " + nome + ", Salario: " + salario;
    }
}
