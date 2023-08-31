package ejercicio1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import ejercicio1.Archivo;

public class Principal {

	public static void main(String[] args) throws IOException {
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
		archivo.setRuta(Archivo.ObtenerRutaAbsoluta("Personas.txt"));
		
		ArrayList<Persona> personas= new ArrayList<Persona>();
		
		archivo.cargarPersona(personas,"-");

		
		for(int i=0; i<personas.size();i++) {
			System.out.println(personas.get(i).getApellido());	
		}	
	}

}
