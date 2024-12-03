package repository;

import java.sql.Connection;
import java.util.ArrayList;

import conexion.Conexion;
import controller.RegistroCajaChicaController;
import model.RegistroCajaChicaModel;

public class RegistroCajaChicaRepository {

	private RegistroCajaChicaModel registroCajaChicaProyecto;
	private ArrayList<RegistroCajaChicaModel> cajasChicasArrayList;

	public void guardar(RegistroCajaChicaModel registroCajaChica) {
		Connection cnn = null;

		try {
			cnn = Conexion.conectar();
			RegistroCajaChicaController registroCajaChicaController = new RegistroCajaChicaController(cnn);
			registroCajaChicaController.insertar(registroCajaChica);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn);
		}
	}
 
	public RegistroCajaChicaModel listarProyecto(int usuario_id) {
		Connection cnn = null;

		try {
			cnn = Conexion.conectar();
			RegistroCajaChicaController registroCajaChicaController = new RegistroCajaChicaController(cnn);
			registroCajaChicaProyecto = registroCajaChicaController.listarCajaPorUsuario(usuario_id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn);
		}

		return registroCajaChicaProyecto;
	}

	public ArrayList<RegistroCajaChicaModel> listarCajasAbiertas() {
		Connection cnn = null;

		try {
			cnn = Conexion.conectar();
			RegistroCajaChicaController registroCajaChicaController = new RegistroCajaChicaController(cnn);
			cajasChicasArrayList = registroCajaChicaController.listarCajasAbiertas();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn);
		}

		return cajasChicasArrayList;
	}

}
