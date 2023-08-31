package ejercicio1;

public class Main {
	
    public static void main(String[] args) {
    	Archivo arch = new Archivo(Persona.FILE_PATH);
    	arch.readLines(line -> {
    		//System.out.println(line);
    		try {
    			Persona p = Persona.setFromLine(line);
    			System.out.println(p.toString());
    		} catch(Exception e) {
    			System.out.println("[ERROR] " + e.getMessage());
    		}
    	});
    	
    }

}
