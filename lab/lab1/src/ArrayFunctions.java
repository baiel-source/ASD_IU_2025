import java.util.Scanner;

public class ArrayFunctions {
    public static int[] createArray(Scanner in, int requiredLength) {
        int input;

        if (requiredLength > 0) {
            do {
                System.out.print("Введите количество элементов в массиве (не меньше " + requiredLength + "): ");
                input = in.nextInt();
                if (input < requiredLength) {
                    System.out.println("Ошибка! Массив должен содержать как минимум " + requiredLength + " элементов.");
                }
            } while (input < requiredLength);
        } else {
            System.out.print("Введите количество элементов в массиве: ");
            input = in.nextInt();
        }

        int[] intArray = new int[input];
        for (int i = 0; i < input; i++) {
            System.out.print("Введите " + i + " элемент массива: ");
            int element = in.nextInt();
            intArray[i] = element;
        }

        return intArray;
    }

    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.printf("%d ", element);
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        boolean swapped;

        for (int i = 0; i < length - 1; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
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

