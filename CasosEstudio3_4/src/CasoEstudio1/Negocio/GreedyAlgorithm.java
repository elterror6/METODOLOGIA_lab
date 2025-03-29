package CasoEstudio1.Negocio;
import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgorithm {
	
	public int[][] tileFloor (Integer[] tiles, int n) {
		int current = 0;
		int roomSize=0;
		int[][] solution = null;
		//TODO: Método para inicializar la solución.
		Arrays.sort(tiles, Collections.reverseOrder());
		
		do {
			if (true==true//TODO: Método para ver si la baldosa actual cabe en el suelo) {
				//TODO: Método para determinar la posición de la baldosa actual.
				//TODO: Método para reducir el roomSize
				//TODO: Método para añadir la baldosa a la solución
			} else {
				++current;
			}
			
		} while (roomSize > 0);
		
		return solution;
	}
}
