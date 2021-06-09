import javax.swing.*;

public class BotonInstrumentos extends JButton {
    String nombre;
    int precio;
    Icon icon;

    public BotonInstrumentos(String nombre, int precio, String icono, int pulsador) {
        this.nombre = nombre;
        this.precio = precio;
        this.setText(nombre + " (" + precio + "€)");
        this.icon = new ImageIcon(icono);
        this.setIcon(icon);
    }
}
