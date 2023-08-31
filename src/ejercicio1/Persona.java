package ejercicio1;

public class Persona {
	public static String FILE_PATH = "F:\\Documents\\GitHub\\LABIV-TP3\\bin\\ejercicio1\\Personas.txt";
    private String name;
    private String surname;
    private int dni;

    public Persona(String name, String surname, int dni) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
    }
    public Persona() {
    	this("","",0);
    }
    

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getDni() {
        return dni;
    }
    
    public static Persona setFromLine(String line) throws InvalidDNIException, InvalidDataException {
    	String n, s;
    	int d;
    	String[] data = line.split("-");
    	if(data.length < 3) {
    		throw new InvalidDataException();
    	}
    	n = data[0];
    	s = data[1];
    	try {
    		d = Integer.parseInt(data[2]);
        	return new Persona(n,s,d);
    	} catch(NumberFormatException e) {
    		throw new InvalidDNIException();
    	}
    }

    @Override
    public String toString() {
        return surname + ", " + name + " (DNI N.º " + dni + ")";
    }
}

