package mx.shf6.SMB.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.shf6.SMB.model.DetalleVenta;
import mx.shf6.SMB.model.Producto;
import mx.shf6.SMB.model.Venta;

public class DetalleVentaDAO implements ObjectDAO{

	@Override
	public boolean crear(Connection connection, Object objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	//METODO PARA HACER SELECT EN LA TABLA DETALLE VENTA
	@Override
	public ArrayList<Object> leer(Connection connection, String campoBusqueda, String valorBusqueda) {
		String query ="";
		DetalleVenta detalleVenta = new DetalleVenta();
		ArrayList<Object> listaDetalleVenta = new ArrayList<Object>();
		if(campoBusqueda.isEmpty() && valorBusqueda.isEmpty()) {
			query="SELECT Sys_PK, Cantidad, Precio, IProducto, FK_Venta_Detalle FROM dventa ORDER BY Sys_PK;";
			try {
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
				while (resultSet.next()) {
					detalleVenta= new DetalleVenta();
					detalleVenta.setSysPK(resultSet.getInt(1));
					detalleVenta.setCantidad(resultSet.getDouble(2));
					detalleVenta.setPrecio(resultSet.getDouble(3));
					ProductoDAO productoDAO = new ProductoDAO();
					Producto producto = null;
					ArrayList <Object> resultadoProducto = productoDAO.leer(connection, "Sys_PK", resultSet.getString(4));
					producto = (Producto) resultadoProducto.get(0);	
					detalleVenta.setProducto(producto);
					VentaDAO ventaDAO = new VentaDAO();
					Venta venta = null;
					ArrayList <Object> resultadoVenta = ventaDAO.leer(connection, "Sys_PK", resultSet.getString(5));
					venta = (Venta) resultadoVenta.get(0);		
					detalleVenta.setFKSaleDetail(venta);
					listaDetalleVenta.add(detalleVenta);
				}
			}catch (SQLException e) {
				System.out.println("Error: En método leer");
				e.printStackTrace();
			}
		}else {
			query="SELECT Sys_PK, Cantidad, Precio, IProducto, FK_Venta_Detalle FROM dventa WHERE "+campoBusqueda+" = ? ORDER BY Sys_PK;";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, valorBusqueda);
				ResultSet resultSet=preparedStatement.executeQuery();
				while (resultSet.next()) {
					detalleVenta= new DetalleVenta();
					detalleVenta.setSysPK(resultSet.getInt(1));
					detalleVenta.setCantidad(resultSet.getDouble(2));
					detalleVenta.setPrecio(resultSet.getDouble(3));
					ProductoDAO productoDAO = new ProductoDAO();
					Producto producto = null;
					ArrayList <Object> resultadoProducto = productoDAO.leer(connection, "Sys_PK", resultSet.getString(4));
					producto = (Producto) resultadoProducto.get(0);	
					detalleVenta.setProducto(producto);
					VentaDAO ventaDAO = new VentaDAO();
					Venta venta = null;
					ArrayList <Object> resultadoVenta = ventaDAO.leer(connection, "Sys_PK", resultSet.getString(5));
					venta = (Venta) resultadoVenta.get(0);		
					detalleVenta.setFKSaleDetail(venta);
					listaDetalleVenta.add(detalleVenta);
				}
			}catch (SQLException e) {
				System.out.println("Error: En método leer");
				e.printStackTrace();
			}	
		}
		return listaDetalleVenta;
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

}//FIN METODO