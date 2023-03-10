
package vista;

import java.awt.Frame;
import modelo.Producto;

/**
 * ventana para editar los productos
 * @author luiscobian
 */
public class EditarProducto extends ActualizarProductos {

    public EditarProducto(Frame parent, Producto p) {
        super(parent, true);
        acualizaTitulo("Editar Producto");
        habilitarCodigo(false);
        cargarDatos(p);
    }

    
    
    @Override
    public boolean procesarTarea(Producto p) {
        System.out.println(p);
        boolean res = db.actualizarProducto(p);
        return res;
    }

    
    
    
}
