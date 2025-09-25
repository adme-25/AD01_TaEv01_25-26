package Ejercicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File pdf = new File("./src/main/resources/Formato_tareas.pdf");
        FileInputStream fis;
		try {
			fis = new FileInputStream(pdf);
	        byte[] archivo = new byte[4];
	        fis.read(archivo);
	        byte[] pdfValido = {37, 80, 68, 70};
	     	  
	        if (Arrays.equals(archivo, pdfValido)) {
	           System.out.print("El archivo pdf es valido");
	        } else {
	           System.out.print("El archivo pdf no es valido");
	        }
	        
	        fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
