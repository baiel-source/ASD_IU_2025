// Группа Б. Дан целочисленный массив. Верните число, частота встречи которого в
// массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
// таких чисел несколько, вернуть наибольшее.

import java.util.Scanner;

public class FrequencyMatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayFunctions.createArray(in, -1);
        System.out.print("Массив: ");
        ArrayFunctions.printArray(arr);
        int result = findNumber(arr);
        System.out.printf("Результат: %d", result);
    }

    private static int findNumber(int[] arr) {
        ArrayFunctions.bubbleSort(arr);
        int length = arr.length;
        int result = -1;
        int count = 1;

        for (int i = 1; i <= length; i++) {
            if (i < length && arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (count == arr[i - 1]) {
                    result = Math.max(result, arr[i - 1]);
                }
                count = 1;
            }
        }
        return result;
    }
}

