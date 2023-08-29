package ejercicio1;
import org.apache.commons.lang3.StringUtils;
public class ClaseTemp {
	/* La funcion la hice teniendo en cuenta la funcion isNumeric de:
	 * https://aprenderjava.net/base/comprobar-si-un-valor-es-un-numero-en-java-guia-y-ejemplos/
	 * Importe desde https://commons.apache.org/proper/commons-lang/download_lang.cgi
	 * se pasa el parametro casteado ejemplo: verificarDniInvalido(dni.ToString())
	 */
	public static void verificarDniInvalido(String dni) throws DNIInvalidoException{
		Boolean esValido= StringUtils.isNumeric(dni);
		
		if(!esValido)
			throw new DNIInvalidoException();
		
	}
	public static void main(String[] args) {
		String dni= "asd6265sad";
		try {
			ClaseTemp.verificarDniInvalido(dni);
		} catch (DNIInvalidoException e) {
			e.printStackTrace();
		}
	}

}
