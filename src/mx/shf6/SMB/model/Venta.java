package mx.shf6.SMB.model;

import java.sql.Date;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Venta {

	//PROPIEDADES
	private ObjectProperty<Integer> sysPk; 			//Sys_PK (INT) | PrimaryKey
	private StringProperty referencia; 				//Referencia (VARCHAR)
	private ObjectProperty<Date> fecha; 			//Fecha (DATE)
	private ObjectProperty<Cliente> cliente; 		//ICliente (INT) | ForeingKey
	private ObjectProperty<Tecnico> tecnico; 		//IAgente (INT) | ForeingKey
	private ObjectProperty<Marca> marca; 			//IRepartidor (INT) | ForeingKey
	private ObjectProperty<Modelo> modelo;			//IPorteador (INT) | ForeingKey
	private StringProperty numeroSerie;				//DomicilioEntrega (VARCHAR)
	private StringProperty placa; 					//txtGuia (VARCHAR)
	private ObjectProperty<Double> kilometraje;		//PComision (DOUBLE)
	private StringProperty notas;					//Notas (VARCHAR)
	
	//CONSTRUCTOR SIN PARAMETROS
	public Venta() {
		this(0,"",null,null,null,null,null,"","",0.0,"");
	}//FIN METODO
	
	//CONSTRUCTOR CON PARAMETROS
	public Venta(Integer sysPk, String referencia, Date fecha, Cliente cliente, Tecnico tecnico, Marca marca, Modelo modelo,
			String numeroSerie, String placa, Double kilometraje, String notas) {
		this.sysPk = new SimpleObjectProperty<Integer>(sysPk);
		this.referencia = new SimpleStringProperty(referencia);
		this.fecha = new SimpleObjectProperty<Date>(fecha);
		this.cliente = new SimpleObjectProperty<Cliente>(cliente);
		this.tecnico = new SimpleObjectProperty<Tecnico>(tecnico);
		this.marca = new SimpleObjectProperty<Marca>(marca);
		this.modelo = new SimpleObjectProperty<Modelo>(modelo);
		this.numeroSerie = new SimpleStringProperty(numeroSerie);
		this.placa = new SimpleStringProperty(placa);
		this.kilometraje = new SimpleObjectProperty<Double>(kilometraje);
		this.notas = new SimpleStringProperty(notas);
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
	
	//METODOS PARA ACCESO A "REFERENCIA"
	public void setReferencia(String referencia) {
		this.referencia.set(referencia);
	}//FIN METODO
	
	public String getReferencia() {
		return this.referencia.get();
	}//FIN METODO
	
	public StringProperty referenciaProperty() {
		return this.referencia;
	}//FIN METODO
	//FIN METODOS "REFERENCIA"
	
	//METODOS PARA ACCESO A "FECHA"
	public void setFecha(Date fecha) {
		this.fecha.set(fecha);
	}//FIN METODO
	
	public Date getFecha() {
		return this.fecha.get();
	}//FIN METODO
	
	public ObjectProperty<Date> fechaProperty() {
		return this.fecha;
	}//FIN METODO
	//FIN METODOS "FECHA"
	
	//METODOS PARA ACCESO A "CLIENTE"
	public void setCliente(Cliente cliente) {
		this.cliente.set(cliente);
	}//FIN METODO
	
	public Cliente getCliente() {
		return this.cliente.get();
	}//FIN METODO
	
	public ObjectProperty<Cliente> clienteProperty() {
		return this.cliente;
	}//FIN METODO
	//FIN METODOS "CLIENTE"
	
	//METODOS PARA ACCESO A "TECNICO"
	public void setTecnico(Tecnico tecnico) {
		this.tecnico.set(tecnico);
	}//FIN METODO
	
	public Tecnico getTecnico() {
		return this.tecnico.get();
	}//FIN METODO
	
	public ObjectProperty<Tecnico> tecnicoProperty() {
		return this.tecnico;
	}//FIN METODO
	//FIN METODOS "TECNICO"
	
	//METODOS PARA ACCESO A "MARCA"
	public void setMarca(Marca marca) {
		this.marca.set(marca);
	}//FIN METODO
	
	public Marca getMarca() {
		return this.marca.get();
	}//FIN METODO
	
	public ObjectProperty<Marca> marcaProperty() {
		return this.marca;
	}//FIN METODO
	//FIN METODOS "MARCA"
	
	//METODOS PARA ACCESO A "MODELO"
	public void setModelo(Modelo modelo) {
		this.modelo.set(modelo);
	}//FIN METODO
	
	public Modelo getModelo() {
		return this.modelo.get();
	}//FIN METODO
	
	public ObjectProperty<Modelo> modeloProperty() {
		return this.modelo;
	}//FIN METODO
	//FIN METODOS "MODELO"
	
	//METODOS PARA ACCESO A "NUMERO SERIE"
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie.set(numeroSerie);
	}//FIN METODO
	
	public String getNumeroSerie() {
		return this.numeroSerie.get();
	}//FIN METODO
	
	public StringProperty numeroSerieProperty() {
		return this.numeroSerie;
	}//FIN METODO
	//FIN METODOS "NUMERO SERIE"
	
	//METODOS PARA ACCESO A "PLACA"
	public void setPlaca(String placa) {
		this.placa.set(placa);
	}//FIN METODO
	
	public String getPlaca() {
		return this.placa.get();
	}//FIN METODO
	
	public StringProperty placaProperty() {
		return this.placa;
	}//FIN METODO
	//FIN METODOS "PLACA"
	
	//METODOS PARA ACCESO A "KILOMETRAJE"
	public void setKilometraje(Double kilometraje) {
		this.kilometraje.set(kilometraje);
	}//FIN METODO
	
	public Double getKilometraje() {
		return this.kilometraje.get();
	}//FIN METODO
	
	public ObjectProperty<Double> kilometrajeProperty() {
		return this.kilometraje;
	}//FIN METODO
	//FIN METODOS "KILOMETRAJE"
	
	//METODOS PARA ACCESO A "NOTAS"
	public void setNotas(String notas) {
		this.notas.set(notas);
	}//FIN METODO
	
	public String getNotas() {
		return this.notas.get();
	}//FIN METODO
	
	public StringProperty notasProperty() {
		return this.notas;
	}//FIN METODO
	//FIN METODOS "NOTAS"
	
	public String showInformacion() {
		String informacionVenta = "";
		return informacionVenta;
	}//FIN METODO
	
}//FIN CLASE
