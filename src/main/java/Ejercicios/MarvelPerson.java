package Ejercicios;

import java.io.Serializable;

public class MarvelPerson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7448026338579603627L;
	
	private String dni;
	private String nombre;
	private String identidad;
	private String tipo;
	private int peso;
	private int altura;

	public MarvelPerson(String dni, String nombre, String identidad, String tipo, int peso, int altura) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.identidad = identidad;
		this.tipo = tipo;
		this.peso = peso;
		this.altura = altura;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentidad() {
		return identidad;
	}

	public void setIdentidad(String identidad) {
		this.identidad = identidad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	   @Override
	   public String toString() {
	      return String.format(
	         	"SuperHeroe [dni=%-9s, nombre=%-15s, identidad=%-20s, tipo=%-10s, peso=%-3d, altura=%-4d]",
	         	dni, nombre, identidad, tipo, peso, altura);
	   }

}
