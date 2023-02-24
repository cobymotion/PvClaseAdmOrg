package modelo;

public interface OperacionesBaseDatos {
    
    /// Operaciones Productos 
    public String[][] todosProductos();
    public String[][] todosProductos(String filtro);
    public boolean agregarProducto(Producto producto);
    public boolean actualizarProducto(Producto producto);
    public Producto buscarProducto(String codigo);
    
}
