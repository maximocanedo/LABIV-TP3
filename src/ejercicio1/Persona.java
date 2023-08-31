package ejercicio1;

public class Persona {
	private String nombre, apellido, DNI;
	
	public Persona() {
		this.nombre = "Sin asignar";
		this.apellido = "Sin asignar";
		DNI = "Sin asignar";
	}
	
	public Persona(String nombre, String apellido, String dNI) {
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
	}

	@Override
	public String toString() {
		return apellido+ ", " +nombre   + ", DNI: " + DNI ;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
		
}
