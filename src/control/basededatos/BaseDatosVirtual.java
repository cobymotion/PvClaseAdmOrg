
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
        List<Producto> listaDatos = ArchivoTexto.getProductos(); 
        boolean res; 
        Producto original = listaDatos.stream()
                            .filter(x -> x.getCodigo()
                                    .trim()
                                    .equals(producto
                                            .getCodigo().trim()))
                            .findFirst()
                            .orElse(null);
        if(original!=null){             
            original.setDescripcion(producto.getDescripcion());
            original.setCosto(producto.getCosto());
            System.out.println("Aqui voy a regenerar mi archivo");
            res = ArchivoTexto.regenerarElArchivo(listaDatos);
        }else {
            System.out.println("No lo encontro");
            res = false; 
        }
        return res;
    }

    @Override
    public Producto buscarProducto(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
