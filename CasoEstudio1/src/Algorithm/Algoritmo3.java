package Algorithm;

/**
 * Clase que proporciona un metodo recursivo para calcular el numero hexagonal 
 * de un entero dado de manera recursiva.
 * 
 * @author Daniel Diaz Garcia
 * @author Oussama Bolbaroud
 * @author Miguel Ahijon Hormigos
 * @author David Marcos Valhondo
 */
public class Algoritmo3 {

    /**
     * Metodo recursivo para calcular el numero hexagonal de un numero entero.
     * <p>
     * La funcion se basa en la ecuacion recursiva:
     * {@code F(n) = (4 * n - 3) + F(n - 1)}, con el caso base {@code F(1) = 1}.
     * </p>
     * <p>
     * La complejidad del algoritmo es de {@code T(n)=O(n)}
     * </p>
     * 
     * @param n El numero entero para calcular su numero hexagonal.
     * @return El numero hexagonal calculado recursivamente.
     */
    private static int F(int n) {
        if (n == 1) {
            return 1;
        }
        return (4 * n - 3) + F(n - 1); 
    } 

    /**
     * Calcula el numero hexagonal de un numero entero dado utilizando una implementacion
     * recursiva.
     * <p>
     * Mide el tiempo de ejecucion del calculo utilizando {@link System#nanoTime()}.
     * </p>
     * 
     * @param n El numero entero para calcular su numero hexagonal.
     * @return Un objeto {@link Par} que contiene el tiempo de ejecucion en nanosegundos
     *         y el resultado del calculo del numero hexagonal.
     */
    public static Par calcularHexagonal(int n) {
        int result = 0;
        long t0, t1, deltaT;
        Par pair = null;
        
        t0 = System.nanoTime();
        result = F(n);
        t1 = System.nanoTime();
        
        deltaT = t1 - t0;
        pair = new Par(deltaT, result);
        
        return pair;
    }
}
