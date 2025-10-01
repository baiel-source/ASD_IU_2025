//Реализовать алгоритм бинарного поиска двумя способами.

package maintask;

import java.util.Scanner;
import array.Array;

public class BinarySearch {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = Array.inputArray();
        array = Array.bubbleSort(array);
        System.out.println("Array has been sorted!");

        int leftIndex = 0;
        int rightIndex = array.length - 1;

        System.out.println("Input target number:");
        int target = scanner.nextInt();

        int index = binarySearch(array, target);
        int indexWithRecursion = recursiveBinarySearch(array, target, leftIndex, rightIndex);

        if (array[index] == -1) {
            System.out.println("target number is not in array");
        } else {
            System.out.println("Index of this number is " + index);
        }

        if (array[indexWithRecursion] == -1) {
            System.out.println("target number is not in array");
        } else {
            System.out.println("Index of this number is " + indexWithRecursion);
        }

    }

    static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (key == arr[mid]) {
                return mid;
            }

            if (key > arr[mid]) {
                left = mid + 1;
            }

            if (key < arr[mid]) {
                right = mid - 1;
            }

            mid = (left + right) / 2;
        }

        return -1;
    }

    static int recursiveBinarySearch(int[] arr, int key, int left, int right) {
        int mid = (left + right) / 2;

        if (left == right) {
            if (key == arr[left]) {
                return left;
            } else {
                return -1;
            }
        }

        if (key > arr[mid]) {
            return recursiveBinarySearch(arr, key, mid + 1, right);
        }

        if (key < arr[mid]) {
            return recursiveBinarySearch(arr, key, left, mid - 1);
        }

        return mid;
    }
}