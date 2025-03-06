package CasoEstudio1;
/**
 * Esta clase representa una interfaz gráfica básica para
 * realizar un menu con varias opciones.
 * 
 * @author Daniel Diaz Garcia
 * @author Oussama Bolbaroud
 * @author Miguel Ahijon Hormigos
 * @author David Marcos Valhondo
 */
public class Interfaz {
	
	/** La interfaz con las opciones. */
	private String intrfc;
	
	/**
	 * Crea una nueva instancia de la clase Interfaz.
	 *
	 * @param menu El menú de la clase.
	 */
	public Interfaz (String intrfc) {
		this.intrfc = intrfc;
	}
	/**
	 * Devuelve la interfaz.
	 * 
	 * @return La interfaz introducida en la clase.
	 */
	public String getInterface () {
		return this.intrfc;
	}
	/**
	 * Actualiza la interfaz de la clase.
	 * 
	 * @param intrfc La nueva interfaz.
	 */
	public void setInterface (String intrfc) {
		this.intrfc = intrfc;
	}
}
