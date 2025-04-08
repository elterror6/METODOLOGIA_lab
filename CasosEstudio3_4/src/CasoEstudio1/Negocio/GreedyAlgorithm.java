package CasoEstudio1.Negocio;

import java.util.Arrays;
import java.util.Collections;

/**
 * The Class GreedyAlgorithm.
 */
public class GreedyAlgorithm {

	/**
	 * Tile floor.
	 *
	 * @param tiles the tiles
	 * @param n     the n
	 * @return the int[][]
	 */
	public static int[][] tileFloor(Integer[] tiles, int n) {
		int current = 0, roomSize = n * n;
		int[][] solution = new int[n][n];

		Arrays.sort(tiles, Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (solution[i][j] == 0) {  // Celda vacía
                    boolean placed = false;
                    // Intenta colocar la baldosa más grande posible en esta celda
                    for (int k = 0; k < tiles.length; k++) {
                        int tileSize = tiles[k];
                        if (fits(solution, tileSize, i, j)) {
                            place(solution, tileSize, i, j);
                            roomSize -= tileSize * tileSize;
                            placed = true;
                            // Avanza j para saltar el bloque ya cubierto por la baldosa
                            j += tileSize - 1;
                            break; // Se colocó una baldosa, salir del for de tipos
                        }
                    }
                    // Si ninguna baldosa se ajusta en ese hueco, márcalo (por ejemplo, con -1)
                    if (!placed) {
                        solution[i][j] = 0;
                    }
                }
            }
        }

		return solution;

	}
	
	/**
	 * Este método comprueba si una baldosa cabe o no en el suelo. A su vez,
	 * también calcula donde se va a alojar la baldosa, guardando las coordenadas
	 * en el objeto Coordinate pasado por parametros.
	 *
	 * @param floor El array que representa el suelo.
	 * @param tileSize El tamaño de la actual baldosa.
	 * @param position El objeto Coordinate que indica donde va a estar la baldosa.
	 * @return true, si la baldosa de tamaño m cabe en el suelo.
	 */
	public static boolean fits(int[][] floor, int tileSize, int row, int col) {
	    int n = floor.length;
	    if (col + tileSize > n || row + tileSize > n) {
	        return false;
	    }
	    
	    for (int i = row; i < row + tileSize; i++) {
	    	for (int j = col; j < col + tileSize; j++) {
	    		if (floor[i][j] != 0) {
	    			return false;
	    		}
	    	}
	    }
	    return true;
	}
	/**
	 * Este método se encarga de añadir la baldosa al suelo.
	 * 
	 * @param a El array que representa el suelo.
	 * @param c El objeto coordenada que contiene donde se va a meter.
	 * @param m El tamaño de la baldosa.
	 */
	public static void place(int[][] floor, int tileSize, int row, int col) {
	    for (int i = 0; i < tileSize; i++) {
	        for (int j = 0; j < tileSize; j++) {
	            floor[row + i][col + j] = tileSize;
	        }
	    }
	}
}
