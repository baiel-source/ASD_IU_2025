//Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
//число, которое является суммой двух наименьших положительных чисел.

import java.util.Scanner;

public class SumOfTwoSmallestPositiveNumbers {
    static final Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = ArrayUtil.inputArray();
        ArrayUtil.selectionSort(array);
        int resultSum = summaryMinNumbers(array);
        System.out.println("Полученный результат: " + (resultSum != -1 ? resultSum : "в массиве нет 2 положительных чисел"));
    }

    static int summaryMinNumbers(int[] array) {
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
