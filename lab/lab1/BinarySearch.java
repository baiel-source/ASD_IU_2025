// Реализовать алгоритм бинарного поиска двумя способами. //

import java.util.Scanner;

public class BinarySearch {
    static final Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = ArrayUtil.inputArray();
        System.out.println("Введите число, которое нужно найти:");
        int searchNumber = inputScanner.nextInt();
        ArrayUtil.selectionSort(array);
        int iterativeMethodResult = iterativeBinarySearch(array, searchNumber);
        int recursiveMethodResult = recursiveBinarySearch(array, searchNumber);
        System.out.println("Результат итеративного способа: " + (iterativeMethodResult != -1 ? iterativeMethodResult : "значения в массиве нет!"));
        System.out.println("Результат рекурсивного метода: " + (recursiveMethodResult != -1 ? recursiveMethodResult : "значения в массиве нет!"));
    }

    static int iterativeBinarySearch(int[] array, int searchNumber) {
        int bottomInd = 0;
        int topInd = array.length - 1;

        while (bottomInd <= topInd) {
            int middleInd = (bottomInd + topInd) / 2;
            if (searchNumber < array[middleInd]) {
                topInd = middleInd - 1;
            }
            else if (searchNumber > array[middleInd]) {
                bottomInd = middleInd + 1;
            }
            else return middleInd;
        }
        return -1;
    }

    static int recursiveBinarySearch(int[] array, int searchNumber) {
        int bottomInd = 0;
        int topInd = array.length - 1;
        return recursiveBinarySearch(array, searchNumber, bottomInd, topInd);
    }

    static int recursiveBinarySearch(int[] array, int searchNumber, int bottomInd, int topInd) {
        if (bottomInd > topInd) {
            return -1;
        }

        int middleInd = (bottomInd + topInd) / 2;
        if (searchNumber < array[middleInd]) {
            topInd = middleInd - 1;
            return recursiveBinarySearch(array, searchNumber, bottomInd, topInd);
        }
        else if (searchNumber > array[middleInd]) {
            bottomInd = middleInd + 1;
            return recursiveBinarySearch(array, searchNumber, bottomInd, topInd);
        }
        else return middleInd;
    }
}
