
package control.basededatos;

import control.archivos.ArchivoTexto;
import java.util.List;
import modelo.OperacionesBaseDatos;
import modelo.Producto;

public class BaseDatosVirtual implements OperacionesBaseDatos {
    
    
    @Override
    public String[][] todosProductos() {
        List<Producto> lista = ArchivoTexto.getProductos();
        String data[][] = new  
            String[lista.size()][3]; 
        
        int i = 0; 
        for(Producto producto : lista){
            data[i][0] = producto.getCodigo().trim(); 
            data[i][1] = producto.getDescripcion().trim(); 
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
        //BaseDatosVirtual.dbProductos.add(producto); 
        boolean res = ArchivoTexto.agregarProducto(producto);
        return res;
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
