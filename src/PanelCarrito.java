import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class PanelCarrito extends JPanel {
    JTextArea textoProductos;
    Map<String, Integer> listaProductos;

    public PanelCarrito() {
        textoProductos = new JTextArea("Los productos que añadas se mostrarán aquí...", 20, 30);
        this.add(textoProductos);
        this.listaProductos = new TreeMap<>();
    }

    public void anyadirProducto(String nombreProducto, int precio, int contador) {
        if (!listaProductos.containsKey(nombreProducto)) {
            listaProductos.put(nombreProducto, precio);
            creaContador(nombreProducto, contador);
        } else {
            listaProductos.put(nombreProducto, listaProductos.get(nombreProducto) + precio);
            escribeContador(nombreProducto);
        }
        mostrarTexto();
    }

    private void creaContador(String nombreProducto, int contador) {
        File rutaArchivos = new File("Resources/Contadores");
        rutaArchivos.mkdirs();
        try (BufferedWriter crearFichero = new BufferedWriter(new FileWriter(rutaArchivos + "/contador" + nombreProducto + ".csv"))) {
            crearFichero.write(String.valueOf(contador));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int escribeContador(String nombreProducto) {
        File rutaArchivos = new File("Resources/Contadores");
        int contador = 0;
        try (BufferedReader leerFichero = new BufferedReader(new FileReader(rutaArchivos + "/contador" + nombreProducto + ".csv"))) {
            contador = Integer.parseInt(leerFichero.readLine());
            contador++;
            try (BufferedWriter escribeNuevoContador = new BufferedWriter(new FileWriter(rutaArchivos + "/contador" + nombreProducto + ".csv"))) {
                escribeNuevoContador.write(String.valueOf(contador));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }

    public void borrarProducto(String nombreProducto, int precio, int cantidadArticuloBorrar) {
        int contador;
        File rutaArchivos = new File("Resources/Contadores");
        if (listaProductos.containsKey(nombreProducto)) {
            listaProductos.put(nombreProducto, listaProductos.get(nombreProducto) - (precio * cantidadArticuloBorrar));
            try (BufferedReader leeContador = new BufferedReader(new FileReader(rutaArchivos + "/contador" + nombreProducto + ".csv"))) {
                contador = Integer.parseInt(leeContador.readLine());
                try (BufferedWriter escribeContador = new BufferedWriter(new FileWriter(rutaArchivos + "/contador" + nombreProducto + ".csv"))) {
                    int contadorActualizado = contador - cantidadArticuloBorrar;
                    escribeContador.write(String.valueOf(contadorActualizado));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (listaProductos.get(nombreProducto) <= 0) {
                listaProductos.remove(nombreProducto);
            }
        }
        mostrarTexto();
    }

    private void mostrarTexto() {
        String salida = "";
        File rutaArchivos = new File("Resources/Contadores");
        for (Map.Entry<String, Integer> texto : listaProductos.entrySet()) {
            try (BufferedReader leerContadores = new BufferedReader(new FileReader(rutaArchivos + "/contador" + texto.getKey() + ".csv"))) {
                salida += "-> " + texto.getKey() + ": " + texto.getValue() + "€" + " (x" + leerContadores.readLine() + ")\n";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        salida += "\n Total: " + factura() + "€";
        this.textoProductos.setText(salida);
    }

    private int factura() {
        int sumaTotal = 0;
        for (Integer i : listaProductos.values()) {
            sumaTotal += i;
        }
        return sumaTotal;
    }

    public void botonTotalPulsado() {
        JOptionPane.showMessageDialog(null, "El total es: " + factura() + "€");
        int reply = JOptionPane.showConfirmDialog(null, "¿Quieres imprimir la factura?", "title", JOptionPane.YES_NO_OPTION);
        System.out.println(reply);
        if (reply == 0) {
            JTextPane jtp = new JTextPane();
            jtp.setBackground(Color.white);
            jtp.setFont(new Font("Courier New", Font.BOLD, 16));
            jtp.setText("INSTRUMENTOS CHO PIN \n \n" + BotonTotal.getFecha() + "\n \n" + textoProductos.getText());
            boolean show = true;
            try {
                jtp.print(null, null, show, null, null, show);
            } catch (java.awt.print.PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
