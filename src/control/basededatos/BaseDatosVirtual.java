
package control.basededatos;

import control.archivos.ArchivoBinario;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import modelo.OperacionesBaseDatos;
import modelo.Producto;

public class BaseDatosVirtual implements OperacionesBaseDatos {
    
    
    @Override
    public String[][] todosProductos() {        
        return convertirAArreglo
                (ArchivoBinario.getProductos()); 
    }

    private String[][] convertirAArreglo
                              (List<Producto> listita){
        String data[][] = new String[listita.size()][3];
        int i = 0; 
        for(Producto producto: listita){
            data[i][0] = producto.getCodigo().trim();
            data[i][1] = producto.getDescripcion(); 
            data[i][2] = String.format("%.2f", 
                           producto.getCosto());
            i++;
        }
        return data; 
    }
    
    @Override
    public String[][] todosProductos(String filtro) {
        String filtro2 = filtro.toLowerCase(); 
        List<Producto> productos = 
                ArchivoBinario.getProductos();
        Stream<Producto> streamFiltrado = 
                productos.stream()
                .filter(x -> x.getDescripcion()
                        .toLowerCase()
                        .contains(filtro2) || 
                        x.getCodigo().toLowerCase()
                                .contains(filtro2)); 
        List<Producto> productosFiltrados = 
                      streamFiltrado.collect
                            (Collectors.toList());
        return convertirAArreglo
                            (productosFiltrados);
    }

    @Override
    public boolean agregarProducto(Producto producto) {
        //BaseDatosVirtual.dbProductos.add(producto); 
        boolean res = ArchivoBinario.agregarProducto(producto);
        return res;
    }

    @Override
    public boolean actualizarProducto(Producto producto) {
        List<Producto> listaDatos = ArchivoBinario.getProductos(); 
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
            res = ArchivoBinario.regenerarElArchivo(listaDatos);
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
