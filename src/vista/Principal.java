package vista;

import vista.reporte.ReporteForm;
import vista.venta.Venta;

/**
 *
 * @author luiscobian
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navegacionPanel = new javax.swing.JPanel();
        logoEncabezado = new javax.swing.JLabel();
        nombreTienda = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        btnVenta = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        navegacionPanel.setBackground(new java.awt.Color(0, 132, 158));

        logoEncabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/imgs/shopping64.png"))); // NOI18N

        nombreTienda.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        nombreTienda.setForeground(new java.awt.Color(204, 223, 229));
        nombreTienda.setText("Tienda X");

        btnProductos.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnVenta.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnVenta.setText("Venta");
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });

        btnReporte.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navegacionPanelLayout = new javax.swing.GroupLayout(navegacionPanel);
        navegacionPanel.setLayout(navegacionPanelLayout);
        navegacionPanelLayout.setHorizontalGroup(
            navegacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navegacionPanelLayout.createSequentialGroup()
                .addGroup(navegacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navegacionPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(logoEncabezado))
                    .addGroup(navegacionPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(navegacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombreTienda)
                            .addComponent(btnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReporte, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        navegacionPanelLayout.setVerticalGroup(
            navegacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navegacionPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(logoEncabezado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreTienda)
                .addGap(18, 18, 18)
                .addComponent(btnProductos)
                .addGap(18, 18, 18)
                .addComponent(btnVenta)
                .addGap(18, 18, 18)
                .addComponent(btnReporte)
                .addContainerGap(437, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(navegacionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(755, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navegacionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        System.out.println("Auch me presiono");
        ListaProductos vlista = new ListaProductos
                                     (this,true);
        vlista.setLocationRelativeTo(this);
        vlista.setVisible(true);
        System.out.println("Se mando llamar");
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed
        // TODO add your handling code here:
        Venta ventana = new Venta(this, true); 
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        System.out.println("Le presiono");
        ReporteForm ventana = new 
                    ReporteForm(this,true); 
        ventana.setLocationRelativeTo(this);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnReporteActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnVenta;
    private javax.swing.JLabel logoEncabezado;
    private javax.swing.JPanel navegacionPanel;
    private javax.swing.JLabel nombreTienda;
    // End of variables declaration//GEN-END:variables
}
