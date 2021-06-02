import javax.swing.*;

public class VentanaPrincipal {
    public static void ventana() {
        JFrame frame = new JFrame("Instrumentos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        PanelInstrumentos panelArticulos = new PanelInstrumentos();
        frame.add(panelArticulos.getPanel());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
