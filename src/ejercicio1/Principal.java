package ejercicio1;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

import ejercicio1.Archivo;

public class Principal {

	public static void main(String[] args) throws IOException {
		/* La funcion la hice teniendo en cuenta la funcion isNumeric de:
		 * https://aprenderjava.net/base/comprobar-si-un-valor-es-un-numero-en-java-guia-y-ejemplos/
		 * Importe desde https://commons.apache.org/proper/commons-lang/download_lang.cgi
		 * se pasa el parametro casteado ejemplo: verificarDniInvalido(dni.ToString())
		 import org.apache.commons.lang3.StringUtils;
		*/
		
		
		Archivo archivo = new Archivo();
		archivo.setRuta(Archivo.ObtenerRutaAbsoluta("Personas.txt"));
		
		TreeSet<Persona> personas = new TreeSet<>(Comparator.comparing(Persona::getApellido));
		
		archivo.cargarPersona(personas,"-");

		
		for(Persona persona: personas) {
			System.out.println(persona.toString()+"\n");
		}	
		
		archivo.escribirArchivo(personas, Archivo.ObtenerRutaAbsoluta("Personas.txt"));
	}
	

}



