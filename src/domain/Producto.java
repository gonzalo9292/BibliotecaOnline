package domain;

public abstract class Producto {
	private static int contadorProducto = 111;
	
	
	


	private int id;
	private String titulo;
	private double precio;
	private boolean alquilado;
	
	public Producto(int id,String titulo, double precio, boolean alquilado) {
		super();
		//this.id = contadorProducto;
		//contadorProducto++;
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.setAlquilado(alquilado);
	}

	
	public Producto() {}

	
	
	public static int getContadorProducto() {
		return contadorProducto;
	}


	public static void setContadorProducto(int contadorProducto) {
		Producto.contadorProducto = contadorProducto;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", precio=" + precio + "]";
	}


	public boolean isAlquilado() {
		return alquilado;
	}


	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}





	
	
	
	
	

}
