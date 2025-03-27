package principal;

import menu.Menu;
import operaciones.Operaciones;
import java.io.IOException;
import java.util.logging.*;

/**
 * Clase Calculadora que permite realizar operaciones matemáticas básicas mediante un menú interactivo.
 */
public class Calculadora {
    
    private static final Logger Logger1 = Logger.getLogger(Calculadora.class.getName());
    
    static {
        try {
            LogManager.getLogManager().reset();
            FileHandler fileHandler = new FileHandler("operaciones1.html",false);
            fileHandler.setFormatter(new formhtml.formhtml());
            Logger1.addHandler(fileHandler);
            Logger1.setLevel(Level.ALL);
            
        }catch (IOException e) {
            System.err.println("No se pudo configurar el logger:"+ e.getMessage());
        }
    }
    /**
     * Método principal que inicia la aplicación de la calculadora.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {   
        int resultado = 0; // Variable para almacenar el resultado de las operaciones.
        String operacion = ""; // Variable para almacenar la operación seleccionada.
        int[] operandos = new int[2]; // Array para almacenar los operandos ingresados por el usuario.
        
        // Creación de instancias de las clases Menu y Operaciones.
        Menu menu = new Menu();
        Operaciones operaciones = new Operaciones();
        
        do {
            // Solicita al usuario los operandos y la operación a realizar.
            operandos = menu.pedirNumeros();
            operacion = menu.menuOpciones();
            try {
                if (operacion.equalsIgnoreCase("+")) {
                    resultado = operaciones.sumar(operandos[0], operandos[1]);
                    System.out.println("Resultado: " + resultado);
                    Logger1.log(Level.FINE, "Operacion suma : {0} + {1} = {2}", new Object[] {operandos[0],operandos[1],resultado});
                } else if (operacion.equalsIgnoreCase("-")) {
                    resultado = operaciones.restar(operandos[0], operandos[1]);
                    System.out.println("Resultado: " + resultado);
                    Logger1.log(Level.FINE, "Operacion suma : {0} - {1} = {2}", new Object[] {operandos[0],operandos[1],resultado});
                } else if (operacion.equalsIgnoreCase("*")) {
                    resultado = operaciones.multiplicar(operandos[0], operandos[1]);
                    System.out.println("Resultado: " + resultado);
                    Logger1.log(Level.FINE, "Operacion suma : {0} * {1} = {2}", new Object[] {operandos[0],operandos[1],resultado});
                } else if (operacion.equalsIgnoreCase("/")) {
                    resultado = operaciones.dividir(operandos[0], operandos[1]);
                    System.out.println("Resultado: " + resultado);
                    Logger1.log(Level.FINE, "Operacion suma : {0} / {1} = {2}", new Object[] {operandos[0],operandos[1],resultado});
                } else if (operacion.equalsIgnoreCase("%")) {
                    resultado = operaciones.resto(operandos[0], operandos[1]);
                    System.out.println("Resultado: " + resultado);
                    Logger1.log(Level.FINE, "Operacion suma : {0} % {1} = {2}", new Object[] {operandos[0],operandos[1],resultado});
                } else {
                    System.out.println("Operación no válida"); // Mensaje de error para operaciones no válidas.
                }
                
            }catch (ArithmeticException e) {
                System.err.println("No se pudo configurar el logger:"+ e.getMessage());
                Logger1.log(Level.WARNING, "Error al realizar operacion: {0}", e.getMessage());
            }
            // Evalúa la operación seleccionada y realiza la correspondiente operación matemática.
            
        } while (menu.repetir()); // Pregunta al usuario si desea realizar otra operación.
    }
}