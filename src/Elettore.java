public class Elettore {

    private String nome;
    private boolean haVotato;

    public Elettore(String nome) {

        this.nome = nome;
        this.haVotato = false;

    }

    public String getNome() {

        return nome;
    }

    public boolean haGiaVotato() {

        return haVotato;
        
    }

    public void vota() {

        haVotato = true;

    }
}
