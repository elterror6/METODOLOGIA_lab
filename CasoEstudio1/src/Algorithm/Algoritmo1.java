package Algorithm;

public class Algoritmo1 {
	public static Par calcularHexagonal(int n) {
		 int result;
		 Par pair = null;
		 long t0,t1, deltaT;
		 t0= System.nanoTime();
	     result = n * (2 * n - 1);
	     t1= System.nanoTime();
	     deltaT = t1-t0;
	     pair = new Par (deltaT, result);
	     return pair;    
	}
}
