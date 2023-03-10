
package vista;

import java.awt.Frame;
import modelo.Producto;

/**
 * Vista para agregar nuevos productos
 * @author luiscobian
 */
public class AgregaProducto extends ActualizarProductos {

    public AgregaProducto(Frame parent) {
        super(parent, true);
        acualizaTitulo("Agregar productos");
    }
    
    

    public boolean procesarTarea(Producto p){
        boolean res = db.agregarProducto(p);
        return res;
    }
}
