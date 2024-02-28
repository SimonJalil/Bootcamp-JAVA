package model.domain;
import java.util.Scanner;

public class Desafio_1{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Solicito al usuario ingresar la fecha
		System.out.println("Ingrese a una fecha (dd/mm/yyyy): ");
		String fecha = scanner.nextLine();
		
		// Divido el string en tres partes
		String[] partes = fecha.split("/");
		int dia = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		int anio = Integer.parseInt(partes[2]);
		
		// Aplico la funcion validar fecha
		if(validarFecha(dia,mes,anio)) {
			System.out.println("La fecha ingresada es VALIDA");
		}
		else{
			System.out.println("La fecha ingresada es INVALIDA");
		}
	}

	private static boolean validarFecha(int dia, int mes, int anio) {
		
		// Valido el año
		if(!(anio >= 0 && anio <= 9999)) {
			return false;
		}
		
		// Valido el rango del mes
		if(!(mes >= 1 && mes <= 12)) {
			return false;
		}
		
		// Validar el rango del dia considerando el mes
		if(mes == 2) {
			if(esAnioBisiesto(anio)) {
				return (dia >= 1 && dia <= 29);
			}
			else {
				return (dia >1 && dia <= 28);
			}
		}
		else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			return (dia >= 0 && dia <= 30);
		}
		else {
			return (dia >= 0 && dia <= 31);
		}
	}

	private static boolean esAnioBisiesto(int anio) {
		/**
		 * Condiciones Año bisiesto:
		 * 		- Si el año es divisible por 4 pero no por 100.
		 * 		- Si es divisible por 400
		 * */
		
		return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
	}
	

	
}