package ejercicio1;


public class DNIInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DNIInvalidoException() {
		
	}

	@Override
	public String getMessage() {
		return "El DNI ingresado no es válido. ";
	}
	
}
