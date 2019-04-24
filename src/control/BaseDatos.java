package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
	/*-----------TERCERA EVALUACION-----------------*/
	/*----------09/04/2019---------*/
	//Empezamos con la creacion del codigo para poder conectar java con la base de datos
	
	// propiedades para la base de datos
	private String host; //el servidor fisicamente
	private String dbName;
	private String dbUser;
	private String dbPass;
	private Connection conexion; //propiedad para poder conectar a sql
	
	
	public BaseDatos(String host, String dbName, String dbUser, String dbPass) {
		super();
		this.host = host;
		this.dbName = dbName;
		this.dbUser = dbUser;
		this.dbPass = dbPass;
		try { //metodo para poder conectarse a la base de datos con el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/sakila?"
							+ "user=root&password=Chachan4567&serverTimezone=UTC");
			
			System.out.println("Conectado......");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	/*---------------------23/04/2019----------------------*/
	/*Hacer un metodo donde crear una tabla actor y que devuelva una lista de Actores*/
	
	
	public BaseDatos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	
	public String getDbPass() {
		return dbPass;
	}
	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
	
	
}
