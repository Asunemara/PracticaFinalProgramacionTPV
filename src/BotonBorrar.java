import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BotonBorrar {
    private final PanelCarrito carrito;
    JPanel panel;
    JButton botonBorrar;

    public BotonBorrar(PanelCarrito carrito, String rutaIcono) {
        this.panel = new JPanel();
        this.carrito = carrito;
        ImageIcon iconoBorrar = new ImageIcon(rutaIcono);
        this.botonBorrar = new JButton("Quitar Artículo", iconoBorrar);
        botonBorrar.setVerticalTextPosition(SwingConstants.BOTTOM);
        botonBorrar.setHorizontalTextPosition(SwingConstants.CENTER);
        botonBorrar.addActionListener(e -> {
            borrarObjeto();
        });
        panel.add(botonBorrar);
    }

    private void borrarObjeto() {
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
    }

    private int getPrecioArticulo(String nombreArticulo) throws IOException {
        String rutaCompleta = "Resources/Precios.csv";
        List<String> lineas = Files.readAllLines(Paths.get(rutaCompleta));
        for (String s : lineas) {
            String nombre = s.split(":")[0];
            String cantidad = s.split(":")[1];
            if (nombreArticulo.equals(nombre)) {
                return Integer.parseInt(cantidad);
            }
        }
        return 0;
    }
}
