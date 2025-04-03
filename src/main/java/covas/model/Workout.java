package covas.model;

/**
 * Clase que representa un entrenamiento (Workout) en el sistema. Contiene
 * información como la fecha del entrenamiento, comentarios, y el identificador
 * del usuario al que pertenece este entrenamiento.
 *
 * @author Toni Covas
 */
public class Workout {

    /**
     * Identificador único del entrenamiento. Utilizado para diferenciar cada
     * entrenamiento en el sistema.
     */
    private int id;

    /**
     * Fecha del entrenamiento. Representa el día en que se realizó o programó
     * este entrenamiento.
     */
    private String forDate;

    /**
     * Comentarios adicionales del entrenamiento. Proporciona detalles o notas
     * relevantes sobre el entrenamiento.
     */
    private String comments;

    /**
     * Identificador único del usuario asociado al entrenamiento. Indica a qué
     * usuario pertenece este entrenamiento.
     */
    private int idUsuari;

    /**
     * Constructor por defecto de la clase Workout. Inicializa un entrenamiento
     * vacío sin datos predefinidos.
     */
    public Workout() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa un entrenamiento con comentarios.
     *
     * @param comments Comentarios relevantes sobre el entrenamiento.
     */
    public Workout(String comments) {
        this.comments = comments;
    }

    /**
     * Obtiene el identificador único del entrenamiento.
     *
     * @return El entero que representa el identificador del entrenamiento.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del entrenamiento.
     *
     * @param id El entero que representa el identificador del entrenamiento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha del entrenamiento.
     *
     * @return Una cadena que representa la fecha del entrenamiento.
     */
    public String getForDate() {
        return forDate;
    }

    /**
     * Establece la fecha del entrenamiento.
     *
     * @param forDate Una cadena que representa la fecha del entrenamiento.
     */
    public void setForDate(String forDate) {
        this.forDate = forDate;
    }

    /**
     * Obtiene el identificador único del usuario asociado al entrenamiento.
     *
     * @return El entero que representa el identificador del usuario.
     */
    public int getIdUsuari() {
        return idUsuari;
    }

    /**
     * Establece el identificador único del usuario asociado al entrenamiento.
     *
     * @param idUsuari El entero que representa el identificador del usuario.
     */
    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    /**
     * Obtiene los comentarios del entrenamiento.
     *
     * @return Una cadena que representa los comentarios del entrenamiento.
     */
    public String getComments() {
        return comments;
    }

    /**
     * Establece los comentarios del entrenamiento.
     *
     * @param comments Una cadena que representa los comentarios del
     * entrenamiento.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
