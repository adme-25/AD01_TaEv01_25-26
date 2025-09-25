package Ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		File archivo = new File("./src/main/resources/marvel.dat");
		
		String tipoPedido = pedirTipo(teclado);
		String dni = "";
		String nombre = "";
		String identidad = "";
		String tipo= "";
		int peso;
		int altura;

		int posicion = 102;
		String tipoEncontrado = "";
		int contador = 0;
		
		MarvelPerson personaje;
		ArrayList<MarvelPerson> marvel = new ArrayList<MarvelPerson>();
		
		try {
			RandomAccessFile raf = new RandomAccessFile(archivo,"r");
			while (posicion < raf.length()) {
				raf.seek(posicion);

				for (int i = 0; i < 10; i++) {
					tipo += raf.readChar();
				}
				if ((tipo.trim()).equals(tipoPedido)) {
					contador++;
					tipoEncontrado = tipo.trim();
					raf.seek(posicion - 98);
					for (int i = 0; i < 9; i++) {
						dni += raf.readChar();
					}
					for (int i = 0; i < 20; i++) {
						nombre += raf.readChar();
					}
					for (int i = 0; i < 20; i++) {
						identidad += raf.readChar();
					}
					raf.seek(posicion + 20);
					peso = raf.readInt();
					altura = raf.readInt();

					personaje = new MarvelPerson(dni,nombre.trim(),identidad.trim(),tipo.trim(),peso,altura);
					marvel.add(personaje);
				}
				posicion += 130;
				tipo = "";
				dni = "";
				nombre = "";
				identidad = "";
			}
			if (!tipoEncontrado.equals(tipoPedido)) {
				System.out.println("No existe el tipo " + tipoPedido + " en el fichero.");
			} else {
				System.out.println("Se han encontrado " + contador + " personajes del tipo " + tipoPedido + ":");
				imprimir(marvel);
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
	public static String pedirTipo(Scanner teclado) {
		System.out.print("Introduzca un tipo de personaje: ");
		String tipo = teclado.nextLine();
		return tipo;
	}

	public static void imprimir(ArrayList<MarvelPerson> lista) {
		for(int i = 0; i<lista.size(); i++) {
			MarvelPerson personaje = lista.get(i);
			System.out.println(personaje.toString());
		}
	}
}
