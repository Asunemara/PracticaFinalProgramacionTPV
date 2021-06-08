import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class VentanaPrincipal {

    public static void ventana() {
        PanelCarrito carrito = new PanelCarrito();
        JFrame frame = new JFrame("Instrumentos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        //carrito.setBorder(new LineBorder(Color.BLACK, 7));
        carrito.setBackground(Color.black);

        GridBagConstraints cCarrito = new GridBagConstraints();
        cCarrito.gridx = 1;
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
/*
        ImageIcon water = new ImageIcon("C:\\Users\\Khakuki\\Desktop\\unnamed.jpg");
        JButton button = new JButton(water);
        frame.add(button);
*/
        //frame.setSize(1000,1000);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
