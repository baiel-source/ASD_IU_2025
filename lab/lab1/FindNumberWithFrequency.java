package Tasks_B;

/* Дан целочисленный массив. Верните число, частота встречи которого в
        массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
        таких чисел несколько, вернуть наибольшее. */

import java.util.Scanner;

public class FindNumberWithFrequency {
    static final Scanner inputScanner = new Scanner(System.in);

    public void main(String[] args) {
        int[] array = inputArray();
        selectionSort(array);
        int searchNumber = findNumberWithFrequency(array);
        System.out.println("Число, удовлетворяющее условию: " + (searchNumber != -1 ? searchNumber : "не найдено"));
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

    static int[] selectionSort(int[] array) { //Сортировка по убыванию
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

    static int findNumberWithFrequency(int[] array) {
        int length = array.length;
        int countNum = 1;
        if (length > 1) {
            for (int i = 1; i < length - 1; ) {
                if (array[i] == array[i + 1]) {
                    countNum += 1;
                    i += 1;
                } else if (countNum == array[i]) {
                    return countNum;
                } else {
                    countNum = 1;
                    i += 1;
                }
            }
            if (array[length - 1] == 1) return 1;
        }
        else if (array[0] == 1) return 1;
        return -1;
    }
}
