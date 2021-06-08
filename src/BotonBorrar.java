import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BotonBorrar {
    JPanel panel;
    JButton botonBorrar;
    private final PanelCarrito carrito;
    //private String nombreArticulo;

    public BotonBorrar(PanelCarrito carrito, String rutaIcono) {
        int precioArticulo;
        this.panel = new JPanel();
        this.carrito = carrito;
        ImageIcon iconoBorrar = new ImageIcon(rutaIcono);
        this.botonBorrar = new JButton("Borrar último elemento", iconoBorrar);
        botonBorrar.setVerticalTextPosition(SwingConstants.BOTTOM);
        botonBorrar.setHorizontalTextPosition(SwingConstants.CENTER);
        botonBorrar.addActionListener(e -> {
            try {
                String nombreArticulo = JOptionPane.showInputDialog("¿Qué artículo quieres borrar?");
                if (carrito.listaProductos.containsKey(nombreArticulo)) {
                    String cantidadArticuloBorrar = JOptionPane.showInputDialog("¿Cuántas unidades?");
                    carrito.borrarProducto(nombreArticulo, getPrecioArticulo(nombreArticulo), Integer.parseInt(cantidadArticuloBorrar));
                    getPrecioArticulo(nombreArticulo);
                } else {
                    JOptionPane.showMessageDialog(null, "El artículo introducido no es correcto");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //carrito.borrarProducto("Arpa", 400);
                });
        panel.add(botonBorrar);
    }

    private int getPrecioArticulo(String nombreArticulo) throws IOException {
        System.out.println(nombreArticulo);
        String rutaCompleta = "C:\\Users\\Khakuki\\Desktop\\sip.txt";
        List<String> lineas = Files.readAllLines(Paths.get(rutaCompleta));
        for (String s : lineas) {
            String nombre = s.split(":")[0];
            String cantidad = s.split(":")[1];
            System.out.println(nombre);
        if (nombreArticulo.equals(nombre)) {
            System.out.println("Estoy");
            System.out.println(cantidad);
            return Integer.parseInt(cantidad);
        } else {
            System.out.println("No estoy");
        }
    }
        return 0;
    }
}
