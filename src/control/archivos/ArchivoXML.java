
package control.archivos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import modelo.VentaModelo;
import modelo.Ventas;

/**
 * clase para las operaciones con el archivo XML 
 * @author luiscobian
 */
public class ArchivoXML {

    private static final String archivo = "ventas.xml";
    
    public static Ventas leerXML() {
        
        File file = new File(archivo); 
        Ventas ventas = null; 
        if(file.exists()){            
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance
                                     (Ventas.class); 
                Unmarshaller um = jaxbContext.createUnmarshaller(); 
                ventas = (Ventas) um.unmarshal(file);                
            } catch (Exception e) {
                e.printStackTrace();                
            }            
        } else {
            ventas = new Ventas();
            ventas.setVentas
            (new ArrayList<VentaModelo>());
        }
        return ventas;
    }
    
    
    public static boolean guardarVenta(VentaModelo venta) {
        Ventas ventaXml = leerXML();         
        if(ventaXml == null){ // en caso que no exista 
            ventaXml = new Ventas();   // se crea uno nuevo 
            ventaXml.setVentas(new ArrayList<>()); 
        }
        ventaXml.getVentas().add(venta);
        /// guardar en el xml 
        File archivito = new File(archivo); 
        boolean res = false; 
        //trycatch
        try {
            JAXBContext context  = JAXBContext
                    .newInstance(Ventas.class); 
            Marshaller marshal = context.createMarshaller();
            marshal.setProperty(
                    Marshaller.JAXB_FORMATTED_OUTPUT,
                    true);
            marshal.marshal(ventaXml, archivito);   
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return res; 
    }
    
    /**
     * Permite regresar el numero de ventas registradas
     * @return 
     */
    public static int cantidadVentas(){
        Ventas venta = leerXML(); 
        int cantidad = venta==null?0:venta.getVentas().size();
        return cantidad;
    }

}






