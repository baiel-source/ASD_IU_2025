import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task2B {
    public static void main(String[] args) throws IOException {
        int size1 = Array.arraySize();
        int[] array1 = Array.arrayInput(size1);
        int size2 = Array.arraySize();
        int[] array2 = Array.arrayInput(size2);
        int[] result = multiplyArrays(array1, array2);
        numberResult(array1, array2, result);
    }

    public static int arrayNumber(int[] numberArray) {
        int number = 0;
        for (int i = 0; i < numberArray.length; i++) {
            number = number * 10 + numberArray[i];
        }
        return number;
    }

    public static int[] numberToArray(long number) {
        if (number == 0) {
            return new int[]{0};
        }
        long number2 = number;
        int numberCount = 0;
        while (number2 > 0) {
            number2 = number2 / 10;
            numberCount++;
        }
        int[] digitArray = new int[numberCount];
        number2 = number;
        for (int i = numberCount - 1; i >= 0; i--) {
            digitArray[i] = (int)(number2 % 10);
            number2 = number2 / 10;
        }
        return digitArray;
    }

    public static int[] multiplyArrays(int[] array1, int[] array2) {
        int number1 = arrayNumber(array1);
        int number2 = arrayNumber(array2);

        long result = (long) number1 * number2;
        return numberToArray(result);
    }

    public static void numberResult(int[] array1, int[] array2, int[] result) {
        System.out.println("\nПервое число:");
        Array.arrayPrint(array1);
        System.out.println("\nВторое число:");
        Array.arrayPrint(array2);
        System.out.println("\nРезультат умножения:");
        Array.arrayPrint(result);
    }
}