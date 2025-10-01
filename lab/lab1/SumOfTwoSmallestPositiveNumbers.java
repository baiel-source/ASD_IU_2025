package Tasks_B;

//Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
//число, которое является суммой двух наименьших положительных чисел.

import java.util.Scanner;

public class SumOfTwoSmallestPositiveNumbers {
    static final Scanner inputScanner = new Scanner(System.in);

    public void main(String[] args) {
        int[] array = inputArray();
        selectionSort(array);
        int resultSum = sumOfMinNumbers(array);
        System.out.println("Полученный результат: " + (resultSum != -1 ? resultSum : "в массиве нет 2 положительных чисел"));
    }

    static int[] inputArray() {
        System.out.println("Введите количество элементов массива:");
        int lengthArrayIn = inputScanner.nextInt();
        if (lengthArrayIn < 5) {
            System.out.println("Недопустимое количество элементов в массиве, введите значение >4");
            lengthArrayIn = inputScanner.nextInt();
        }
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

    static int sumOfMinNumbers(int[] array) {
        int sum = 0;
        int countNumOfSum = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (countNumOfSum == 2) {
                return sum;
            }
            if (array[i] > 0) {
                sum += array[i];
                countNumOfSum += 1;
            }
        }
        return -1;
    }
}
