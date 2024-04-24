package db;

import java.sql.SQLException;

public class DBCreator {
	
	
	public static void main(String[] args) throws SQLException {
		
		DBManager.limpiarBd();
		
		System.out.println("Conectando con la base de datos...");
		
		//Creacion de tablas
		System.out.println("Creando tabla Usuario");
		DBManager.crearTablaUsuario();
		/*
		System.out.println("A�adiendo Usuarios de ejemplo");
		db.a�adirUsuariosEjemplo();
//		*/
		
	
		System.out.println("Creando tabla Libro");
		DBManager.crearTablaLibro();
		
//		DBManager.a�adirCuentaBancariaEjemplo();
		
		System.out.println("Creando tabla Pelocula");
		DBManager.crearTablaPelicula();
		
		System.out.println("Creando tabla Juego");
		DBManager.crearTablaJuego();
		
		DBManager.a�adirLibrosDisponibles();
		DBManager.a�adirJuegosDisponibles();
		DBManager.a�adirPeliculasDisponibles();
		

	

		
		/*
		//Agregacion de datos de prueba a las tablas
		System.out.println("A�adiendo Usuarios de ejemplo");
		DBManager.a�adirUsuariosEjemplo();
		
		System.out.println("A�adiendo Datos de ejemplo en ruleta");
		DBManager.a�adirRuletaEjemplo();

		System.out.println("A�adiendo Datos de ejemplo en Balance");
		DBManager.a�adirBalanceEjemplo();
		
		System.out.println("A�adiendo Datos de ejemplo en Crash");
		DBManager.a�adirCrashEjemplo();
		
		System.out.println("A�adiendo Datos de ejemplo en Black Jack");
		DBManager.a�adirBlackJackEjemplo();
		*/
		
		System.out.println("Cerrando conexion...");
	}

}
