import javax.swing.*;

public class BotonInstrumentos extends JButton {
    String nombre;
    int precio;
    Icon icon;

    public BotonInstrumentos(String nombre, int precio, String icono, int pulsador) {
        this.nombre = nombre;
        this.precio = precio;
        this.setText(nombre);
        this.icon = new ImageIcon(icono);
        //Icon icon = new ImageIcon("\"" + icono + "\"");
        this.setIcon(icon);
        System.out.println(icon);
        System.out.println(icono);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }
}
