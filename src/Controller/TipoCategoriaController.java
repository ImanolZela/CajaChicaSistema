package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import model.TipoCategoriaModel;

public class TipoCategoriaController {

	private final Connection cnn4;
	private ArrayList<TipoCategoriaModel> tipoCategoriaArrayList;

	public TipoCategoriaController(Connection cnn) {
		this.cnn4 = cnn;
	}

	public ArrayList<TipoCategoriaModel> listaTipoCategoria() {
		Statement st4 = null;
		ResultSet rs4 = null;

		TipoCategoriaModel tipoCategoria;
		tipoCategoriaArrayList = new ArrayList<>();

		try {
			String sql = "select * from Categoria_Gasto";
			st4 = cnn4.createStatement();
			rs4 = st4.executeQuery(sql);

			while (rs4.next()) {
				int categoria_id = rs4.getInt("categoria_id");
				String nombre_categoria = rs4.getString("nombre_categoria");
				tipoCategoria = new TipoCategoriaModel(categoria_id, nombre_categoria);
				tipoCategoriaArrayList.add(tipoCategoria);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Conexion.cerrar(st4, rs4);
		}

		return tipoCategoriaArrayList;

	}

}
