import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PanelInstrumentos {
    JPanel panel;
    List<BotonInstrumentos> botonesInstrumentos;

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
            String cantidad = s.split(":")[1];
            BotonInstrumentos botonInstrumentos = new BotonInstrumentos(nombre, Integer.parseInt(cantidad));
            botonInstrumentos.addActionListener(e -> ESCarrito.insertarProducto(nombre, Integer.parseInt(cantidad), carrito));
            botonesInstrumentos.add(botonInstrumentos);
            panel.add(botonInstrumentos);
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
