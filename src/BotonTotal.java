import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BotonTotal {
    JPanel panel;
    JButton botonTotal;
    private final PanelCarrito carrito;

    public BotonTotal(PanelCarrito carrito, String rutaIcono) {
        this.panel = new JPanel();
        ImageIcon iconoFactura = new ImageIcon(rutaIcono);
        this.botonTotal = new JButton("Imprimir Factura", iconoFactura);
        botonTotal.setVerticalTextPosition(SwingConstants.BOTTOM);
        botonTotal.setHorizontalTextPosition(SwingConstants.CENTER);
        //this.botonTotal = new JButton(quitIcon);
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
