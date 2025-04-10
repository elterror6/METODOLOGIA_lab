package CasoEstudio3.Negocio;

import java.util.Arrays;
import java.util.Collections;

/**
 * Esta clase contiene el algoritmo voraz del caso de estudio 3. Este algoritmo realiza
 * un relleno del suelo priorizando las baldosas de mayor tamaño, haciendo que tenga un
 * parecido al problema del cambio de dinero.
 * 
 * @author Daniel Díaz García
 * @author Oussama Bolbaroud
 * @author 
 * @author 
 */
public class GreedyAlgorithm {

	/**
	 * Rellena un suelo (matriz de n x n) con baldosas utilizando una estrategia
	 * voraz.
	 * <p>
	 * El método recorre cada celda del suelo y, para cada celda vacía (valor 0),
	 * intenta colocar la baldosa de mayor tamaño posible disponible. Los tamaños de
	 * baldosas se reciben en el array {@code tiles} y se ordenan de mayor a menor
	 * para priorizar aquellas que cubren mayor área.
	 * <p>
	 * Para cada celda vacía, se recorre la lista de baldosas y se llama al método
	 * {@link #fits(int[][], int, int, int)} para comprobar si la baldosa de un
	 * tamaño determinado cabe en esa posición sin salirse de los límites ni
	 * solaparse con otras baldosas ya colocadas. Si {@code fits} retorna
	 * {@code true}, se coloca la baldosa llamando al método
	 * {@link #place(int[][], int, int, int)} y, para optimizar el recorrido, se
	 * salta el bloque de celdas que ahora quedan cubiertas por esa baldosa.
	 * <p>
	 * <strong>Complejidad:</strong>
	 * <ul>
	 * <li><strong>Ordenación de tiles:</strong> Se ordena el array de baldosas con
	 * {@code Arrays.sort(tiles, Collections.reverseOrder())} lo que tiene una
	 * complejidad de O(T log T), donde T es el número de tipos de baldosa.</li>
	 * <li><strong>Recorrido de la matriz:</strong> Se recorren n<sup>2</sup>
	 * celdas. En cada celda vacía se itera sobre los T tipos de baldosa. En el peor
	 * caso, si ningún tipo encaja, se realizan T llamadas al método {@code fits}.
	 * </li>
	 * <li><strong>Método {@code fits}:</strong> Comprueba que la baldosa de tamaño
	 * {@code tileSize} cabe en la posición dada y recorre un bloque de
	 * {@code tileSize} × {@code tileSize} celdas para verificar que están vacías.
	 * Su complejidad es O(tileSize<sup>2</sup>); en el peor caso, tileSize puede
	 * ser O(n), por lo que {@code fits} tiene complejidad O(n<sup>2</sup>).</li>
	 * <li><strong>Método {@code place}:</strong> Rellena el bloque de
	 * {@code tileSize} × {@code tileSize} en la matriz, lo que implica una
	 * complejidad O(tileSize<sup>2</sup>), también O(n<sup>2</sup>) en el peor
	 * caso.</li>
	 * </ul>
	 * <p>
	 * Por lo tanto, en el peor escenario, el algoritmo tiene una complejidad de O(T
	 * · n<sup>2</sup> · n<sup>2</sup>) = O(T · n<sup>4</sup>).
	 * <p>
	 * Sin embargo, en la práctica la optimización de "saltar" las celdas ya
	 * cubiertas reduce significativamente el número de iteraciones en los casos
	 * promedio, haciendo que el tiempo de ejecución medio sea mucho menor.
	 *
	 * @param tiles Un array de {@code Integer} con los tamaños disponibles de las
	 *              baldosas. Se espera que contenga los tamaños en metros (por
	 *              ejemplo, {3, 2, 1}).
	 * @param n     La dimensión del suelo, de modo que el suelo es una matriz n x
	 *              n.
	 * @return Una matriz de enteros de tamaño n x n que representa el suelo
	 *         rellenado con las baldosas; en cada celda se almacena el tamaño de la
	 *         baldosa que cubre esa posición o 0 si está vacío.
	 *
	 * @see #fits(int[][], int, int, int)
	 * @see #place(int[][], int, int, int)
	 */
	public static int[][] tileFloor(Integer[] tiles, int n) {
		int[][] solution = new int[n][n];

		Arrays.sort(tiles, Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (solution[i][j] == 0) { // Celda vacía
					// Intenta colocar la baldosa más grande posible en esta celda
					for (int k = 0; k < tiles.length; k++) {
						int tileSize = tiles[k];
						if (fits(solution, tileSize, i, j)) {
							place(solution, tileSize, i, j);
							// Avanza j para saltar el bloque ya cubierto por la baldosa
							j += tileSize - 1;
							break; // Se colocó una baldosa, salir del for de tipos
						}
					}
				} else {
					j += solution[i][j]-1;
				}
			}
		}

		return solution;

	}

	/**
	 * Determina si una baldosa de tamaño {@code tileSize} puede colocarse en la posición especificada del suelo.
     * <p>
     * Este método verifica dos aspectos fundamentales:
     * <ol>
     *   <li>
     *     Que la baldosa no se salga de los límites del suelo. Se comprueba que al sumar el tamaño de la
     *     baldosa a la fila y a la columna de la posición dada no se supere la dimensión {@code n} del suelo.
     *   </li>
     *   <li>
     *     Que todas las celdas del bloque que ocuparía la baldosa se encuentren libres (es decir, tengan el valor 0).
     *   </li>
     * </ol>
     * <p>
     * La complejidad de este método depende del área que se verifica, recorriendo un bloque de
     * {@code tileSize} &times; {@code tileSize} celdas. En el peor caso, cuando {@code tileSize} es comparable a {@code n},
     * la complejidad es O(n<sup>2</sup>).
     *
     * @param floor    Una matriz de enteros que representa el suelo.
     * @param tileSize El tamaño de la baldosa que se desea colocar.
     * @param row      La fila del suelo donde se quiere colocar la baldosa.
     * @param col      La columna del suelo donde se quiere colocar la baldosa.
     * @return         {@code true} si la baldosa de tamaño {@code tileSize} cabe en la posición (row, col)
     *                 sin salirse de los límites ni solaparse con otra baldosa; de lo contrario, {@code false}.
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
	* Coloca una baldosa de tamaño {@code tileSize} en el suelo a partir de la posición (row, col).
     * <p>
     * Este método rellena el bloque de {@code tileSize} &times; {@code tileSize} en la matriz {@code floor}
     * comenzando en la posición (row, col) y asigna en cada celda el valor de {@code tileSize}. Esto indica que
     * esa celda está cubierta por una baldosa de dicho tamaño.
     * <p>
     * La complejidad de este método es O(tileSize<sup>2</sup>), ya que recorre todas las celdas que ocupará la baldosa.
     * En el peor caso, cuando {@code tileSize} es comparable a {@code n}, la complejidad es O(n<sup>2</sup>).
     *
     * @param floor    La matriz que representa el suelo.
     * @param tileSize El tamaño de la baldosa que se va a colocar.
     * @param row      La fila del suelo donde se inicia la colocación.
     * @param col      La columna del suelo donde se inicia la colocación.
	 */
	public static void place(int[][] floor, int tileSize, int row, int col) {
		for (int i = 0; i < tileSize; i++) {
			for (int j = 0; j < tileSize; j++) {
				floor[row + i][col + j] = tileSize;
			}
		}
	}
}
