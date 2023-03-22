package vista;

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
                        .addGroup(navegacionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProductos)
                            .addComponent(nombreTienda))))
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
                .addContainerGap(531, Short.MAX_VALUE))
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
    }//GEN-LAST:event_btnProductosActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProductos;
    private javax.swing.JLabel logoEncabezado;
    private javax.swing.JPanel navegacionPanel;
    private javax.swing.JLabel nombreTienda;
    // End of variables declaration//GEN-END:variables
}
