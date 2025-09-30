import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task2B {

    public static void main(String[] args) throws IOException {
        int size1 = arraySize();
        int[] array1 = readArray("первого числа", size1);

        int size2 = arraySize();
        int[] array2 = readArray("второго числа", size2);

        int[] result = multiplyArrays(array1, array2);

        numberResult(array1, array2, result);
    }

    public static int arraySize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        return scanner.nextInt();
    }

    public static int[] readArray(String arrayName, int size) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[size];
        System.out.println("Введите " + size + " цифр для " + arrayName );
        for (int i = 0; i < size; i++) {
            System.out.print("Цифра " + (i + 1) + ": ");
            String input = reader.readLine().trim();
            int number = Integer.parseInt(input);
            array[i] = number;
        }
        return array;
    }

    public static int arrayNumber(int[] numberArray) {
        int number = 0;
        for (int i = 0; i < numberArray.length; i++) {
            number = number * 10 + numberArray[i];
        }
        return number;
    }

    public static int[] numberToArray(int number) {
        if (number == 0) {
            return new int[]{0};
        }
        int number2 = number;
        int numberCount = 0;
        while (number2 > 0) {
            number2 = number2 / 10;
            numberCount++;
        }
        int[] digitArray = new int[numberCount];
        number2 = number;
        for (int i = numberCount - 1; i >= 0; i--) {
            digitArray[i] = number2 % 10;
            number2 = number2 / 10;
        }
        return digitArray;
    }

    public static int[] multiplyArrays(int[] array1, int[] array2) {
        int number1 = arrayNumber(array1);
        int number2 = arrayNumber(array2);

        int result = number1 * number2;
        return numberToArray(result);
    }

    public static void printArray(int[] array, String name) {
        System.out.print(name + ": [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void numberResult(int[] array1, int[] array2, int[] result) {
        printArray(array1, "Первое число");
        printArray(array2, "Второе число");
        printArray(result, "Результат умножения");
    }
}