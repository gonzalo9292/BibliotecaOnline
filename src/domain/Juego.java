package domain;

public class Juego extends Producto{
	
	private String compania;
	private String plataforma;

	public Juego() {
		
	}




	public Juego(int id,String titulo, double precio, boolean alquilado, String compania, String plataforma) {
		super(id,titulo, precio, alquilado);
		this.compania = compania;
		this.plataforma = plataforma;
	}




	public String getCompania() {
		return compania;
	}


	public void setCompania(String compania) {
		this.compania = compania;
	}


	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}




	@Override
	public String toString() {
		return "Juego [compania=" + compania + ", plataforma=" + plataforma + ", getId()=" + getId() + ", getTitulo()="
				+ getTitulo() + ", getPrecio()=" + getPrecio() + "]";
	}




	
	

}
