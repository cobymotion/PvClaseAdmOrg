
package util;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import modelo.TablaDetalleViewModel;
import modelo.VentaModelo;

/**
 * Clase para hacer la impresion de un ticket 
 * @author luiscobian
 */
public class ImprimirTicket {
    
    public void printTicket(VentaModelo venta){
        // obtengo el servicio de impresion 
        PrinterJob impresora = PrinterJob.getPrinterJob(); 
        impresora.setPrintable(new FormatoImpresion(venta));
        boolean quieroImprimir = impresora.printDialog(); 
        if(quieroImprimir){
            try {
                impresora.print();
            } catch (Exception e) {
                System.out.println("No se pudo imprimir");
            }
        }                
    }  // Metodo printTicket 

    private class FormatoImpresion implements Printable{
        
        private VentaModelo venta;
        
        public FormatoImpresion(VentaModelo venta){
            this.venta = venta; 
        }

        @Override
        public int print(Graphics graphics, PageFormat pageFormat, 
                int pageIndex) throws PrinterException {
            //validacion en caso de eco 
            if(pageIndex > 0){
                return Printable.NO_SUCH_PAGE; 
            }
            
            Graphics2D print  = (Graphics2D)graphics; 
            print.translate(pageFormat.getImageableX(), 
                            pageFormat.getImageableY());
 
            int y = 20; 
            print.setFont(new Font("Monospaced", 
                    Font.BOLD,
                    12));            
            print.drawString("PUNTO DE VENTA TEC", 60, y);            
            y+=15; 
            print.setFont(new Font("Monospaced", 
                    Font.PLAIN,
                    12));      
            print.drawString("Ticket: #" + venta.getFolio(), 
                                  80, y);
            y+=15; 
            SimpleDateFormat format = 
                    new SimpleDateFormat("dd/MM/yyyy");
            print.drawString(format.format(
                                venta.getFecha()), 
                                  80, y);
            y+=15;
            print.drawLine(0, y, 240, y);
            y+=15;
            print.setFont(new Font("Monospaced", 
                    Font.PLAIN,
                    8));      
            // imprimir los productos 
            for(TablaDetalleViewModel item: venta.getDetalle()){
                print.drawString("" +item.getCantidad(), 7, y);
                print.drawString(item.getDescripcion(), 40, y);
                print.drawString("" +item.getPrecio(), 140, y);
                print.drawString("" +item.getTotal(), 200, y);
                y+=13;
            }
            return Printable.PAGE_EXISTS;            
        }
        
        
        
    }
    
    
}






