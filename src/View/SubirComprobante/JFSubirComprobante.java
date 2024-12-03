
package View.SubirComprobante;

import Controller.SubirComprobante.SubirComprobante;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class JFSubirComprobante extends javax.swing.JFrame {
        private JButton btnSeleccionarArchivo;
        private JButton btnSubir;
        private JTextField txtDescripcion;
        private JLabel lblArchivoSeleccionado;
        private File archivoSeleccionado;
        
    public JFSubirComprobante() {
        initComponents();
        setTitle("Subir Comprobante");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        lblArchivoSeleccionado = new JLabel("Archivo no seleccionado");
        add(lblArchivoSeleccionado);

        btnSeleccionarArchivo = new JButton("Seleccionar Archivo");
        btnSeleccionarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    archivoSeleccionado = fileChooser.getSelectedFile();
                    lblArchivoSeleccionado.setText("Seleccionado: " + archivoSeleccionado.getName());
                }
            }
        });
        add(btnSeleccionarArchivo);
        
        txtDescripcion = new JTextField("Descripción del comprobante", 20);
        add(txtDescripcion);
        
        btnSubir = new JButton("Subir Comprobante");
        btnSubir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (archivoSeleccionado == null) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un archivo.");
                    return;
                }

                String descripcion = txtDescripcion.getText().trim();
                if (descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa una descripción.");
                    return;
                }

                SubirComprobante controlador = new SubirComprobante();
                boolean exito = controlador.subirComprobante(archivoSeleccionado, descripcion);

                if (exito) {
                    JOptionPane.showMessageDialog(null, "Comprobante subido exitosamente.");
                    lblArchivoSeleccionado.setText("Archivo no seleccionado");
                    txtDescripcion.setText("");
                    archivoSeleccionado = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Error al subir el comprobante.");
                }
            }
        });
        add(btnSubir);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 634, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 409, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JFSubirComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFSubirComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFSubirComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFSubirComprobante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFSubirComprobante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
