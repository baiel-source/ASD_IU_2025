import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int size = arraySize();
        int[] array = arrayInput(size);

        System.out.println("\nВведенный массив:");

        arrayPrint(array);
        arraySort(array);
        System.out.println("Отсортированный массив:");
        arrayPrint(array);

        int number = numberInput();

        int resultIterative = searchIterative(array, number);
        if (resultIterative != -1) {
            System.out.println("Итеративный поиск: элемент найден на позиции " + resultIterative);
        } else {
            System.out.println("Итеративный поиск: элемент не найден");
        }

        int resultRecursive = searchRecursive(array, number, 0, array.length - 1);
        if (resultRecursive != -1) {
            System.out.println("Рекурсивный поиск: элемент найден на позиции " + resultRecursive);
        } else {
            System.out.println("Рекурсивный поиск: элемент не найден");
        }
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

    public static int numberInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число для поиска: ");
        return Integer.parseInt(reader.readLine());
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

    public static void arraySort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static int searchIterative(int[] array, int number) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == number) {
                return mid;
            } else if (array[mid] < number) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int searchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return searchRecursive(array, target, mid + 1, right);
        } else {
            return searchRecursive(array, target, left, mid - 1);
        }
    }
}