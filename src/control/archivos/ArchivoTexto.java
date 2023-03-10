
package control.archivos;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Producto;

/**
 * Clase que me permite controlar las operaciones 
 * Basicas de los archivos en este caso de texto 
 * @author luiscobian
 */
public class ArchivoTexto {

    private static final String nombreArchivo = 
                    "MiBaseDatos.txt"; 
    
    
    public static List<Producto> getProductos(){
        List<Producto> lista = new ArrayList<>(); 
        
        File archivo = new 
        File(nombreArchivo);        
        try {
            FileReader fr = new FileReader
                                (archivo);
            Scanner sc = new Scanner(fr);
            sc.useDelimiter("#");
            while(sc.hasNext()){
                String codigo = sc.next(); 
                if(codigo.trim().isEmpty())
                    break;
                String descripcion = sc.next(); 
                String costoStr = sc.next(); 
                double costo = Double.parseDouble
                                       (costoStr);
                Producto p = new Producto
                         (codigo, descripcion, costo); 
                lista.add(p);
                System.out.println(p);
            }            
        } catch (IOException e) {
            System.out.println("Error " + 
                                 e.getMessage());
            lista = new ArrayList<>();
        }
        
        return lista; 
    }
    
    
    /**
     * Metodo que permite grabar en el archivo 
     * los datos de los productos
     * @param p datos del producto
     * @return verdadero si se grabo correctamente
     */
    public static boolean agregarProducto(Producto p){
        String dato = p.toString();
        boolean resultado = false; 
        
        File archivo  = new File
                          (nombreArchivo);
        
        try {
            FileWriter fw = new FileWriter 
                        (archivo,true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(dato);
            pw.flush();
            pw.close(); 
            fw.close();   
            resultado = true;
        } catch (IOException ex) {
            System.out.println("Auch algo paso " 
                        + ex.getMessage());
            resultado  = false; 
        }
                 
        return resultado; 
    }

    public static boolean regenerarElArchivo(List<Producto> listaDatos) {
        boolean resultado; 
        File archivo = new File(nombreArchivo);
        try {
            FileWriter fw  = new FileWriter(archivo, false); 
            PrintWriter pw = new PrintWriter(fw);
            for(Producto p: listaDatos){
                pw.println(p);
            }
            pw.flush();
            pw.close();
            fw.close();
            resultado = true;
        } catch (IOException e) {
            System.out.println("No se pudo regenerar");
            resultado =false; 
        }
        return resultado;
    }
    
}











