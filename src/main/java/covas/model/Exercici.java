package covas.model;

/**
 * Clase que representa un ejercicio en el sistema. Contiene información sobre
 * el identificador, el nombre, la descripción y una imagen de demostración
 * asociada al ejercicio.
 *
 * @author Toni Covas
 */
public class Exercici {

    /**
     * Identificador único del ejercicio. Es un valor numérico que diferencia
     * cada ejercicio en el sistema.
     */
    private int id;

    /**
     * Nombre del ejercicio. Especifica el título o el nombre del ejercicio tal
     * como aparecerá en el sistema.
     */
    private String nomExercici;

    /**
     * Descripción del ejercicio. Proporciona detalles adicionales sobre cómo
     * realizar el ejercicio.
     */
    private String descripcio;

    /**
     * Foto de demostración del ejercicio. URL o nombre del archivo de la imagen
     * que ilustra cómo se realiza el ejercicio.
     */
    private String demoFoto;

    /**
     * Obtiene el identificador único del ejercicio.
     *
     * @return Un entero que representa el identificador del ejercicio.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del ejercicio.
     *
     * @param id El entero que representa el identificador único del ejercicio.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del ejercicio.
     *
     * @return Una cadena de texto que representa el nombre del ejercicio.
     */
    public String getNomExercici() {
        return nomExercici;
    }

    /**
     * Establece el nombre del ejercicio.
     *
     * @param nomExercici La cadena de texto que representa el nombre del
     * ejercicio.
     */
    public void setNomExercici(String nomExercici) {
        this.nomExercici = nomExercici;
    }

    /**
     * Obtiene la descripción del ejercicio.
     *
     * @return Una cadena de texto que representa la descripción del ejercicio.
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Establece la descripción del ejercicio.
     *
     * @param descripcio La cadena de texto que representa la descripción del
     * ejercicio.
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    /**
     * Obtiene la foto de demostración del ejercicio.
     *
     * @return Una cadena de texto que representa la URL o el nombre del archivo
     * de la foto de demostración.
     */
    public String getDemoFoto() {
        return demoFoto;
    }

    /**
     * Establece la foto de demostración del ejercicio.
     *
     * @param demoFoto La cadena de texto que representa la URL o el nombre del
     * archivo de la foto de demostración.
     */
    public void setDemoFoto(String demoFoto) {
        this.demoFoto = demoFoto;
    }
}
