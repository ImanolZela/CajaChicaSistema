package repository;

import java.sql.Connection;
import java.util.ArrayList;

import conexion.Conexion;
import controller.UsuarioController;
import model.Usuario;
import utilitarios.CajaException;
 
public class UsuarioRepository {

	private ArrayList<Usuario> usuarioArrayList;

	public void guardar(Usuario usuario) throws CajaException {

		Connection cnn = null;
		try {
			cnn = Conexion.conectar();
			UsuarioController usuarioController = new UsuarioController(cnn);
			usuarioController.insertar(usuario);

		} finally {
			Conexion.cerrar(cnn);
		}
	}

	public ArrayList<Usuario> listarUsuarios() {
		Connection cnn = null;

		try {
			cnn = Conexion.conectar();
			UsuarioController usuarioController = new UsuarioController(cnn);
			usuarioArrayList = usuarioController.listaUsuarios();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn);
		}

		return usuarioArrayList;
	}

	public void actualizarPassword(Usuario usuario) {
		Connection cnn = null;

		try {
			cnn = Conexion.conectar();
			UsuarioController usuarioController = new UsuarioController(cnn);
			usuarioController.actualizarPassword(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn);
		}
	}

}
