package domain;

public class Producto {
	private String titulo;
	private String precio;
	
	
	public Producto(String titulo, String precio) {
		super();
		this.titulo = titulo;
		this.precio = precio;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Producto [titulo=" + titulo + ", precio=" + precio + "]";
	}
	
	
	
	
	

}
