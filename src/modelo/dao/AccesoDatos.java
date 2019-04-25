package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import control.BaseDatos;

public class AccesoDatos {

	/*------------TERCERA EVALUACION---------------*/
	/*------------25/04/2019---------------*/
	/* Vamos a crear un metodo que nos devuelva una lista de actores
	 * usaremos la consulta SELECT*/
	
	public static void recorreTabla(){
		//mostrar por consola TODOS los actores...
		//CONECTAR BBDD...
		try {
			BaseDatos bd = new BaseDatos("localhost", "sakila", "root", "Chachan4567");
			Connection conexion = bd.getConexion(); //variable para conectarse a las bases de datos
			Statement stnt = conexion.createStatement();
			ResultSet rS = stnt.executeQuery("SELECT first_name , last_name FROM actor WHERE 1");
			ResultSetMetaData mD = rS.getMetaData();
			
			//vamos a iterar en el ResulSet
			while(rS.next()){ //es parecido al readLine de los ficheros
				 System.out.println(rS.getString(1) + "\t\t" + rS.getString("last_name"));
			}
			//cerrar la conexion
			rS.close();
			stnt.close();
			conexion.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Error de conexion...");
		}
	}
	
}
