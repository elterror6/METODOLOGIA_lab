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
	public static int[][] tileFloor (Integer[] tiles, int n) {
		int current = 0, roomSize = 0, oldTileY = 0;
		int[][] solution = new int[n][n];
		Coordinate c = new Coordinate (0,0);
		
		fillfloor(solution);

		Arrays.sort(tiles, Collections.reverseOrder());
		
		do {
			if (tileFits(solution, tiles[current],c,oldTileY)){ 
				//TODO: Método para reducir el roomSize
				addTile (solution, c, tiles[current]);
			} else {
				oldTileY = c.getY();
				c.setY(0);
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
	private static boolean tileFits (int[][] a, int m, Coordinate c, int oldTileY) {
		boolean solution = true;
		if (c.getX()+m > a[c.getY()].length-1 && c.getY()+m > a.length-1) {
			solution = false;
		} else if (c.getX()+m <= a[c.getY()].length) {
			if (c.getY() == 0) {
				c.setY(m);
			}
			c.setX(c.getX()+m);
		} else if (c.getY()+m <= a.length) {
			if (c.getOldY() >= oldTileY) {
				c.setX(0);
			} else {
				c.setX(c.getOldX());
			}
			c.setY(c.getY()+m);
		}
		return solution;
	}
	/**
	 * Este método se encarga de añadir la baldosa al suelo.
	 * 
	 * @param a El array que representa el suelo.
	 * @param c El objeto coordenada que contiene donde se va a meter.
	 * @param m El tamaño de la baldosa.
	 */
	private static void addTile (int[][] a, Coordinate c, int m) {
		for (int i = c.getOldY(); i < c.getY(); i++) {
			for (int j = c.getOldX(); j < c.getX(); j++) {
				a[i][j]=m;
			}
		}
	}
	private static void fillfloor(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			Arrays.fill(a[i], 0);
			
		}
	}
}
