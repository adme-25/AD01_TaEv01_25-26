package Ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio4_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		File archivo = new File("./src/main/resources/marvel.dat");
		
		try {
			RandomAccessFile raf = new RandomAccessFile(archivo,"r");
			
			String dniPedido = pedirDni(teclado);
			int pesoPedido = pedirPeso(teclado);

			String dni = "";
			String nombre = "";
			int peso;

			int posicion = 4;
			
			while (posicion < raf.length()) {
				raf.seek(posicion);
				
				for(int i=0; i<9; i++) {
					dni += raf.readChar();
				}
				
				if(dni.equals(dniPedido)) {
					for(int i=0; i<20; i++) {
						nombre += raf.readChar();
					}
					raf.seek(posicion+118);
					peso = raf.readInt();

					compararPeso(nombre,peso,pesoPedido);
					break;
				}
				else {
					dni = "";
					posicion += 130;
				}
			}
			if (!dni.equals(dniPedido)) {
				System.out.print("No existe ningún personaje con ese DNI");
			}
			raf.close();
			teclado.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int pedirPeso(Scanner teclado) {
		System.out.println("Introduzca su peso actual: ");
		int peso = teclado.nextInt();
		return peso;
	}

	public static String pedirDni(Scanner teclado) {
		String dni;
		Pattern formatoUsuario = Pattern.compile("[0-9]{8}[A-Z]");
		Matcher comparaFormato = formatoUsuario.matcher("");
		do {
			System.out.println(
					"Introduzca un DNI válido (ocho digitos y letra Mayúscula) del personaje para el control del peso: ");
			dni = teclado.next();
			comparaFormato = formatoUsuario.matcher(dni);
			if(!comparaFormato.matches()) {
				System.out.println("DNI no valido");
			}
		} while (!comparaFormato.matches());
		return dni;
	}

	public static void compararPeso(String nombre, int pesoPedido, int peso) {

		if (peso < pesoPedido) {
			System.out.println(nombre.trim() + " ha engordado " + (pesoPedido - peso) + " kilos.");
		} else if (peso > pesoPedido) {
			System.out.println(nombre.trim() + " ha adelgazado " + (peso - pesoPedido) + " kilos.");
		} else {
			System.out.println(nombre.trim() + " se mantiene en su peso.");
		}
	}
}
