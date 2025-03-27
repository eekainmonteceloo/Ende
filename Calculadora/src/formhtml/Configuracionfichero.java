package formhtml;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Configuracionfichero {
   
    private static final Logger LOGGER = Logger.getLogger("conflogger");
    private static final LogManager logManager = LogManager.getLogManager();


    static {
        try {
            logManager.readConfiguration(new FileInputStream("./logs/configlog.properties"));
            
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Error al cargar la configuración", exception);
        }
    }

    public static void main(String[] args) {
        LOGGER.fine("Mensaje FINE guardado.");
    }
}
