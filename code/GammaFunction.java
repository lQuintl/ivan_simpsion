/***************************************************************************
 * Clase:    GammaFunction.java
 * Autor:   Cristian Ivan Garcia Blanco
 * Fecha:   4/12/2025
 *
 * Descripción: Proporciona el cálculo de la función Gamma 
 ***************************************************************************/

public class GammaFunction
{

    //Se almacena el ultimo valor de gamma
    private double gammaValue;

    public double computeIntGamma(int intValue) 
    {
        // Resultado acumulado (factorial de n-1).
        double result = 1.0; // Inicializa en 1 por definición de factorial.

        if (intValue <= 0) // Verifica que el argumento sea válido.
        {
            throw new IllegalArgumentException(
                    "Gamma no está definida para enteros <= 0"); 
        }

        // Multiplica desde 1 hasta (n-1) para obtener (n-1)!.
        for (int i = 1; i < intValue; i++) // Bucle para factorial.
        {
            result *= (double) i; // Multiplicación iterativa.
        }

        gammaValue = result; // Guarda para trazabilidad.
        return gammaValue;   // Devuelve el resultado.
    }

    /*
     * @param doubleValue valor double x para el cual se desea Gamma(x)
     * @return Gamma(doubleValue)
     *
     * @throws IllegalArgumentException 
     *         si el valor no es entero ni semi-entero
     */
    public double computeDblGamma(double doubleValue) 
    {
        // Valor que contendrá el resultado.
        double result;
        // Calcula la parte entera aproximada.
        int intPart = (int) Math.round(doubleValue); // Redondeo al entero más cercano.
        // Parte fraccionaria aproximada.
        double frac = doubleValue - (double) intPart;

        // Caso 1: si la fracción es prácticamente cero, tratamos como entero.
        if (Math.abs(frac) < 1.0e-10) // Comparación con tolerancia.
        {
            result = computeIntGamma(intPart); // Usa computeIntGamma.
            gammaValue = result; // Guarda resultado.
            return gammaValue;   // Devuelve.
        }

        // Caso 2: intentar reconocer semi-enteros (n + 0.5).
        double nTimes = doubleValue - 0.5; // x - 0.5 para verificar n.
        int nInt = (int) Math.round(nTimes); // Entero candidato.

        // Si nTimes es entero (dentro de tolerancia) y no negativo.
        if (Math.abs(nTimes - (double) nInt) < 1.0e-10 && nInt >= 0) 
        {
            // Gamma(0.5) = sqrt(pi).
            result = Math.sqrt(Math.PI); // Base de la recurrencia.

            // Aplica la recurrencia multiplicativa para llegar a Gamma(n+0.5).
            for (int i = 1; i <= nInt; i++) // Recorre factores (i - 0.5).
            {
                result *= (i - 0.5); // Multiplica por cada término.
            }

            gammaValue = result; // Guarda.
            return gammaValue;   // Devuelve.
        }

        // Caso 3: no soportado por esta implementación.
        throw new IllegalArgumentException(
                "GammaFunction solo implementada para enteros y semi-enteros.");
    }

    /**
     * Regresa el último valor de Gamma calculado.
     * @return gammaValue
     */
    public double getGammaValue() 
    {
        return gammaValue; 
    }
}
