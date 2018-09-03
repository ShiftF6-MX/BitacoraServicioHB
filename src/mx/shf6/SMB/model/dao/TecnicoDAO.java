package mx.shf6.SMB.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.SMB.model.Tecnico;


public class TecnicoDAO implements ObjectDAO{

	@Override
	public boolean crear(Connection connection, Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	//METODO PARA HACER SELECT EN LA TABLA PORTEADOR
	@Override
	public ArrayList<Object> leer(Connection connection, String campoBusqueda, String valorBusqueda) {
		String query ="";
		Tecnico tecnico = new Tecnico();
		ArrayList<Object> listaTecnico = new ArrayList<Object>();
		if(campoBusqueda.isEmpty() && valorBusqueda.isEmpty()) {
			query="SELECT Sys_PK, nombre FROM agente ORDER BY Sys_PK;";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					tecnico= new Tecnico();
					tecnico.setSysPk(resultSet.getInt(1));
					tecnico.setNombre(resultSet.getString(2));
					listaTecnico.add(tecnico);
				}
			}catch (SQLException e) {
				System.out.println("Error: En método leer");
				e.printStackTrace();
			}
		}else {
			query="SELECT Sys_PK, nombre FROM agente WHERE "+campoBusqueda+" = ? ORDER BY Sys_PK;";	
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, valorBusqueda);
				ResultSet resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					tecnico= new Tecnico();
					tecnico.setSysPk(resultSet.getInt(1));
					tecnico.setNombre(resultSet.getString(2));
					listaTecnico.add(tecnico);
				}
			}catch (SQLException e) {
				System.out.println("Error: En método leer");
				e.printStackTrace();
			}	
		}
		return listaTecnico;
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
