package Algorithm;

/**
 * Clase que representa un par de valores, compuesto por un tiempo de ejecución y un número entero.
 * <p>
 * Se utiliza para almacenar el tiempo que tomó un cálculo y el resultado correspondiente.
 * </p>
 */
public class Par {
    /** Tiempo de ejecución en nanosegundos. */
    private long time;

    /** Resultado del cálculo numérico. */
    private int n;

    /**
     * Constructor que inicializa un objeto {@code Par} con el tiempo de ejecución y el resultado.
     *
     * @param time Tiempo de ejecución en nanosegundos.
     * @param n Resultado del cálculo numérico.
     */
    public Par(long time, int n) {
        this.time = time;
        this.n = n;
    }

    /**
     * Obtiene el tiempo de ejecución almacenado.
     *
     * @return El tiempo de ejecución en nanosegundos.
     */
    public long getTime() {
        return time;
    }

    /**
     * Establece el tiempo de ejecución.
     *
     * @param time El tiempo de ejecución en nanosegundos.
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Obtiene el resultado del cálculo numérico almacenado.
     *
     * @return El valor numérico calculado.
     */
    public int getN() {
        return n;
    }

    /**
     * Establece el resultado del cálculo numérico.
     *
     * @param n El nuevo valor numérico.
     */
    public void setN(int n) {
        this.n = n;
    }
}
