
package control.archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;

/**
 * Clase que permite realizar 
 * operaciones con el archivo binario
 * @author luiscobian
 */
public class ArchivoBinario {
    
    private static final String nombreArchivo = "datos.dat"; 
    
    /**
     * Metodo que me permite recuperar la lista de los 
     * productos almacenados en el archivo
     * @return Lista de productos
     */
    public static List<Producto> getProductos(){
        List<Producto> lista = new ArrayList<>(); 
        
        File archivo = new File(nombreArchivo);
        
        if(archivo.exists()){            
            try {
                FileInputStream fis = new FileInputStream
                                         (archivo);
                ObjectInputStream ois = new ObjectInputStream
                                         (fis);
                lista = (ArrayList<Producto>) ois.readObject();
                ois.close(); 
                fis.close();
            } catch (IOException e) {
                System.out.println("Error: " + 
                                   e.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Error: " + 
                                   ex.getMessage());
            }            
        }//fin if
        return lista; 
    }

    /**
     * Lee la lista que se tiene en el archivo y agrega
     * un nuevo elemento, manda a llamar que regenere el
     * archivo
     * @param p
     * @return 
     */
    public static boolean agregarProducto(Producto p){        
        boolean resultado = false;         
        List<Producto> lista  = getProductos(); 
        lista.add(p); 
        resultado = regenerarElArchivo(lista);        
        return resultado; 
    }
    /**
     * metodo que permite renerar el archivo con la lista qu
     * se manda
     * @param lista con los datos
     * @return verdadero si se hace el cambio
     */
    public static boolean regenerarElArchivo
                          (List<Producto> lista){
        boolean resultado = false; 
        File archivo = new File(nombreArchivo);
        try {   
            FileOutputStream fos = new FileOutputStream
                                       (archivo,false); 
            ObjectOutputStream oos = new ObjectOutputStream
                                       (fos);
            oos.writeObject(lista);
            oos.close();
            fos.close();
            resultado = true;
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return resultado; 
    }
    
    
}
