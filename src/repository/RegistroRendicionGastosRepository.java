package repository;

import java.sql.Connection;
import java.util.ArrayList;

import conexion.Conexion;
import controller.RegistroRendicionGastosController;
import model.RegistroRendicionGastosModel;

public class RegistroRendicionGastosRepository {

	private ArrayList<RegistroRendicionGastosModel> gastosPorCajaChicaList = new ArrayList<RegistroRendicionGastosModel>();

	public void guardar(RegistroRendicionGastosModel registroRendicionGastosModel) {
		Connection cnn = null;

		try {
			cnn = Conexion.conectar();
			RegistroRendicionGastosController registroRendicionGastosController = new RegistroRendicionGastosController(
					cnn);
			registroRendicionGastosController.insertar(registroRendicionGastosModel);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn);
		}
 
	}

	public ArrayList<RegistroRendicionGastosModel> obtenerGastosPorCajaChicaPorId(int cajaId) {

		Connection cnn = null;

		try {
			cnn = Conexion.conectar();
			RegistroRendicionGastosController registroRendicionGastosController = new RegistroRendicionGastosController(
					cnn);
			gastosPorCajaChicaList = registroRendicionGastosController.obtenerGastosPorCajaChica(cajaId);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn);
		}

		return gastosPorCajaChicaList;
	}

}
