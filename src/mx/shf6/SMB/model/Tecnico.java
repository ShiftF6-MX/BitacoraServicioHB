package mx.shf6.SMB.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tecnico {
	//PROPIEDADES								EN LA BASE DE DATOS LA TABLA SE LLAMA AGENTE
	private ObjectProperty<Integer> sysPk; 		//Sys_PK (INT) | PrimaryKey
	private StringProperty nombre; 				//Nombre (VARCHAR)
	
	//CONSTRUCTOR SIN PARAMETROS
	public Tecnico() {
		this(0,"");
	}//FIN METODO
	
	//CONSTRUCTOR CON PARAMETROS
	public Tecnico(Integer sysPk, String nombre) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.nombre = new SimpleStringProperty(nombre);
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
	
	//METODOS PARA ACCESO A "NOMBRE"
	public void setNombre(String nombre) {
		this.nombre.set(nombre);
	}//FIN METODO
	
	public String getNombre() {
		return this.nombre.get();
	}//FIN METODO
	
	public StringProperty nombreProperty() {
		return this.nombre;
	}//FIN METODO
	//FIN METODOS "REFERENCIA"
	
	public String showInformacion() {
		String informacionVenta = "DATOS DEL TÉCNICO:\n Sys_PK: " + this.getSysPk() + "\n"
				+ "Nombre: " + this.getNombre();
		return informacionVenta;
	}//FIN METODO

}//FIN CLASE
