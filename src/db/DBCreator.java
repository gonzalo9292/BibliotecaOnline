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
		System.out.println("Añadiendo Usuarios de ejemplo");
		db.añadirUsuariosEjemplo();
//		*/
		
	
		System.out.println("Creando tabla Libro");
		DBManager.crearTablaLibro();
		
//		DBManager.añadirCuentaBancariaEjemplo();
		
		System.out.println("Creando tabla Pelocula");
		DBManager.crearTablaPelicula();
		
		System.out.println("Creando tabla Juego");
		DBManager.crearTablaJuego();
		
		DBManager.añadirLibrosDisponibles();
		DBManager.añadirJuegosDisponibles();
		DBManager.añadirPeliculasDisponibles();
		

	

		
		/*
		//Agregacion de datos de prueba a las tablas
		System.out.println("Añadiendo Usuarios de ejemplo");
		DBManager.añadirUsuariosEjemplo();
		
		System.out.println("Añadiendo Datos de ejemplo en ruleta");
		DBManager.añadirRuletaEjemplo();

		System.out.println("Añadiendo Datos de ejemplo en Balance");
		DBManager.añadirBalanceEjemplo();
		
		System.out.println("Añadiendo Datos de ejemplo en Crash");
		DBManager.añadirCrashEjemplo();
		
		System.out.println("Añadiendo Datos de ejemplo en Black Jack");
		DBManager.añadirBlackJackEjemplo();
		*/
		
		System.out.println("Cerrando conexion...");
	}

}
