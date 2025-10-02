package lab1;

public class TaskA4 {

    /**
     * Дано целое число. Реализуйте метод, который находит N первых простых
     * чисел. Используйте алгоритм «Решето Эратосфена».
     */

    public static void main(String[] args) {
        int n = MainTask.readIntSafe("Введите количество искомых простых чисел: ", true);
        System.out.println(writeIntArray(firstPrimeNumbers(n)));
    }

    private static int[] firstPrimeNumbers(int n) {
        int[] primes = new int[n];

        int index = 0;
        for (int number = 2; index < n; number++) {
            boolean isPrime = true;

            for (int i = 0; i < index; i++) {
                if (number % primes[i] == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes[index] = number;
                index++;
            }
        }

        return primes;
    }

    private static String writeIntArray(int[] array) {
        if (array.length == 0) return "[]";

        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++) {
            s.append(array[i]).append(", ");
        }
        s.append(array[array.length - 1]).append(']');

        return s.toString();
    }
}
