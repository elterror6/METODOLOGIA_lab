package CasoEstudio4.Negocio;

/**
 * Clase que representa un festival.
 * <p>
 * Cada festival se define por su nombre, día de inicio, día de finalización y precio total de la entrada.
 * Además, se calcula la duración del festival en días (incluyendo tanto el día de inicio como el día de finalización).
 * </p>
 * 
 * @version 1.0
 */
public class Festival {
    private String name;
    private int start;
    private int end;
    private int price;
    private int days;

    /**
     * Constructor para crear un objeto Festival.
     * 
     * @param name  Nombre del festival.
     * @param start Día de inicio del festival.
     * @param end   Día de finalización del festival.
     * @param price Precio total de la entrada.
     */
    public Festival(String name, int start, int end, int price) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.price = price;
        // Calcula la duración del festival considerando ambos extremos.
        this.days = end - start + 1;
    }

    /**
     * Devuelve el nombre del festival.
     * 
     * @return el nombre del festival.
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve el día de inicio del festival.
     * 
     * @return el día de inicio.
     */
    public int getStart() {
        return start;
    }

    /**
     * Devuelve el día de finalización del festival.
     * 
     * @return el día de finalización.
     */
    public int getEnd() {
        return end;
    }

    /**
     * Devuelve el precio total de la entrada del festival.
     * 
     * @return el precio total.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Devuelve la duración del festival en días.
     * 
     * @return el número de días que dura el festival.
     */
    public int getDays() {
        return days;
    }

    /**
     * Devuelve una representación en cadena de la información del festival.
     * 
     * @return Cadena que incluye el nombre, duración, día de inicio, día de finalización y precio del festival.
     */
    @Override
    public String toString() {
        return name + " (Días: " + days + ", Inicio: " + start + ", Fin: " + end + ", Precio: " + price + ")";
    }
}

