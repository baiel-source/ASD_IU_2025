// Группа Б. Пусть любое число – это массив его цифр слева направо. Пример, число 1234 – это массив [1,2,3,4]
// Дан массив целых чисел. Реализовать умножение двух чисел.

import java.util.Scanner;
import java.util.Arrays;

public class ArrayMultiplication {
    private static int[] multiply(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        for (int i = arr1.length - 1; i >= 0; i--) {
            for (int j = arr2.length - 1; j >= 0; j--) {
                int multiplication = arr1[i] * arr2[j] + result[i + j + 1];
                result[i + j + 1] = multiplication % 10;
                result[i + j] += multiplication / 10;
            }
        }

        int k = 0;
        while (k < result.length - 1 && result[k] == 0) k++;
        return Arrays.copyOfRange(result, k, result.length);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr1 = ArrayFunctions.createArray(in, -1);
        int[] arr2 = ArrayFunctions.createArray(in, -1);
        System.out.print("Первый массив: ");
        ArrayFunctions.printArray(arr1);
        System.out.print("Второй массив: ");
        ArrayFunctions.printArray(arr2);
        System.out.print("Результат: ");
        System.out.println(Arrays.toString(multiply(arr1, arr2)));
    }
}
