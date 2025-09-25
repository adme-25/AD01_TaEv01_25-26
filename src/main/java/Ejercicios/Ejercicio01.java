package Ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = new File("./src/main/resources/ejercicio1.txt");
		File salida = new File("./src/main/resources/reversoEjercicio1.txt");
		
		int i;
		String texto = "";
		String reverso = "";
		
		try {
			FileReader fr = new FileReader(archivo);
			FileWriter fw = new FileWriter(salida);
			
			while((i = fr.read())!= -1){
				texto += (char)i;
			}
			String[] palabras = texto.split(" ");

            for (int x = 0; x < palabras.length; x++) {
                String palabra = palabras[x];
                for (int z = palabra.length() - 1; z >= 0; z--) {
                   reverso += palabra.charAt(z);
                   
                }
                fw.write(reverso + " ");
                System.out.print(reverso + " ");
                reverso = "";
            }
            fr.close();
            fw.close();
		}catch (FileNotFoundException e){
			e.printStackTrace();
	    }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
