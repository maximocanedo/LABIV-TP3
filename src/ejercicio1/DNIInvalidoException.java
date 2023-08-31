package ejercicio1;


public class DNIInvalidoException extends Exception {

	public DNIInvalidoException() {
		
	}

	@Override
	public String getMessage() {
		return "El DNI ingresado no es válido. ";
	}
	
}
