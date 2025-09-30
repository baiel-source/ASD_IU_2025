import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task1B {

    public static void main(String[] args) {
        int size = arraySize();
        int[] array = arrayInput(size);

        arrayPrint(array);

        int result = findFrequency(array);
        numberResult(result);
    }

    public static int arraySize() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        return scanner.nextInt();
    }

    public static int[] arrayInput(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void arrayPrint(int[] array) {
        System.out.print("Массив: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] countFrequency(int[] array) {
        int maxElement = maxElement(array);
        int[] frequency = new int[maxElement + 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0 && array[i] <= maxElement) {
                frequency[array[i]]++;
            }
        }
        return frequency;
    }

    public static int maxElement(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public static int findFrequency(int[] array) {
        int[] frequencies = countFrequency(array);
        int result = -1;

        // Ищем числа, где значение равно частоте
        for (int i = 0; i < frequencies.length; i++) {
            if (i == frequencies[i] && i > 0) {
                // Если нашли подходящее число и оно больше текущего результата
                if (i > result) {
                    result = i;
                }
            }
        }

        return result;
    }

    public static void numberResult(int result) {
        if (result == -1) {
            System.out.println("Результат: -1 (подходящих чисел не найдено)");
        } else {
            System.out.println("Число, частота встречи которого в массиве равна его значению: \n" + result);
        }
    }
}