package CasoEstudio1.Negocio;

// TODO: Auto-generated Javadoc
/**
 * Esta clase representa una coordenada xy, pero guardando el anterior valor
 * de cada coordenada. Esta clase esta creada exclusivamente para poder utilizarla
 * en el caso de estudio 3 para poder localizar donde se va a insertar una baldosa.
 * 
 * @author Daniel Diaz Garcia
 */
public class Coordinate {
	
	/** La coordenada x. */
	private int x;
	
	/** La coordenada y. */
	private int y;
	
	/** La antigua coordenada x. */
	private int oldX;
	
	/** La antigua coordenada y. */
	private int oldY;
	
	/**
	 * Instancia una nueva coordenada xy.
	 *
	 * @param x La coordenada x
	 * @param y La coordenada y
	 */
	public Coordinate (int x, int y) {
		this.x = x;
		this.y = y;
		this.oldX = this.x;
		this.oldY = this.y;
	}

	/**
	 * Devuelve el actual de la coordenada x.
	 *
	 * @return El valor de la coordenada x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Introduce un nuevo valor para la coordenada x. El valor anterior
	 * de la coordenada x pasa a ser la antigua  coordenada de x.
	 *
	 * @param x El nuevo valor de la coordenada x.
	 */
	public void setX(int x) {
		this.oldX = this.x;
		this.x = x;
	}

	/**
	 * Devuelve el actual de la coordenada y.
	 *
	 * @return El valor de la coordenada y.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Introduce un nuevo valor para la coordenada y. El valor anterior
	 * de la coordenada x pasa a ser la antigua  coordenada de y.
	 *
	 * @param y El nuevo valor de la coordenada y
	 */
	public void setY(int y) {
		this.oldY = this.y;
		this.y = y;
	}

	/**
	 * Devuelve el antiguo valor de la coordenada x.
	 *
	 * @return El antiguo valor de la coordenada x.
	 */
	public int getOldX() {
		return oldX;
	}

	/**
	 * GDevuelve el antiguo valor de la coordenada y.
	 *
	 * @return El antiguo valor de la coordenada y.
	 */
	public int getOldY() {
		return oldY;
	}
	
	
}
