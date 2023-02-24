
package control.basededatos;

import java.util.ArrayList;
import java.util.List;
import modelo.OperacionesBaseDatos;
import modelo.Producto;

public class BaseDatosVirtual implements OperacionesBaseDatos {

    private static final List<Producto> dbProductos = 
            new ArrayList<Producto>();
    
    @Override
    public String[][] todosProductos() {
        String data[][] = new  
            String[BaseDatosVirtual.dbProductos.size()][3]; 
        
        int i = 0; 
        for(Producto producto : BaseDatosVirtual.dbProductos){
            data[i][0] = producto.getCodigo(); 
            data[i][1] = producto.getDescripcion(); 
            data[i][2] = String.format("%.2f",
                                 producto.getCosto());
            i++;
        }
        return data; 
    }

    @Override
    public String[][] todosProductos(String filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarProducto(Producto producto) {
        BaseDatosVirtual.dbProductos.add(producto); 
        return true;
    }

    @Override
    public boolean actualizarProducto(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto buscarProducto(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
