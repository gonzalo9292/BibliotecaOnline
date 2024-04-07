package domain;

public class Pelicula extends Producto{
	private int duracion;

	
	

	public Pelicula(String id, String titulo, double precio, int duracion) {
		super(id, titulo, precio);
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Pelicula [Duracion=" + duracion + "]";
	}
	
	
	
	
	
}
