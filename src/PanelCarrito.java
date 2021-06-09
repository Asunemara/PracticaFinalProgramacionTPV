import javax.swing.*;
import java.awt.*;
import java.io.*;
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

    public void anyadirProducto(String nombreProducto, int precio, int contador) {
        System.out.println("CASA");
        int contadorActualizado = 0;
        if(!listaProductos.containsKey(nombreProducto)) {
            listaProductos.put(nombreProducto,precio);
            creaContador(nombreProducto, contador);
            System.out.println("CASA1");
        } else {
            listaProductos.put(nombreProducto, listaProductos.get(nombreProducto) + precio);
            contadorActualizado = escribeContador(nombreProducto);
            System.out.println("CASA2");
        }
        mostrarTexto();
    }

    private void creaContador(String nombreProducto, int contador) {
        File rutaArchivos = new File("Resources/Contadores");
        rutaArchivos.mkdirs();
        try (BufferedWriter crearFichero = new BufferedWriter(new FileWriter(rutaArchivos + "/contador" + nombreProducto + ".csv"))) {
            crearFichero.write(String.valueOf(contador));
            System.out.println("Hola, he llegado vivo");
            System.out.println(contador);
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
            System.out.println(contador + " novedad");
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
        System.out.println("PISTACHO" + rutaArchivos);
        if(listaProductos.containsKey(nombreProducto)) {
            System.out.println(listaProductos.get("Arpa"));
            listaProductos.put(nombreProducto, listaProductos.get(nombreProducto) - (precio * cantidadArticuloBorrar));
            System.out.println(cantidadArticuloBorrar + "chchhc");
            try (BufferedReader leeContador = new BufferedReader(new FileReader(rutaArchivos + "/contador" + nombreProducto + ".csv"))) {
                contador = Integer.parseInt(leeContador.readLine());
                System.out.println(contador + " novedad2");
                try (BufferedWriter escribeContador = new BufferedWriter(new FileWriter(rutaArchivos + "/contador" + nombreProducto + ".csv"))) {
                    int contadorActualizado = contador - cantidadArticuloBorrar;
                    System.out.println(contadorActualizado + " Pro");
                    escribeContador.write(String.valueOf(contadorActualizado));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(listaProductos.get(nombreProducto) + " chorizo plástico");
            if (listaProductos.get(nombreProducto) <= 0) {
                listaProductos.remove(nombreProducto);
            }
            System.out.println("PISTACHO1");
        }
       mostrarTexto();
    }

    private void mostrarTexto() {
        String salida = "";
        File rutaArchivos = new File("Resources/Contadores");
        for (Map.Entry<String, Integer> texto : listaProductos.entrySet()) {
            try (BufferedReader leerContadores = new BufferedReader(new FileReader(rutaArchivos + "/contador" + texto.getKey() + ".csv"))) {
            salida += "-> " + texto.getKey() + ": " + texto.getValue() + "€" + " (x" + leerContadores.readLine() + ")\n";
            System.out.println(salida);
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        System.out.println(salida);
        this.textoProductos.setText(salida);
    }

    private int factura() {
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
