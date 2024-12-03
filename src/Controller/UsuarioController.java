package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import model.Usuario;
import utilitarios.CajaException;

public class UsuarioController {

	private final Connection cnn;
	private ArrayList<Usuario> usuariosArrayList;

	public UsuarioController(Connection cnn) {
		this.cnn = cnn;
	}

	public void insertar(Usuario usuario) throws CajaException {
		PreparedStatement sentencia = null;

		try {
			String sql = "INSERT INTO Usuarios (rol_id, nombres, apellidos, dni_ce, correo, direccion, password, fecha_registro) VALUES (?,?,?,?,?,?,?,?)";
			sentencia = cnn.prepareStatement(sql);
			sentencia.setInt(1, usuario.getRol_id());
			sentencia.setString(2, usuario.getNombres());
			sentencia.setString(3, usuario.getApellidos());
			sentencia.setString(4, usuario.getDni_ce());
			sentencia.setString(5, usuario.getCorreo());
			sentencia.setString(6, usuario.getDireccion());
			sentencia.setString(7, usuario.getPassword());
			sentencia.setString(8, usuario.getFecha_registro());

			sentencia.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
			// throw new CajaException(-2, "Error al insertar el usuario");
		} finally {
			Conexion.cerrar(sentencia);
		}
	}

	public int iniciarSesion(String correo, String clave) throws CajaException {
		PreparedStatement sentencia = null;
		ResultSet resultado = null;

		int usuario_id;

		try {
			sentencia = cnn.prepareStatement("SELECT * FROM Usuarios WHERE correo = ? AND password = ?");
			sentencia.setString(1, correo);
			sentencia.setString(2, clave);

			resultado = sentencia.executeQuery();

			if (resultado.next()) {
				usuario_id = resultado.getInt("usuario_id");
				return usuario_id;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(sentencia, resultado);
		}
		throw new CajaException(-5, "Error en el correo y/o clave");
	}

	public ArrayList<Usuario> listaUsuarios() {

		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		Usuario usuario;
		usuariosArrayList = new ArrayList<Usuario>();

		try {
			sentencia = cnn.prepareStatement("select * from usuarios where correo not like ?");
			sentencia.setString(1, "a");

			resultado = sentencia.executeQuery();

			while (resultado.next()) {
				int usuario_id = resultado.getInt("usuario_id");
				String nombres = resultado.getString("nombres");
				String apellidos = resultado.getString("apellidos");
				String correo = resultado.getString("correo");
				String password = resultado.getString("password");
				usuario = new Usuario(usuario_id, nombres, apellidos, correo, password);

				usuariosArrayList.add(usuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(sentencia, resultado);
		}

		return usuariosArrayList;
	}

	public void actualizarPassword(Usuario usuario) {
		PreparedStatement sentencia = null;

		String password = usuario.getPassword();
		String correo = usuario.getCorreo();

		try {
			sentencia = cnn.prepareStatement("UPDATE Usuarios SET password = ? WHERE correo LIKE ?");

			sentencia.setString(1, password);
			sentencia.setString(2, correo);

			sentencia.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(sentencia);
		}
	}

}
