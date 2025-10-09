package lab1;

import java.util.Scanner;

public class RequiredTask {
    public static void main() {
        int[] valueArr = ArrayUtils.inputArray();

        System.out.println("Начальный массив: ");
        ArrayUtils.printStartArray(valueArr);

        insertionSort(valueArr);

        System.out.println("Отсортированный массив: ");
        ArrayUtils.printFinalArray(valueArr);

        System.out.println("Введите элемент: ");

        int number = inputValue();
        binarySearch(valueArr, number);
        recursiveBinarySearch(valueArr, 0, valueArr.length - 1, number);
    }


    public static void insertionSort(int[] arr) {            //Сортировка вставками
        for (int left = 0; left < arr.length; left++) {
            int value = arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }
    }


    public static int inputValue() {  //Ввод числа с клавиатуры
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        return number;
    }

    public static void binarySearch(int[] arr, int number) {    //Бинарный поиск
        int left = 0;
        int right = arr.length - 1;
        boolean flag = false;

        while (left <= right) {
            int middleNum = (left + right) / 2;

            if (arr[middleNum] == number) {
                System.out.println("Элемент " + number + " найден");
                flag = true;
                break;
            } else if (arr[middleNum] < number) {
                left = middleNum + 1;
            } else {
                right = middleNum - 1;
            }
        }
        if (flag != true) {
            System.out.println("Элемент " + number + " не найден");
        }
    }

    public static int recursiveBinarySearch(int arr[], int left, int right, int number) {
        if (left > right) {
            System.out.println("Элемент " + number + " не найден(рекурсия)");
            return -1;
        }

        int middleNum = (left + right) / 2;
        if (arr[middleNum] == number) {
            System.out.println("Элемент " + number + " найден(рекурсия)");
            return middleNum;
        } else if (arr[middleNum] < number) {
            return recursiveBinarySearch(arr, middleNum + 1, right, number);
        } else {
            return recursiveBinarySearch(arr, left, middleNum - 1, number);
        }
    }
}

class ArrayUtils {  //Класс по работе с массивами
    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов в массиве: ");   //Ввод массива
        int countNum = scanner.nextInt();
        System.out.println("Введите элементы массива: ");
        int[] arr = new int[countNum];
        for (int i = 0; i < countNum; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void printStartArray(int[] arr) {      //Вывод начального массива
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printFinalArray(int[] arr) {       //Вывод отсортированного массива
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}