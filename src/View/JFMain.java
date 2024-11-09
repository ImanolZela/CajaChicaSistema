
package View;

import Model.Conexion;
import View.GastoCategoria.JFClasificarGasto;
import View.ReporteDeGasto.JFReporteDeGastoPorProyecto;
import View.SubirComprobante.JFSubirComprobante;
import View.VerSaldo.JFVerSaldo;

public class JFMain extends javax.swing.JFrame {

    private JFClasificarGasto jfClasificarGasto;
    private JFVerSaldo jfVerSaldo;
    private JFReporteDeGastoPorProyecto jfReporteDeGastoPorProyecto;
    private JFSubirComprobante jfSubirComprobante;
    
    public JFMain() {
        initComponents();
        Conexion.conectar();
        this.jfClasificarGasto = new JFClasificarGasto();
        this.jfVerSaldo = new JFVerSaldo();
        this.jfReporteDeGastoPorProyecto = new JFReporteDeGastoPorProyecto();
        this.jfSubirComprobante = new JFSubirComprobante();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClasificarGasto = new javax.swing.JButton();
        btnVerSaldo = new javax.swing.JButton();
        btnReporteGastoProyecto = new javax.swing.JButton();
        btnSubirComprobante = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClasificarGasto.setText("Clasificar Gasto");
        btnClasificarGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClasificarGastoActionPerformed(evt);
            }
        });

        btnVerSaldo.setText("Ver saldo");
        btnVerSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSaldoActionPerformed(evt);
            }
        });

        btnReporteGastoProyecto.setText("Reporte De Gasto Por Proyecto");
        btnReporteGastoProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteGastoProyectoActionPerformed(evt);
            }
        });

        btnSubirComprobante.setText("Subir comprobante");
        btnSubirComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirComprobanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnClasificarGasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReporteGastoProyecto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubirComprobante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnClasificarGasto)
                .addGap(32, 32, 32)
                .addComponent(btnVerSaldo)
                .addGap(18, 18, 18)
                .addComponent(btnReporteGastoProyecto)
                .addGap(33, 33, 33)
                .addComponent(btnSubirComprobante)
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClasificarGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClasificarGastoActionPerformed
        jfClasificarGasto.setVisible(true);
    }//GEN-LAST:event_btnClasificarGastoActionPerformed

    private void btnVerSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSaldoActionPerformed
        jfVerSaldo.setVisible(true);
    }//GEN-LAST:event_btnVerSaldoActionPerformed

    private void btnReporteGastoProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteGastoProyectoActionPerformed
        jfReporteDeGastoPorProyecto.setVisible(true);
        
    }//GEN-LAST:event_btnReporteGastoProyectoActionPerformed

    private void btnSubirComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirComprobanteActionPerformed
        jfSubirComprobante.setVisible(true);
    }//GEN-LAST:event_btnSubirComprobanteActionPerformed
    
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
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClasificarGasto;
    private javax.swing.JButton btnReporteGastoProyecto;
    private javax.swing.JButton btnSubirComprobante;
    private javax.swing.JButton btnVerSaldo;
    // End of variables declaration//GEN-END:variables
}
