import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {

    public static void ventana() {
        PanelCarrito carrito = new PanelCarrito();
        JFrame frame = new JFrame("Instrumentos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints cCarrito = new GridBagConstraints();
        cCarrito.gridx = 0;
        cCarrito.gridy = 0;
        
        frame.add(carrito, cCarrito);
/*
        PanelInstrumentos panelCategorias = new PanelInstrumentos("categoriasInstrumentos.csv", carrito);
        GridBagConstraints cPanelCategoria = new GridBagConstraints();
        cPanelCategoria.gridx = 1;
        cPanelCategoria.gridy = 1;
        frame.add(panelCategorias.getPanel(), cPanelCategoria);
*/
        PanelInstrumentos panelInstrumentosViento = new PanelInstrumentos("instrumentosViento.csv", carrito);
        GridBagConstraints cPanelInstrumentosViento = new GridBagConstraints();
        cPanelInstrumentosViento.gridx = 1;
        cPanelInstrumentosViento.gridy = 4;
        frame.add(panelInstrumentosViento.getPanel(), cPanelInstrumentosViento);

        PanelInstrumentos panelInstrumentosCuerda = new PanelInstrumentos("instrumentosCuerda.csv", carrito);
        GridBagConstraints cPanelIntrumentosCuerda = new GridBagConstraints();
        cPanelIntrumentosCuerda.gridx = 1;
        cPanelIntrumentosCuerda.gridy = 1;
        frame.add(panelInstrumentosCuerda.getPanel(), cPanelIntrumentosCuerda);

        PanelInstrumentos panelInstrumentosPercusion = new PanelInstrumentos("instrumentosPercusion.csv", carrito);
        GridBagConstraints cpanelInstrumentosPercusion = new GridBagConstraints();
        cpanelInstrumentosPercusion.gridx = 1;
        cpanelInstrumentosPercusion.gridy = 2;
        frame.add(panelInstrumentosPercusion.getPanel(), cpanelInstrumentosPercusion);

        PanelInstrumentos panelInstrumentosElectricos = new PanelInstrumentos("instrumentosElectricos.csv", carrito);
        GridBagConstraints cpanelInstrumentosElectricos = new GridBagConstraints();
        cpanelInstrumentosElectricos.gridx = 1;
        cpanelInstrumentosElectricos.gridy = 3;
        frame.add(panelInstrumentosElectricos.getPanel(), cpanelInstrumentosElectricos);

        //frame.setSize(1000,1000);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
