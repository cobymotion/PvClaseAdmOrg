
package modelo;

import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Este permite la estructura primaria de mi XML 
 * @author luiscobian
 */
@XmlRootElement
public class Ventas {
    
    private List<VentaModelo> ventas; 

    public List<VentaModelo> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaModelo> ventas) {
        this.ventas = ventas;
    }
    
    
    

}












