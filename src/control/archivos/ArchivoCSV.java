
package control.archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.VentaModelo;

public class ArchivoCSV {
    
    public static boolean crear(String ruta, 
            List<VentaModelo> datos){
        boolean res = false;         
        try {
            FileWriter writer = 
                     new FileWriter(ruta);
            
            writer.append("Reporte ventas,,\n"); 
            writer.append("Folio,Fecha,Total\n");
            SimpleDateFormat sdf = 
                    new SimpleDateFormat("dd-MM-yyyy");
            for(VentaModelo venta: datos){
                writer.append(venta.getFolio())
                        .append(",")
                        .append(sdf.format(venta.getFecha()))
                        .append(",")
                        .append(String.format("$%.2f",
                                   venta.getTotal()))
                        .append("\n");
            }
            writer.flush();
            writer.close();
            res = true;
            
        } catch (IOException e) {
            e.printStackTrace();
            res = false;
        }
        
        
        return res;         
    }

}
