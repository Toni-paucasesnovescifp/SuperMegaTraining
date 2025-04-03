package covas.dataaccess;

import covas.model.Usuari;
import covas.model.Exercici;
import covas.model.Workout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Clase que proporciona acceso a los datos del sistema, interactuando con la
 * base de datos. Contiene métodos para realizar operaciones CRUD sobre
 * usuarios, entrenamientos y ejercicios.
 *
 * @author Mike
 */
public class DataAccess {

    /**
     * Establece una conexión con la base de datos.
     *
     * @return Un objeto {@code Connection} que representa la conexión con la
     * base de datos.
     */
    private static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            //properties.load(DataAccess.class.getClassLoader().getResourceAsStream("properties/application.properties"));
            //connection = DriverManager.getConnection(properties.getProperty("connectionUrl"));
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=simulapdb;user=sa;password=Pwd1234;encrypt=false;trustServerCertificate=false;loginTimeout=10;";
            String connectionStringAzureSQLServer = "jdbc:sqlserver://simulapsqlserver.database.windows.net:1433;database=simulapdb25;user=simulapdbadmin@simulapsqlserver;password=Pwd1234.;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            connection = DriverManager.getConnection(connectionStringAzureSQLServer);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Obtiene un usuario de la base de datos en función de su correo
     * electrónico.
     *
     * @param email El correo electrónico del usuario.
     * @return Un objeto {@code Usuari} que representa al usuario, o
     * {@code null} si no existe.
     * @throws Exception Si ocurre algún error durante la consulta.
     * @throws SQLException Si ocurre un error relacionado con SQL.
     */
    public static Usuari getUser(String email) throws Exception, SQLException {
        Usuari user = null;
        String sql = "SELECT * FROM Usuaris WHERE Email = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            user = new Usuari();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                user.setFoto(resultSet.getBytes("Foto")); // Leer el campo Foto
            }
        }

        if (user.getId() == 0) {
            user = null;
        }
        return user;
    }

    /**
     * Obtiene todos los usuarios de la base de datos.
     *
     * @return Una lista de objetos {@code Usuari} que representa todos los
     * usuarios.
     */
    public static ArrayList<Usuari> getAllUsers() {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris ";

        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                user.setFoto(resultSet.getBytes("Foto")); // Leer el campo Foto
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }

    /**
     * Obtiene todos los usuarios asignados a un instructor específico.
     *
     * @param idInstructor El identificador único del instructor.
     * @return Una lista de objetos {@code Usuari} que representa los usuarios
     * del instructor.
     */
    public static ArrayList<Usuari> getAllUsersByInstructor(int idInstructor) {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE AssignedInstructor=?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idInstructor);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }

    /**
     * Obtiene una lista de entrenamientos (Workouts) asociados a un usuario.
     *
     * @param user El usuario cuyo historial de entrenamientos se quiere
     * consultar.
     * @return Una lista de objetos {@code Workout} que representa los
     * entrenamientos del usuario.
     */
    public static ArrayList<Workout> getWorkoutsPerUser(Usuari user) {
        ArrayList<Workout> workouts = new ArrayList<>();
        String sql = "SELECT Workouts.Id, Workouts.ForDate, Workouts.UserId, Workouts.Comments"
                + " FROM Workouts"
                + " WHERE Workouts.UserId=?"
                + " ORDER BY Workouts.ForDate";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, user.getId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Workout workout = new Workout();
                workout.setId(resultSet.getInt("Id"));
                workout.setForDate(resultSet.getString("ForDate"));
                workout.setIdUsuari(resultSet.getInt("UserId"));
                workout.setComments(resultSet.getString("Comments"));

                workouts.add(workout);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workouts;

    }

    /**
     * Recupera todos los ejercicios asociados a un entrenamiento específico.
     *
     * @param workout El objeto Workout que representa el entrenamiento del cual
     * se quieren obtener los ejercicios.
     * @return Una lista de objetos {@code Exercici} que contiene los ejercicios
     * asociados al entrenamiento.
     */
    public static ArrayList<Exercici> getExercicisPerWorkout(Workout workout) {
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT ExercicisWorkouts.IdExercici,"
                + " Exercicis.NomExercici, Exercicis.Descripcio, Exercicis.DemoFoto"
                + " FROM ExercicisWorkouts INNER JOIN Exercicis ON ExercicisWorkouts.IdExercici=Exercicis.Id"
                + " WHERE ExercicisWorkouts.IdWorkout=?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, workout.getId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Exercici exercici = new Exercici();
                exercici.setId(resultSet.getInt("IdExercici"));
                exercici.setNomExercici(resultSet.getString("NomExercici"));
                exercici.setDescripcio(resultSet.getString("Descripcio"));
                exercici.setDemoFoto(resultSet.getString("DemoFoto"));

                exercicis.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercicis;
    }

    /**
     * Recupera todos los ejercicios disponibles en la base de datos.
     *
     * @return Una lista de objetos {@code Exercici} que contiene todos los
     * ejercicios.
     */
    public static ArrayList<Exercici> getAllExercicis() {
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT Id, Exercicis.NomExercici, Exercicis.Descripcio, Exercicis.DemoFoto"
                + " FROM Exercicis";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Exercici exercici = new Exercici();
                exercici.setId(resultSet.getInt("Id"));
                exercici.setNomExercici(resultSet.getString("NomExercici"));
                exercici.setDescripcio(resultSet.getString("Descripcio"));
                exercici.setDemoFoto(resultSet.getString("DemoFoto"));

                exercicis.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercicis;
    }

    /**
     * Registra un nuevo usuario en la tabla "Usuaris" de la base de datos.
     *
     * @param u El objeto {@code Usuari} que contiene los datos del usuario a
     * registrar.
     * @return El identificador único del nuevo usuario, o 0 si la operación
     * falló.
     */
    public static int registerUser(Usuari u) {
        String sql = "INSERT INTO dbo.Usuaris (Nom, Email, PasswordHash, Instructor)"
                + " VALUES (?,?,?,?)"
                + " SELECT CAST(SCOPE_IDENTITY() as int)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            insertStatement.setString(1, u.getNom());
            insertStatement.setString(2, u.getEmail());
            insertStatement.setString(3, u.getPasswordHash());
            insertStatement.setBoolean(4, u.isInstructor());

            int newUserId = insertStatement.executeUpdate();
            return newUserId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Inserta un entrenamiento y sus ejercicios asociados en la base de datos.
     * Este proceso debe realizarse dentro de una transacción de SQL.
     *
     * @param w El objeto {@code Workout} que representa el entrenamiento a
     * insertar.
     * @param exercicis Una lista de objetos {@code Exercici} que contiene los
     * ejercicios asociados al entrenamiento.
     */
    public static void insertWorkout(Workout w, ArrayList<Exercici> exercicis) {
        // The following should be done in a SQL transaction
        int newWorkoutId = insertToWorkoutTable(w);
        insertExercisesPerWorkout(newWorkoutId, exercicis);
    }

    /**
     * Inserta un nuevo entrenamiento en la base de datos y devuelve su ID
     * generado.
     *
     * @param w El entrenamiento que se desea insertar.
     * @return El ID del entrenamiento recién creado, o 0 si ocurre un error.
     */
    public static int insertToWorkoutTable(Workout w) {
        String sql = "INSERT INTO dbo.Workouts (ForDate, UserId, Comments)"
                + " VALUES (?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
            insertStatement.setString(1, w.getForDate());
            insertStatement.setInt(2, w.getIdUsuari());
            insertStatement.setString(3, w.getComments());

            int affectedRows = insertStatement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated keys (identity value)
                ResultSet resultSet = insertStatement.getGeneratedKeys();

                // Check if a key was generated
                if (resultSet.next()) {
                    // Get the last inserted identity value
                    int lastInsertedId = resultSet.getInt(1);
                    return lastInsertedId;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Elimina un entrenamiento (workout) de la tabla "Workouts" en la base de
     * datos.
     *
     * @param workoutId El identificador único del entrenamiento que se desea
     * eliminar.
     * @return El último identificador generado si la operación tuvo éxito, o 0
     * en caso contrario.
     */
    public static int deleteFromWorkoutTable(int workoutId) {
        String sql = "delete from dbo.Workouts where Id=?";

        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
            insertStatement.setInt(1, workoutId);
            int affectedRows = insertStatement.executeUpdate();
            if (affectedRows > 0) {
                // Retrieve the generated keys (identity value)
                ResultSet resultSet = insertStatement.getGeneratedKeys();
                // Check if a key was generated
                if (resultSet.next()) {
                    // Get the last inserted identity value
                    int lastInsertedId = resultSet.getInt(1);
                    return lastInsertedId;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Actualiza un entrenamiento (workout) en la tabla "Workouts" de la base de
     * datos.
     *
     * @param nouForDate La nueva fecha y hora del entrenamiento en formato
     * String.
     * @param nouComments Los nuevos comentarios asociados al entrenamiento.
     * @param workoutId El identificador único del entrenamiento a actualizar.
     * @return El último identificador generado si la operación tuvo éxito, o 0
     * en caso contrario.
     */
    public static int updateFromWorkoutTable(String nouForDate, String nouComments, int workoutId) {
        String sql = "update dbo.Workouts set  comments=?, ForDate=? where Id=?";

        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
            insertStatement.setString(1, nouComments);
            insertStatement.setString(2, nouForDate);
            insertStatement.setInt(3, workoutId);
            int affectedRows = insertStatement.executeUpdate();
            if (affectedRows > 0) {
                // Retrieve the generated keys (identity value)
                ResultSet resultSet = insertStatement.getGeneratedKeys();
                // Check if a key was generated
                if (resultSet.next()) {
                    // Get the last inserted identity value
                    int lastInsertedId = resultSet.getInt(1);
                    return lastInsertedId;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Inserta múltiples ejercicios asociados a un entrenamiento en la base de
     * datos.
     *
     * @param wId El identificador único del entrenamiento al que se asociarán
     * los ejercicios.
     * @param exercicis Una lista de ejercicios a asociar al entrenamiento.
     * @return El número total de ejercicios insertados, o 0 si ocurrió un
     * error.
     */
    private static int insertExercisesPerWorkout(int wId, ArrayList<Exercici> exercicis) {
        for (Exercici e : exercicis) {
            int rowsAffected = insertExerciciPerWorkout(wId, e);
            if (rowsAffected != 1) {
                return 0;
            }
        }
        return exercicis.size();
    }

    /**
     * Inserta un ejercicio asociado a un entrenamiento en la tabla
     * "ExercicisWorkouts".
     *
     * @param wId El identificador único del entrenamiento al que se asociará el
     * ejercicio.
     * @param e El objeto ejercicio que se desea asociar.
     * @return El número de filas afectadas por la operación.
     */
    public static int insertExerciciPerWorkout(int wId, Exercici e) {
        String sql = "INSERT INTO dbo.ExercicisWorkouts (IdWorkout, IdExercici)"
                + " VALUES (?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            insertStatement.setInt(1, wId);
            insertStatement.setInt(2, e.getId());
            int rowsAffected = insertStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * Elimina un registro específico en las tablas "Intents" y
     * "ExercicisWorkouts" de la base de datos.
     *
     * @param IdExercici El identificador único del ejercicio.
     * @param IdWorkout El identificador único del entrenamiento.
     * @return El número de filas afectadas en la tabla "ExercicisWorkouts".
     * @throws SQLException Si ocurre un error durante la operación.
     */
    public static int deleteFromExercicisWorkoutsTable(int IdExercici, int IdWorkout) throws SQLException {
        String deleteIntentsSql = "DELETE FROM dbo.Intents WHERE IdExerciciWorkout IN (SELECT id FROM dbo.ExercicisWorkouts WHERE IdExercici = ? AND IdWorkout = ?)";
        String deleteExercicisWorkoutsSql = "DELETE FROM dbo.ExercicisWorkouts WHERE IdExercici = ? AND IdWorkout = ?";

        try (Connection conn = getConnection()) {
            // Eliminar los registros de la tabla Intents
            try (PreparedStatement deleteIntentsStatement = conn.prepareStatement(deleteIntentsSql)) {
                deleteIntentsStatement.setInt(1, IdExercici);
                deleteIntentsStatement.setInt(2, IdWorkout);
                deleteIntentsStatement.executeUpdate();
            }

            // Eliminar los registros de la tabla ExercicisWorkouts
            try (PreparedStatement deleteStatement = conn.prepareStatement(deleteExercicisWorkoutsSql)) {
                deleteStatement.setInt(1, IdExercici);
                deleteStatement.setInt(2, IdWorkout);
                int affectedRows = deleteStatement.executeUpdate();
                return affectedRows;
            }

        }
        //return 0;
    }

}
