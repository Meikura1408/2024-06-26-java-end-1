import java.util.HashMap;
import java.util.Map;

public class SistemaDiVotazione {

    private Map<String, Candidato> candidati;
    private Map<String, Integer> voti;
    private Map<String, Elettore> elettori;

    public SistemaDiVotazione() {

        candidati = new HashMap<>();
        voti = new HashMap<>();
        elettori = new HashMap<>();

    }

    // Aggiungi Candidato
    public void aggiungiCandidato(Candidato candidato) throws Exception {

        if (!candidati.containsKey(candidato.getNome())) {
            candidati.put(candidato.getNome(), candidato);
            voti.put(candidato.getNome(), 0);
        }

        else {
            throw new Exception("Candidato già esistente.");
        }

    }

    // Aggiungi Elettore
    public void aggiungiElettore(Elettore elettore) throws Exception {

        if (!elettori.containsKey(elettore.getNome())) {
            elettori.put(elettore.getNome(), elettore);
        } 

        else {
            throw new Exception("Elettore già esistente.");
        }

    }

    // Vota candidato
    public void vota(String nomeElettore, String nomeCandidato) throws Exception {

        if (!elettori.containsKey(nomeElettore)) {
            throw new Exception("Elettore non registrato.");
        }

        if (!candidati.containsKey(nomeCandidato)) {
            throw new Exception("Candidato non esistente.");
        }

        Elettore elettore = elettori.get(nomeElettore);
        
        if (elettore.haGiaVotato()) {
            throw new Exception("L'elettore ha già votato.");
        }

        elettore.vota();
        int conteggioVoti = voti.get(nomeCandidato);
        voti.put(nomeCandidato, conteggioVoti + 1);

    }

    // Voti candidato
    public int getVoti(String nomeCandidato) {

        return voti.getOrDefault(nomeCandidato, 0);

    }

    // Stampa risultati
    public void stampaRisultati() {

        String[] chiavi = voti.keySet().toArray(new String[0]);

        for (int i = 0; i < chiavi.length; i++) {
            String nomeCandidato = chiavi[i];
            System.out.println(nomeCandidato + ": " + voti.get(nomeCandidato) + " voti");
        }

    }

}

