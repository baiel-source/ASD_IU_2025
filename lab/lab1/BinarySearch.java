// Реализовать алгоритм бинарного поиска двумя способами. //

import java.util.Scanner;

public class BinarySearch {
    static final Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = inputArray();
        System.out.println("Введите число, которое нужно найти:");
        int searchNumber = inputScanner.nextInt();
        selectionSort(array);
        int iterativeMethodResult = iterativeBinarySearch(array, searchNumber);
        int recursiveMethodResult = recursiveBinarySearch(array, searchNumber);
        System.out.println("Результат итеративного способа: " + (iterativeMethodResult != -1 ? iterativeMethodResult : "значения в массиве нет!"));
        System.out.println("Результат рекурсивного метода: " + (recursiveMethodResult != -1 ? recursiveMethodResult : "значения в массиве нет!"));
    }

    static int[] inputArray() {
        System.out.println("Введите количество элементов массива:");
        int lengthArrayIn = inputScanner.nextInt();
        int[] arrayIn = new int[lengthArrayIn];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < lengthArrayIn; i++) {
            System.out.println("Элемент №" + (i+1) + ": ");
            arrayIn[i] = inputScanner.nextInt();
        }
        return arrayIn;
    }

    static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    static int[] selectionSort(int[] array) {
        int length = array.length;
        for (int left = 0; left < length; left++) {
            int minIndex = left;
            for (int i = left; i < length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(array, left, minIndex);
        }
        return array;
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

    static int recursiveBinarySearch(int[] array, int searchNumber) {
        int bottomInd = 0;
        int topInd = array.length - 1;
        return recursiveBinarySearch(array, searchNumber, bottomInd, topInd);
    }
}
