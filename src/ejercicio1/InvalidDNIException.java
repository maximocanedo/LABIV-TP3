package ejercicio1;

public class InvalidDNIException extends Exception {
	public InvalidDNIException() {
		
	}

	@Override
	public String getMessage() {
		return "El DNI ingresado no es válido. ";
	}
	
}
