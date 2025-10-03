//Пусть любое число – это массив его цифр слева направо. Пример, число
//1234 – это массив [1,2,3,4].
//Дан массив целых чисел. Реализовать умножение двух чисел.
//Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
//Результат – число, представленное массивом.

import java.util.Scanner;

public class DigitArrayMultiplier {
    static final Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Массив целых чисел 1:");
        int[] array1 = ArrayUtil.inputArray();
        System.out.println("Массив целых чисел 2:");
        int[] array2 = ArrayUtil.inputArray();
        int[] resultArray = multiplyArrays(array1, array2);
        System.out.println("Результат умножения:");
        ArrayUtil.outputArray(resultArray);

    }

    static int[] multiplyArrays(int[] array1, int[] array2) {
        int digit1 = arrayToDigit(array1);
        int digit2 = arrayToDigit(array2);
        int multipleDigit = digit1 * digit2;
        int[] array = digitToArray(multipleDigit);
        return array;
    }

    static int arrayToDigit(int[] array) {
        int number = 0;
        int length = array.length;

        for (int i = 0; i < length; i++) {
            number += array[i] * Math.pow(10, length - i - 1);
        }
        return number;
    }

    static int[] digitToArray(int digit) {
        int length = 0;
        int digitForDivision = digit;
        int[] array = new int[length];

        while (digitForDivision != 0) {
            digitForDivision = digitForDivision / 10;
            length += 1;
        }

        for (int i = length - 1; i > -1; i--) {
            array[i] = digit % 10;
            digit /= 10;
        }
        return array;
    }
}
