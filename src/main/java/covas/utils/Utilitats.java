package covas.utils;

import covas.vistas.Main;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Clase de utilidades para gestionar recursos de imágenes utilizados en la
 * aplicación. Proporciona métodos para obtener imágenes o íconos desde la
 * carpeta de recursos.
 *
 * @author Toni Covas
 */
public class Utilitats {

    /**
     * Obtiene una imagen desde la carpeta de recursos de la aplicación.
     *
     * @param nomFitxer El nombre del archivo de la imagen (incluyendo la
     * extensión, por ejemplo, "imagen.jpg").
     * @return Un objeto de tipo {@code Image} correspondiente a la imagen
     * cargada.
     */
    public static Image obtenirImage(String nomFitxer) {
        // Obtenir la URL de l'arxiu de imatge
        URL iconURL = Main.class.getResource("/images/" + nomFitxer);

        // Crear un ImageIcon a partir de la URL
        ImageIcon icon = new ImageIcon(iconURL);

        // Obtenir la imatge del icono
        Image image = icon.getImage();

        return image;
    }

    /**
     * Obtiene un ícono desde la carpeta de recursos de la aplicación.
     *
     * @param nomFitxer El nombre del archivo del ícono (incluyendo la
     * extensión, por ejemplo, "icono.png").
     * @return Un objeto de tipo {@code ImageIcon} correspondiente al ícono
     * cargado.
     */
    public static ImageIcon obtenirIcon(String nomFitxer) {
        // Obtenir la URL de l'arxiu de imatge
        URL iconURL = Main.class.getResource("/images/" + nomFitxer);

        // Crear un ImageIcon a partir de la URL
        ImageIcon icon = new ImageIcon(iconURL);

        return icon;
    }

}
