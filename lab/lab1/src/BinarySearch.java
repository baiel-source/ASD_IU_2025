// Основное задание. Реализовать алгоритм бинарного поиска двумя способами.
import java.util.Scanner;

public class BinarySearch {
    private static int iterativeSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int recursiveSearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return recursiveSearch(arr, target, left, mid - 1);
        } else {
            return recursiveSearch(arr, target, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = ArrayFunctions.createArray(in, -1);
        ArrayFunctions.bubbleSort(arr);
        System.out.print("Отсортированный массив: ");
        ArrayFunctions.printArray(arr);
        System.out.print("Введите элемент для поиска: ");
        int target = in.nextInt();
        System.out.printf("Результат через итеративный способ: %d\n", iterativeSearch(arr, target));
        System.out.printf("Результат через рекурсивный способ: %d\n", recursiveSearch(arr, target, 0, arr.length - 1));
    }
}
