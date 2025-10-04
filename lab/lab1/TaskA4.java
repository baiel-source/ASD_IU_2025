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
        if (n < 1) return new int[0];
        int limit = n > 10 ? (int) (n * (Math.log(n) + Math.log(Math.log(n)))) : 30;

        int[] primes = new int[n];
        boolean[] numbersDeleted = new boolean[limit];

        int index = 0;
        for (int number = 2; index < n; number++) {
            if (numbersDeleted[number]) continue;

            primes[index] = number;
            index++;

            for (int i = number * 2; i < numbersDeleted.length; i+= number) {
                numbersDeleted[i] = true;
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
