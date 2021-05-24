import javax.swing.*;

public class BotonesInstrumentos {
    JButton boton;
    String nombre;
    int cantidad;

    public BotonesInstrumentos(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        boton = new JButton(nombre);
    }

    public JButton getBoton() {
        return boton;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
}
