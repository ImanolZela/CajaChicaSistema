package View;

import View.CajaChica.MovimientosDeCajaChica.JFMovimientosDeCajaChica;
import View.EstadoCuentaMensualCajaChica.JFEstadoCuentaMensualCajaChica;
import View.GastoCategoria.JFClasificarGasto;
import View.GastosPorComprobante.RegistrarGasto;
import View.Registros.AprobacionGastos;
import View.Registros.RecuperarContrasena;
import View.Registros.RegistarUsuario;
import View.Registros.RegistroCajaChica;
import View.Registros.RegistroProyecto;
import View.Registros.RegistroRendicionGastos;
import View.ReporteDeGasto.JFReporteDeGastoPorAuditor;
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
        
        
        //Dylan
        private JFMovimientosDeCajaChica cajaChica_JFMovimientosDeCajaChica;
        private JFEstadoCuentaMensualCajaChica cajaChica_JFEstadoCuentaMensualCajaChica;
        private JFVerSaldo cajaChica_JFVerSaldo;
        private JFReporteDeGastoPorAuditor reportes_JFReporteDeGastoPorAuditor;
        private JFReporteDeGastoPorProyecto reportes_JFReporteDeGastoPorProyecto;
        
        // Imanol
        private JFClasificarGasto reportes_JFClasificarGasto; //4req
        private RegistrarGasto rendicion_RegistrarGasto; //1req
        private JFSubirComprobante rendicion_JFSubirComprobante; //1req

                
        
        //CajaChica
        //Rendicion
        //Reportes
        
        
        
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
                
                //--------
                JMenuItem mntmMovimientosDeCajaChica = new JMenuItem("Movimientos de Caja");
		mnCajaChica.add(mntmMovimientosDeCajaChica);

                JMenuItem mntmEstadoCuentaMensualCajaChica = new JMenuItem("Estado Cuenta Mensual");
		mnCajaChica.add(mntmEstadoCuentaMensualCajaChica);
        
                JMenuItem mntmVerSaldo = new JMenuItem("Verificar Saldo");
		mnCajaChica.add(mntmVerSaldo);
                
                
                
                //Menu Rendición
		JMenu mnRendirComprobantes = new JMenu("Rendicion");
		menuBar.add(mnRendirComprobantes);

		JMenuItem mntmRegistrarComprobante = new JMenuItem("Registrar Comprobantes");
		mnRendirComprobantes.add(mntmRegistrarComprobante);

		JMenuItem mntmAprobarRendiciones = new JMenuItem("Aprobar Rendiciones");
		mnRendirComprobantes.add(mntmAprobarRendiciones);
                //ImanolReq
                JMenuItem mntmRegistrarGasto = new JMenuItem("Registrar Gasto");
		mnRendirComprobantes.add(mntmRegistrarGasto);

                JMenuItem mntmSubirComprobante = new JMenuItem("Subir Comprobante");
		mnRendirComprobantes.add(mntmAprobarRendiciones);

                
        
                //Menu Reporte
		JMenu mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		JMenuItem mntmHistorialCajaChica = new JMenuItem("Historial Caja Chica");
		mnReportes.add(mntmHistorialCajaChica);
                
                JMenuItem mntmReporteDeGastoPorAuditor = new JMenuItem("Reporte Gasto Auditor");
		mnReportes.add(mntmReporteDeGastoPorAuditor);
                
                JMenuItem mntmReporteDeGastoPorProyecto = new JMenuItem("Reporte Gasto Proyecto");
		mnReportes.add(mntmReporteDeGastoPorProyecto);
                
                JMenuItem mntmClasificarGasto = new JMenuItem("Clasificar Gasto");
		mnReportes.add(mntmClasificarGasto);
                
                
                
                
                //Declaración para las clases que utilizan, JinternalFrame
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
                //cajaChica_JFMovimientosDeCajaChica;
                //cajaChica_JFEstadoCuentaMensualCajaChica;
                //cajaChica_JFVerSaldo;
                //reportes_JFReporteDeGastoPorAuditor;
                //reportes_JfReporteDeGastoPorProyecto;
                //reportes_JFClasificarGasto;
                //rendicion_RegistrarGasto;
                //rendicion_JFSubirComprobante;
                
                mntmVerSaldo.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        cajaChica_JFVerSaldo = new JFVerSaldo();
                        cajaChica_JFVerSaldo.setVisible(true);
                    }
                });

                mntmMovimientosDeCajaChica.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        cajaChica_JFMovimientosDeCajaChica = new JFMovimientosDeCajaChica();
                        cajaChica_JFMovimientosDeCajaChica.setVisible(true);
                    }
                });

                mntmEstadoCuentaMensualCajaChica.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        cajaChica_JFEstadoCuentaMensualCajaChica = new JFEstadoCuentaMensualCajaChica();
                        cajaChica_JFEstadoCuentaMensualCajaChica.setVisible(true);
                    }
                });

                mntmReporteDeGastoPorAuditor.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        reportes_JFReporteDeGastoPorAuditor = new JFReporteDeGastoPorAuditor();
                        reportes_JFReporteDeGastoPorAuditor.setVisible(true);
                    }
                });

                mntmReporteDeGastoPorProyecto.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        reportes_JFReporteDeGastoPorProyecto = new JFReporteDeGastoPorProyecto();
                        reportes_JFReporteDeGastoPorProyecto.setVisible(true);
                    }
                });

                mntmClasificarGasto.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        reportes_JFClasificarGasto = new JFClasificarGasto();
                        reportes_JFClasificarGasto.setVisible(true);
                    }
                });

                mntmRegistrarGasto.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        rendicion_RegistrarGasto = new RegistrarGasto();
                        rendicion_RegistrarGasto.setVisible(true);
                    }
                });

                mntmSubirComprobante.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        rendicion_JFSubirComprobante = new JFSubirComprobante();
                        rendicion_JFSubirComprobante.setVisible(true);
                    }
                });

                
                
                
	}
}

                
                