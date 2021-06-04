import javax.swing.*;
import java.util.Map;
import java.util.TreeMap;

public class PanelCarrito {
    JPanel panelProductos;
    JTextArea textoProductos;
    Map<String, Integer> listaProductos;

    public PanelCarrito() {
        this.panelProductos = new JPanel();
        textoProductos = new JTextArea();
        textoProductos.setSize(50,50);
        this.panelProductos.add(textoProductos);
        this.listaProductos = new TreeMap<>();
    }

    public JTextArea getTextoProductos() {
        return textoProductos;
    }

    public JPanel getPanelProductos() {
        return panelProductos;
    }

    public void mostrarProducto(String producto, int cantidad) {
        if(!listaProductos.containsKey(producto)) {
            listaProductos.put(producto,cantidad);
        } else {
            listaProductos.put(producto, listaProductos.get(producto) + cantidad);
        }
        mostrarTexto();
    }

    private void mostrarTexto() {
        String salida = "";
        for (Map.Entry<String, Integer> texto : listaProductos.entrySet()) {
            salida += "-> " + texto.getKey() + ": " + texto.getValue() + "€";
        }
        textoProductos.setText(salida);
    }
}
