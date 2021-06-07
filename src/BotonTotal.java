import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BotonTotal {
    JPanel panel;
    JButton botonTotal;
    private final PanelCarrito carrito;

    public BotonTotal(PanelCarrito carrito) {
        this.panel = new JPanel();
        this.botonTotal = new JButton("Imprimir Factura");
        botonTotal.addActionListener(e -> carrito.botonTotalPulsado());
        this.carrito = carrito;
        panel.add(botonTotal);
    }

    public static String getFecha() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}
