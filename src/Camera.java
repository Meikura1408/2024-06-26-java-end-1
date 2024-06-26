public class Camera {

    private int numero;
    private String tipo;

    public Camera(int numero, String tipo) {

        this.numero = numero;
        this.tipo = tipo;
        
    }

    public int getNumero() {

        return numero;
    }

    public String getTipo() {

        return tipo;
    }

    @Override
    public String toString() {

        return "Camera " + numero + " (" + tipo + ")";
    }
}

