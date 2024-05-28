package domain;

public class Libro extends Producto{
	 
	private String autor;
	private int numero_Paginas;

	
	public Libro() {
		
	}

	public Libro(int id,String titulo, double precio, boolean alquilado, String autor, int numero_Paginas) {
		super(id,titulo, precio, alquilado);
		this.autor = autor;
		this.numero_Paginas = numero_Paginas;
	}


	public int getNumPaginas() {
		return numero_Paginas;
	}

	public void setNumPaginas(int numero_Paginas) {
		this.numero_Paginas = numero_Paginas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor= autor;
	}

	@Override
	public String toString() {
		return "Libro [autor=" + autor + ", numero_Paginas=" + numero_Paginas + ", getId()=" + getId()
				+ ", getTitulo()=" + getTitulo() + ", getPrecio()=" + getPrecio() + "]";
	}









	
	







	
	
	

}
