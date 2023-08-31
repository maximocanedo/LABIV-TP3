package ejercicio1;

import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static int repetidos = 0;
	public static int erroneos = 0;
	public static int sanos = 0;
	
    public static void main(String[] args) {
    	Set<Persona> personasUnicas = new HashSet<>();
    	
    	Archivo people = new Archivo(Persona.FILE_PATH);
    	Archivo res = new Archivo(Persona.RESULTS_PATH);
    	res.clearFile();
    	
    	people.readLines(line -> {
    		try {
    			Persona p = Persona.setFromLine(line);
    			if(!personasUnicas.add(p)) {
    				repetidos++;
    			} else {
    				sanos++;
    				res.writeLines(p.toString() + "\n");
    			}
    		} catch(Exception e) {
    			System.out.println("[ERROR] " + e.getMessage());
    			erroneos++;
    		}
    	});
    	
    	System.out.println("Detalles de la operación: \n\t" + repetidos + " registros duplicados.\n\t" + erroneos + " registros mal estructurados.\n\t" + sanos + " registros correctamente parseados. \n");
    }

    public static void mainLegacy(String[] args) {
    	Archivo people = new Archivo(Persona.FILE_PATH);
        Set<Persona> personasUnicas = new HashSet<>();
    	people.readLines(line -> {
    		try {
    			Persona p = Persona.setFromLine(line);
    			if(!personasUnicas.add(p)) {
    				repetidos++;
    			} else sanos++;
    		} catch(Exception e) {
    			System.out.println("[ERROR] " + e.getMessage());
    			erroneos++;
    		}
    	});
    	for (Persona p : personasUnicas) {
            String linea = p.toString();
            Archivo res = new Archivo(Persona.RESULTS_PATH);
            res.writeLines(linea + "\n");
        }
    	System.out.println("Detalles de la operación: \n"+repetidos+" registros duplicados.\n"+erroneos+" registros mal estructurados.\n"+sanos+" registros correctamente parseados. \n");
    }
    
}
