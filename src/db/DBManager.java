package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Juego;
import domain.Libro;
import domain.Pelicula;
import domain.Usuario;

public class DBManager {
	

	private static final String URL = "jdbc:sqlite:resorces/db/Biblioteca.db";
	
	
	
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
						+ "    	saldo DOUBLE,\n"
						+ "    	contrasena VARCHAR(255),\n"
						+ "    	nombre_usuario VARCHAR(50) PRIMARY KEY ); ");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		public static void crearTablaJuego() {
			try (Connection conn =  obtenerConexion();
					Statement stmt = conn.createStatement()) {
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Juego (\n"
						+ "     id VARCHAR(30)  PRIMARY KEY ,\n"
					    + "     titulo VARCHAR(30) ,\n"
					    + "     precio DOUBLE,\n"    
					    + "     plataforma VARCHAR(30) );");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void crearTablaLibro() {
			try (Connection conn = obtenerConexion();
					Statement stmt = conn.createStatement()){
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Libro (\n"
					    + "     id VARCHAR(30)  PRIMARY KEY,\n"
					    + "     titulo VARCHAR(30) ,\n"
					    + "     precio DOUBLE,\n"    
					    + "     autor VARCHAR(30) );");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void crearTablaPelicula() {
			try (Connection conn = obtenerConexion();
					Statement stmt = conn.createStatement()){
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Pelicula (\n"
						+ "     id VARCHAR(30)  PRIMARY KEY,\n"
					    + "     titulo VARCHAR(30),\n"
					    + "     precio DOUBLE,\n"    
					    + "     duracion INTEGER );");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void añadirLibrosDisponibles() {
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Libro (id, titulo, precio, autor) VALUES "
												       
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
		
		public static void añadirJuegosDisponibles() {
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Juego (id, titulo, precio, plataforma) VALUES "
					        + "('15', 'The Elder Scrolls V: Skyrim', 39.99, 'PC'), "
					        + "('16', 'Assassis Creed Valhalla', 59.99, 'PlayStation 5'), "
					        + "('17', 'Super Smash Bros. Ultimate', 59.99, 'Nintendo Switch'), "
					        + "('18', 'Spider-Man: Miles Morales', 49.99, 'PlayStation 5'), "
					        + "('19', 'Halo Infinite', 59.99, 'Xbox Series X'), "
					        + "('20', 'Resident Evil Village', 49.99, 'PC'), "
					        + "('21', 'Cyberpunk 2077', 49.99, 'PlayStation 5'), "
					        + "('22', 'Legend of Zelda: Skyward Sword HD', 59.99, 'Nintendo Switch'), "
					        + "('23', 'Forza Horizon 5', 59.99, 'Xbox Series X'), "
					        + "('24', 'Deathloop', 59.99, 'PlayStation 5'), "
					        + "('25', 'Ratchet & Clank: Rift Apart', 69.99, 'PlayStation 5'), "
					        + "('26', 'Pokémon Brilliant Diamond and Shining Pearl', 59.99, 'Nintendo Switch'), "
					        + "('27', 'Final Fantasy VII Remake Intergrade', 69.99, 'PlayStation 5'), "
					        + "('28', 'God of War Ragnarok', 69.99, 'PlayStation 5'), "
					        + "('29', 'Far Cry 6', 59.99, 'PlayStation 5'), "
					        + "('30', 'Battlefield 2042', 59.99, 'PC')");){
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void añadirPeliculasDisponibles() {
			try (Connection conn = obtenerConexion();
					PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Pelicula (id, titulo, precio, duracion) VALUES "
							+ "('1', '1984', 15.99, 'George Orwell'), "
							+ "('2', 'To Kill a Mockingbird', 12.50, 'Harper Lee'), "
							+ "('3', 'The Great Gatsby', 10.99, 'F. Scott Fitzgerald'), "
							+ "('4', 'Harry Potter and the Philosophers Stone', 19.99, 'J.K. Rowling'), "
							+ "('5', 'The Catcher in the Rye', 9.95, 'J.D. Salinger'), "
							+ "('6', 'Pride and Prejudice', 11.25, 'Jane Austen'), "
							+ "('7', 'The Hobbit', 14.50, 'J.R.R. Tolkien'), "
							+ "('8', 'Lord of the Flies', 8.99, 'William Golding'), "
							+ "('9', 'Brave New World', 13.75, 'Aldous Huxley'), "
							+ "('10', 'The Lord of the Rings: The Fellowship of the Ring', 22.99, 'J.R.R. Tolkien'), "
							+ "('11', 'Moby-Dick', 16.50, 'Herman Melville'), "
							+ "('12', 'The Hunger Games', 11.99, 'Suzanne Collins'), "
							+ "('13', 'The Da Vinci Code', 14.25, 'Dan Brown'), "
							+ "('14', 'Gone with the Wind', 17.95, 'Margaret Mitchell'), "
							+ "('15', 'The Hitchhikers Guide to the Galaxy', 10.50,'Douglas Adams'), "
							+ "('16', 'Inception', 9.99, 'Christopher Nolan'), "
							+ "('17', 'The Shawshank Redemption', 12.75, 'Frank Darabont'), "
							+ "('18', 'The Godfather', 14.99, 'Francis Ford Coppola'), "
							+ "('19', 'Pulp Fiction', 11.25, 'Quentin Tarantino'), "
							+ "('20', 'Fight Club', 13.50, 'David Fincher'), "
							+ "('21', 'Forrest Gump', 16.99, 'Robert Zemeckis'), "
							+ "('22', 'The Matrix', 9.50, 'Lana Wachowski, Lilly Wachowski'), "
							+ "('23', 'Titanic', 18.75, 'James Cameron'), "
							+ "('24', 'The Silence of the Lambs', 15.25, 'Jonathan Demme'), "
							+ "('25', 'The Dark Knight', 19.50, 'Christopher Nolan'), "
							+ "('26', 'Schindlers List', 14.25, 'Steven Spielberg'), "
							+ "('27', 'Gladiator', 12.99, 'Ridley Scott'), "
							+ "('28', 'The Lord of the Rings: The Return of the King', 21.99, 'Peter Jackson'), "
							+ "('29', 'Goodfellas', 17.25, 'Martin Scorsese'), "
							+ "('30', 'The Lion King', 11.50, 'Roger Allers, Rob Minkoff'), "
							+ "('31', 'The Green Mile', 16.25, 'Frank Darabont'), "
							+ "('32', 'Inglourious Basterds', 14.99, 'Quentin Tarantino'), "
							+ "('33', 'The Departed', 13.75, 'Martin Scorsese'), "
							+ "('34', 'Saving Private Ryan', 15.50, 'Steven Spielberg'), "
							+ "('35', 'The Prestige', 11.99, 'Christopher Nolan'), "
							+ "('36', 'The Shawshank Redemption', 12.75, 'Frank Darabont'), "
							+ "('37', 'The Godfather: Part II', 15.99, 'Francis Ford Coppola'), "
							+ "('38', 'The Dark Knight Rises', 18.50, 'Christopher Nolan'), "
							+ "('39', 'Interstellar', 17.75, 'Christopher Nolan'), "
							+ "('40', 'The Departed', 13.75, 'Martin Scorsese')");){
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static List<Libro> obtenerLibrosBD(){
			List<Libro> listaLibros = new ArrayList<>();
			try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement())
			
			{ ResultSet rs = stmt.executeQuery("SELECT * FROM Libro");
				while(rs.next()) {
				Libro libro = new Libro(null, null, 0.0, null);
				//Usuario
				libro.setId(rs.getString("id"));
			    libro.setTitulo(rs.getString("titulo"));
				libro.setPrecio(rs.getDouble("precio"));
				libro.setAutor(rs.getString("autor"));
			
				//Añadir a la lista el usuario
				listaLibros.add(libro);
				}
				
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
			return listaLibros;
		}
		
		
		
		public static List<Juego> obtenerJuegosBD(){
			List<Juego> listaJuegos = new ArrayList<>();
			try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement())
			
			{ ResultSet rs = stmt.executeQuery("SELECT * FROM Juego");
				while(rs.next()) {
				Juego juego = new Juego(null, null, 0.0, null);
				//Usuario
				juego.setId(rs.getString("id"));
			    juego.setTitulo(rs.getString("titulo"));
				juego.setPrecio(rs.getDouble("precio"));
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
			List<Pelicula> listaPeliculas = new ArrayList<>();
			try(Connection conn = obtenerConexion();
				Statement stmt = conn.createStatement())
			
			{ ResultSet rs = stmt.executeQuery("SELECT * FROM Pelicula");
				while(rs.next()) {
				Pelicula pelicula = new Pelicula(null, null, 0.0, 0);
				//Usuario
				pelicula.setId(rs.getString("id"));
			    pelicula.setTitulo(rs.getString("titulo"));
				pelicula.setPrecio(rs.getDouble("precio"));
				pelicula.setDuracion(rs.getInt("duracion"));
			
				//Añadir a la lista el usuario
				listaPeliculas.add(pelicula);
				}
				
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
			return listaPeliculas;
		}
		
		
		
		
		
		
		
		
		
		
		
}
