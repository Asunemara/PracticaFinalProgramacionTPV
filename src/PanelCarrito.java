import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public class PanelCarrito extends JPanel {
    JTextArea textoProductos;
    Map<String, Integer> listaProductos;

    public PanelCarrito() {
        textoProductos = new JTextArea("Factura...",20,30);
        //textoProductos.setSize(3,2);
        this.add(textoProductos);
        this.listaProductos = new TreeMap<>();
    }

    public JTextArea getTextoProductos() {
        return textoProductos;
    }

    public void anyadirProducto(String nombreProducto, int precio) {
        System.out.println("CASA");
        if(!listaProductos.containsKey(nombreProducto)) {
            listaProductos.put(nombreProducto,precio);
            System.out.println("CASA1");
        } else {
            listaProductos.put(nombreProducto, listaProductos.get(nombreProducto) + precio);
            System.out.println("CASA2");
        }
        mostrarTexto();
    }

    public void borrarProducto(String nombreProducto, int precio) {
        System.out.println("PISTACHO");
        if(!listaProductos.containsKey(nombreProducto)) {
            listaProductos.remove(precio);
            System.out.println("PISTACHO1");
        }
        mostrarTexto();
    }

    private void mostrarTexto() {
        String salida = "";
        for (Map.Entry<String, Integer> texto : listaProductos.entrySet()) {
            salida += "-> " + texto.getKey() + ": " + texto.getValue() + "€\n";
            System.out.println(salida);
        }
        System.out.println(salida);
        this.textoProductos.setText(salida);
    }

    public int factura() {
        int sumaTotal = 0;
        for (Integer i: listaProductos.values()) {
            sumaTotal += i;
        }
        return sumaTotal;
    }

    public void botonTotalPulsado() {
        System.out.println("El total es: " + factura() + "€");
        JOptionPane.showMessageDialog(null,"El total es: " + factura() + "€");
        int reply = JOptionPane.showConfirmDialog(null, "¿Quieres imprimir la factura?", "title", JOptionPane.YES_NO_OPTION);
        System.out.println(reply);
        if (reply == 0) {
            JTextPane jtp = new JTextPane();
            jtp.setBackground(Color.white);
            jtp.setFont(new Font("Courier New",Font.BOLD,16));
            jtp.setText("INSTRUMENTOS CHO PIN \n \n" + BotonTotal.getFecha() + "\n \n" + textoProductos.getText() + "\n Total: " + factura() + "€");
            boolean show = true;
            try {
                jtp.print(null, null, show, null, null, show);
            } catch (java.awt.print.PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
