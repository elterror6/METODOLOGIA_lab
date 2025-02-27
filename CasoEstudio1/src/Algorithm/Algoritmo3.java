package Algorithm;

public class Algoritmo3 {
	private static int F(int n) {
        if (n == 1) {
            return 1;
        }
        return (4 * n - 3) + F(n - 1); 
    } 
	public static Par calcularHexagonal (int n) {
		int result = 0;
		long t0, t1, deltaT;
		Par pair = null;
		
		t0=System.nanoTime();
		result = F(n);
		t1=System.nanoTime();
		
		deltaT = t1-t0;
		pair = new Par (deltaT,result);
		
		return pair;
	}
}
