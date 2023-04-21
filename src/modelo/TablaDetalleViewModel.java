
package modelo;
/**
 * Clase para guardar datos en estructura 
 * @author luiscobian
 */
public class TablaDetalleViewModel {
    private String codigo; 
    private String descripcion; 
    private int cantidad; 
    private double precio; 

    public double getTotal() {
        return precio * cantidad; 
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    

}
