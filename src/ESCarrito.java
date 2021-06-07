public class ESCarrito {
    public static void insertarProducto(String nombre, int precio, PanelCarrito carrito) {
        carrito.anyadirProducto(nombre, precio);
    }

    public static void borrarProducto(String nombre, int precio, PanelCarrito carrito) {
        carrito.borrarProducto(nombre, precio);
    }
}
