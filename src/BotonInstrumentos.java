import javax.swing.*;

public class BotonInstrumentos extends JButton {
    String nombre;
    int cantidad;

    public BotonInstrumentos(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.setText(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
}
