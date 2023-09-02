package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;


public class Archivo {
		
	private String path;
	private File archivo = null;	
	
	public Archivo(String rutaArchivo) throws IOException {
		this.path=rutaArchivo;
		archivo = new File(path);
		if(archivo.exists() == false) {
			throw new IOException();
		}
	}
	
	public Archivo() {}
	
	public void leerArchivo(TreeSet<Persona> listadoPersonas) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			String nombre, apellido;
			String dni=null;
			
			String cadena=null;
			
			while((cadena=bf.readLine()) != null) {
				String[] listaAux = cadena.split("-");
				
				if(listaAux.length == 3) {
					nombre = listaAux[0];
					apellido = listaAux[1];
					try {
						if(Persona.verificarNumeroDNI(listaAux[2])) {
							dni= listaAux[2];
						}
				}catch(DNIInvalidoException err) {
					dni="0";
				}
				listadoPersonas.add(new Persona(nombre,apellido,dni));			
				}						
			}
			
			bf.close();
			
		}catch(IOException err) {
			System.out.println(err.getMessage());
		}				 		
	}
	
	
	public boolean existe() {
		File archivo = new File(path);
		if(archivo.exists())
					return true;
		return false;
	}
	
	
	public boolean crearArchivo() {
			FileWriter escritura;
			try {
				escritura = new FileWriter(path, true);
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
			FileWriter entrada = new FileWriter(path, true);
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
			entrada = new FileReader(path);
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
	
	
	public void escribirArchivo(TreeSet<Persona> personas,String ruta)throws IOException {
		File f = new File(ruta);
		
		if(!f.exists()){
			try {
				BufferedWriter buffer = new BufferedWriter(new FileWriter(f,true));
				for(Persona p : personas) {
					buffer.write(p.getNombre() + "-" + p.getApellido() + "-" + ((p.getDNI() != "0") ? p.getDNI() : "DNI INVALIDO"));
					buffer.newLine();
				}
				buffer.close();
			}catch(IOException e) { 
				e.printStackTrace();
			}			
		}else {
			throw new IOException();
		}
	}
	 
	///GETS SETS
	public String getRuta() {
		return path;
	}
	
	


	public void setRuta(String ruta) {
		this.path = ruta;
	}
	

}
