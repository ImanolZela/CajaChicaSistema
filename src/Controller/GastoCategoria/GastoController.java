
package Controller.GastoCategoria;

import DAO.GastoCategoria.RendicionGastosDAO;
import Model.Rendicion_Gastos;
import Model.Conexion;

import java.sql.Connection;
import java.util.List;

public class GastoController {
    private RendicionGastosDAO gastosDAO;
    private ReporteGastosPDF reportePDF;

    public GastoController() {
        this.gastosDAO = new RendicionGastosDAO();
        reportePDF = new ReporteGastosPDF();
    }

   
    public List<Rendicion_Gastos> obtenerTodosLosGastos() {
        Connection conn = Conexion.conectar();
        try {
            return gastosDAO.obtenerTodosLosGastos(conn);
        } finally {
            Conexion.desconectar();
        }
    }

    public List<Rendicion_Gastos> filtrarPorCategoria(int categoriaId) {
        Connection conn = Conexion.conectar();
        List<Rendicion_Gastos> lista = gastosDAO.filtrarGastosPorCategoria(conn, categoriaId);
        Conexion.desconectar(); 
        return lista;
    }

    public List<Rendicion_Gastos> procesarFiltrado(String filtroSeleccionado, String categoriaSeleccionada) {
        if ("Categoria".equals(filtroSeleccionado)) {
            int categoriaId = obtenerIdCategoria(categoriaSeleccionada);
            return ordenarPorCategoria(filtrarPorCategoria(categoriaId));
        } else if ("Precio".equals(filtroSeleccionado)) {
            return ordenarPorMonto(obtenerTodosLosGastos());
        }
        return obtenerTodosLosGastos();
    }

    public List<Rendicion_Gastos> ordenarPorMonto(List<Rendicion_Gastos> listaGastos) {
        int n = listaGastos.size();

        for (int i = 0; i < n - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < n; j++) {
                if (listaGastos.get(j).getMonto() < listaGastos.get(indexMin).getMonto()) {
                    indexMin = j;
                }
            }

            Rendicion_Gastos temp = listaGastos.get(i);
            listaGastos.set(i, listaGastos.get(indexMin));
            listaGastos.set(indexMin, temp);
        }
        return listaGastos;
    }

    public List<Rendicion_Gastos> ordenarPorCategoria(List<Rendicion_Gastos> listaGastos) {
        int n = listaGastos.size();

        for (int i = 1; i < n; i++) {
            Rendicion_Gastos key = listaGastos.get(i);
            int j = i - 1;


            while (j >= 0 && listaGastos.get(j).getCategoria_id() > key.getCategoria_id()) {
                listaGastos.set(j + 1, listaGastos.get(j));
                j = j - 1;
            }
            listaGastos.set(j + 1, key);
        }
        return listaGastos;
    }

    public int obtenerIdCategoria(String nombreCategoria) {
        switch (nombreCategoria) {
            case "Alimentacion":
                return 1;  
            case "Transporte":
                return 2;
            case "Hospedaje":
                return 3;
            case "Otros":
                return 4;
            default:
                return 0;
        }
    }
    
}
