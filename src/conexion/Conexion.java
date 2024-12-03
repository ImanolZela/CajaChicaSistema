package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import utilitarios.CajaException;

public class Conexion {

	public static Connection conectar() throws CajaException {

		try {
			Class.forName("org.sqlite.JDBC");
			Connection cnn = DriverManager
					.getConnection("jdbc:sqlite:bd/sistemacajachica.sqlite");
			return cnn;
		} catch (ClassNotFoundException | SQLException e) {
			Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
			throw new CajaException(-1, "Error al conectar a la base de datos");
		}
	}

	public static void cerrar(Connection cnn, Statement st, PreparedStatement sentencia, ResultSet resultado) {
		try {
			if (resultado != null) {
				resultado.close();
			}
			if (st != null) {
				st.close();
			}
			if (sentencia != null) {
				sentencia.close();
			}
			if (cnn != null) {
				cnn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void cerrar(Connection cnn) {
		cerrar(cnn, null, null, null);
	}

	public static void cerrar(Statement st) {
		cerrar(null, st, null, null);
	}

	public static void cerrar(PreparedStatement sentencia) {
		cerrar(null, null, sentencia, null);
	}

	public static void cerrar(PreparedStatement sentencia, ResultSet resultado) {
		cerrar(null, null, sentencia, resultado);
	}

	public static void cerrar(Statement st, ResultSet resultado) {
		cerrar(null, st, null, resultado);
	}
}
