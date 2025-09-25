package Ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio4_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int [] ids= {1, 2, 3, 4, 5, 6, 7};
        String[] dnis= {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
        String[] noms= {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
        String[] identidades = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
        String[] tipos = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
        int[] pesos = {76,84,66,136,78,102,70};
        int[] alturas = {178,183,156,152,177,182,188};
        
		File archivo = new File("./src/main/resources/marvel.dat");
        try {
			RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
			StringBuffer buffer = null;
	        int x = ids.length;
	      	
	        for (int i = 0; i<x; i++) {
	        	
	        	raf.writeInt(ids[i]);
	        	
	         	buffer = new StringBuffer(dnis[i]);
	         	buffer.setLength(9);
	         	raf.writeChars(buffer.toString());
	         	
	         	buffer = new StringBuffer(noms[i]);
	         	buffer.setLength(20);
	         	raf.writeChars(buffer.toString());
	         	
	         	buffer = new StringBuffer(identidades[i]);
	         	buffer.setLength(20);
	         	raf.writeChars(buffer.toString());
	         	
	         	buffer = new StringBuffer(tipos[i]);
	         	buffer.setLength(10);
	         	raf.writeChars(buffer.toString());
	            
	            raf.writeInt(pesos[i]);
	            raf.writeInt(alturas[i]);
	         }
	         raf.close();
	         System.out.print("La carga de los personajes ha terminado correctamente");

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
