import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PanelInstrumentos {
    JPanel panel;
    List<BotonInstrumentos> botonesInstrumentos;
    int contador = 0;

    public PanelInstrumentos(String rutaArchivo, PanelCarrito carrito) {
        this.panel = new JPanel(new GridBagLayout());
        this.botonesInstrumentos = new ArrayList<>();
        try {
            rellenaBotonesFichero(rutaArchivo, carrito);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void rellenaBotonesFichero(String ruta, PanelCarrito carrito) throws IOException {
        // ¡¡¡CAMBIAR EXCEPCIÓN!!!
        String rutaCompleta = "Resources/" + ruta;
        List<String> lineas = Files.readAllLines(Paths.get(rutaCompleta));
        for (String s : lineas) {
            String nombre = s.split(":")[0];
            String precio = s.split(":")[1];
            String icono = s.split(":")[2];
            String pulsador = s.split(":")[3];
            BotonInstrumentos botonInstrumentos = new BotonInstrumentos(nombre, Integer.parseInt(precio), icono, Integer.parseInt(pulsador));
            botonInstrumentos.addActionListener(e -> { carrito.anyadirProducto(nombre, Integer.parseInt(precio), Integer.parseInt(pulsador));});
            botonesInstrumentos.add(botonInstrumentos);
            botonInstrumentos.addActionListener(e -> {
                contador++;
                System.out.println("Me he ejecutado: " + contador + " veces");
            });
            panel.add(botonInstrumentos);
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
