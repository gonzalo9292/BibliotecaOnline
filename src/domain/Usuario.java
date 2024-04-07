package domain;

public class Usuario {
	
	private String dni;
	private String nombre;
	private String apellidos;
	private double saldo;
	private String nombreUsuario;
	private String contrase�a;
	
	


	public Usuario(String dni, String nombre, String apellidos, double saldo, String nombreUsuario, String contrase�a) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.saldo = saldo;
		this.nombreUsuario = nombreUsuario;
		this.contrase�a = contrase�a;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}


	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo
				+ ", nombreUsuario=" + nombreUsuario + ", contrase�a=" + contrase�a + "]";
	}



	
	
	
	

}
