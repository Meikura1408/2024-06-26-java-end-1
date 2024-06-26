import java.util.ArrayList;

public class Studente {
    private String nome;
    private String matricola;
    private ArrayList<Integer> voti;

    public Studente(String nome, String matricola) {
        this.nome = nome;
        this.matricola = matricola;
        this.voti = new ArrayList<>();
    }

    // Aggiungi voti
    public void aggiungiVoto(int voto) throws IllegalArgumentException {

        if (voto < 0 || voto > 10) {

            throw new IllegalArgumentException("Il voto deve essere compreso tra 0 e 10.");
        }

        voti.add(voto);
    }

    // Media voti
    public double calcolaMedia() {

        if (voti.isEmpty()) {
            return 0.0;
        }

        int somma = 0;

        for (int i = 0; i < voti.size(); i++) {
            somma += voti.get(i);
        }

        return (double) somma / voti.size();

    }


    public void stampaDettagli() {

        System.out.println("Nome: " + nome);
        System.out.println("Matricola: " + matricola);
        System.out.print("Voti: ");

        if (voti.isEmpty()) {

            System.out.print("Nessun voto disponibile.");

        } else {

            for (int i = 0; i < voti.size(); i++) {
                System.out.print(voti.get(i) + " ");
            }

        }

        System.out.println();
        System.out.println("Media voti: " + calcolaMedia());

    }
}
