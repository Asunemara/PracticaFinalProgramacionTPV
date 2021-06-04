import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {

    public static void ventana() {
        PanelCarrito carrito = new PanelCarrito();
        JFrame frame = new JFrame("Instrumentos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        PanelCarrito carrito2 = new PanelCarrito();
        GridBagConstraints cCarrito = new GridBagConstraints();
        cCarrito.gridx = 3;
        cCarrito.gridy = 0;
        frame.add(carrito2, cCarrito);

        PanelInstrumentos panelCategorias = new PanelInstrumentos("categoriasInstrumentos.csv", carrito2);
        GridBagConstraints cPanelCategoria = new GridBagConstraints();
        cPanelCategoria.gridx = 0;
        cPanelCategoria.gridy = 0;
        frame.add(panelCategorias.getPanel(), cPanelCategoria);

        PanelInstrumentos panelInstrumentosViento = new PanelInstrumentos("instrumentosViento.csv", carrito2);
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
