package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.RegistroRendicionGastosModel;

public class RegistroRendicionGastosController {

	private final Connection cnn;
	private ArrayList<RegistroRendicionGastosModel> gastosPorCajaChicaList = new ArrayList<RegistroRendicionGastosModel>();

	public RegistroRendicionGastosController(Connection cnn) {
		this.cnn = cnn;
	}

	public void insertar(RegistroRendicionGastosModel registroRendicionGastosModel) {
		PreparedStatement sentencia = null;

		int caja_id = registroRendicionGastosModel.getCaja_id();
		int categoria_id = registroRendicionGastosModel.getCategoria_id();
		int tipo_comprobante_id = registroRendicionGastosModel.getTipo_comprobante_id();
		String num_comprobante = registroRendicionGastosModel.getNum_comprobante();
		String descripcion_gasto = registroRendicionGastosModel.getDescripcion_gasto();
		double monto = registroRendicionGastosModel.getMonto();
		String fecha_registro = registroRendicionGastosModel.getFecha_registro();
		String estado_aprobacion = registroRendicionGastosModel.getEstado_aprobacion();

		try {
			String sql = "INSERT INTO Rendicion_Gastos (caja_id, categoria_id, tipo_comprobante_id, num_comprobante, descripcion_gasto, monto, fecha_registro, estado_aprobacion) VALUES (?,?,?,?,?,?,?,?)";
			sentencia = cnn.prepareStatement(sql);
			sentencia.setInt(1, caja_id);
			sentencia.setInt(2, categoria_id);
			sentencia.setInt(3, tipo_comprobante_id);
			sentencia.setString(4, num_comprobante);
			sentencia.setString(5, descripcion_gasto);
			sentencia.setDouble(6, monto);
			sentencia.setString(7, fecha_registro);
			sentencia.setString(8, estado_aprobacion);

			sentencia.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<RegistroRendicionGastosModel> obtenerGastosPorCajaChica(int cajaId) {

		PreparedStatement sentencia = null;
		ResultSet rs = null;

		RegistroRendicionGastosModel registroGasto;

		try {
			String sql = "select * from rendicion_gastos where caja_id = ?";

			sentencia = cnn.prepareStatement(sql);

			sentencia.setInt(1, cajaId);

			rs = sentencia.executeQuery();

			while (rs.next()) {

				int caja_id = rs.getInt("caja_id");
				int categoria_id = rs.getInt("categoria_id");
				int tipo_comprobante_id = rs.getInt("tipo_comprobante_id");
				String num_comprobante = rs.getString("num_comprobante");
				String descripcion_gasto = rs.getString("descripcion_gasto");
				double monto = rs.getDouble("monto");
				String fecha_registro = rs.getString("fecha_registro");
				String estado_aprobacion = rs.getString("estado_aprobacion");

				registroGasto = new RegistroRendicionGastosModel(caja_id, categoria_id, tipo_comprobante_id,
						num_comprobante, descripcion_gasto, monto, fecha_registro, estado_aprobacion);

				gastosPorCajaChicaList.add(registroGasto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return gastosPorCajaChicaList;
	}

}
