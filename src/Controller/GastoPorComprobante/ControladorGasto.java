package Controller.GastoPorComprobante;

import DAO.GastoPorComprobante.RendicionGastosDAO;
import Model.Rendicion_Gastos;

import java.util.Date;

public class ControladorGasto {

    private RendicionGastosDAO rendicionDAO;

    public ControladorGasto() {
        this.rendicionDAO = new RendicionGastosDAO();
    }

    public void guardarGasto(String tipoComprobante, String descripcionBoleta, Date fechaBoleta,
                             String numeroComprobante, String descripcionGasto, String montoDeGasto, 
                             Date fechaDeGasto) {

        double monto = Double.parseDouble(montoDeGasto);
        Rendicion_Gastos rendicion = new Rendicion_Gastos(0, 1, 1, tipoComprobante, numeroComprobante, descripcionGasto,
                                                          monto, fechaDeGasto, 1, "Pendiente");

        rendicionDAO.insertarRendicionGastos(rendicion);
    }
}
