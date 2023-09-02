package ejercicio1;
import java.io.IOException;
import java.util.TreeSet;

import ejercicio1.Archivo;

public class Principal {

	public static void main(String[] args){
TreeSet<Persona> listaDePersonas = new TreeSet<Persona>();
		
		try {
			Archivo nvFichero = new Archivo(Archivo.ObtenerRutaAbsoluta("Personas.txt"));			
			nvFichero.leerArchivo(listaDePersonas);			
		}catch(IOException err) {
			System.out.println("La ruta ingresada no existe.");
		}
		
		try {
			Archivo nvFicheroSalida = new Archivo();
			nvFicheroSalida.escribirArchivo(listaDePersonas, "src\\Resultado.txt");
			System.out.println("El archivo Resultado.txt ya se encuentra disponible");
		} catch (IOException err) {
			System.out.println("El archivo ya existe.");			
		}
	
	}
}



