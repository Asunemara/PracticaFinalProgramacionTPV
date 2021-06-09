import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {

    public static void ventana() {
        PanelCarrito carrito = new PanelCarrito();
        JFrame frame = new JFrame("Instrumentos Cho Pin");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("Resources/Images/Icon.png").getImage());
        frame.setLayout(new GridBagLayout());
        carrito.setBackground(Color.black);

        GridBagConstraints cCarrito = new GridBagConstraints();
        cCarrito.gridx = 1;
        cCarrito.gridy = 0;
        frame.add(carrito, cCarrito);

        PanelInstrumentos panelInstrumentosViento = new PanelInstrumentos("instrumentosViento.csv", carrito);
        GridBagConstraints cPanelInstrumentosViento = new GridBagConstraints();
        cPanelInstrumentosViento.gridx = 1;
        cPanelInstrumentosViento.gridy = 3;
        cPanelInstrumentosViento.ipady = 5;
        frame.add(panelInstrumentosViento.getPanel(), cPanelInstrumentosViento);

        PanelInstrumentos panelInstrumentosCuerda = new PanelInstrumentos("instrumentosCuerda.csv", carrito);
        GridBagConstraints cPanelIntrumentosCuerda = new GridBagConstraints();
        cPanelIntrumentosCuerda.gridx = 1;
        cPanelIntrumentosCuerda.gridy = 1;
        cPanelIntrumentosCuerda.ipady = 5;
        frame.add(panelInstrumentosCuerda.getPanel(), cPanelIntrumentosCuerda);

        PanelInstrumentos panelInstrumentosPercusion = new PanelInstrumentos("instrumentosPercusion.csv", carrito);
        GridBagConstraints cpanelInstrumentosPercusion = new GridBagConstraints();
        cpanelInstrumentosPercusion.gridx = 1;
        cpanelInstrumentosPercusion.gridy = 2;
        cpanelInstrumentosPercusion.ipady = 5;
        frame.add(panelInstrumentosPercusion.getPanel(), cpanelInstrumentosPercusion);

        PanelInstrumentos panelInstrumentosElectricos = new PanelInstrumentos("instrumentosElectricos.csv", carrito);
        GridBagConstraints cpanelInstrumentosElectricos = new GridBagConstraints();
        cpanelInstrumentosElectricos.gridx = 1;
        cpanelInstrumentosElectricos.gridy = 4;
        cpanelInstrumentosElectricos.ipady = 5;
        frame.add(panelInstrumentosElectricos.getPanel(), cpanelInstrumentosElectricos);

        BotonTotal botonTotal = new BotonTotal(carrito, "Resources/Images/Invoice_Small_Icon.png");
        GridBagConstraints cBotonTotal = new GridBagConstraints();
        cBotonTotal.gridx = 0;
        cBotonTotal.gridy = 0;
        frame.add(botonTotal.panel, cBotonTotal);

        BotonBorrar botonBorrar = new BotonBorrar(carrito, "Resources/Images/Delete_Small_Icon.png");
        GridBagConstraints cBotonBorrar = new GridBagConstraints();
        cBotonBorrar.gridx = 2;
        cBotonBorrar.gridy = 0;
        frame.add(botonBorrar.panel, cBotonBorrar);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
