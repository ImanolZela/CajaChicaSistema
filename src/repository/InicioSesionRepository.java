package repository;

import java.sql.Connection;

import javax.swing.JFrame;

import conexion.Conexion;

import utilitarios.CajaException;
import View.Menu;

import controller.UsuarioController;

public class InicioSesionRepository {

	public void iniciarSesion(String correo, String clave) throws CajaException {

		Connection cnn = null;

		try {
			cnn = Conexion.conectar();
			UsuarioController usuarioController = new UsuarioController(cnn);
			int usuario_id = usuarioController.iniciarSesion(correo, clave);
			// JOptionPane.showMessageDialog(null, "Inicio de sesion correcto");
			Menu menu = new Menu(usuario_id);
			menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
			menu.setVisible(true);
		} finally {
			Conexion.cerrar(cnn);
		}
	}
 
}
