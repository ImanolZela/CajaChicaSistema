package View.Registros;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.RegistroCajaChicaModel;
import model.RegistroRendicionGastosModel;
import repository.RegistroCajaChicaRepository;
import repository.RegistroRendicionGastosRepository;
import utilitarios.VariablesGlobales;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AprobacionGastos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;

	private ArrayList<RegistroCajaChicaModel> cajasChicasArrayList;
	private ArrayList<RegistroRendicionGastosModel> obtenerGastosPorCajaChicaPorIdList;
	
	DefaultTableModel model; // manejador de elementos dentro de la tabla

	// Constructor
	public AprobacionGastos() {

		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("AprobacionGastos");
		setBounds(100, 100, 686, 292);
		getContentPane().setLayout(null);

		JComboBox<RegistroCajaChicaModel> cbmProyectos = new JComboBox<RegistroCajaChicaModel>();
		cbmProyectos.setBounds(136, 12, 171, 26);
		getContentPane().add(cbmProyectos);

		JLabel lblProyecto = new JLabel("Proyecto");
		lblProyecto.setBounds(41, 17, 60, 17);
		getContentPane().add(lblProyecto);

		JButton btnAprobar = new JButton("Aprobar");
		btnAprobar.setBounds(343, 12, 105, 27);
		getContentPane().add(btnAprobar);

		JLabel lblUsuarioAsignado = new JLabel("Usuario asignado");
		lblUsuarioAsignado.setBounds(41, 61, 137, 25);
		getContentPane().add(lblUsuarioAsignado);

		JLabel lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(SystemColor.activeCaption);
		lblNombre.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblNombre.setBounds(152, 63, 99, 21);
		getContentPane().add(lblNombre);

		JLabel lblMontoGastado = new JLabel("0");
		lblMontoGastado.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontoGastado.setForeground(SystemColor.activeCaption);
		lblMontoGastado.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblMontoGastado.setBounds(349, 227, 123, 21);
		getContentPane().add(lblMontoGastado);

		JLabel lblUsuarioAsignado_1 = new JLabel("Total gastado");
		lblUsuarioAsignado_1.setBounds(190, 225, 137, 25);
		getContentPane().add(lblUsuarioAsignado_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 98, 512, 115);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Categoria", "T. Comprobante", "N. Comprobante", "Descripcion", "Monto" }));
		scrollPane.setViewportView(table);

		JLabel lblMontoDeLa = new JLabel("Monto de la caja chica");
		lblMontoDeLa.setBounds(390, 61, 137, 25);
		getContentPane().add(lblMontoDeLa);

		JLabel lblMontocajachica = new JLabel("0");
		lblMontocajachica.setHorizontalAlignment(SwingConstants.CENTER);
		lblMontocajachica.setForeground(SystemColor.activeCaption);
		lblMontocajachica.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		lblMontocajachica.setBounds(557, 63, 99, 21);
		getContentPane().add(lblMontocajachica);

		// metodos

		// método gatillado al mostrar la ventana
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {

				cajasChicasArrayList = new RegistroCajaChicaRepository().listarCajasAbiertas();

				cbmProyectos.addItem(new RegistroCajaChicaModel());
				for (RegistroCajaChicaModel cajaChica : cajasChicasArrayList) {
					cbmProyectos.addItem(cajaChica);
				}
			}
		});

		// metodo asociado a la seleccion de un elemento del combobox
		cbmProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int montoTotal = 0;
				int cajaIdTemp = 0;
				int usuarioId_t = 0;
				
				RegistroCajaChicaModel seleccionado = (RegistroCajaChicaModel) cbmProyectos.getSelectedItem();
				usuarioId_t = seleccionado.getUsuario_id();
				
				// Acceder al modelo de la tabla
				model = (DefaultTableModel) table.getModel();
				
				if(seleccionado.toString() != null) {
					
					System.out.println("primer item seleccionado" + seleccionado.getUsuario_id());
					RegistroCajaChicaModel miCajaChica = new RegistroCajaChicaRepository().listarProyecto(usuarioId_t);
					
					VariablesGlobales.CAJA_CHICA_ID = miCajaChica.getCaja_id();
					
					lblNombre.setText(miCajaChica.getNombre_proyecto());
					lblMontocajachica.setText(String.valueOf(miCajaChica.getMonto_asignado()));
					
				}

				

				
				
				
				

				

				
				cajaIdTemp = seleccionado.getCaja_id();

				obtenerGastosPorCajaChicaPorIdList = new RegistroRendicionGastosRepository()
						.obtenerGastosPorCajaChicaPorId(cajaIdTemp);

				for (RegistroRendicionGastosModel registroGastosPorCajaChica : obtenerGastosPorCajaChicaPorIdList) {
					
					int categoria_id = registroGastosPorCajaChica.getCategoria_id();
					int tipo_comprobante_id = registroGastosPorCajaChica.getTipo_comprobante_id();
					String num_comprobante = registroGastosPorCajaChica.getNum_comprobante();
					String descripcion_gasto = registroGastosPorCajaChica.getDescripcion_gasto();
					double monto = registroGastosPorCajaChica.getMonto();
					
					model.addRow(new Object[] { String.valueOf(categoria_id), String.valueOf(tipo_comprobante_id),
							num_comprobante, descripcion_gasto, String.valueOf(monto) });
					montoTotal += registroGastosPorCajaChica.getMonto();
				}

				lblMontoGastado.setText(String.valueOf(montoTotal));

			}
		});
		
		// boton 
		btnAprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ralizado");
			}
		});

	}
}
