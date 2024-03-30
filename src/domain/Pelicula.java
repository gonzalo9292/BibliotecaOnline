package domain;

public class Pelicula extends Producto{
	private int duracion;

	public Pelicula(String titulo, String precio, int duracion) {
		super(titulo, precio);
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
