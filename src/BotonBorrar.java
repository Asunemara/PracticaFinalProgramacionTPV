import javax.swing.*;
import java.awt.*;

public class BotonBorrar {
    JPanel panel;
    JButton botonBorrar;
    private final PanelCarrito carrito;

    public BotonBorrar(PanelCarrito carrito) {
        this.panel = new JPanel();
        this.botonBorrar = new JButton("Borrar último elemento");
        botonBorrar.addActionListener(e -> ESCarrito.borrarProducto());
        this.carrito = carrito;
        panel.add(botonBorrar);
    }
}
