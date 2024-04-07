package domain;

public class Juego extends Producto{
	
	private String plataforma;

	
	public Juego(String id, String titulo, double precio, String plataforma) {
		super(id, titulo, precio);
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	@Override
	public String toString() {
		return "Juego [plataforma=" + plataforma + "]";
	}
	
	

}
