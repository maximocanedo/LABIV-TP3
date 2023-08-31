package ejercicio1;

public class InvalidDataException extends Exception {
	public InvalidDataException() {
		
	}

	@Override
	public String getMessage() {
		return "La cadena no posee los elementos necesarios. ";
	}
}
