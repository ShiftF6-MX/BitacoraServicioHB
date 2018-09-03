package mx.shf6.SMB.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.SMB.model.Cliente;
import mx.shf6.SMB.model.Marca;
import mx.shf6.SMB.model.Modelo;
import mx.shf6.SMB.model.Tecnico;
import mx.shf6.SMB.model.Venta;

public class VentaDAO implements ObjectDAO {

	@Override
	public boolean crear(Connection connection, Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//METODO PARA HACER SELECT EN LA TABLA VENTAS
		@Override
		public ArrayList<Object> leer(Connection connection, String campoBusqueda, String valorBusqueda) {
			String query ="";
			Venta venta = new Venta();
			ArrayList<Object> listaVenta = new ArrayList<Object>();
			if(campoBusqueda.isEmpty() && valorBusqueda.isEmpty()) {
				query="SELECT Sys_PK, Referencia, Fecha, ICliente, IAgente, IRepartidor, "
						+ "IPorteador, DomicilioEntrega, txtGuia, PComision, Notas "
						+ "FROM venta ORDER BY Fecha DESC";
				try {
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(query);
					while (resultSet.next()) {
						venta = new Venta();
						venta.setSysPk(resultSet.getInt(1));
						venta.setReferencia(resultSet.getString(2));
						venta.setFecha(resultSet.getDate(3));
						ClienteDAO clienteDAO = new ClienteDAO();
						Cliente cliente = null;
						ArrayList <Object> resultadoCliente = clienteDAO.leer(connection, "Sys_PK", resultSet.getString(4));
						cliente= (Cliente) resultadoCliente.get(0);
						venta.setCliente(cliente);
						TecnicoDAO tecnicoDAO = new TecnicoDAO();
						Tecnico tecnico = null;						
						ArrayList <Object> resultadoTecnico = tecnicoDAO.leer(connection, "Sys_PK", resultSet.getString(5));						
						tecnico= (Tecnico) resultadoTecnico.get(0);						
						venta.setTecnico(tecnico);
						MarcaDAO marcaDAO = new MarcaDAO();
						Marca marca = null;
						ArrayList <Object> resultadoMarca = marcaDAO.leer(connection, "Sys_PK", resultSet.getString(6));
						marca = (Marca) resultadoMarca.get(0);
						venta.setMarca(marca);
						ModeloDAO modeloDAO = new ModeloDAO();
						Modelo modelo = null;
						ArrayList <Object> resultadoModelo = modeloDAO.leer(connection, "Sys_PK", resultSet.getString(7));
						modelo = (Modelo) resultadoModelo.get(0);
						venta.setModelo(modelo);
						venta.setNumeroSerie(resultSet.getString(8));
						venta.setPlaca(resultSet.getString(9));
						venta.setKilometraje(resultSet.getDouble(10));
						venta.setNotas(resultSet.getString(11));
						listaVenta.add(venta);

					}
				}catch (SQLException e) {
					System.out.println("Error: En método leer");
					e.printStackTrace();
				}
			}else {
				if(campoBusqueda.isEmpty()) {
					query="SELECT venta.Sys_PK, venta.Referencia, venta.Fecha, venta.ICliente, venta.IAgente, "
							+ "venta.IRepartidor, venta.IPorteador, venta.DomicilioEntrega, venta.txtGuia, venta.PComision, "
							+ "venta.Notas "
							+ "FROM venta "
							+ "INNER JOIN cliente "
							+ "ON venta.ICliente = cliente.Sys_PK "
							+ "INNER JOIN agente "
							+ "ON venta.IAgente = agente.Sys_PK "
							+ "INNER JOIN repartidor "
							+ "ON venta.IRepartidor = repartidor.Sys_PK "
							+ "INNER JOIN porteador "
							+ "ON venta.IPorteador = porteador.Sys_PK "
							+ "WHERE cliente.nombre like '%"+valorBusqueda+"%' or "
							+ "venta.Referencia like '%"+valorBusqueda+"%' or "
							+ "venta.fecha like '%"+valorBusqueda+"%' or "
							+ "agente.nombre like '%"+valorBusqueda+"%' or "
							+ "repartidor.nombre like '%"+valorBusqueda+"%' or "
							+ "porteador.descripcion like '%"+valorBusqueda+"%' "
							+ "ORDER BY Fecha DESC";
					try {
						Statement statement = connection.createStatement();
						ResultSet resultSet = statement.executeQuery(query);
						while (resultSet.next()) {
							venta = new Venta();
							venta.setSysPk(resultSet.getInt(1));
							venta.setReferencia(resultSet.getString(2));
							venta.setFecha(resultSet.getDate(3));
							ClienteDAO clienteDAO = new ClienteDAO();
							Cliente cliente = null;
							ArrayList <Object> resultadoCliente = clienteDAO.leer(connection, "Sys_PK", resultSet.getString(4));
							cliente= (Cliente) resultadoCliente.get(0);
							venta.setCliente(cliente);
							TecnicoDAO tecnicoDAO = new TecnicoDAO();
							Tecnico tecnico = null;
							ArrayList <Object> resultadoTecnico = tecnicoDAO.leer(connection, "Sys_PK", resultSet.getString(5));
							tecnico= (Tecnico) resultadoTecnico.get(0);
							venta.setTecnico(tecnico);
							MarcaDAO marcaDAO = new MarcaDAO();
							Marca marca = null;
							ArrayList <Object> resultadoMarca = marcaDAO.leer(connection, "Sys_PK", resultSet.getString(6));
							marca = (Marca) resultadoMarca.get(0);
							venta.setMarca(marca);
							ModeloDAO modeloDAO = new ModeloDAO();
							Modelo modelo = null;
							ArrayList <Object> resultadoModelo = modeloDAO.leer(connection, "Sys_PK", resultSet.getString(7));
							modelo = (Modelo) resultadoModelo.get(0);
							venta.setModelo(modelo);
							venta.setNumeroSerie(resultSet.getString(8));
							venta.setPlaca(resultSet.getString(9));
							venta.setKilometraje(resultSet.getDouble(10));
							venta.setNotas(resultSet.getString(11));
							listaVenta.add(venta);
						}
					}catch (SQLException e) {
						System.out.println("Error: En método leer");
						e.printStackTrace();
					}				
				}else {
					query="SELECT Sys_PK, Referencia, Fecha, ICliente, IAgente, IRepartidor, IPorteador, DomicilioEntrega, "
							+ "txtGuia, PComision, Notas FROM venta "
							+ "WHERE "+campoBusqueda+" = ? ORDER BY Fecha DESC;";			
					try {
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, valorBusqueda);
						ResultSet resultSet=preparedStatement.executeQuery();
						while (resultSet.next()) {
							venta = new Venta();
							venta.setSysPk(resultSet.getInt(1));
							venta.setReferencia(resultSet.getString(2));
							venta.setFecha(resultSet.getDate(3));
							ClienteDAO clienteDAO = new ClienteDAO();
							Cliente cliente = null;
							ArrayList <Object> resultadoCliente = clienteDAO.leer(connection, "Sys_PK", resultSet.getString(4));
							cliente= (Cliente) resultadoCliente.get(0);
							venta.setCliente(cliente);
							TecnicoDAO tecnicoDAO = new TecnicoDAO();
							Tecnico tecnico = null;
							ArrayList <Object> resultadoTecnico = tecnicoDAO.leer(connection, "Sys_PK", resultSet.getString(5));
							tecnico= (Tecnico) resultadoTecnico.get(0);
							venta.setTecnico(tecnico);
							MarcaDAO marcaDAO = new MarcaDAO();
							Marca marca = null;
							ArrayList <Object> resultadoMarca = marcaDAO.leer(connection, "Sys_PK", resultSet.getString(6));
							marca = (Marca) resultadoMarca.get(0);
							venta.setMarca(marca);
							ModeloDAO modeloDAO = new ModeloDAO();
							Modelo modelo = null;
							ArrayList <Object> resultadoModelo = modeloDAO.leer(connection, "Sys_PK", resultSet.getString(7));
							modelo = (Modelo) resultadoModelo.get(0);
							venta.setModelo(modelo);
							venta.setNumeroSerie(resultSet.getString(8));
							venta.setPlaca(resultSet.getString(9));
							venta.setKilometraje(resultSet.getDouble(10));
							venta.setNotas(resultSet.getString(11));
							listaVenta.add(venta);
						}
					}catch (SQLException e) {
						System.out.println("Error: En método leer");
						e.printStackTrace();
					}				
				}						
			}
			return listaVenta;
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
