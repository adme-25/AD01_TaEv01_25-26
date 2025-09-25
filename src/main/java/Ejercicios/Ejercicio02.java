package Ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File archivo = new File("./src/main/resources/ejercicio2.txt");
		int contador = 0;
		int numLetras = 0;
		String masLarga = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			String linea;
			
			while((linea= br.readLine()) != null) {
				String[] palabras = linea.split(" ");
	            for (int x = 0; x < palabras.length; x++) {
	                String palabra = palabras[x];
	                for (int z =0; z <palabra.length(); z++) {
	                   contador += 1;
	                   if(contador > numLetras) {
	                	   numLetras = contador;
	                	   masLarga = palabra;
	                   }
	                }
	            contador = 0;
	            }
			}
			System.out.print(masLarga + " tiene " + numLetras + " letras.");
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
