package ejercicio1;
import ejercicio1.Archivo;

public class Principal {

	public static void main(String[] args) {
		/* La funcion la hice teniendo en cuenta la funcion isNumeric de:
		 * https://aprenderjava.net/base/comprobar-si-un-valor-es-un-numero-en-java-guia-y-ejemplos/
		 * Importe desde https://commons.apache.org/proper/commons-lang/download_lang.cgi
		 * se pasa el parametro casteado ejemplo: verificarDniInvalido(dni.ToString())
		 import org.apache.commons.lang3.StringUtils;
		 
		public static void verificarDniInvalido(String dni) throws DNIInvalidoException{
			Boolean esValido= StringUtils.isNumeric(dni);
			
			if(!esValido)
				throw new DNIInvalidoException();
			
		}*/
		Archivo archivo = new Archivo();
		System.out.println(Archivo.ObtenerRutaAbsoluta("Personas.txt"));
		String ruta= Archivo.ObtenerRutaAbsoluta("Personas.txt");
		System.out.println(ruta); 
		archivo.setRuta(Archivo.ObtenerRutaAbsoluta(ruta));
		
		archivo.leer();
		
	}

}
