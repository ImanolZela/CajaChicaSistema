package View;

import View.EstadoCuentaMensualCajaChica.JFEstadoCuentaMensualCajaChica;
import View.GastoCategoria.JFClasificarGasto;
import View.Registros.AprobacionGastos;
import View.Registros.RecuperarContrasena;
import View.Registros.RegistarUsuario;
import View.Registros.RegistroCajaChica;
import View.Registros.RegistroProyecto;
import View.Registros.RegistroRendicionGastos;
import View.ReporteDeGasto.JFReporteDeGastoPorProyecto;
import View.SubirComprobante.JFSubirComprobante;
import View.VerSaldo.JFVerSaldo;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.UIManager;
import utilitarios.VariablesGlobales;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private RegistroCajaChica reg_caja_chica;
	private RegistroRendicionGastos reg_rendicion_gastos;
	private RegistroProyecto reg_proyecto;
	private RecuperarContrasena recup_contrasena;
	private RegistarUsuario reg_usuario;
	private AprobacionGastos reg_aprobacion_gastos;
        
        
        // Imanol and Dylan
        //Caja chica
        private JFVerSaldo cajaChica_jFVerSAldo;
        private JFEstadoCuentaMensualCajaChica cajaChhica;
        
        //Rendicion
        private JFSubirComprobante jfSubirComprobante = new JFSubirComprobante();
        
        
        //Reportes
        private JFClasificarGasto reportes_jfClasificarGasto;
        private JFReporteDeGastoPorProyecto reportes_jfReporteDeGastoPorProyecto;
        private JFReporteDeGastoPorProyecto reportes_JFReporteDeGastoPorAuditor;

	/**
	 * Create the frame.
	 */
	public Menu(int usuario_id) {
		
		VariablesGlobales.USUARIO_ID = usuario_id;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 413);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);

		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu.this.dispose();
			}
		});

		JMenuItem mntmRegistrarUsuario = new JMenuItem("Registrar Usuario");
		mnSistema.add(mntmRegistrarUsuario);

		JMenuItem mntmRecuperarContrasea = new JMenuItem("Recuperar contraseña");
		mnSistema.add(mntmRecuperarContrasea);
		mnSistema.add(mntmCerrar);
                
                
                //Menu Caja Chica
		JMenu mnCajaChica = new JMenu("Caja Chica");
		menuBar.add(mnCajaChica);

		JMenuItem mntmRegistraCajaChica = new JMenuItem("Registrar Caja Chica");
		mnCajaChica.add(mntmRegistraCajaChica);

		JMenuItem mntmRegistroProyecto = new JMenuItem("Registrar Proyecto");
		mnCajaChica.add(mntmRegistroProyecto);
                
                //Dylan req
                JMenuItem mntmVerSaldo = new JMenuItem("Ver Saldo");
		mnCajaChica.add(mntmVerSaldo);

                JMenuItem mntmEstadoCuentaMensualCajaChica = new JMenuItem("Estado Cuenta Mensual");
		mnCajaChica.add(mntmEstadoCuentaMensualCajaChica);
        
                
                //Menu Rendición
		JMenu mnRendirComprobantes = new JMenu("Rendicion");
		menuBar.add(mnRendirComprobantes);

		JMenuItem mntmRegistrarComprobante = new JMenuItem("Registrar Comprobantes");
		mnRendirComprobantes.add(mntmRegistrarComprobante);

		JMenuItem mntmAprobarRendiciones = new JMenuItem("Aprobar Rendiciones");
		mnRendirComprobantes.add(mntmAprobarRendiciones);
                //ImanolReq
                JMenuItem mntmSubirComprobante = new JMenuItem("Subir Comprobante");
		mnRendirComprobantes.add(mntmAprobarRendiciones);

                
/*
        //Rendicion
        private JFSubirComprobante jfSubirComprobante = new JFSubirComprobante();
        
        
        //Reportes
        private JFClasificarGasto reportes_jfClasificarGasto;
        private JFReporteDeGastoPorProyecto reportes_jfReporteDeGastoPorProyecto;
        private JFReporteDeGastoPorProyecto reportes_JFReporteDeGastoPorAuditor;
mntmEstadoCuentaMensualCajaChica
mntmAprobarRendiciones
*/

        
                //Menu Reporte
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		JMenuItem mntmHistorialCajaChica = new JMenuItem("Historial Caja Chica");
		mnReportes.add(mntmHistorialCajaChica);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JDesktopPane escritorio = new JDesktopPane();
		escritorio.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		contentPane.add(escritorio, "name_53079116797437");
		escritorio.setLayout(null);

                
                
                //Listeners
		mntmRegistraCajaChica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg_caja_chica = new RegistroCajaChica();

				Dimension desktopSize = escritorio.getSize();
				Dimension frameSize = reg_caja_chica.getSize();

				reg_caja_chica.setLocation((desktopSize.width - frameSize.width) / 2,
						(desktopSize.height - frameSize.height) / 2);
				escritorio.add(reg_caja_chica);
				reg_caja_chica.setVisible(true);
			}
		});

		mntmRegistroProyecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg_proyecto = new RegistroProyecto();

				Dimension desktopSize = escritorio.getSize();
				Dimension frameSize = reg_proyecto.getSize();

				reg_proyecto.setLocation((desktopSize.width - frameSize.width) / 2,
						(desktopSize.height - frameSize.height) / 2);
				escritorio.add(reg_proyecto);
				reg_proyecto.setVisible(true);
			}
		});

		mntmRegistrarComprobante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg_rendicion_gastos = new RegistroRendicionGastos();

				Dimension desktopSize = escritorio.getSize();
				Dimension frameSize = reg_rendicion_gastos.getSize();
				reg_rendicion_gastos.setLocation((desktopSize.width - frameSize.width) / 2,
						(desktopSize.height - frameSize.height) / 2);
				escritorio.add(reg_rendicion_gastos);
				reg_rendicion_gastos.setVisible(true);

			}
		});

		mntmRecuperarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recup_contrasena = new RecuperarContrasena();

				Dimension desktopSize = escritorio.getSize();
				Dimension frameSize = recup_contrasena.getSize();
				recup_contrasena.setLocation((desktopSize.width - frameSize.width) / 2,
						(desktopSize.height - frameSize.height) / 2);
				escritorio.add(recup_contrasena);
				recup_contrasena.setVisible(true);
			}
		});

		mntmRegistrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reg_usuario = new RegistarUsuario();

				Dimension desktopSize = escritorio.getSize();
				Dimension frameSize = reg_usuario.getSize();
				reg_usuario.setLocation((desktopSize.width - frameSize.width) / 2,
						(desktopSize.height - frameSize.height) / 2);
				escritorio.add(reg_usuario);
				reg_usuario.setVisible(true);
			}
		});

		mntmAprobarRendiciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reg_aprobacion_gastos = new AprobacionGastos();

				Dimension desktopSize = escritorio.getSize();
				Dimension frameSize = reg_aprobacion_gastos.getSize();
				reg_aprobacion_gastos.setLocation((desktopSize.width - frameSize.width) / 2,
						(desktopSize.height - frameSize.height) / 2);
				escritorio.add(reg_aprobacion_gastos);
				reg_aprobacion_gastos.setVisible(true);
			}
		});
                
                
                
                //Dylan and Imanol Code:
                
               mntmVerSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cajaChica_jFVerSAldo = new JFVerSaldo();
				cajaChica_jFVerSAldo.setVisible(true);
			}
		});
                

	}
}
