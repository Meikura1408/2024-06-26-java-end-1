public class Manager extends Impiegato {

    private double bonus;

 
    public Manager(String nome, double salario, double bonus) {

        super(nome, salario);
        this.bonus = bonus;

    }


    public double getBonus() {

        return bonus;
    }

    @Override
    public void aumentaSalario(int percentuale) {

        double salarioBase = getSalario();
        double aumento = salarioBase * percentuale / 100.0;
        double nuovoSalario = salarioBase + aumento + bonus;
        System.out.println("Nuovo salario (incluso bonus): " + nuovoSalario);

    }

    @Override
    public String toString() {
        
        return "Manager: " + getNome() + ", Salario: " + getSalario() + ", Bonus: " + bonus;
    }
}

