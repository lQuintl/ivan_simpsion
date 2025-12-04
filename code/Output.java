/***************************************************************************
 * Clase:   Output
 * Autor:   Cristian Ivan Garcia Blanco
 * Fecha:   4/12/2025
 *
 *   Genera el archivo de salida
 *   
 ***************************************************************************/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Proporciona un método para escribir texto en un archivo externo.
 */
public class Output
{

    public void writeData(String outFile, String outText) 
    {
        // Se usa try-with-resources para asegurar cierre del recurso.
        try (PrintWriter writer = new PrintWriter(new FileWriter(outFile))) 
        {
            writer.print(outText); // Escribe el contenido tal cual.
        } 
        catch (IOException e) // Captura problemas de IO.
        {
            System.err.println("Error al escribir archivo de salida: " + e.getMessage());
        }
    }
}
