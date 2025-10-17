package lab1;

import java.util.Scanner;

public class RequiredTask {
    public static void main() {
        int[] valueArr = Utils.inputArray();

        System.out.println("Начальный массив: ");
        Utils.printStartArray(valueArr);

        Utils.insertionSort(valueArr);

        System.out.println("Отсортированный массив: ");
        Utils.printFinalArray(valueArr);

        System.out.println("Введите элемент: ");

        int number = inputValue();
        binarySearch(valueArr, number);
        recursiveBinarySearch(valueArr, 0, valueArr.length - 1, number);

        int indexIterative = binarySearch(valueArr, number);
        printResult(number, indexIterative, false);

        // Рекурсивный поиск
        int indexRecursive = recursiveBinarySearch(valueArr, 0, valueArr.length - 1, number);
        printResult(number, indexRecursive, true);
    }


    public static int inputValue() {  //Ввод числа с клавиатуры
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        return number;
    }

    public static int binarySearch(int[] arr, int number) {    // Бинарный поиск с возвратом индекса
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middleNum = (left + right) / 2;

            if (arr[middleNum] == number) {
                return number;

            } else if (arr[middleNum] < number) {
                left = middleNum + 1;
            } else {
                right = middleNum - 1;
            }
        }

        return -1;
    }

    public static int recursiveBinarySearch(int arr[], int left, int right, int number) {
        if (left > right) {
            return -1;
        }

        int middleNum = (left + right) / 2;
        if (arr[middleNum] == number) {
            return number;
        } else if (arr[middleNum] < number) {
            return recursiveBinarySearch(arr, middleNum + 1, right, number);
        } else {
            return recursiveBinarySearch(arr, left, middleNum - 1, number);
        }
    }

    private static void printResult(int number, int index, boolean isRecursive) {
        String method;

        if (isRecursive) {
            method = "(рекурсия)";
        } else {
            method = "(итерация)";
        }

        if (index != -1) {
            System.out.println("Элемент " + number + " найден " + method + ", индекс: " + index);
        } else {
            System.out.println("Элемент " + number + " не найден " + method + ", индекс: " + index);
        }
    }
}
