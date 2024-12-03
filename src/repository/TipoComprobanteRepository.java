package repository;

import java.sql.Connection;
import java.util.ArrayList;

import conexion.Conexion;
import controller.TipoComprobanteController;
import model.TipoComprobanteModel;

public class TipoComprobanteRepository {
 
	private ArrayList<TipoComprobanteModel> tipoComprobanteArrayList;

	public ArrayList<TipoComprobanteModel> obtenerTipoComprobante() {
		Connection cnn2 = null;

		try {
			cnn2 = Conexion.conectar();
			TipoComprobanteController tipoComprobanteController = new TipoComprobanteController(cnn2);
			tipoComprobanteArrayList = tipoComprobanteController.listaTipoComprobante();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn2);
		}
		return tipoComprobanteArrayList;
	}

}
