package domain;

public class Juego extends Producto{
	private String plataforma;

	public Juego(String titulo, String precio, String plataforma) {
		super(titulo, precio);
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
