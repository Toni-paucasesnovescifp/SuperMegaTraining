/**
 * Contiene clases de utilidad que proporcionan funcionalidades auxiliares para la aplicación.
 * Estas clases incluyen métodos comunes, como el formateo de fechas o la obtención de recursos gráficos,
 * que pueden ser reutilizados en distintas partes de la aplicación.
 */
package covas.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField;

/**
 * Clase que implementa un formateador de etiquetas de fecha para componentes
 * Swing. Permite convertir una cadena en un objeto de tipo fecha y viceversa,
 * utilizando un formato específico definido por el patrón "dd-MM-yyyy".
 *
 * @author Toni Covas
 */
public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern = "dd-MM-yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

    /**
     * Convierte una cadena en un objeto de tipo fecha.
     *
     * @param text La cadena de texto que representa una fecha en el formato
     * "dd-MM-yyyy".
     * @return Un objeto que representa la fecha convertida.
     * @throws ParseException Si la cadena no cumple con el formato definido.
     */
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }

    /**
     * Convierte un objeto de tipo fecha en una cadena con formato específico.
     *
     * @param value El objeto que representa una fecha (de tipo Calendar).
     * @return Una cadena de texto que representa la fecha en el formato
     * "dd-MM-yyyy".
     * @throws ParseException Si ocurre un error en el formato del objeto.
     */
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }

        return "";
    }
}
