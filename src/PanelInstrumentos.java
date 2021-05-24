import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PanelInstrumentos {
    JPanel panel;
    List<BotonesInstrumentos> botonesInstrumentos;

    public PanelInstrumentos(){
        this.panel = new JPanel();
        this.botonesInstrumentos = new ArrayList<>();
        try {
            rellenaBotonesFichero();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void rellenaBotonesFichero() throws IOException {
        // ¡¡¡CAMBIAR EXCEPCIÓN!!!
        List<String> lineas = Files.readAllLines(Paths.get("intrumentos.csv"));
        for (String s: lineas) {
           String nombre = s.split(":")[0];
           String cantidad = s.split(":")[1];
           BotonesInstrumentos botonInstrumentos = new BotonesInstrumentos(nombre, Integer.parseInt(cantidad));
           botonesInstrumentos.add(botonInstrumentos);
           panel.add(botonInstrumentos.getBoton());
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
