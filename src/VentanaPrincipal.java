import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {
    static PanelCarrito carrito = new PanelCarrito();

    public static void ventana() {
        JFrame frame = new JFrame("Instrumentos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        PanelInstrumentos panelCategorias = new PanelInstrumentos("categoriasInstrumentos.csv");
        GridBagConstraints cPanelCategoria = new GridBagConstraints();
        cPanelCategoria.gridx = 0;
        cPanelCategoria.gridy = 0;
        frame.add(panelCategorias.getPanel(), cPanelCategoria);

        PanelInstrumentos panelInstrumentosViento = new PanelInstrumentos("instrumentosViento.csv");
        GridBagConstraints cPanelInstrumentosViento = new GridBagConstraints();
        cPanelInstrumentosViento.gridx = 1;
        cPanelInstrumentosViento.gridy = 1;
        frame.add(panelInstrumentosViento.getPanel(), cPanelInstrumentosViento);
/*
        PanelInstrumentos panelInstrumentosCuerda = new PanelInstrumentos("instrumentosCuerda.csv");
        frame.add(panelInstrumentosCuerda.getPanel());

        PanelInstrumentos panelInstrumentosPercusion = new PanelInstrumentos("instrumentosPercusion.csv");
        frame.add(panelInstrumentosPercusion.getPanel());

        PanelInstrumentos panelInstrumentosElectricos = new PanelInstrumentos("instrumentosElectricos.csv");
        frame.add(panelInstrumentosElectricos.getPanel());
*/
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
