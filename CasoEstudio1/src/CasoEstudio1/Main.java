package CasoEstudio1;

import java.util.Scanner;
import Algorithm.*;

public class Main {

	public static void main(String[] args) {
		String menu = "C�lculo de n�meros hexagonales\n_______________________________\n\t1) C�lculo con f�rmula fija.\n\t2) C�lculo de manera iterativa.\n\t3) C�lculo de manera recursiva.\n\t4) Salir\n�Qu� opci�n quiere escoger? ";
		String icc = "C�lculo de n�mero hexagonal con ecuaci�n cerrada\n________________________________________________\n�Cu�l n�mero hexagonal desea calcular? ";
		String ici = "C�lculo de n�mero hexagonal de forma iterativa\n______________________________________________\n�Cu�l n�mero hexagonal desea calcular? ";
		String icr = "C�lculo de n�mero hexagonal de forma recursiva\n______________________________________________\n�Cu�l n�mero hexagonal desea calcular? ";
		
		Interfaz interfaz = new Interfaz (menu);
		int option=0, n;
		Par pair;
		Scanner in = new Scanner(System.in);
		do {
			n=0;
			pair=null;
			interfaz.setInterface(menu);
			System.out.println(interfaz.getInterface());
			option = in.nextInt();
			switch (option) {
				case 1:
					interfaz.setInterface(icc);
					System.out.println(interfaz.getInterface());
					n = in.nextInt();
					pair=Algoritmo1.calcularHexagonal(n);
					System.out.println("Resultado: "+pair.getN()+" ["+pair.getTime()+"ns]");
					break;
				case 2:
					interfaz.setInterface(ici);
					System.out.println(interfaz.getInterface());
					n = in.nextInt();
					pair = Algoritmo2.calcularHexagonal(n);
					System.out.println("Resultado: "+pair.getN()+" ["+pair.getTime()+"ns]");
					break;
				case 3:
					interfaz.setInterface(icr);
					System.out.println(interfaz.getInterface());
					n = in.nextInt();
					pair = Algoritmo3.calcularHexagonal(n);
					System.out.println("Resultado: "+pair.getN()+" ["+pair.getTime()+"ns]");
					break;
				case 4:
					System.out.println("Goodbye.");
					break;
				default:
					System.out.println("Opci�n no v�lida.");
			}
		} while (option!=4);
	}

}
