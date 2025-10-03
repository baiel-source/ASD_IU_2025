//Класс для методов для работы с массивом

import java.util.Scanner;

public class ArrayUtil {

    static final Scanner inputScanner = new Scanner(System.in);

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

    static int[] selectionSortWane(int[] array) { //Сортировка по убыванию
        int length = array.length;
        for (int left = 0; left < length; left++) {
            int maxIndex = left;
            for (int i = left; i < length; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(array, left, maxIndex);
        }
        return array;
    }

    static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    static void outputArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
    }
}
