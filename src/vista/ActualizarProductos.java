/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import control.basededatos.BaseDatosVirtual;
import modelo.OperacionesBaseDatos;
import modelo.Producto;

/**
 *
 * @author luiscobian
 */
public class ActualizarProductos extends javax.swing.JDialog {

    OperacionesBaseDatos db ; 
    /**
     * Creates new form ActualizarProductos
     */
    public ActualizarProductos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        db = new BaseDatosVirtual();
        ocultarErrores(); 
    }

    /**
     * Permite esconder los label de los errores
     */
    private void ocultarErrores(){
        lblErrorCodigo.setVisible(false);
        lblErrorDescripcion.setVisible(false);
        lblErrorCosto.setVisible(false);
    }
    /**
     * Permite mostrar el error que presenta el campo 
     * @param code numero de error 0 - vacío 2 - mal formato
     */
    private void showErrorCost(int code){
        String msg = code==2?"No es una cantidad válida":"El campo no puede ir vacío";
        lblErrorCosto.setText("(*) " + msg);
        lblErrorCosto.setVisible(true);
    }
    
    /**
     * Sirve para mostrar el focus del componente al presentar un error
     * @param component numero de componente que genera el error
     */
    private void requestFocusInput(int component){
        switch(component){
            case 1 -> jtCodigo.requestFocus();
            case 2 -> jtDescripcion.requestFocus();
            case 3 -> jtCosto.requestFocus();
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtCodigo = new javax.swing.JTextField();
        jtDescripcion = new javax.swing.JTextField();
        jtCosto = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblErrorCosto = new javax.swing.JLabel();
        lblErrorDescripcion = new javax.swing.JLabel();
        lblErrorCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jlTitulo.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(204, 204, 204));
        jlTitulo.setText("Operación con Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel2.setText("Descripción");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setText("Costo:");

        jtCodigo.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jtDescripcion.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jtCosto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblErrorCosto.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        lblErrorCosto.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorCosto.setText("(*) El campo no puede ir vacío");

        lblErrorDescripcion.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        lblErrorDescripcion.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorDescripcion.setText("(*) El campo no puede ir vacío");

        lblErrorCodigo.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        lblErrorCodigo.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorCodigo.setText("(*) El campo no puede ir vacío");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(241, 241, 241)
                        .addComponent(lblErrorDescripcion))
                    .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(197, 197, 197)
                        .addComponent(lblErrorCodigo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblErrorCosto)
                            .addComponent(jtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorCodigo)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrorDescripcion)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorCosto)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Manejando la accion de la actualización del boton
     * @param evt 
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ocultarErrores();
        String codigo = jtCodigo.getText(); 
        String descripcion = jtDescripcion.getText(); 
        String strCosto = jtCosto.getText();
        int componentError = 0; 
        if(strCosto.isEmpty()) {showErrorCost(1); componentError=3;}
        if(descripcion.isEmpty()) {lblErrorDescripcion.setVisible(true);componentError=2;}        
        if(codigo.isEmpty()) {lblErrorCodigo.setVisible(true); componentError=1;}        
        double costo = 0; 
        try {
            costo = Double.parseDouble(strCosto);
        }
        catch(NumberFormatException e){
            costo = 0;
            showErrorCost(2);
            if(componentError == 0) componentError = 3;
        }
        
        requestFocusInput(componentError); 
        Producto p = new Producto(codigo, descripcion, costo); 
        db.agregarProducto(p); 
        this.dispose();
        ///// AQUI VOY
    }//GEN-LAST:event_btnGuardarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtCodigo;
    private javax.swing.JTextField jtCosto;
    private javax.swing.JTextField jtDescripcion;
    private javax.swing.JLabel lblErrorCodigo;
    private javax.swing.JLabel lblErrorCosto;
    private javax.swing.JLabel lblErrorDescripcion;
    // End of variables declaration//GEN-END:variables
}
