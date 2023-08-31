package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class Archivo {
		
	private String ruta;
	
	public Archivo() {
		
	}
	
	public Archivo(String ruta)
	{
		this.ruta = ruta;
	}
	
	public boolean existe() {
		File archivo = new File(ruta);
		if(archivo.exists())
					return true;
		return false;
	}
	
	
	public boolean crearArchivo() {
			FileWriter escritura;
			try {
				escritura = new FileWriter(ruta, true);
				escritura.write("");
				escritura.close();
				return true;
			}	catch (IOException e) {
				e.printStackTrace();
			}
			return false;
	}

	public void escribir(String palabra) {
		try {
			FileWriter entrada = new FileWriter(ruta, true);
			BufferedWriter buffer = new BufferedWriter(entrada);
			buffer.write(palabra);
			buffer.close();
			entrada.close();
					
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	public static String ObtenerRutaAbsoluta(String nombreArchivo) {
		String rutaAbsoluta;
		try {
			rutaAbsoluta= new File(nombreArchivo).getAbsolutePath();
			rutaAbsoluta = rutaAbsoluta.replace("\\", "\\\\");
		}catch(SecurityException e){
			rutaAbsoluta= null;
		}catch(Exception e){
			rutaAbsoluta= null;
		}
				
		return rutaAbsoluta;
	}
	 
	public int leer() {  
		FileReader entrada;
		int cantLineas=0;
		try {
			entrada = new FileReader(ruta);
			BufferedReader buffer = new BufferedReader(entrada);
			
			String linea = "";
			while(linea!= null) {
				System.out.println(linea);
				linea = buffer.readLine();
				cantLineas++;
			}
			entrada.close();
			buffer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se encontro el archvo");
		}
		return cantLineas;
	}
	public void cargarPersona(ArrayList<Persona> personas, String separador) throws IOException {
		FileReader entrada;
		try {
			entrada = new FileReader(ruta);
			BufferedReader buffer = new BufferedReader(entrada);
			
			String linea = "";
			while(linea!= null){
				linea = buffer.readLine();
				
				try{
					String []v= linea.split(separador);
					personas.add(new Persona(v[0],v[1],v[2]));
				}catch(NullPointerException e) {
					System.out.println("A");

					entrada.close();
					buffer.close();
					return;
				}
				catch(ArrayIndexOutOfBoundsException e) {		
					System.out.println("A");

					entrada.close();
					buffer.close();
					return;
				}
				
			}
			entrada.close();
			buffer.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se encontro el archvo");
		}
		
}
	///GETS SETS
	public String getRuta() {
		return ruta;
	}
	
	


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	

}
