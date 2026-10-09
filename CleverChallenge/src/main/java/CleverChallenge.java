/*
  Clever Internship - Desafío inicial



  Aquí resuelvo los 3 ejercicios del desafío (una función por ejercicio):
    1. Suma de dígitos
    2. Palíndromos
    3. Ordenamiento (sin usar sort())
 */
public class CleverChallenge {

    // ------------------------------------------------------------
    // EJERCICIO 1: Suma de dígitos
    // Idea: con "% 10" obtengo el último dígito del número y con
    // "/ 10" se lo quito. Repito hasta que el número llegue a 0.
    // ------------------------------------------------------------
    public static int digitsSum(int inputInt) {
        // Uso long y valor absoluto para que también funcione con números negativos
        long numero = Math.abs((long) inputInt);
        int suma = 0;

        // Mientras todavía queden dígitos
        while (numero > 0) {
            suma = suma + (int) (numero % 10); // sumo el último dígito
            numero = numero / 10;              // quito el último dígito
        }

        return suma;
    }

    // ------------------------------------------------------------
    // EJERCICIO 2: Palíndromos
    // Idea: comparo el primer carácter con el último, el segundo
    // con el penúltimo, y así hasta llegar a la mitad.
    // Si alguna pareja es diferente, no es palíndromo.
    // ------------------------------------------------------------
    public static boolean isPalindrome(String inputStr) {
        // Si el texto es nulo no se puede revisar, así que regreso false
        if (inputStr == null) {
            return false;
        }

        int izquierda = 0;                    // posición del inicio
        int derecha = inputStr.length() - 1;  // posición del final

        // Me detengo cuando los dos índices se cruzan o se encuentran
        while (izquierda < derecha) {
            // Si las letras de las dos puntas son distintas, ya no es palíndromo
            if (inputStr.charAt(izquierda) != inputStr.charAt(derecha)) {
                return false;
            }
            izquierda++; // avanzo desde el inicio
            derecha--;   // retrocedo desde el final
        }

        // Si nunca encontré diferencias, sí es palíndromo
        return true;
    }

    // ------------------------------------------------------------
    // EJERCICIO 3: Ordenamiento
    // Idea: uso el algoritmo "Bubble Sort" (ordenamiento burbuja):
    // comparo cada par de vecinos y los intercambio si están
    // desordenados. Así, el número más grande "sube" al final.
    // Regla importante: NO se modifica el arreglo original,
    // por eso primero hago una copia.
    // ------------------------------------------------------------
    public static int[] integerSort(int[] inputArray) {
        // Si el arreglo es nulo regreso un arreglo vacío
        if (inputArray == null) {
            return new int[0];
        }

        // Creo una copia con .clone() para no modificar el original
        int[] resultado = inputArray.clone();

        // Ciclo externo: cada vuelta deja un número grande en su lugar final
        for (int i = 0; i < resultado.length - 1; i++) {
            // Ciclo interno: comparo vecinos (cada vez hay uno menos por revisar)
            for (int j = 0; j < resultado.length - 1 - i; j++) {
                // Si el de la izquierda es mayor que el de la derecha, los intercambio
                if (resultado[j] > resultado[j + 1]) {
                    int temporal = resultado[j];
                    resultado[j] = resultado[j + 1];
                    resultado[j + 1] = temporal;
                }
            }
        }

        return resultado;
    }

    // ------------------------------------------------------------
    // MAIN: aquí pruebo las funciones con los casos de ejemplo del PDF
    // ------------------------------------------------------------
    public static void main(String[] args) {

        // Pruebas del ejercicio 1 (salida esperada: 27, 28, 15)
        System.out.println("--- 1. Suma de dígitos ---");
        System.out.println("Entrada: 999 -> " + digitsSum(999));
        System.out.println("Entrada: 9184501 -> " + digitsSum(9184501));
        System.out.println("Entrada: 12345 -> " + digitsSum(12345));

        // Pruebas del ejercicio 2 (salida esperada: true, false, true)
        System.out.println("\n--- 2. Palíndromos ---");
        System.out.println("Entrada: aabaa -> " + isPalindrome("aabaa"));
        System.out.println("Entrada: abac -> " + isPalindrome("abac"));
        System.out.println("Entrada: salas -> " + isPalindrome("salas"));

        // Prueba del ejercicio 3 (salida esperada: -7 -2 0 3 5 10)
        System.out.println("\n--- 3. Ordenamiento ---");
        int[] inputArray = {5, -2, 10, 0, 3, -7};
        int[] ordenado = integerSort(inputArray);

        System.out.print("Arreglo ordenado: ");
        for (int i = 0; i < ordenado.length; i++) {
            System.out.print(ordenado[i] + " ");
        }

        // Imprimo también el original para comprobar que NO cambió
        System.out.print("\nArreglo original: ");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println();
    }
}