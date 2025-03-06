package Algorithm;

/**
 * Clase que representa un par de valores, compuesto por un tiempo de ejecucion y un numero 
 * entero. Esta clase se utiliza para que los algoritmos devuelvan tanto el tiempo de ejecución
 * como el resultado del algoritmo.
 *
 * @author Daniel Diaz Garcia
 * @author Oussama Bolbaroud
 * @author Miguel Ahijon Hormigos
 * @author David Marcos Valhondo
 */
public class Par {
    /** Tiempo de ejecucion en nanosegundos. */
    private long time;

    /** Resultado del calculo numerico. */
    private int n;

    /**
     * Constructor que inicializa un objeto {@code Par} con el tiempo de ejecucion y el resultado.
     *
     * @param time Tiempo de ejecucion en nanosegundos.
     * @param n Resultado del calculo numerico.
     */
    public Par(long time, int n) {
        this.time = time;
        this.n = n;
    }

    /**
     * Obtiene el tiempo de ejecucion almacenado.
     *
     * @return El tiempo de ejecucion en nanosegundos.
     */
    public long getTime() {
        return time;
    }

    /**
     * Establece el tiempo de ejecucion.
     *
     * @param time El tiempo de ejecucion en nanosegundos.
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Obtiene el resultado del calculo numerico almacenado.
     *
     * @return El valor numerico calculado.
     */
    public int getN() {
        return n;
    }

    /**
     * Establece el resultado del calculo numerico.
     *
     * @param n El nuevo valor numerico.
     */
    public void setN(int n) {
        this.n = n;
    }
}
