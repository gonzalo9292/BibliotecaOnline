package db;

import java.sql.SQLException;

public class DBCreator {
	
	
	public static void main(String[] args) throws SQLException {
		DBManager.EliminarTablaBd();
		
		//DBManager.limpiarBd();
		
		System.out.println("Conectando con la base de datos...");
		
		//Creacion de tablas
		System.out.println("Creando tabla Usuario");
		DBManager.crearTablaUsuario();
		/*
		System.out.println("Añadiendo Usuarios de ejemplo");
		db.añadirUsuariosEjemplo();
//		*/
		System.out.println("Creando tabla Alquiler");
		DBManager.crearTablaAlquiler();
	
		System.out.println("Creando tabla Libro");
		DBManager.crearTablaLibro();
		
//		DBManager.añadirCuentaBancariaEjemplo();
		
		System.out.println("Creando tabla Pelocula");
		DBManager.crearTablaPelicula();
		
		System.out.println("Creando tabla Juego");
		DBManager.crearTablaJuego();
		
		DBManager.crearTablaJuegoCopia();
		System.out.println("Copia de la tabla juego creada");
		DBManager.crearTablaLibroCopia();
		System.out.println("Copia de la tabla libro creada");
		DBManager.crearTablaPeliculaCopia();
		System.out.println("Copia de la tabla pelicula creada");
		
		DBManager.añadirLibrosDisponibles();
		System.out.println("Libros añadidos a la tabla");
		DBManager.añadirJuegosDisponibles();
		System.out.println("Juegos añadidos a la tabla");
		
		DBManager.añadirPeliculasDisponibles();
		System.out.println("Peliculas añadidos a la tabla");
		
		

		DBManager.añadirLibrosCopiaDisponibles();
		DBManager.añadirJuegosCopiaDisponibles();
		DBManager.añadirPeliculasCopiaDisponibles();
		

	

		
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
