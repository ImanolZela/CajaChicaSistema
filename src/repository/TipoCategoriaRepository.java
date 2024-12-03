package repository;

import java.sql.Connection;
import java.util.ArrayList;

import conexion.Conexion;
import controller.TipoCategoriaController;
import model.TipoCategoriaModel;

public class TipoCategoriaRepository {

	private ArrayList<TipoCategoriaModel> tipoCategoriaArrayList;

	public ArrayList<TipoCategoriaModel> obtenerTipoCategoria() {
		Connection cnn1 = null;

		try {
			cnn1 = Conexion.conectar();
			TipoCategoriaController tipoCategoriaController = new TipoCategoriaController(cnn1);
			tipoCategoriaArrayList = tipoCategoriaController.listaTipoCategoria();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(cnn1);
		}

		return tipoCategoriaArrayList;
	}
 
}
