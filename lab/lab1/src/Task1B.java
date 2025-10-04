import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task1B {

    public static void main(String[] args) {
        int size = Array.arraySize();
        int[] array = Array.arrayInput(size);

        Array.arrayPrint(array);

        int result = findFrequency(array);
        numberResult(result);
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