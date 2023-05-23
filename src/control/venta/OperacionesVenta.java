
package control.venta;

import java.util.List;
import modelo.Producto;
import modelo.TablaDetalleViewModel;

/**
 * Operaciones basicas para la venta
 * @author luiscobian
 */
public class OperacionesVenta {
    
    /**
     * Metodo para agregar el valor a la venta
     * @param detalle lista de los productos que van en la venta 
     * @param producto producto que se tiene que agregar
     */
    public static void agregar(List<TablaDetalleViewModel> detalle, 
            Producto producto){
        
        var item = detalle.stream().filter
                   (x -> x.getCodigo().trim()
                           .equals(producto.getCodigo()))
                   .findFirst().orElse(null); 
        
        if(item == null){
            TablaDetalleViewModel venta = 
                    new TablaDetalleViewModel();             
            venta.setCodigo(
                    producto.getCodigo());
            venta.setCantidad(1);
            venta.setPrecio(
                     producto.getCosto());
            venta.setDescripcion(
               producto.getDescripcion());
            detalle.add(venta);
        } else {
            item.setCantidad(item.getCantidad() + 1);
        }
        
    }

    /**
     * Metodo para poder borrar un elemento
     * @param detalle lista de los elementos 
     * @param codigo codigo que se eliminara
     */
    public static boolean borrar(List<TablaDetalleViewModel> detalle, 
            String codigo){
        boolean borrado= false; 
        int i = 0; 
        for(var item: detalle){            
            if(codigo.trim().equals(item.getCodigo())){
                detalle.remove(i); 
                borrado = true;
                break;
            }
            i++; 
        }
        return borrado;
    }
    
}
