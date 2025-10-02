import java.util.Scanner;

public class ArrayFunctions {
    public static int[] createArray(Scanner in, int requiredLength) {
        int n;

        if (requiredLength > 0) {
            do {
                System.out.print("Введите количество элементов в массиве (не меньше " + requiredLength + "): ");
                n = in.nextInt();
                if (n < requiredLength) {
                    System.out.println("Ошибка! Массив должен содержать как минимум " + requiredLength + " элементов.");
                }
            } while (n < requiredLength);
        } else {
            System.out.print("Введите количество элементов в массиве: ");
            n = in.nextInt();
        }

        int[] intArray = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите " + i + " элемент массива: ");
            int element = in.nextInt();
            intArray[i] = element;
        }

        return intArray;
    }

    public static void printArray(int[] array) {
        for (int j : array) {
            System.out.printf("%d ", j);
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
