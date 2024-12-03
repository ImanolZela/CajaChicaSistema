package repository;

import java.sql.Connection;
import java.util.ArrayList;

import conexion.Conexion;
import controller.Rol_Usuario_Controller;
import model.Rol_Usuario;

public class Rol_Usuario_Repository {

	private ArrayList<Rol_Usuario> rolUsuarioArrayList;

	public ArrayList<Rol_Usuario> obtenerRoles() {
		Connection cnn = null;

		try {
			cnn = Conexion.conectar();
			Rol_Usuario_Controller rolUsuarioController = new Rol_Usuario_Controller(cnn);
			rolUsuarioArrayList = rolUsuarioController.listaRolUsuario();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn);
		}
		return rolUsuarioArrayList;
	}
 
}
