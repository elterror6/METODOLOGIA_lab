package Algorithm;

public class Algoritmo2 {
	public static Par calcularHexagonal(int n) {
        int resultado=0;
        long t0, t1, deltaT;
        Par pair = null;
        t0=System.nanoTime();
        for (int i = 0; i < n; i++) {
            resultado += (4 * i + 1);
        }
        t1=System.nanoTime();
        deltaT = t1-t0;
        pair = new Par (deltaT,resultado);
        return pair;
    }
}
