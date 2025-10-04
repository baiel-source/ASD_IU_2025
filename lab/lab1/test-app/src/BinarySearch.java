/*Основное задание. Задание оценивается в 0 баллов, но является обязательным.
Реализовать алгоритм бинарного поиска двумя способами.*/

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberArray = ArrayProcessor.createNumberArray(scanner);
        ArrayProcessor.insertionSort(numberArray);
        System.out.print("Отсортированный массив: ");
        ArrayProcessor.printArray(numberArray);
        System.out.print("Введите число для поиска: ");
        int targetNumber = scanner.nextInt();
        int resultIterative = binarySearchIterative(numberArray, targetNumber);
        int resultRecursive = binarySearchRecursive(numberArray, targetNumber, 0, numberArray.length - 1);
        System.out.println("Результат итеративного поиска: " + resultIterative);
        System.out.println("Результат рекурсивного поиска: " + resultRecursive);
        scanner.close();
    }

    public static int binarySearchIterative(int[] array, int target) {
        int leftBorder = 0;
        int rightBorder = array.length - 1;

        while(leftBorder <= rightBorder) {
            int middleIndex = leftBorder + (rightBorder - leftBorder) / 2;
            int middleElement = array[middleIndex];
            if (middleElement == target) {
                return middleIndex;
            }

            if (middleElement < target) {
                leftBorder = middleIndex + 1;
            } else {
                rightBorder = middleIndex - 1;
            }
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] array, int target, int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            return -1;
        } else {
            int middleIndex = leftBorder + (rightBorder - leftBorder) / 2;
            int middleElement = array[middleIndex];
            if (middleElement == target) {
                return middleIndex;
            } else {
                return middleElement < target ? binarySearchRecursive(array, target, middleIndex + 1, rightBorder) : binarySearchRecursive(array, target, leftBorder, middleIndex - 1);
            }
        }
    }
}