package domain;

public class Libro extends Producto{

	private String autor;

	public Libro(String titulo, String precio, String autor) {
		super(titulo, precio);
		this.autor = autor;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor= autor;
	}

	@Override
	public String toString() {
		return "Libro [Autor=" + autor + "]";
	}
	
	
	

}
