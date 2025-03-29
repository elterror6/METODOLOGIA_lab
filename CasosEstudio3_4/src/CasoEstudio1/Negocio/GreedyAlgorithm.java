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
	 * @param n the n
	 * @return the int[][]
	 */
	public int[][] tileFloor (Integer[] tiles, int n) {
		int current = 0, roomSize=0, oldTileX, oldTileY;
		int[][] solution = null;
		Coordinate c = new Coordinate (0,0);
		//TODO: Método para inicializar la solución.
		Arrays.sort(tiles, Collections.reverseOrder());
		
		do {
			if (tileFits(solution, tiles[current],c)){ 
				//TODO: Método para reducir el roomSize
				addTile (solution, c, tiles[current]);
			} else {
				++current;
			}
		}while(roomSize>0 || current < tiles.length);

	return solution;

	}
	
	/**
	 * Este método comprueba si una baldosa cabe o no en el suelo. A su vez,
	 * también calcula donde se va a alojar la baldosa, guardando las coordenadas
	 * en el objeto Coordinate pasado por parametros.
	 *
	 * @param a El array que representa el suelo.
	 * @param m El tamaño de la actual baldosa.
	 * @param c El objeto Coordinate que indica donde va a estar la baldosa.
	 * @return true, si la baldosa de tamaño m cabe en el suelo.
	 */
	private boolean tileFits (int[][] a, int m, Coordinate c) {
		boolean solution = true;
		if (c.getX()+m > a[c.getY()].length && c.getY()+m > a.length) {
			solution = false;
		} else if (c.getX()+m < a[c.getY()].length) {
			if (c.getY() == 0) {
				c.setY(m);
			}
			c.setX(c.getX()+m);
		} else if (c.getY()+m < a.length) {
			c.setX(0);
			c.setY(c.getY()+m);
		}
		return solution;
	}
	
	private void addTile (int[][] a, Coordinate c, int m) {
		for (int i = c.getOldY(); i <= c.getY(); i++) {
			for (int j = c.getOldX(); j <= c.getX(); j++) {
				a[i][j]=m;
			}
		}
	}
}
