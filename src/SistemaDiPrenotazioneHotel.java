import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaDiPrenotazioneHotel {
    private List<Camera> camereDisponibili;
    private Map<Cliente, PrenotazioneCamera> prenotazioni;

    public SistemaDiPrenotazioneHotel() {

        camereDisponibili = new ArrayList<>();
        prenotazioni = new HashMap<>();
        
    }

    // Aggiungi camera
    public void aggiungiCamera(Camera camera) {

        camereDisponibili.add(camera);
    }

    // Prenotazione camera
    public void effettuaPrenotazione(Cliente cliente, Camera camera, LocalDate dataInizio, LocalDate dataFine) throws Exception {

        if (!camereDisponibili.contains(camera)) {
            throw new Exception("Camera non disponibile.");
        }

        if (prenotazioni.containsKey(cliente)) {
            throw new Exception("Cliente ha già una prenotazione.");
        }

        PrenotazioneCamera prenotazione = new PrenotazioneCamera(cliente, camera, dataInizio, dataFine);
        prenotazioni.put(cliente, prenotazione);
        camereDisponibili.remove(camera);

    }

    // Modifica prenotazione
    public void modificaPrenotazione(Cliente cliente, LocalDate nuovaDataInizio, LocalDate nuovaDataFine) throws Exception {
        
        if (!prenotazioni.containsKey(cliente)) {

            throw new Exception("Prenotazione non trovata.");
        }

        PrenotazioneCamera prenotazione = prenotazioni.get(cliente);
        prenotazione = new PrenotazioneCamera(cliente, prenotazione.getCamera(), nuovaDataInizio, nuovaDataFine);
        prenotazioni.put(cliente, prenotazione);

    }

    // Cancella Prenotazione
    public void cancellaPrenotazione(Cliente cliente) throws Exception {

        if (!prenotazioni.containsKey(cliente)) {
            throw new Exception("Prenotazione non trovata.");
        }

        PrenotazioneCamera prenotazione = prenotazioni.remove(cliente);
        camereDisponibili.add(prenotazione.getCamera());
    }

    // Mostra prenotazioni
    public void stampaPrenotazioni() {

        if (prenotazioni.isEmpty()) {
            System.out.println("Nessuna prenotazione effettuata.");

        } else {
            
            for (Cliente cliente : prenotazioni.keySet()) {
                System.out.println(prenotazioni.get(cliente));
            }

        }
    }

    // MOstra camere disponibili
    public void stampaCamereDisponibili() {

        if (camereDisponibili.isEmpty()) {
            System.out.println("Nessuna camera disponibile.");

        } else {

            for (int i = 0; i < camereDisponibili.size(); i++) {
                System.out.println(camereDisponibili.get(i));
            }

        }

    }
    
}
