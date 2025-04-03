package covas.model;

/**
 * Clase que representa a un usuario en el sistema. Contiene información básica
 * sobre el usuario, como su identificador, nombre, correo electrónico,
 * contraseña encriptada, foto de perfil y su rol como instructor.
 *
 * @author Toni Covas
 */
public class Usuari {

    /**
     * Identificador único del usuario. Este valor es utilizado para distinguir
     * cada usuario en el sistema.
     */
    private int id;

    /**
     * Nombre del usuario. Representa el nombre asociado al usuario en el
     * sistema.
     */
    private String nom;

    /**
     * Correo electrónico del usuario. Utilizado para el inicio de sesión y como
     * medio de comunicación.
     */
    private String email;

    /**
     * Contraseña encriptada del usuario. Almacena el hash de la contraseña para
     * garantizar la seguridad.
     */
    private String passwordHash;

    /**
     * Foto de perfil del usuario. Contiene la imagen en formato de array de
     * bytes.
     */
    private byte[] foto;

    /**
     * Indica si el usuario tiene el rol de instructor. {@code true} si el
     * usuario es un instructor; {@code false} en caso contrario.
     */
    private boolean instructor;

    
    
    
    /**
     * Obtiene el identificador único del usuario.
     *
     * @return Un entero que representa el identificador del usuario.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     *
     * @param id El entero que representa el identificador del usuario.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Una cadena de texto que representa el nombre del usuario.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nom La cadena de texto que representa el nombre del usuario.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return Una cadena de texto que representa el correo electrónico del
     * usuario.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param email La cadena de texto que representa el correo electrónico del
     * usuario.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el hash de la contraseña del usuario.
     *
     * @return Una cadena de texto que representa el hash de la contraseña del
     * usuario.
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Establece el hash de la contraseña del usuario.
     *
     * @param passwordHash La cadena de texto que representa el hash de la
     * contraseña del usuario.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Obtiene la foto de perfil del usuario.
     *
     * @return Un array de bytes que representa la foto de perfil del usuario.
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     * Establece la foto de perfil del usuario.
     *
     * @param foto Un array de bytes que representa la foto de perfil del
     * usuario.
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    /**
     * Indica si el usuario tiene el rol de instructor.
     *
     * @return {@code true} si el usuario es un instructor, {@code false} en
     * caso contrario.
     */
    public boolean isInstructor() {
        return instructor;
    }

    /**
     * Establece si el usuario tiene el rol de instructor.
     *
     * @param instructor {@code true} si el usuario será instructor,
     * {@code false} en caso contrario.
     */
    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }
}
