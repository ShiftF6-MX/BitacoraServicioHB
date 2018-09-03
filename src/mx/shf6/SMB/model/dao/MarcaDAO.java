package mx.shf6.SMB.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.SMB.model.Marca;

public class MarcaDAO implements ObjectDAO {

	@Override
	public boolean crear(Connection connection, Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	//METODO PARA HACER SELECT EN LA TABLA REPARTIDOR
	@Override
	public ArrayList<Object> leer(Connection connection, String campoBusqueda, String valorBusqueda) {
		String query ="";
		Marca marca = new Marca();
		ArrayList<Object> listaMarca = new ArrayList<Object>();
		if(campoBusqueda.isEmpty() && valorBusqueda.isEmpty()) {
			query="SELECT Sys_PK, nombre FROM repartidor ORDER BY Sys_PK;";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					marca= new Marca();
					marca.setSysPk(resultSet.getInt(1));
					marca.setDescripcion(resultSet.getString(2));
					listaMarca.add(marca);
				}
			}catch (SQLException e) {
				System.out.println("Error: En método leer");
				e.printStackTrace();
			}
		}else {
			query="SELECT Sys_PK, nombre FROM repartidor WHERE "+campoBusqueda+" = ? ORDER BY Sys_PK;";	
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, valorBusqueda);
				ResultSet resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					marca= new Marca();
					marca.setSysPk(resultSet.getInt(1));
					marca.setDescripcion(resultSet.getString(2));
					listaMarca.add(marca);
				}
			}catch (SQLException e) {
				System.out.println("Error: En método leer");
				e.printStackTrace();
			}	
		}
		return listaMarca;
	}//FIN METODO

	@Override
	public boolean modificar(Connection connection, Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Connection connection, Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

}
