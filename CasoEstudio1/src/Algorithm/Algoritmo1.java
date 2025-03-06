package Algorithm;

/**
 * Clase que proporciona un metodo para calcular el numero hexagonal 
 * de un entero dado con formula cerrada.
 * 
 * @author Daniel Diaz Garcia
 * @author Oussama Bolbaroud
 * @author Miguel Ahijon Hormigos
 * @author David Marcos Valhondo
 */
public class Algoritmo1 {

    /**
     * Calcula el numero hexagonal de un numero entero dado con la formula cerrada.
     * <p>
     * Un numero hexagonal se define por la formula: 
     * {@code H(n) = n * (2n - 1)}
     * </p>
     * <p>
     * La complejidad de este algoritmo es de <code>T(n)=&Theta;(1)</code>
     * </p>
     * 
     * @param n El numero entero para calcular su numero hexagonal.
     * @return Un objeto {@link Par} que contiene el tiempo de ejecucion en nanosegundos
     *         y el resultado del calculo del numero hexagonal.
     */
    public static Par calcularHexagonal(int n) {
        int result;
        Par pair = null;
        long t0, t1, deltaT;
        
        t0 = System.nanoTime();
        result = n * (2 * n - 1);
        t1 = System.nanoTime();
        
        deltaT = t1 - t0;
        pair = new Par(deltaT, result);
        
        return pair;
    }
}
