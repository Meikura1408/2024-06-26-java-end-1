import java.time.LocalDate;

public class PrenotazioneCamera {
    
    private Cliente cliente;
    private Camera camera;
    private LocalDate dataInizio;
    private LocalDate dataFine;

    public PrenotazioneCamera(Cliente cliente, Camera camera, LocalDate dataInizio, LocalDate dataFine) {
        this.cliente = cliente;
        this.camera = camera;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Cliente getCliente() {

        return cliente;
    }

    public Camera getCamera() {

        return camera;
    }

    public LocalDate getDataInizio() {

        return dataInizio;
    }

    public LocalDate getDataFine() {

        return dataFine;
    }

    @Override
    public String toString() {

        return "Prenotazione per " + cliente + " nella " + camera + " dal " + dataInizio + " al " + dataFine;
    }
}
