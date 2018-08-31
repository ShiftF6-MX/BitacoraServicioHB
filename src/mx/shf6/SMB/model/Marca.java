package mx.shf6.SMB.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Marca {

	//PROPIEDADES								EN LA BASE DE DATOS LA TABLA SE LLAMA REPARTIDOR
	private ObjectProperty<Integer> sysPk; 		//Sys_PK (INT) | PrimaryKey
	private StringProperty descripcion; 		//Nombre (VARCHAR)
	
	//CONSTRUCTOR SIN PARAMETROS
	public Marca() {
		this(0,"");
	}//FIN METODO
	
	//CONSTRUCTOR CON PARAMETROS
	public Marca(Integer sysPk, String descripcion) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.descripcion = new SimpleStringProperty(descripcion);
	}//FIN METODO
	
	//METODOS PARA ACCESO A "SYSPK"
	public void setSysPk(Integer sysPK) {
		this.sysPk.set(sysPK);
	}//FIN METODO
	
	public Integer getSysPk() {
		return this.sysPk.get();
	}//FIN METODO
	
	public ObjectProperty<Integer> sysPkProperty() {
		return this.sysPk;
	}//FIN METODO
	//FIN METODOS "SYSPK"
	
	//METODOS PARA ACCESO A "DESCRIPCION"
	public void setDescripcion(String descripcion) {
		this.descripcion.set(descripcion);
	}//FIN METODO
	
	public String getDescripcion() {
		return this.descripcion.get();
	}//FIN METODO
	
	public StringProperty descripcionProperty() {
		return this.descripcion;
	}//FIN METODO
	//FIN METODOS "DESCRIPCION"
	
	public String showInformacion() {
		String informacionVenta = "DATOS DE LA MARCA:\n Sys_PK: " + this.getSysPk() + "\n"
				+ "Descripción: " + this.getDescripcion();
		return informacionVenta;
	}//FIN METODO

}//FIN CLASE
