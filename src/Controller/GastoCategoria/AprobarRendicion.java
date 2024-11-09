
package Controller.GastoCategoria;

import DAO.GastoCategoria.AprobarRendicionDAO;
import Model.Conexion;
import java.sql.Connection;

public class AprobarRendicion {
    private AprobarRendicionDAO aprobarRendicionDAO;

    public AprobarRendicion() {
        this.aprobarRendicionDAO = new AprobarRendicionDAO();
    }

    public boolean aprobarRendicion(int rendicionId) {
        if (rendicionId <= 0) {
            System.out.println("ID de rendición inválido.");
            return false;
        }

        Connection conn = Conexion.conectar(); 
        try {
            return aprobarRendicionDAO.aprobarRendicion(conn, rendicionId);
        } finally {
            Conexion.desconectar();
        }
    }
}
