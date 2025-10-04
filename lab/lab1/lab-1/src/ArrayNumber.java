/* Пусть любое число – это массив его цифр слева направо. Пример, число
1234 – это массив [1,2,3,4].
Дан массив целых чисел. Реализовать умножение двух чисел.
Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
Результат – число, представленное массивом. */

import java.util.Scanner;

public class ArrayNumber {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Введите длину первого массива: ");
        int length1 = scanner.nextInt();
        int[] array1 = Arrays.newArray(length1);

        System.out.print("Введите длину второго массива: ");
        int length2 = scanner.nextInt();
        int[] array2 = Arrays.newArray(length2);

        System.out.println("Результат произведения: ");

        Arrays.printArray(numToArr(arrToNum(array1) * arrToNum(array2)));
    }

    private static int arrToNum(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += (int) (array[i] * Math.pow(10, array.length - i - 1));
        }
        return result;
    }

    // Перевод числа в требуемый формат (список из цифр числа):
    private static int[] numToArr(long number) {
        long temp = number;
        int count = 0;
        while (temp > 0) {
            temp /= 10;
            count++;
        }

        int[] array = new int[count];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = (int) (number % 10);
            number /= 10;
        }
        return array;
    }
}

