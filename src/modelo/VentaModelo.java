
package modelo;

import java.util.Date;
import java.util.List;

/**
 * Datos de la venta 
 * @author luiscobian
 */
public class VentaModelo {

    private String folio; 
    private Date fecha; 
    private double total; 
    private List<TablaDetalleViewModel> detalle; 

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<TablaDetalleViewModel> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<TablaDetalleViewModel> detalle) {
        this.detalle = detalle;
    }
    
    
    
}
