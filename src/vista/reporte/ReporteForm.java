/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.reporte;

import control.archivos.ArchivoCSV;
import control.archivos.ArchivoXML;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.VentaModelo;
import modelo.Ventas;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import vista.venta.Venta;

/**
 *
 * @author luiscobian
 */
public class ReporteForm extends javax.swing.JDialog {

    private List<VentaModelo> listaMostrada; 
    
    public ReporteForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Calendar calendar = Calendar.getInstance(); 
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date inicialFecha = calendar.getTime(); 
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date finalFecha = calendar.getTime();
        filtrarDatos(inicialFecha, finalFecha);         
    }
    
    private void filtrarDatos(Date inicialFecha, Date finalFecha){
        System.out.println("Inicial:" + inicialFecha.toString());
        System.out.println("Fecha:" + finalFecha.toString());
        Ventas objVenta  = ArchivoXML.leerXML();
        List<VentaModelo> listaFiltrada 
                = objVenta.getVentas().stream()
                .filter(v -> v.getFecha().after(inicialFecha)
                       && v.getFecha().before(finalFecha))
                .collect(Collectors.toList());
        acomodarGrid(listaFiltrada);
    }
        

    private void acomodarGrid(List<VentaModelo> listaDatos){
        listaMostrada = listaDatos; 
        String[][] datos = extraerDatos(listaDatos); 
        String[] columnas = {"Folio", "Fecha", "Total"}; 
        DefaultTableModel modelo = new DefaultTableModel
                         (datos, columnas);
        tbDatos.setModel(modelo);
        // necesitos datos formateados 
        DefaultCategoryDataset datosGrafico = 
                extrarDatosGrafico(listaDatos);
        // crear el grafico 
        crearGrafico(datosGrafico); 
        // ponerlo en el panel 
    }
    
    private DefaultCategoryDataset extrarDatosGrafico(List<VentaModelo> lista){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        HashMap<String, Double> mapa = new HashMap<>();
        for(VentaModelo venta : lista){
            Calendar calendar = Calendar.getInstance(); 
            calendar.setTime(venta.getFecha());            
            int dia = calendar.get(Calendar.DAY_OF_WEEK);
            double total = venta.getTotal(); 
            String llaveDia = numeroADia(dia); 
            double loqueSeLleva = 0; 
            if(mapa.containsKey(llaveDia )){
                loqueSeLleva = mapa.get(llaveDia); 
            }
            mapa.put(llaveDia, total + loqueSeLleva);
        }               
        /// recorrer mapa 
        for(Map.Entry<String, Double> entrada : mapa.entrySet()){
            String llave = entrada.getKey(); 
            double valor = entrada.getValue(); 
            dataset.addValue(valor, "Ventas día"
                    , llave);        
        }
        return dataset;
    }
    
    private String numeroADia(int dia){
        String diaLetra = ""; 
        switch(dia){
            case 1: diaLetra = "DO"; break; 
            case 2: diaLetra = "LU"; break; 
            case 3: diaLetra = "MA"; break; 
            case 4: diaLetra = "MI"; break; 
            case 5: diaLetra = "JU"; break; 
            case 6: diaLetra = "VI"; break; 
            default: diaLetra = "SA"; break; 
        }
        return diaLetra; 
    }
    
    private void crearGrafico(DefaultCategoryDataset datos){
        JFreeChart grafico = ChartFactory.createBarChart
        ("Ventas tienda", "Días", "Total", datos);
        
        ChartPanel panel = new ChartPanel(grafico); 
        panel.setPreferredSize(graficoPanel.getSize());
        /// cambiar el color fondo de la grafica 
        CategoryPlot plot = grafico.getCategoryPlot();
        Color miColorBk = new Color(79, 213, 242); 
        Color miColor = new Color(0,153,255);  //[0,153,255]
        plot.setBackgroundPaint(miColorBk);
        BarRenderer render = (BarRenderer) plot.getRenderer(); 
        render.setSeriesPaint(0, miColor);
        //// 
        graficoPanel.removeAll();
        graficoPanel.add(panel); 
        graficoPanel.updateUI();
        graficoPanel.repaint();        
    }
    
    private String[][] extraerDatos(List<VentaModelo> lista){
        String[][] arregloDatos = new String[lista.size()][3];
        int i=0; 
        for (VentaModelo venta: lista) {
            arregloDatos[i][0] = venta.getFolio(); 
            arregloDatos[i][1] = formatearFecha(venta.getFecha()); 
            arregloDatos[i][2] = String.format("$%.2f", 
                               venta.getTotal());
            i++; 
        }        
        return arregloDatos; 
    }
    
    private String formatearFecha(Date date){
        SimpleDateFormat format = new 
                     SimpleDateFormat("dd-MM-yyyy");
        return format.format(date);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFInicial = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFFinal = new javax.swing.JFormattedTextField();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        graficoPanel = new javax.swing.JPanel();
        btnReimprimir = new javax.swing.JButton();
        btnExportar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reporte de venta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("Fecha Incial");

        try {
            txtFInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFInicial.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Fecha Final");

        try {
            txtFFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFFinal.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        txtBuscar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        btnBuscar.setText("jButton1");

        tbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbDatos);

        graficoPanel.setBackground(new java.awt.Color(204, 204, 204));

        btnReimprimir.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnReimprimir.setText("Reimprimir");

        btnExportar.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        btnExportar.setText("Exportar");
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });

        btnActualizar.setText("jButton1");
        btnActualizar.setSize(new java.awt.Dimension(78, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBuscar)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtFFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graficoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(graficoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReimprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExportar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        // AQUI VOY A EXPORTAR LO QUE VEO EN LA TABLA 
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar archivo CSV");
        chooser.setFileFilter(
                new FileNameExtensionFilter("Archivo CSV",
                        "csv"));
        int respuesta = chooser.showSaveDialog(this);
        if(respuesta==JFileChooser.APPROVE_OPTION){
             ///el usuario selecciono el archivo 
             String ruta = chooser.getSelectedFile().getPath(); 
             ruta = !ruta.toLowerCase().endsWith(".csv")
                     ?ruta + ".csv":ruta;
             System.out.println("Ruta " + ruta); // 
             boolean res = ArchivoCSV.crear(ruta, listaMostrada);
             if(res){
                 JOptionPane.showMessageDialog(this, 
                         "Se exportó");
             }
        }
        
    }//GEN-LAST:event_btnExportarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExportar;
    private javax.swing.JButton btnReimprimir;
    private javax.swing.JPanel graficoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDatos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JFormattedTextField txtFFinal;
    private javax.swing.JFormattedTextField txtFInicial;
    // End of variables declaration//GEN-END:variables
}
