
package modelo;

import java.io.Serializable;

/**
 * Clases para guardar los datos de un producto en particular
 * @author luiscobian
 */
public class Producto implements Serializable {
    
    private String codigo; 
    private String descripcion; 
    private double costo; 

    @Override
    public String toString() {
        return codigo + "#" + descripcion + "#" + costo + "#";
    }
    
    

    public Producto(String codigo, String descripcion, double costo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
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
    
    
    
    

}















