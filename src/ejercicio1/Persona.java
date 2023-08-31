package ejercicio1;

public class Persona {
	public static String FILE_PATH = "Personas.txt";
	public static String RESULTS_PATH = "Resultados.txt";
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
    
    public boolean equals(Object o) {
        return (o == null || getClass() != o.getClass()) || (this == o || ((Persona) o).dni == this.dni);
    }
    public int hashCode() {
    	return this.dni;
    }

    @Override
    public String toString() {
        return surname + ", " + name + " (DNI N.º " + dni + ")";
    }
}

