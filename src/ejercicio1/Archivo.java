package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {

    private String path;
    
    public Archivo() {
    	
    }
    public Archivo(String path) {
    	this.path = path;
    }

    public boolean exists() {
        File file = new File(path);
        return file.exists();
    }

    public boolean create() {
        try {
            FileWriter writer = new FileWriter(path, true);
            writer.write("");
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void writeCharByChar(String phrase) {
        try {
            FileWriter writer = new FileWriter(path, true);

            for (int i = 0; i < phrase.length(); i++) {
                writer.write(phrase.charAt(i));
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCharByChar() {
        try {
            FileReader reader = new FileReader(path);
            int c = reader.read();

            while (c != -1) {
                char letter = (char) c;
                System.out.println(letter);
                c = reader.read();
            }

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeLines(String phrase) {
        try {
            FileWriter writer = new FileWriter(path, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(phrase);
            buffer.close();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void originalReadLines(IReadingAction<String> action) {
        try {
            FileReader reader = new FileReader(path);
            BufferedReader buffer = new BufferedReader(reader);

            String line;
            while ((line = buffer.readLine()) != null) {
                action.exec(line);
            }

            buffer.close();
            reader.close();

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public void readLines() {
    	originalReadLines(data -> System.out.println(data));
    }
    public void readLines(IReadingAction<String> action) {
    	originalReadLines(action);
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
