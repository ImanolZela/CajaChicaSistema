
package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static Connection conn = null;
    private static String url = "jdbc:sqlite:bd/sistemacajachica.sqlite";
    private static String driver = "org.sqlite.JDBC";

    public static Connection conectar() {
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url);
                System.out.println("Conexión establecida a la base de datos SQLite");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }

    public static void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
