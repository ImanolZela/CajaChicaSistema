package View.GastosPorComprobante;

import Controller.GastoPorComprobante.ControladorGasto;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;
import java.util.Date;



public class RegistrarGasto extends javax.swing.JFrame {
    private JDateChooser txtFechaBoleta;
    private JDateChooser txtFechaDeGasto;
    /**
     * Creates new form RegistrarGasto
     */
    public RegistrarGasto() {
        initComponents();
        initializeDatePickers();
        
    }
   
    
    private void initializeDatePickers() {
        txtFechaBoleta = new JDateChooser();
        txtFechaDeGasto = new JDateChooser();

        txtFechaBoleta.setDateFormatString("yyyy-MM-dd");
        txtFechaDeGasto.setDateFormatString("yyyy-MM-dd");
  
        txtFechaBoleta.setBounds(400, 160, 120, 30);
        txtFechaDeGasto.setBounds(455, 268, 120, 30);
        
        getContentPane().add(txtFechaBoleta);
        getContentPane().add(txtFechaDeGasto);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbTipoComprobante = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcionBoleta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumeroComprobante = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcionGasto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMontoDeGasto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnGuardarGasto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo de comprobante :");

        cbTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Boleta", "Factura" }));

        jLabel2.setText("Descripcion :");

        jLabel3.setText("Fecha de creacion: ");

        jLabel4.setText("Num. de comprobante: ");

        jLabel5.setText("Descripcion de gasto: ");

        jLabel6.setText("Monto:");

        jLabel7.setText("Fecha de gasto: ");

        btnGuardarGasto.setText("Guarda Gasto");
        btnGuardarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarGastoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumeroComprobante)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(txtMontoDeGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDescripcionGasto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(14, 14, 14))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardarGasto)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescripcionBoleta)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(56, 56, 56)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumeroComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMontoDeGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnGuardarGasto)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarGastoActionPerformed
        String tipoComprobante = cbTipoComprobante.getSelectedItem().toString();
        String descripcionBoleta = txtDescripcionBoleta.getText();
        Date fechaBoleta = txtFechaBoleta.getDate();
        String numeroComprobante = txtNumeroComprobante.getText();
        String descripcionGasto = txtDescripcionGasto.getText();
        String montoDeGasto = txtMontoDeGasto.getText();
        Date fechaDeGasto = txtFechaDeGasto.getDate();

        if (tipoComprobante.equals("Seleccione...")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar el tipo de comprobante.");
            return;
        }
        if (descripcionBoleta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una descripción de la boleta.");
            return;
        }
        if (fechaBoleta == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha de boleta válida.");
            return;
        }
        if (numeroComprobante.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número de comprobante.");
            return;
        }
        if (descripcionGasto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una descripción de gasto.");
            return;
        }
        if (montoDeGasto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el monto del gasto.");
            return;
        }

        try {
            Double monto = Double.parseDouble(montoDeGasto);
            if (monto <= 0) {
                JOptionPane.showMessageDialog(this, "El monto debe ser un número positivo.");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El monto debe ser un número válido.");
            return;
        }

        if (fechaDeGasto == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha de gasto válida.");
            return;
        }

        ControladorGasto controlador = new ControladorGasto();
        controlador.guardarGasto(tipoComprobante, descripcionBoleta, fechaBoleta, numeroComprobante, descripcionGasto, montoDeGasto, fechaDeGasto);
        JOptionPane.showMessageDialog(this, "Gasto guardado correctamente.");
    }//GEN-LAST:event_btnGuardarGastoActionPerformed

    
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarGasto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarGasto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarGasto;
    private javax.swing.JComboBox<String> cbTipoComprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtDescripcionBoleta;
    private javax.swing.JTextField txtDescripcionGasto;
    private javax.swing.JTextField txtMontoDeGasto;
    private javax.swing.JTextField txtNumeroComprobante;
    // End of variables declaration//GEN-END:variables


}

