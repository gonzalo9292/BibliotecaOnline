package domain;

public class Pelicula extends Producto{
	
	private String director;
	private int duracion;
	//private int anyo;
	
	
	public Pelicula() {
		
	}


	

	public Pelicula(int id,String titulo, double precio, boolean alquilado, String director, int duracion) {
		super(id,titulo, precio, alquilado);
		this.director = director;
		this.duracion = duracion;
	}




	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}




	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", duracion=" + duracion + ", getId()=" + getId() + ", getTitulo()="
				+ getTitulo() + ", getPrecio()=" + getPrecio() + "]";
	}




	





	/*public int getAnyo() {
		return anyo;
	}


	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	*/
	
	
}
