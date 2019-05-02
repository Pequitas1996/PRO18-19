package modelo.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import control.BaseDatos;

public class AccesoDatos {

	/*------------TERCERA EVALUACION---------------*/
	
	/*---------------------30/04/2019-----------------*/
	/*Creamos directamente dentro del worbench la base de datos*/
	/*Vamos a crear la tabla e insertar los registros dentro de la tabla*/
	
	public void insertaEquiposDesdeFichero(String rutaEquipos) {
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(rutaEquipos));
			String registro;
			BaseDatos bd = new BaseDatos("localhost", "liga", "root", "Chachan4567");
			Connection conexion = bd.getConexion(); //variable para conectarse a las bases de datos
			Statement stnt = conexion.createStatement();
			

			while ((registro = fichero.readLine()) != null) {
				String[] campos = registro.split("#");
				int id = Integer.parseInt(campos[0]);
				String nombreCorto = campos[1]; //Ojo con las comillas en el INSERT
				String nombre = campos[2];
				//String sql = "INSERT INTO equipos (id, nombreCorto, nombre)VALUES"; //primera forma de hacer la consulta
				String sql = "INSERT INTO equipos(id , nombreCorto , nombre )" //segunda forma de hacer la consulta...
						+ "VALUES(" + id + ",\"" + nombreCorto +  "\"," + "\"" + nombre +"\")";
				//sql +="(" + id + ",\"" + nombreCorto + "\"," + "\""+ nombre + "\")";
				System.out.println(stnt.executeUpdate(sql));
				//stnt.executeUpdate(sql);
			}
			
			stnt.close();
			conexion.close();
			fichero.close();
			System.out.println("Fin de la lectura del fichero");

		} catch (FileNotFoundException excepcion) {
			System.out.println("fichero no encontrado");

		} catch (IOException e) {
			System.out.println("IO Excepcion");
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		}
	}
	
	public void insertarPartidosDesdeFichero(String rutaPartidos){
		//metodo donde meteremos la informacion del fichero partidos dentro de la base de datos Liga.
		//primero creamos la tabla por consola desde mysql
		//empezamos con el prototipo 
		try {	
			BufferedReader fichero = new BufferedReader(new FileReader(rutaPartidos));
			String registro;
			BaseDatos bd = new BaseDatos("localhost", "liga", "root", "Chachan4567");
			Connection conexion = bd.getConexion();
			Statement stnt = conexion.createStatement();
			while ((registro = fichero.readLine()) != null) {
				String[] campos = registro.split("#");
				if (campos[3].equals("")) // ultimo partido jugado..
					break;
				int id = Integer.parseInt(campos[0]);
				int jornada = Integer.parseInt(campos[1]);
				String nombreCortoLocal = campos[2];
				int golesLocal = Integer.parseInt(campos[3]);
				String nombreCortoVisitante = campos[4];
				int golesVisitante = Integer.parseInt(campos[5]);
				//consulta para generar en sql
				String sql = "INSERT INTO partidos(id, jornada, nombreCortoLocal, golesLocal,"
						+ "nombreCortoVisitante, golesVisitante)VALUES(" + id + "," + jornada + ",\""
						+ nombreCortoLocal + "\"," + golesLocal + ",\"" + nombreCortoVisitante + "\","
						+ golesVisitante + ")";
				System.out.println(stnt.executeUpdate(sql));
			}
			stnt.close();
			conexion.close();
			fichero.close();
			System.out.println("Fin de la lectura del fichero");

		} catch (FileNotFoundException excepcion) {
			System.out.println("fichero no encontrado");

		} catch (IOException e) {
			System.out.println("IO Excepcion");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public void insertarJugadoresDesdeFichero(String rutaJugadores){
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(rutaJugadores));
			String registro;
			BaseDatos bd = new BaseDatos("localhost", "liga", "root", "Chachan4567");
			Connection conexion = bd.getConexion();
			Statement stnt = conexion.createStatement();
			while ((registro = fichero.readLine()) != null) {
				String[] campos = registro.split("#");
				int id = Integer.parseInt(campos[0]);
				String nombre = campos[1];
				int dorsal = Integer.parseInt(campos[2]);
				int idEquipo = Integer.parseInt(campos[3]);
				//consulta para generar en sql
				String sql = "INSERT INTO jugadores(id, nombre, dorsal, idEquipo)VALUES ("
						+ id + ",\"" + nombre + "\"," + dorsal + "," + idEquipo + ")";
				System.out.println(stnt.executeUpdate(sql));
			}
			stnt.close();
			conexion.close();
			fichero.close();
			System.out.println("Fin de la lectura del fichero");

		} catch (FileNotFoundException excepcion) {
			System.out.println("fichero no encontrado");

		} catch (IOException e) {
			System.out.println("IO Excepcion");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*------------25/04/2019---------------*/
	/* Vamos a crear un metodo que nos devuelva una lista de actores
	 * usaremos la consulta SELECT*/
	
	public static void recorreTabla(String bddatos, String tabla){
		//mostrar por consola TODOS los actores...
		//CONECTAR BBDD...
		try {
			BaseDatos bd = new BaseDatos("localhost", bddatos, "root", "Chachan4567");
			Connection conexion = bd.getConexion(); //variable para conectarse a las bases de datos
			Statement stnt = conexion.createStatement();
			ResultSet rS = stnt.executeQuery("SELECT * FROM " + tabla + " WHERE 1");
			ResultSetMetaData mD = rS.getMetaData();
			for (int i = 1; i < mD.getColumnCount(); i++) {
				System.out.print(i + " -> " + mD.getColumnName(i) + "\t\t");
			}
			System.out.println();
			
			//vamos a iterar en el ResulSet
			while(rS.next()){ //es parecido al readLine de los ficheros
				for (int i = 1; i < mD.getColumnCount(); i++)
					System.out.print(rS.getString(i) + "\t\t");
				
				System.err.println();
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
