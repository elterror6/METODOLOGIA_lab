package CasoEstudio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String menu = "Cálculo de números hexagonales\n_______________________________\n\t1) Cálculo con fórmula fija.\n\t2) Cálculo de manera iterativa.\n\t3) Cálculo de manera recursiva.\n\t4) Salir\n¿Qué opción quiere escoger? ";
		String icc = "Cálculo de número hexagonal con ecuación cerrada\n________________________________________________\n¿Cuál número hexagonal desea calcular? ";
		String ici = "Cálculo de número hexagonal de forma iterativa\n______________________________________________\n¿Cuál número hexagonal desea calcular? ";
		String icr = "Cálculo de número hexagonal de forma recursiva\n______________________________________________\n¿Cuál número hexagonal desea calcular? ";
		
		Interfaz interfaz = new Interfaz (menu);
		int option=0;
		Scanner in = new Scanner(System.in);
		do {
			interfaz.setInterface(menu);
			System.out.println(interfaz.getInterface());
			option = in.nextInt();
			switch (option) {
				case 1:
					interfaz.setInterface(icc);
					System.out.println(interfaz.getInterface());
					break;
				case 2:
					interfaz.setInterface(ici);
					System.out.println(interfaz.getInterface());
					break;
				case 3:
					interfaz.setInterface(icr);
					System.out.println(interfaz.getInterface());
					break;
				case 4:
					System.out.println("Goodbye.");
					break;
				default:
					System.out.println("Opción no válida.");
			}
		} while (option!=4);
	}

}
