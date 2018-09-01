package mx.shf6.SMB.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class DetalleVenta {

	//PROPIEDADES
	private ObjectProperty<Integer> sysPK;				//Sys_PK (INT) | PrimaryKey
	private ObjectProperty<Double> cantidad;			//Cantidad (DOUBLE)
	private ObjectProperty<Double> precio;				//Precio (DOUBLE)
	private ObjectProperty<Producto> producto;			//IProductoo (INT) | ForeingKey (Productoo.Sys_PK)
	private ObjectProperty<Venta> venta;				//FK_Venta_Detalle (INT) | ForeingKey (Venta.Sys_PK)
	
	//CONSTRUCTOR SIN PARAMETROS
	public DetalleVenta() {
		this(0, 0.0, 0.0,null,null);
	}//FIN CONSTRUCTOR
	
	//CONSTRUCTOR CON PARAMETROS
	public DetalleVenta(Integer sysPK, Double cantidad, Double precio, Producto producto, Venta venta) {
		this.sysPK = new SimpleObjectProperty<Integer>(sysPK);
		this.cantidad = new SimpleObjectProperty<Double>(cantidad);
		this.precio = new SimpleObjectProperty<Double>(precio);
		this.producto = new SimpleObjectProperty<Producto>(producto);
		this.venta = new SimpleObjectProperty<Venta>(venta);	
	}//FIN CONSTRUCTOR

	//METODOS PARA ACCESO A "SYSPK"
	public Integer getSysPK() {
		return sysPK.get();
	}//FIN METODO

	public void setSysPK(Integer sysPK) {
		this.sysPK.set(sysPK);
	}//FIN METODO
	
	public ObjectProperty<Integer> sysPkProperty() {
		return this.sysPK;
	}//FIN METODO
	//FIN METODOS "SYSPK"
	
	//METODOS PARA ACCESO A "CANTIDAD"
	public Double getCantidad() {
		return cantidad.get();
	}//FIN METODO

	public void setCantidad(Double cantidad) {
		this.cantidad.set(cantidad);
	}//FIN METODO
	
	public ObjectProperty<Double> cantidadProperty() {
		return this.cantidad;
	}//FIN METODO
	//FIN METODOS "CANTIDAD"
	
	//METODOS PARA ACCESO A "PRECIO"
	public Double getPrecio() {
		return precio.get();
	}//FIN METODO

	public void setPrecio(Double precio) {
		this.precio.set(precio);
	}//FIN METODO
	
	public ObjectProperty<Double> precioProperty() {
		return this.precio;
	}//FIN METODO
	//FIN METODOS "PRECIO"
	
	//METODOS PARA ACCESO A "PRODUCTO"
	public Producto getProducto() {
		return producto.get();
	}//FIN METODO

	public void setProducto(Producto producto) {
		this.producto.set(producto);
	}//FIN METODO
	
	public ObjectProperty<Producto> productoProperty() {
		return this.producto;
	}//FIN METODO
	//FIN METODOS "PRODUCTO"
	
	//METODOS PARA ACCESO A "VENTA"
	public Venta getVenta() {
		return venta.get();
	}//FIN METODO
	
	public void setFKSaleDetail(Venta venta) {
		this.venta.set(venta);
	}//FIN METODO
	
	public ObjectProperty<Venta> ventaProperty() {
		return this.venta;
	}//FIN METODO
	//FIN METODOS "VENTA"
	
}//FIN CLASE
