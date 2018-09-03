package mx.shf6.SMB.view;

import java.sql.Date;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import mx.shf6.SMB.MainApp;
import mx.shf6.SMB.model.DetalleVenta;
import mx.shf6.SMB.model.Venta;
import mx.shf6.SMB.model.dao.DetalleVentaDAO;
import mx.shf6.SMB.model.dao.VentaDAO;
import mx.shf6.SMB.utilities.ConnectionDB;

public class Busqueda {
	//INICIO DE LA CONEXION DE LA BASE DE DATOS
	static ConnectionDB connectionDB =  new ConnectionDB("shiftf6db", "192.168.0.216", "conn01" , "Simons83Mx");
	    
    //COMPONENTES INTERFAZ DE USUARIO
	@FXML
	private TableView<Venta> tablaVenta;
	@FXML
	private TableColumn<Venta, String> referenciaVentaColumn;
	@FXML
	private TableColumn<Venta, Date> fechaVentaColumn;
	@FXML
	private TableColumn<Venta, String> clienteColumn;
	@FXML
	private TableColumn<Venta, String> tecnicoColumn;
	@FXML
	private TableColumn<Venta, String> marcaColumn;
	@FXML
	private TableColumn<Venta, String> modeloColumn;
	@FXML
	private TableColumn<Venta, String> numeroSerieColumn;		
	@FXML
	private TableColumn<Venta, String> placaColumn;
	@FXML
	private TableColumn<Venta, Double> kilometrajeColumn;
	@FXML
	private TableColumn<Venta, String> notasVentaColumn;	
	@FXML
	private TableView<DetalleVenta> tablaDetalleVenta;
	@FXML
	private TableColumn<DetalleVenta, String> codigoColumn;
	@FXML
	private TableColumn<DetalleVenta, String> servicioProductoColumn;
	@FXML
	private TableColumn<DetalleVenta, Double> costoColumn;
	@FXML
	private TableColumn<DetalleVenta, String> notasDetalleVentaColumn;
	@FXML
	public TextField buscarField;
	@FXML
	public Button buscarButton;
	
	private ObservableList<DetalleVenta> detalleVentaData = FXCollections.observableArrayList();
	
	public Busqueda() {	
		
    }//FIN CONSTRUCTOR
	
	//INICIALIZA LOS COMPOMENTES QUE SE CONTROLAN EN LA INTERFAZ DE USUARIO
    @FXML
    private void initialize() {
    	
        //INICIALIZA LAS COLUMNAS DEL TABLEVIEW
    	
        //SE AGREGAN DATOS A LAS CELDAS DESDE INFORMACION DE LA BASE DE DATOS
    	referenciaVentaColumn.setCellValueFactory(cellData -> cellData.getValue().referenciaProperty());
    	fechaVentaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
    	clienteColumn.setCellValueFactory(cellData -> cellData.getValue().getCliente().nombreProperty());    	
    	tecnicoColumn.setCellValueFactory(cellData -> cellData.getValue().getTecnico().nombreProperty());    
    	marcaColumn.setCellValueFactory(cellData -> cellData.getValue().getMarca().descripcionProperty());
    	modeloColumn.setCellValueFactory(cellData -> cellData.getValue().getModelo().descripcionProperty());
    	numeroSerieColumn.setCellValueFactory(cellData -> cellData.getValue().numeroSerieProperty());
    	placaColumn.setCellValueFactory(cellData -> cellData.getValue().placaProperty());
    	kilometrajeColumn.setCellValueFactory(cellData -> cellData.getValue().kilometrajeProperty());
    	notasVentaColumn.setCellValueFactory(cellData -> cellData.getValue().placaProperty());
    	tablaVenta.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showDetalleVenta(newValue));
    }
       
    
    //BUSCA LOS USUARIOS Y/O CORREOS QUE SE ENCUENTREN EL EL TEXTFIELD DE BUSQUEDA
    @FXML
    private void buscarVenta() {
    	tablaVenta.setItems(null);
        boolean okClicked = true;
        if (okClicked) {
            VentaDAO ventaDAO = new VentaDAO();
            ObservableList<Venta> ventaData = FXCollections.observableArrayList();
    		ArrayList <Object> resultadoSelect = ventaDAO.leer(connectionDB.conectarMySQL(), "", buscarField.getText());           
        	for(Object venta :resultadoSelect) {
        		ventaData.add((Venta) venta);
        	}//FIN FOR
        	tablaVenta.setItems(ventaData);        	
        }//FIN IF
    }//FIN METODO
    	
    
    private void showDetalleVenta(Venta venta) {
    	
        if (venta != null) {
        	detalleVentaData.clear();
        	DetalleVentaDAO detalleVentaDAO = new DetalleVentaDAO();
        	ArrayList <Object> resultadoSelect = detalleVentaDAO.leer(connectionDB.conectarMySQL(), "FK_Venta_Detalle", ""+venta.getSysPk());  
        	for(Object detalleVenta :resultadoSelect) {
        		detalleVentaData.add((DetalleVenta) detalleVenta);         		
        	}
        	tablaDetalleVenta.setItems(detalleVentaData);
        	codigoColumn.setCellValueFactory(cellData -> cellData.getValue().getProducto().codigoProperty());
        	servicioProductoColumn.setCellValueFactory(cellData -> cellData.getValue().getProducto().descripcionProperty());
        	costoColumn.setCellValueFactory(cellData -> cellData.getValue().getProducto().precioProperty());
        	notasDetalleVentaColumn.setCellValueFactory(cellData -> cellData.getValue().getVenta().notasProperty());
        } else
			// Person is null, remove all the text.
        	tablaDetalleVenta.getItems().clear();
    }
	
	
	//ACCESO AL CLASE PRINCIPAL QUE CONTROLA LAS VISTAS
    public void setMainApp(MainApp mainApp) {
        //AGREGA LA LISTA OBSERVABLE CON LOS DATOS EN LA TABLA
        tablaVenta.setItems(mainApp.getVentaData());
    }//FIN METODO
}
