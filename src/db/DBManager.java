package db;

import java.security.KeyStore.ProtectionParameter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.Juego;
import domain.Libro;
import domain.Pelicula;
import domain.Producto;
import domain.Usuario;

public class DBManager {
	

	private static final String URL = "jdbc:sqlite:resorces/db/basededatos.db";
	
	
	
	  public static Connection obtenerConexion() throws SQLException {
	        return DriverManager.getConnection(URL);
	  }
	  
	  
	  // Método para cerrar una conexión
	    public static void cerrarConexion(Connection conexion) {
	        if (conexion != null) {
	            try {
	                conexion.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    
	    public static void crearTablaUsuario() {
			try(Connection conn = obtenerConexion();
					Statement stmt = conn.createStatement()) {
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Usuario (\n"
						+ "    	nombre VARCHAR(255),\n"
						+ "    	apellidos VARCHAR(255),\n"
						+ "    	dni VARCHAR(20),\n"
						+ "    	contrasena VARCHAR(255),\n"
						+ "    	nombre_usuario VARCHAR(50) PRIMARY KEY ); ");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	    public static void crearTablaJuego() {
	        try (Connection conn = obtenerConexion();
	                Statement stmt = conn.createStatement()) {
	            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Juego (\n"
	                    + "     id INTEGER  PRIMARY KEY ,\n"
	                    + "     titulo VARCHAR(30) ,\n"
	                    + "     precio DOUBLE,\n"    
	                    + "     compania VARCHAR(30),\n"  
	                    + "     plataforma VARCHAR(30),\n" 
	                    + "     alquilado VARCHAR(1) default 'N');");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		public static void crearTablaLibro() {
		    try (Connection conn = obtenerConexion();
		            Statement stmt = conn.createStatement()){
		        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Libro (\n"
		                + "     id INTEGER  PRIMARY KEY,\n"
		                + "     titulo VARCHAR(30) ,\n"
		                + "     precio DOUBLE,\n"   
		                + "     autor  VARCHAR(30),\n" 
		                + "     numero_paginas INTEGER,\n" 
		                + "     alquilado VARCHAR(1) default 'N');");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		

			public static void crearTablaPelicula() {
			    try (Connection conn = obtenerConexion();
			            Statement stmt = conn.createStatement()){
			        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Pelicula (\n"
			                + "     id INTEGER  PRIMARY KEY,\n"
			                + "     titulo VARCHAR(30),\n"
			                + "     precio DOUBLE,\n"   
			                + "     director VARCHAR(30),\n"  
			                + "     duracion INTEGER,\n"
			                + "     alquilado VARCHAR(1) default 'N');");
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
		
	    
	    public static void crearTablaAlquiler() {
			try(Connection conn = obtenerConexion();
					Statement stmt = conn.createStatement()) {
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Alquiler (\n"
						+ "    	nombre_usuario VARCHAR(30),\n"
						+ "     id INTEGER  PRIMARY KEY,\n"
						+ "     titulo VARCHAR(30),\n"
						+ "     precio DOUBLE,\n"
						+ "    	tipo VARCHAR(30) ); ");
			
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		 
	 
		public static void crearTablaJuegoCopia() {
			try (Connection conn =  obtenerConexion();
					Statement stmt = conn.createStatement()) {
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS JuegoCopia (\n"
						+ "     id VARCHAR(30)  PRIMARY KEY ,\n"
					    + "     titulo VARCHAR(30) ,\n"
					    + "     precio DOUBLE,\n"    
					    + "     plataforma VARCHAR(30) );");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void crearTablaLibroCopia() {
			try (Connection conn = obtenerConexion();
					Statement stmt = conn.createStatement()){
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS LibroCopia (\n"
					    + "     id VARCHAR(30)  PRIMARY KEY,\n"
					    + "     titulo VARCHAR(30) ,\n"
					    + "     precio DOUBLE,\n"    
					    + "     autor VARCHAR(30) );");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		public static void crearTablaPeliculaCopia() {
			try (Connection conn = obtenerConexion();
					Statement stmt = conn.createStatement()){
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS PeliculaCopia (\n"
						+ "     id VARCHAR(30)  PRIMARY KEY,\n"
					    + "     titulo VARCHAR(30),\n"
					    + "     precio DOUBLE,\n"    
					    + "     duracion INTEGER );");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
/*		public static void añadirLibrosDisponibles() {
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Libro (id, titulo, precio, autor,numero_paginas) VALUES "
																			       
							+ "('1', '1984', 15.99, 'George Orwell', 328), "
							+ "('2', 'Orgullo y prejuicio', 12.50, 'Jane Austen', 432), "
							+ "('3', 'El señor de los anillos', 20.00, 'J.R.R. Tolkien', 1216), "
							+ "('4', 'Crimen y castigo', 18.75, 'Fyodor Dostoevsky', 671), "
							+ "('5', 'Don Quijote de la Mancha', 14.99, 'Miguel de Cervantes', 1072), "
							+ "('6', 'Las aventuras de Sherlock Holmes', 10.25, 'Arthur Conan Doyle', 240), "
							+ "('7', 'Moby Dick', 16.50, 'Herman Melville', 720), "
							+ "('8', 'Anna Karenina', 17.80, 'Leo Tolstoy', 864), "
							+ "('9', 'La Odisea', 13.45, 'Homer', 560), "
							+ "('10', 'El gran Gatsby', 11.99, 'F. Scott Fitzgerald', 200), "
							+ "('11', 'La metamorfosis', 9.75, 'Franz Kafka', 224), "
							+ "('12', 'El retrato de Dorian Gray', 14.25, 'Oscar Wilde', 272), "
							+ "('13', 'Los miserables', 22.30, 'Victor Hugo', 1488), "
							+ "('14', 'Romeo y Julieta', 8.99, 'William Shakespeare', 368), "
							+ "('15', 'Drácula', 12.95, 'Bram Stoker', 418), "
							+ "('16', 'Frankenstein', 11.50, 'Mary Shelley', 352), "
							+ "('17', 'Las crónicas de Narnia', 19.99, 'C.S. Lewis', 768), "
							+ "('18', 'La isla del tesoro', 10.75, 'Robert Louis Stevenson', 336), "
							+ "('19', 'El alquimista', 9.80, 'Paulo Coelho', 208), "
							+ "('20', 'El código Da Vinci', 15.25, 'Dan Brown', 624), "
							+ "('21', 'El guardián entre el centeno', 13.99, 'J.D. Salinger', 280), "
							+ "('22', 'Los pilares de la Tierra', 21.50, 'Ken Follett', 1104), "
							+ "('23', 'El señor de las moscas', 11.45, 'William Golding', 224), "
							+ "('24', 'El amor en los tiempos del cólera', 16.75, 'Gabriel García Márquez', 464), "
							+ "('25', 'La sombra del viento', 14.80, 'Carlos Ruiz Zafón', 568), "
							+ "('26', 'El león, la bruja y el armario', 12.25, 'C.S. Lewis', 208), "
							+ "('27', 'El nombre del viento', 18.99, 'Patrick Rothfuss', 896), "
							+ "('28', 'El perfume', 13.50, 'Patrick Süskind', 255), "
							+ "('29', 'La historia interminable', 14.25, 'Michael Ende', 448), "
							+ "('30', 'El hobbit', 16.80, 'J.R.R. Tolkien', 368), "
							+ "('31', 'Los hombres que no amaban a las mujeres', 15.95, 'Stieg Larsson', 672), "
							+ "('32', 'El psicoanalista', 12.50, 'John Katzenbach', 592), "
							+ "('33', 'La hoguera de las vanidades', 17.25, 'Tom Wolfe', 704), "
							+ "('34', 'El laberinto de los espíritus', 19.50, 'Carlos Ruiz Zafón', 832), "
							+ "('35', 'El día del derrumbe', 14.99, 'Manuel Vicent', 384)");){
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}*/
		
		public static void añadirLibrosDisponibles() {
		    try (Connection conn = obtenerConexion();
		            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Libro (id, titulo, precio, autor,numero_paginas) VALUES "
		                    + "(1, '1984', 15.99, 'George Orwell', 328), "
		                    + "(2, 'Orgullo y prejuicio', 12.50, 'Jane Austen', 432), "
		                    + "(3, 'El señor de los anillos', 20.00, 'J.R.R. Tolkien', 1216), "
		                    + "(4, 'Crimen y castigo', 18.75, 'Fyodor Dostoevsky', 671), "
		                    + "(5, 'Don Quijote de la Mancha', 14.99, 'Miguel de Cervantes', 1072), "
		                    + "(6, 'Las aventuras de Sherlock Holmes', 10.25, 'Arthur Conan Doyle', 240), "
		                    + "(7, 'Moby Dick', 16.50, 'Herman Melville', 720), "
		                    + "(8, 'Anna Karenina', 17.80, 'Leo Tolstoy', 864), "
		                    + "(9, 'La Odisea', 13.45, 'Homer', 560), "
		                    + "(10, 'El gran Gatsby', 11.99, 'F. Scott Fitzgerald', 200), "
		                    + "(11, 'La metamorfosis', 9.75, 'Franz Kafka', 224), "
		                    + "(12, 'El retrato de Dorian Gray', 14.25, 'Oscar Wilde', 272), "
		                    + "(13, 'Los miserables', 22.30, 'Victor Hugo', 1488), "
		                    + "(14, 'Romeo y Julieta', 8.99, 'William Shakespeare', 368), "
		                    + "(15, 'Drácula', 12.95, 'Bram Stoker', 418), "
		                    + "(16, 'Frankenstein', 11.50, 'Mary Shelley', 352), "
		                    + "(17, 'Las crónicas de Narnia', 19.99, 'C.S. Lewis', 768), "
		                    + "(18, 'La isla del tesoro', 10.75, 'Robert Louis Stevenson', 336), "
		                    + "(19, 'El alquimista', 9.80, 'Paulo Coelho', 208), "
		                    + "(20, 'El código Da Vinci', 15.25, 'Dan Brown', 624), "
		                    + "(21, 'El guardián entre el centeno', 13.99, 'J.D. Salinger', 280), "
		                    + "(22, 'Los pilares de la Tierra', 21.50, 'Ken Follett', 1104), "
		                    + "(23, 'El señor de las moscas', 11.45, 'William Golding', 224), "
		                    + "(24, 'El amor en los tiempos del cólera', 16.75, 'Gabriel García Márquez', 464), "
		                    + "(25, 'La sombra del viento', 14.80, 'Carlos Ruiz Zafón', 568), "
		                    + "(26, 'El león, la bruja y el armario', 12.25, 'C.S. Lewis', 208), "
		                    + "(27, 'El nombre del viento', 18.99, 'Patrick Rothfuss', 896), "
		                    + "(28, 'El perfume', 13.50, 'Patrick Süskind', 255), "
		                    + "(29, 'La historia interminable', 14.25, 'Michael Ende', 448), "
		                    + "(30, 'El hobbit', 16.80, 'J.R.R. Tolkien', 368), "
		                    + "(31, 'Los hombres que no amaban a las mujeres', 15.95, 'Stieg Larsson', 672), "
		                    + "(32, 'El psicoanalista', 12.50, 'John Katzenbach', 592), "
		                    + "(33, 'La hoguera de las vanidades', 17.25, 'Tom Wolfe', 704), "
		                    + "(34, 'El laberinto de los espíritus', 19.50, 'Carlos Ruiz Zafón', 832), "
		                    + "(35, 'El día del derrumbe', 14.99, 'Manuel Vicent', 384)");){
		        pstmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

	/*	
		public static void añadirJuegosDisponibles() {
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Juego (id, titulo, precio,compania, plataforma) VALUES "
							+ "(36', 'The Legend of Zelda: Breath of the Wild', 59.99, 'Nintendo', 'Nintendo Switch'), "
							+ "('37', 'Red Dead Redemption 2', 49.99, 'Rockstar Games', 'PlayStation 4'), "
							+ "('38', 'Grand Theft Auto V', 29.99, 'Rockstar Games', 'PC'), "
							+ "('39', 'The Witcher 3: Wild Hunt', 39.99, 'CD Projekt', 'PlayStation 4'), "
							+ "('40', 'Minecraft', 19.99, 'Mojang Studios', 'PC'), "
							+ "('41', 'Portal 2', 9.99, 'Valve Corporation', 'PC'), "
							+ "('42', 'The Last of Us Part II', 49.99, 'Naughty Dog', 'PlayStation 4'), "
							+ "('43', 'Horizon Zero Dawn', 19.99, 'Guerrilla Games', 'PlayStation 4'), "
							+ "('44', 'Cyberpunk 2077', 59.99, 'CD Projekt', 'PC'), "
							+ "('45', 'Animal Crossing: New Horizons', 59.99, 'Nintendo', 'Nintendo Switch'), "
							+ "('46', 'Dark Souls III', 29.99, 'FromSoftware', 'PC'), "
							+ "('47', 'Fallout 4', 19.99, 'Bethesda Game Studios', 'PC'), "
							+ "('48', 'FIFA 22', 59.99, 'EA Sports', 'PlayStation 5'), "
							+ "('49', 'Call of Duty: Black Ops Cold War', 59.99, 'Activision', 'PlayStation 5'), "
							+ "('50', 'Fortnite', 0.00, 'Epic Games', 'PC'), "
							+ "('51', 'Among Us', 4.99, 'InnerSloth', 'PC'), "
							+ "('52', 'League of Legends', 0.00, 'Riot Games', 'PC'), "
							+ "('53', 'Valorant', 0.00, 'Riot Games', 'PC'), "
							+ "('54', 'Apex Legends', 0.00, 'Respawn Entertainment', 'PC'), "
							+ "('55', 'Genshin Impact', 0.00, 'miHoYo', 'PC'), "
							+ "('56', 'Overwatch', 19.99, 'Blizzard Entertainment', 'PC'), "
							+ "('57', 'Counter-Strike: Global Offensive', 0.00, 'Valve Corporation', 'PC'), "
							+ "('58', 'World of Warcraft', 14.99, 'Blizzard Entertainment', 'PC'), "
							+ "('59', 'Minecraft Dungeons', 19.99, 'Mojang Studios', 'PC'), "
							+ "('60', 'Assassins Creed Odyssey', 59.99, 'Ubisoft', 'PC'), "
							+ "('61', 'Doom Eternal', 59.99, 'id Software', 'PC'), "
							+ "('62', 'Star Wars Jedi: Fallen Order', 49.99, 'Respawn Entertainment', 'PC'), "
							+ "('63', 'Stardew Valley', 14.99, 'ConcernedApe', 'PC'), "
							+ "('64', 'The Elder Scrolls Online', 19.99, 'Bethesda Softworks', 'PC'), "
							+ "('65', 'Tom Clancys Rainbow Six Siege', 19.99, 'Ubisoft', 'PC'), "
							+ "('66', 'Sekiro: Shadows Die Twice', 59.99, 'FromSoftware', 'PC'), "
							+ "('67', 'The Sims 4', 39.99, 'Maxis', 'PC'), "
							+ "('68', 'Rust', 39.99, 'Facepunch Studios', 'PC'), "
							+ "('69', 'Rocket League', 19.99, 'Psyonix', 'PC'), "
							+ "('70', 'Cities: Skylines', 29.99, 'Colossal Order', 'PC'), "
							+ "('71', 'Subnautica', 24.99, 'Unknown Worlds Entertainment', 'PC')")){
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		public static void añadirJuegosDisponibles() {
		    try (Connection conn = obtenerConexion();
		            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Juego (id, titulo, precio,compania, plataforma) VALUES "
		                    + "(36, 'The Legend of Zelda: Breath of the Wild', 59.99, 'Nintendo', 'Nintendo Switch'), "
		                    + "(37, 'Red Dead Redemption 2', 49.99, 'Rockstar Games', 'PlayStation 4'), "
		                    + "(38, 'Grand Theft Auto V', 29.99, 'Rockstar Games', 'PC'), "
		                    + "(39, 'The Witcher 3: Wild Hunt', 39.99, 'CD Projekt', 'PlayStation 4'), "
		                    + "(40, 'Minecraft', 19.99, 'Mojang Studios', 'PC'), "
		                    + "(41, 'Portal 2', 9.99, 'Valve Corporation', 'PC'), "
		                    + "(42, 'The Last of Us Part II', 49.99, 'Naughty Dog', 'PlayStation 4'), "
		                    + "(43, 'Horizon Zero Dawn', 19.99, 'Guerrilla Games', 'PlayStation 4'), "
		                    + "(44, 'Cyberpunk 2077', 59.99, 'CD Projekt', 'PC'), "
		                    + "(45, 'Animal Crossing: New Horizons', 59.99, 'Nintendo', 'Nintendo Switch'), "
		                    + "(46, 'Dark Souls III', 29.99, 'FromSoftware', 'PC'), "
		                    + "(47, 'Fallout 4', 19.99, 'Bethesda Game Studios', 'PC'), "
		                    + "(48, 'FIFA 22', 59.99, 'EA Sports', 'PlayStation 5'), "
		                    + "(49, 'Call of Duty: Black Ops Cold War', 59.99, 'Activision', 'PlayStation 5'), "
		                    + "(50, 'Fortnite', 0.00, 'Epic Games', 'PC'), "
		                    + "(51, 'Among Us', 4.99, 'InnerSloth', 'PC'), "
		                    + "(52, 'League of Legends', 0.00, 'Riot Games', 'PC'), "
		                    + "(53, 'Valorant', 0.00, 'Riot Games', 'PC'), "
		                    + "(54, 'Apex Legends', 0.00, 'Respawn Entertainment', 'PC'), "
		                    + "(55, 'Genshin Impact', 0.00, 'miHoYo', 'PC'), "
		                    + "(56, 'Overwatch', 19.99, 'Blizzard Entertainment', 'PC'), "
		                    + "(57, 'Counter-Strike: Global Offensive', 0.00, 'Valve Corporation', 'PC'), "
		                    + "(58, 'World of Warcraft', 14.99, 'Blizzard Entertainment', 'PC'), "
		                    + "(59, 'Minecraft Dungeons', 19.99, 'Mojang Studios', 'PC'), "
		                    + "(60, 'Assassins Creed Odyssey', 59.99, 'Ubisoft', 'PC'), "
		                    + "(61, 'Doom Eternal', 59.99, 'id Software', 'PC'), "
		                    + "(62, 'Star Wars Jedi: Fallen Order', 49.99, 'Respawn Entertainment', 'PC'), "
		                    + "(63, 'Stardew Valley', 14.99, 'ConcernedApe', 'PC'), "
		                    + "(64, 'The Elder Scrolls Online', 19.99, 'Bethesda Softworks', 'PC'), "
		                    + "(65, 'Tom Clancys Rainbow Six Siege', 19.99, 'Ubisoft', 'PC'), "
		                    + "(66, 'Sekiro: Shadows Die Twice', 59.99, 'FromSoftware', 'PC'), "
		                    + "(67, 'The Sims 4', 39.99, 'Maxis', 'PC'), "
		                    + "(68, 'Rust', 39.99, 'Facepunch Studios', 'PC'), "
		                    + "(69, 'Rocket League', 19.99, 'Psyonix', 'PC'), "
		                    + "(70, 'Cities: Skylines', 29.99, 'Colossal Order', 'PC'), "
		                    + "(71, 'Subnautica', 24.99, 'Unknown Worlds Entertainment', 'PC')")){
		        pstmt.executeUpdate();
		    } catch (SQLException e) {
		         e.printStackTrace();
		    }
		}

		
/*		public static void añadirPeliculasDisponibles() {
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Pelicula (id, titulo, precio,director, duracion) VALUES "
							+ "('71', '1984', 15.99, 'Michael Radford', 120), "
							+ "('72', 'To Kill a Mockingbird', 12.50, 'Robert Mulligan', 140), "
							+ "('73', 'The Great Gatsby', 10.99, 'Baz Luhrmann', 160), "
							+ "('74', 'Harry Potter and the Philosophers Stone', 19.99, 'Chris Columbus', 130), "
							+ "('75', 'The Catcher in the Rye', 9.95, 'Unknown', 125), "
							+ "('76', 'Pride and Prejudice', 11.25, 'Joe Wright', 170), "
							+ "('77', 'The Hobbit', 14.50, 'Peter Jackson', 150), "
							+ "('78', 'Lord of the Flies', 8.99, 'Harry Hook', 105), "
							+ "('79', 'Brave New World', 13.75, 'Leslie Libman, Larry Williams', 135), "
							+ "('80', 'The Lord of the Rings: The Fellowship of the Ring', 22.99, 'Peter Jackson', 195), "
							+ "('81', 'Moby-Dick', 16.50, 'John Huston', 170), "
							+ "('82', 'The Hunger Games', 11.99, 'Gary Ross', 145), "
							+ "('83', 'The Da Vinci Code', 14.25, 'Ron Howard', 155), "
							+ "('84', 'Gone with the Wind', 17.95, 'Victor Fleming', 200), "
							+ "('85', 'The Hitchhikers Guide to the Galaxy', 10.50, 'Garth Jennings', 120), "
							+ "('86', 'Inception', 9.99, 'Christopher Nolan', 160), "
							+ "('87', 'The Shawshank Redemption', 12.75, 'Frank Darabont', 180), "
							+ "('88', 'The Godfather', 14.99, 'Francis Ford Coppola', 175), "
							+ "('89', 'Pulp Fiction', 11.25, 'Quentin Tarantino', 150), "
							+ "('90', 'Fight Club', 13.50, 'David Fincher', 140), "
							+ "('91', 'Forrest Gump', 16.99, 'Robert Zemeckis', 190), "
							+ "('92', 'The Matrix', 9.50, 'The Wachowskis', 135), "
							+ "('93', 'Titanic', 18.75, 'James Cameron', 195), "
							+ "('94', 'The Silence of the Lambs', 15.25, 'Jonathan Demme', 130), "
							+ "('95', 'The Dark Knight', 19.50, 'Christopher Nolan', 165), "
							+ "('96', 'Schindlers List', 14.25, 'Steven Spielberg', 185), "
							+ "('97', 'Gladiator', 12.99, 'Ridley Scott', 170), "
							+ "('98', 'The Lord of the Rings: The Return of the King', 21.99, 'Peter Jackson', 210), "
							+ "('99', 'Goodfellas', 17.25, 'Martin Scorsese', 155), "
							+ "('100', 'The Lion King', 11.50, 'Roger Allers, Rob Minkoff', 95), "
							+ "('101', 'The Green Mile', 16.25, 'Frank Darabont', 195), "
							+ "('102', 'Inglourious Basterds', 14.99, 'Quentin Tarantino', 160), "
							+ "('103', 'The Departed', 13.75, 'Martin Scorsese', 175), "
							+ "('104', 'Saving Private Ryan', 15.50, 'Steven Spielberg', 200), "
							+ "('105', 'The Prestige', 11.99, 'Christopher Nolan', 145), "
							+ "('106', 'The Shawshank Redemption', 12.75, 'Frank Darabont', 180), "
							+ "('107', 'The Godfather: Part II', 15.99, 'Francis Ford Coppola', 180), "
							+ "('108', 'The Dark Knight Rises', 18.50, 'Christopher Nolan', 170), "
							+ "('109', 'Interstellar', 17.75, 'Christopher Nolan', 210), "
							+ "('110', 'The Departed', 13.75, 'Martin Scorsese', 175)");){

				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		*/
		
		public static void añadirPeliculasDisponibles() {
		    try (Connection conn = obtenerConexion();
		            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Pelicula (id, titulo, precio,director, duracion) VALUES "
		                    + "(71, '1984', 15.99, 'Michael Radford', 120), "
		                    + "(72, 'To Kill a Mockingbird', 12.50, 'Robert Mulligan', 140), "
		                    + "(73, 'The Great Gatsby', 10.99, 'Baz Luhrmann', 160), "
		                    + "(74, 'Harry Potter and the Philosophers Stone', 19.99, 'Chris Columbus', 130), "
		                    + "(75, 'The Catcher in the Rye', 9.95, 'Unknown', 125), "
		                    + "(76, 'Pride and Prejudice', 11.25, 'Joe Wright', 170), "
		                    + "(77, 'The Hobbit', 14.50, 'Peter Jackson', 150), "
		                    + "(78, 'Lord of the Flies', 8.99, 'Harry Hook', 105), "
		                    + "(79, 'Brave New World', 13.75, 'Leslie Libman, Larry Williams', 135), "
		                    + "(80, 'The Lord of the Rings: The Fellowship of the Ring', 22.99, 'Peter Jackson', 195), "
		                    + "(81, 'Moby-Dick', 16.50, 'John Huston', 170), "
		                    + "(82, 'The Hunger Games', 11.99, 'Gary Ross', 145), "
		                    + "(83, 'The Da Vinci Code', 14.25, 'Ron Howard', 155), "
		                    + "(84, 'Gone with the Wind', 17.95, 'Victor Fleming', 200), "
		                    + "(85, 'The Hitchhikers Guide to the Galaxy', 10.50, 'Garth Jennings', 120), "
		                    + "(86, 'Inception', 9.99, 'Christopher Nolan', 160), "
		                    + "(87, 'The Shawshank Redemption', 12.75, 'Frank Darabont', 180), "
		                    + "(88, 'The Godfather', 14.99, 'Francis Ford Coppola', 175), "
		                    + "(89, 'Pulp Fiction', 11.25, 'Quentin Tarantino', 150), "
		                    + "(90, 'Fight Club', 13.50, 'David Fincher', 140), "
		                    + "(91, 'Forrest Gump', 16.99, 'Robert Zemeckis', 190), "
		                    + "(92, 'The Matrix', 9.50, 'The Wachowskis', 135), "
		                    + "(93, 'Titanic', 18.75, 'James Cameron', 195), "
		                    + "(94, 'The Silence of the Lambs', 15.25, 'Jonathan Demme', 130), "
		                    + "(95, 'The Dark Knight', 19.50, 'Christopher Nolan', 165), "
		                    + "(96, 'Schindlers List', 14.25, 'Steven Spielberg', 185), "
		                    + "(97, 'Gladiator', 12.99, 'Ridley Scott', 170), "
		                    + "(98, 'The Lord of the Rings: The Return of the King', 21.99, 'Peter Jackson', 210), "
		                    + "(99, 'Goodfellas', 17.25, 'Martin Scorsese', 155), "
		                    + "(100, 'The Lion King', 11.50, 'Roger Allers, Rob Minkoff', 95), "
		                    + "(101, 'The Green Mile', 16.25, 'Frank Darabont', 195), "
		                    + "(102, 'Inglourious Basterds', 14.99, 'Quentin Tarantino', 160), "
		                    + "(103, 'The Departed', 13.75, 'Martin Scorsese', 175), "
		                    + "(104, 'Saving Private Ryan', 15.50, 'Steven Spielberg', 200), "
		                    + "(105, 'The Prestige', 11.99, 'Christopher Nolan', 145), "
		                    + "(106, 'The Shawshank Redemption', 12.75, 'Frank Darabont', 180), "
		                    + "(107, 'The Godfather: Part II', 15.99, 'Francis Ford Coppola', 180), "
		                    + "(108, 'The Dark Knight Rises', 18.50, 'Christopher Nolan', 170), "
		                    + "(109, 'Interstellar', 17.75, 'Christopher Nolan', 210), "
		                    + "(110, 'The Departed', 13.75, 'Martin Scorsese', 175)");){

		        pstmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

		
		public static void añadirLibrosCopiaDisponibles() {
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO LibroCopia (id, titulo, precio, autor) VALUES "
												       
								+ "('1', '1984', 15.99, 'George Orwell'), "
								+ "('2', 'Orgullo y prejuicio', 12.50, 'Jane Austen'), "
								+ "('3', 'El señor de los anillos', 20.00, 'J.R.R. Tolkien'), "
								+ "('4', 'Crimen y castigo', 18.75, 'Fyodor Dostoevsky'), "
								+ "('5', 'Don Quijote de la Mancha', 14.99, 'Miguel de Cervantes'), "
								+ "('6', 'Las aventuras de Sherlock Holmes', 10.25, 'Arthur Conan Doyle'), "
								+ "('7', 'Moby Dick', 16.50, 'Herman Melville'), "
								+ "('8', 'Anna Karenina', 17.80, 'Leo Tolstoy'), "
								+ "('9', 'La Odisea', 13.45, 'Homer'), "
								+ "('10', 'El gran Gatsby', 11.99, 'F. Scott Fitzgerald'), "
								+ "('11', 'La metamorfosis', 9.75, 'Franz Kafka'), "
								+ "('12', 'El retrato de Dorian Gray', 14.25, 'Oscar Wilde'), "
								+ "('13', 'Los miserables', 22.30, 'Victor Hugo'), "
								+ "('14', 'Romeo y Julieta', 8.99, 'William Shakespeare'), "
								+ "('15', 'Drácula', 12.95, 'Bram Stoker'), "
								+ "('16', 'Frankenstein', 11.50, 'Mary Shelley'), "
								+ "('17', 'Las crónicas de Narnia', 19.99, 'C.S. Lewis'), "
								+ "('18', 'La isla del tesoro', 10.75, 'Robert Louis Stevenson'), "
								+ "('19', 'El alquimista', 9.80, 'Paulo Coelho'), "
								+ "('20', 'El código Da Vinci', 15.25, 'Dan Brown'), "
								+ "('21', 'El guardián entre el centeno', 13.99, 'J.D. Salinger'), "
								+ "('22', 'Los pilares de la Tierra', 21.50, 'Ken Follett'), "
								+ "('23', 'El señor de las moscas', 11.45, 'William Golding'), "
								+ "('24', 'El amor en los tiempos del cólera', 16.75, 'Gabriel García Márquez'), "
								+ "('25', 'La sombra del viento', 14.80, 'Carlos Ruiz Zafón'), "
								+ "('26', 'El león, la bruja y el armario', 12.25, 'C.S. Lewis'), "
								+ "('27', 'El nombre del viento', 18.99, 'Patrick Rothfuss'), "
								+ "('28', 'El perfume', 13.50, 'Patrick Süskind'), "
								+ "('29', 'La historia interminable', 14.25, 'Michael Ende'), "
								+ "('30', 'El hobbit', 16.80, 'J.R.R. Tolkien'), "
								+ "('31', 'Los hombres que no amaban a las mujeres', 15.95, 'Stieg Larsson'), "
								+ "('32', 'El psicoanalista', 12.50, 'John Katzenbach'), "
								+ "('33', 'La hoguera de las vanidades', 17.25, 'Tom Wolfe'), "
								+ "('34', 'El laberinto de los espíritus', 19.50, 'Carlos Ruiz Zafón'), "
								+ "('35', 'El día del derrumbe', 14.99, 'Manuel Vicent')");){
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void añadirJuegosCopiaDisponibles() {
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO JuegoCopia (id, titulo, precio, plataforma) VALUES "
						    + "('36', 'The Legend of Zelda: Breath of the Wild', 59.99, 'Nintendo Switch'), "
						    + "('37', 'Red Dead Redemption 2', 49.99, 'PlayStation 4'), "
						    + "('38', 'Grand Theft Auto V', 29.99, 'PC'), "
						    + "('39', 'The Witcher 3: Wild Hunt', 39.99, 'PlayStation 4'), "
						    + "('40', 'Minecraft', 19.99, 'PC'), "
						    + "('41', 'Portal 2', 9.99, 'PC'), "
						    + "('42', 'The Last of Us Part II', 49.99, 'PlayStation 4'), "
						    + "('43', 'Horizon Zero Dawn', 19.99, 'PlayStation 4'), "
						    + "('44', 'Cyberpunk 2077', 59.99, 'PC'), "
						    + "('45', 'Animal Crossing: New Horizons', 59.99, 'Nintendo Switch'), "
						    + "('46', 'Dark Souls III', 29.99, 'PC'), "
						    + "('47', 'Fallout 4', 19.99, 'PC'), "
						    + "('48', 'FIFA 22', 59.99, 'PlayStation 5'), "
						    + "('49', 'Call of Duty: Black Ops Cold War', 59.99, 'PlayStation 5'), "
						    + "('50', 'Fortnite', 0.00, 'PC'), "
						    + "('51', 'Among Us', 4.99, 'PC'), "
						    + "('52', 'League of Legends', 0.00, 'PC'), "
						    + "('53', 'Valorant', 0.00, 'PC'), "
						    + "('54', 'Apex Legends', 0.00, 'PC'), "
						    + "('55', 'Genshin Impact', 0.00, 'PC'), "
						    + "('56', 'Overwatch', 19.99, 'PC'), "
						    + "('57', 'Counter-Strike: Global Offensive', 0.00, 'PC'), "
						    + "('58', 'World of Warcraft', 14.99, 'PC'), "
						    + "('59', 'Minecraft Dungeons', 19.99, 'PC'), "
						    + "('60', 'Assassins Creed Odyssey', 59.99, 'PC'), "
						    + "('61', 'Doom Eternal', 59.99, 'PC'), "
						    + "('62', 'Star Wars Jedi: Fallen Order', 49.99, 'PC'), "
						    + "('63', 'Stardew Valley', 14.99, 'PC'), "
						    + "('64', 'The Elder Scrolls Online', 19.99, 'PC'), "
						    + "('65', 'Tom Clancys Rainbow Six Siege', 19.99, 'PC'), "
						    + "('66', 'Sekiro: Shadows Die Twice', 59.99, 'PC'), "
						    + "('67', 'The Sims 4', 39.99, 'PC'), "
						    + "('68', 'Rust', 39.99, 'PC'), "
						    + "('69', 'Rocket League', 19.99, 'PC'), "
						    + "('70', 'Cities: Skylines', 29.99, 'PC'), "
						    + "('71', 'Subnautica', 24.99, 'PC')")){
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void añadirPeliculasCopiaDisponibles() {
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO PeliculaCopia (id, titulo, precio, duracion) VALUES "
						    + "('72', 'To Kill a Mockingbird', 12.50, 140), "
						    + "('73', 'The Great Gatsby', 10.99, 160), "
						    + "('74', 'Harry Potter and the Philosophers Stone', 19.99, 130), "
						    + "('75', 'The Catcher in the Rye', 9.95, 125), "
						    + "('76', 'Pride and Prejudice', 11.25, 170), "
						    + "('77', 'The Hobbit', 14.50, 150), "
						    + "('78', 'Lord of the Flies', 8.99, 105), "
						    + "('79', 'Brave New World', 13.75, 135), "
						    + "('80', 'The Lord of the Rings: The Fellowship of the Ring', 22.99, 195), "
						    + "('81', 'Moby-Dick', 16.50, 170), "
						    + "('82', 'The Hunger Games', 11.99, 145), "
						    + "('83', 'The Da Vinci Code', 14.25, 155), "
						    + "('84', 'Gone with the Wind', 17.95, 200), "
						    + "('85', 'The Hitchhikers Guide to the Galaxy', 10.50, 120), "
						    + "('86', 'Inception', 9.99, 160), "
						    + "('87', 'The Shawshank Redemption', 12.75, 180), "
						    + "('88', 'The Godfather', 14.99, 175), "
						    + "('89', 'Pulp Fiction', 11.25, 150), "
						    + "('90', 'Fight Club', 13.50, 140), "
						    + "('91', 'Forrest Gump', 16.99, 190), "
						    + "('92', 'The Matrix', 9.50, 135), "
						    + "('93', 'Titanic', 18.75, 195), "
						    + "('94', 'The Silence of the Lambs', 15.25, 130), "
						    + "('95', 'The Dark Knight', 19.50, 165), "
						    + "('96', 'Schindlers List', 14.25, 185), "
						    + "('97', 'Gladiator', 12.99, 170), "
						    + "('98', 'The Lord of the Rings: The Return of the King', 21.99, 210), "
						    + "('99', 'Goodfellas', 17.25, 155), "
						    + "('100', 'The Lion King', 11.50, 95), "
						    + "('101', 'The Green Mile', 16.25, 195), "
						    + "('102', 'Inglourious Basterds', 14.99, 160), "
						    + "('103', 'The Departed', 13.75, 175), "
						    + "('104', 'Saving Private Ryan', 15.50, 200), "
						    + "('105', 'The Prestige', 11.99, 145), "
						    + "('106', 'The Shawshank Redemption', 12.75, 180), "
						    + "('107', 'The Godfather: Part II', 15.99, 180), "
						    + "('108', 'The Dark Knight Rises', 18.50, 170), "
						    + "('109', 'Interstellar', 17.75, 210), "
						    + "('110', 'The Departed', 13.75, 175)");){

				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void insertarUsuario(Usuario u) {
		 {
				//Añadir un existe usuario
				String sql = "INSERT INTO Usuario (nombre, apellidos, dni,  contrasena, nombre_usuario) VALUES (?, ?, ?, ?, ?);";
				try (Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)){
					pstmt.setString(1, u.getNombre());
					pstmt.setString(2, u.getApellidos());
					pstmt.setString(3, u.getDni());
					pstmt.setString(4, u.getContraseña());
					pstmt.setString(5, u.getNombreUsuario());
					pstmt.executeUpdate();
					System.out.println("El usuario se ha insertado con exito");
				} catch (SQLException e) {
					e.printStackTrace();
				
		
		}
				}
		 }
		
		
		   
		public static void eliminarUsuario(String nombre_usuario,String contraseña) {
			String sql = "DELETE FROM Usuario WHERE nombre_usuario = ? AND contrasena;";
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, nombre_usuario);
				pstmt.setString(2, contraseña);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		public static void RegistrarAlquiler(String nombre_usuario, Producto p,String tipo) {
		    if (nombre_usuario != null) {
		        // Realizar el registro del alquiler con el usuario
		        String sql = "INSERT INTO Alquiler (nombre_usuario, id, titulo, precio, tipo) VALUES (?, ?, ?, ?, ?);";
		        try (Connection conn = obtenerConexion();
		             PreparedStatement pstmt = conn.prepareStatement(sql)) {
		            pstmt.setString(1, nombre_usuario);
		            pstmt.setInt(2, p.getId());
		            pstmt.setString(3, p.getTitulo());
		            pstmt.setDouble(4, p.getPrecio());
		            pstmt.setString(5, tipo);
		            pstmt.executeUpdate();
		            System.out.println("El alquiler se ha registrado con éxito");
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    } else {
		        System.out.println("Error: El usuario es null. No se puede registrar el alquiler.");
		    }
		}

		
		
		
		public static boolean existeUsuarioLogin(String nombre_usuario, String contraseña) {
			String sql= "SELECT * FROM Usuario WHERE nombre_Usuario = ? AND contrasena = ?";
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, nombre_usuario);
				pstmt.setString(2, contraseña);
				ResultSet rs = pstmt.executeQuery();
				return rs.next();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		 public static List<Usuario> obtenerTodosLosUsuarios(){
				List<Usuario> lstUsuarios = new ArrayList<>();
				try(Connection conn = obtenerConexion();
					Statement stmt = conn.createStatement()){
					ResultSet rs = stmt.executeQuery("SELECT * FROM Usuario");
					while(rs.next()) {
						Usuario user = new Usuario();
						//Usuario
						user.setNombre(rs.getString("nombre"));
						user.setApellidos(rs.getString("apellidos"));
						user.setDni(rs.getString("dni"));;
						user.setNombreUsuario(rs.getString("nombre_usuario"));
						user.setContraseña(rs.getString("contrasena"));
				
						//Añadir a la lista el usuario
						lstUsuarios.add(user);
					}}catch(SQLException eo) {
						eo.printStackTrace();
					}
				return lstUsuarios;
				}
		
		
		
		public static List<Libro> obtenerLibrosBD(){
			List<Libro> listaLibros = new ArrayList<>();
			try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement())
			
			{ ResultSet rs = stmt.executeQuery("SELECT * FROM Libro WHERE alquilado = 'N'");
				while(rs.next()) {
				Libro libro = new Libro();
				//Usuario
				libro.setId(rs.getInt("id"));
			    libro.setTitulo(rs.getString("titulo"));
				libro.setPrecio(rs.getDouble("precio"));
				libro.setAutor(rs.getString("autor"));
				libro.setNumPaginas(rs.getInt("numero_paginas"));
			
				//Añadir a la lista el usuario
				listaLibros.add(libro);
				}
				
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
			return listaLibros;
		}
		
		
		public static Libro obtenerLibroCopiaBD(String id){
			 Libro libro = null;

		        try (Connection conn = obtenerConexion();
		             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM LibroCopia WHERE id = ?")) {
		            
		            stmt.setString(1, id);
		            ResultSet rs = stmt.executeQuery();

		            if (rs.next()) {
		                libro = new Libro();
		                //libro.setId(rs.getInt("id"));
		                libro.setTitulo(rs.getString("titulo"));
		                libro.setPrecio(rs.getDouble("precio"));
		                libro.setAutor(rs.getString("autor"));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return libro;
		    }	

		public static Juego obtenerJuegoCopiaBD(String id){
			 Juego juego = null;

		        try (Connection conn = obtenerConexion();
		             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM JuegoCopia WHERE id = ?")) {
		            
		            stmt.setString(1, id);
		            ResultSet rs = stmt.executeQuery();

		            if (rs.next()) {
		                juego = new Juego();
		               // juego.setId(rs.getInt("id"));
		                juego.setTitulo(rs.getString("titulo"));
		                juego.setPrecio(rs.getDouble("precio"));
		                juego.setPlataforma(rs.getString("plataforma"));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return juego;
		    }	
		
		public static Pelicula obtenerPeliculaCopiaBD(String id){
			 Pelicula pelicula = null;

		        try (Connection conn = obtenerConexion();
		             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PeliculaCopia WHERE id = ?")) {
		            
		            stmt.setString(1, id);
		            ResultSet rs = stmt.executeQuery();

		            if (rs.next()) {
		                pelicula = new Pelicula();
		               // pelicula.setId(rs.getInt("id"));
		                pelicula.setTitulo(rs.getString("titulo"));
		                pelicula.setPrecio(rs.getDouble("precio"));
		                pelicula.setDuracion(rs.getInt("duracion"));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }

		        return pelicula;
		    }	
		
		
		
		public static List<Juego> obtenerJuegosBD(){
			List<Juego> listaJuegos = new ArrayList<>();
			try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement())
			
			{ ResultSet rs = stmt.executeQuery("SELECT * FROM Juego WHERE alquilado = 'N'");
				while(rs.next()) {
				Juego juego = new Juego();
				//Usuario
				juego.setId(rs.getInt("id"));
			    juego.setTitulo(rs.getString("titulo"));
				juego.setPrecio(rs.getDouble("precio"));
				juego.setCompania(rs.getString("compania"));
				juego.setPlataforma(rs.getString("plataforma"));
			
				//Añadir a la lista el usuario
				listaJuegos.add(juego);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				return listaJuegos;
			}
			
		
		
		public static List<Pelicula> obtenerPeliculasBD(){
			List<Pelicula> listaPelicula = new ArrayList<>();
			try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement())
			
			{ ResultSet rs = stmt.executeQuery("SELECT * FROM Pelicula WHERE alquilado = 'N'");
				while(rs.next()) {
				Pelicula pelicula = new Pelicula();
				//Usuario
				pelicula.setId(rs.getInt("id"));
			    pelicula.setTitulo(rs.getString("titulo"));
				pelicula.setPrecio(rs.getDouble("precio"));
				pelicula.setDirector(rs.getString("director"));
				pelicula.setDuracion(rs.getInt("duracion"));
			
				//Añadir a la lista el usuario
				listaPelicula.add(pelicula);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				return listaPelicula;
			}
		   public static Usuario obtenerUsuario(String nombreUsuario, String contraseña) {
		        Usuario usuario = new Usuario();
		        try (Connection conn = obtenerConexion();
		             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Usuario WHERE nombre_usuario = ? AND contrasena = ?")) {
		            stmt.setString(1, nombreUsuario);
		            stmt.setString(2, contraseña);
		            ResultSet rs = stmt.executeQuery();
		            if (rs.next()) {
		                usuario = new Usuario();
		                usuario.setNombre(rs.getString("nombre"));
		                usuario.setApellidos(rs.getString("apellidos"));
		                usuario.setDni(rs.getString("dni"));
		                usuario.setNombreUsuario(rs.getString("nombre_usuario"));
		                usuario.setContraseña(rs.getString("contrasena"));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return usuario;
		    } 
		   

/*		   public static void añadirTrasEliminar(List<Producto> lista)  {
			   
			   for(Producto p : lista) {
				   int id = p.getId();
				
				   if (id >= 1 && id <= 35) {
			            // Hacer algo si el ID está entre 1 y 35
					   try (Connection conn = obtenerConexion();
					             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM LibroCopia WHERE id = ?")) {
					            stmt.setString(1,String.valueOf(id));
					            ResultSet rs = stmt.executeQuery();
					            if (rs.next()) {
					                Libro l = new Libro();
					               // l.setId(rs.getInt("id"));
					                l.setTitulo(rs.getString("titulo"));
					                l.setPrecio(rs.getDouble("precio"));
					                l.setAutor(rs.getString("autor"));
					                insertarLibro(l);
					                
					            }
					        } catch (SQLException e) {
					            e.printStackTrace();
					        }
			            
			        } else if (id >= 36 && id <= 71) {
			            // Hacer algo si el ID está entre 1 y 35
						   try (Connection conn = obtenerConexion();
						             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM JuegoCopia WHERE id = ?")) {
						            stmt.setString(1, String.valueOf(id));
						            ResultSet rs = stmt.executeQuery();
						            if (rs.next()) {
						            	Juego juego = new Juego(null, null, 0.0,null, null);
										//Usuario
										//juego.setId(rs.getInt("id"));
									    juego.setTitulo(rs.getString("titulo"));
										juego.setPrecio(rs.getDouble("precio"));
										juego.setPlataforma(rs.getString("plataforma"));
										insertarJuego(juego);
						            }
						        } catch (SQLException e) {
						            e.printStackTrace();
						        }
			        } else if (id >= 72 && id <= 110) {
			            // Hacer algo si el ID está entre 72 y 110
			        	 try (Connection conn = obtenerConexion();
					             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PeliculaCopia WHERE id = ?")) {
					            stmt.setString(1, String.valueOf(id));
					            ResultSet rs = stmt.executeQuery();
					            if (rs.next()) {
					            	Pelicula pelicula = new Pelicula(null, null, 0.0,null, 0);
									//Usuario
									//pelicula.setId(rs.getInt("id"));
								    pelicula.setTitulo(rs.getString("titulo"));
									pelicula.setPrecio(rs.getDouble("precio"));
									pelicula.setDuracion(rs.getInt("duracion"));
									insertarPelicula(pelicula);
					            }
					        } catch (SQLException e) {
					            e.printStackTrace();
					        }
			        }
			        
				   
			   }
			
		      
		    } */
		   
		   public static List<Producto> ListaMapaUsuario(String nombre_usuario) {
			   	List<Producto> listaProductos = new ArrayList<>();
			   	
		       // Producto producto = new Producto();
		        try (Connection conn = obtenerConexion();
		             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Alquiler WHERE nombre_usuario = ?")) {
		        	   stmt.setString(1, nombre_usuario);
		        	   
		        	  
		         
		            ResultSet rs = stmt.executeQuery();
		            while (rs.next()) {
		            	if(rs.getString("tipo").toLowerCase().equals("libro")) {
		            		
		            		 Libro nuevoLibro= new Libro();
		            		 if(obtenerLibroBD(rs.getInt("id")) != null)
		            			nuevoLibro = obtenerLibroBD(rs.getInt("id")); 
		            		 	listaProductos.add(nuevoLibro);
		            		 }else if(rs.getString("tipo").toLowerCase().equals("juego")) {
		            			 Juego nuevoJuego= new Juego();
			            		 if(obtenerJuegoBD(rs.getInt("id")) != null)
			            			nuevoJuego = obtenerJuegoBD(rs.getInt("id")); 
			            		 	listaProductos.add(nuevoJuego);
		            		 }else if(rs.getString("tipo").toLowerCase().equals("pelicula")) {
		            			 Pelicula nuevoPelicula= new Pelicula();
			            		 if(obtenerPeliculaBD(rs.getInt("id")) != null)
			            			nuevoPelicula = obtenerPeliculaBD(rs.getInt("id")); 
			            		 	listaProductos.add(nuevoPelicula);
		            		 }
		            	
		               
		                
		                
		                
		               
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    //    return listaProductos;
				return listaProductos;
		    } 
		   //buscar Libro dado el id del libro
		   public static String obtenerTipoBD(int idLibro){
			   String tipo = null;
			   String sql = "SELECT * FROM Alquiler where id= ?";
			   try(Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)) {
				   
				   pstmt.setInt(1, idLibro);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
					
						tipo = rs.getString("tipo");
						
					}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			   
			   return tipo;
			
		   
		}
		  
		   //buscar Libro dado el id del libro
		   public static Libro obtenerLibroBD(int idLibro){
			   Libro libro = new Libro();
			   String sql = "SELECT * FROM Libro where id= ?";
			   try(Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)) {
				   
				   pstmt.setInt(1, idLibro);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
					
						//Usuario
						libro.setId(rs.getShort("id"));
					    libro.setTitulo(rs.getString("titulo"));
						libro.setPrecio(rs.getDouble("precio"));
						if(rs.getString("alquilado").equals("N") ) {
							libro.setAlquilado(false);
						}else {
							libro.setAlquilado(true);
						}
						
						libro.setAutor(rs.getString("autor"));
						libro.setNumPaginas(rs.getInt("numero_paginas"));
						
					}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			   
			   return libro;
			
		   
		}
		   
		   public static Juego obtenerJuegoBD(int idJuego){
			   Juego juego = new Juego();
			   String sql = "SELECT * FROM Juego where id= ?";
			   try(Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)) {
				   
				   pstmt.setInt(1, idJuego);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
					
						//Usuario
						juego.setId(rs.getInt("id"));
					    juego.setTitulo(rs.getString("titulo"));
						juego.setPrecio(rs.getDouble("precio"));
						if(rs.getString("alquilado") == "N") {
							juego.setAlquilado(false);
						}else {
							juego.setAlquilado(true);
						}
						
						juego.setCompania(rs.getString("compania"));
						juego.setPlataforma(rs.getString("plataforma"));
						return juego;
					}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			   
			return null;
			
		   
		}
		   
		   public static Pelicula obtenerPeliculaBD(int idPelicula){
			   Pelicula pelicula = new Pelicula();
			   String sql = "SELECT * FROM Pelicula where id= ?";
			   try(Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)) {
				   
				   pstmt.setInt(1, idPelicula);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {
					
						//Usuario
						pelicula.setId(rs.getInt("id"));
					    pelicula.setTitulo(rs.getString("titulo"));
						pelicula.setPrecio(rs.getDouble("precio"));
						if(rs.getString("alquilado") == "N") {
							pelicula.setAlquilado(false);
						}else {
							pelicula.setAlquilado(true);
						}
						
						pelicula.setDirector(rs.getString("director"));
						pelicula.setDuracion(rs.getInt("duracion"));
						return pelicula;
					}
			} catch (SQLException e) {
				// TODO: handle exception
			}
			   
			return null;
			
		   
		}
		   public static void insertarLibro(Libro l) {
				 {
						//Añadir un existe usuario
						String sql = "INSERT INTO Libro (id, titulo, precio, autor) VALUES (?, ?, ?, ?);";
						try (Connection conn = obtenerConexion();
								PreparedStatement pstmt = conn.prepareStatement(sql)){
							//pstmt.setString(1, l.getId());
							pstmt.setString(2, l.getTitulo());
							pstmt.setDouble(3, l.getPrecio());
							pstmt.setString(4, l.getAutor());
							pstmt.executeUpdate();
							System.out.println("Se ha insertado con exito el libro");
						} catch (SQLException e) {
							e.printStackTrace();
						
				
				}
						}
				 }
		   
		   public static void insertarJuego(Juego j) {
				 {
						//Añadir un existe usuario
						String sql = "INSERT INTO Juego (id, titulo, precio,  plataforma) VALUES (?, ?, ?, ?);";
						try (Connection conn = obtenerConexion();
								PreparedStatement pstmt = conn.prepareStatement(sql)){
							//pstmt.setString(1, j.getId());
							pstmt.setString(2, j.getTitulo());
							pstmt.setDouble(3, j.getPrecio());
							pstmt.setString(4, j.getPlataforma());
							pstmt.executeUpdate();
							System.out.println("Se ha insertado con exito el juego");
						} catch (SQLException e) {
							e.printStackTrace();
						
				
				}
						}
				 }
		   
		   public static void insertarPelicula(Pelicula p) {
				 {
						//Añadir un existe usuario
						String sql = "INSERT INTO Pelicula (id, titulo, precio,  duracion) VALUES (?, ?, ?, ?);";
						try (Connection conn = obtenerConexion();
								PreparedStatement pstmt = conn.prepareStatement(sql)){
							//pstmt.setString(1, p.getId());
							pstmt.setString(2, p.getTitulo());
							pstmt.setDouble(3, p.getPrecio());
							pstmt.setInt(4, p.getDuracion());
							pstmt.executeUpdate();
							System.out.println("Se ha insertado con exito el juego");
						} catch (SQLException e) {
							e.printStackTrace();
						
				
				}
						}
				 }
		   
		  
		/*	public static void eliminarLibro(String id) {
				String sql = "DELETE FROM Libro WHERE id = ?;";
				try (Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)){
					pstmt.setString(1, id);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			*/
		   
		   public static void modificarAlquilerEnTablaLibro(int idLibro) {
			   String sql = "UPDATE Libro Set alquilado = 'S' WHERE id = ? ";
			   try(Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				   pstmt.setInt(1, idLibro);
				   pstmt.executeUpdate();			   
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		   public static void modificarAlquiler2EnTablaLibro(int idLibro) {
			   String sql = "UPDATE Libro Set alquilado = 'N' WHERE id = ? ";
			   try(Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				   pstmt.setInt(1, idLibro);
				   pstmt.executeUpdate();			   
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		   public static void modificarAlquiler2EnTablaJuego(int idJuego) {
			   String sql = "UPDATE Juego Set alquilado = 'N' WHERE id = ? ";
			   try(Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				   pstmt.setInt(1, idJuego);
				   pstmt.executeUpdate();			   
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		   public static void modificarAlquiler2EnTablaPelicula(int idPelicula) {
			   String sql = "UPDATE Pelicula Set alquilado = 'N' WHERE id = ? ";
			   try(Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement(sql)) {
				   pstmt.setInt(1, idPelicula);
				   pstmt.executeUpdate();			   
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		  }
		   
		   
			public static void eliminarJuego(String id) {
				String sql = "DELETE FROM Juego WHERE id = ?;";
				try (Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)){
					pstmt.setString(1,id);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			public static void modificarAlquilerEnTablaJuego(int idJuego) {
				   String sql = "UPDATE Juego Set alquilado = 'S' WHERE id = ? ";
				   try(Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)) {
					   pstmt.setInt(1, idJuego);
					   pstmt.executeUpdate();			   
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			  }
			
			

			public static void eliminarPelicula(String id) {
				String sql = "DELETE FROM Pelicula WHERE id = ?;";
				try (Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)){
					pstmt.setString(1, id);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			public static void modificarAlquilerEnTablaPelicula(int idPelicula) {
				   String sql = "UPDATE Pelicula Set alquilado = 'S' WHERE id = ? ";
				   try(Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)) {
					   pstmt.setInt(1, idPelicula);
					   pstmt.executeUpdate();			   
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			  }
			
			
			  
			public static void eliminarAlquiler(int id) {
				String sql = "DELETE FROM Alquiler WHERE id = ?;";
				try (Connection conn = obtenerConexion();
						PreparedStatement pstmt = conn.prepareStatement(sql)){
					pstmt.setInt(1,id);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		public static void limpiarBd() {
			try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()){
				
				stmt.executeUpdate("DELETE FROM Libro");
				stmt.executeUpdate("DELETE FROM Juego");
				stmt.executeUpdate("DELETE FROM Pelicula");
				stmt.executeUpdate("DELETE FROM Usuario");
				stmt.executeUpdate("DELETE FROM LibroCopia");
				stmt.executeUpdate("DELETE FROM JuegoCopia");
				stmt.executeUpdate("DELETE FROM PeliculaCopia");
				stmt.executeUpdate("DELETE FROM Alquiler");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		public static void EliminarTablaBd() {
			try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()){
				
				stmt.executeUpdate("DROP TABLE Libro");
				stmt.executeUpdate("DROP TABLE Juego");
				stmt.executeUpdate("DROP TABLE Pelicula");
				stmt.executeUpdate("DROP TABLE Usuario");
				stmt.executeUpdate("DROP TABLE LibroCopia");
				stmt.executeUpdate("DROP TABLE JuegoCopia");
				stmt.executeUpdate("DROP TABLE PeliculaCopia");
				stmt.executeUpdate("DROP TABLE Alquiler");
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public static void ActualizarBdAlEliminarUusario() {
			try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement()){
				
				
				
				
			
				stmt.executeUpdate("DELETE FROM LibroCopia");
				stmt.executeUpdate("DELETE FROM JuegoCopia");
				stmt.executeUpdate("DELETE FROM PeliculaCopia");
				System.out.println("Se han eliminado los datos de las tablas copia");
				
				añadirLibrosCopiaDisponibles();
				añadirJuegosCopiaDisponibles();
				añadirPeliculasCopiaDisponibles();
				System.out.println("Se han rellenado las tablas copia");
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
}
