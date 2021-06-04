import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class PanelCarrito extends JPanel {
    JTextArea textoProductos;
    Map<String, Integer> listaProductos;

    public PanelCarrito() {
        textoProductos = new JTextArea("Hoal");
        textoProductos.setSize(50,50);
        this.add(textoProductos);
        this.listaProductos = new TreeMap<>();
    }

    public JTextArea getTextoProductos() {
        return textoProductos;
    }

    public void anyadirProducto(String producto, int cantidad) {
        System.out.println("CASA");
        if(!listaProductos.containsKey(producto)) {
            listaProductos.put(producto,cantidad);
            System.out.println("CASA1");
        } else {
            listaProductos.put(producto, listaProductos.get(producto) + cantidad);
            System.out.println("CASA2");
        }
        mostrarTexto();
    }

    private void mostrarTexto() {
        String salida = "";
        for (Map.Entry<String, Integer> texto : listaProductos.entrySet()) {
            salida += "-> " + texto.getKey() + ": " + texto.getValue() + "€";
            System.out.println(salida);
        }
        System.out.println(salida);
        this.textoProductos.setText(salida);
    }
}
