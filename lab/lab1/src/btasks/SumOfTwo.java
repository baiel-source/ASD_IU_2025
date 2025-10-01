//Дан массив целых чисел. Минимальное количество элементов – 5. Вернуть
//число, которое является суммой двух наименьших положительных чисел.

package btasks;

import array.Array;

public class SumOfTwo {
    public static void main(String[] args) {
        int[] array = Array.inputArray();
        if (array.length < 5) {
            System.out.println("Array must have 5 or more elements");
        } else {
            int result = findSumOfTwoMinNumbers(array);

            if (result == -1) {
                System.out.println("There is not enough positive numbers");
            } else {
                System.out.println("Summary: " + findSumOfTwoMinNumbers(array));
            }
        }
    }

    static int findSumOfTwoMinNumbers(int[] arr) {
        int min1 = 2^31 - 1;
        int min2 = 2^31;

        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 & arr[i] < min1) {
                min2 = min1;
                min1 = arr[i];
                k++;
            }

            if (arr[i] > min1 & arr[i] < min2) {
                min2 = arr[i];
                k++;
            }
        }

        if (k < 2) {
            return -1;
        }

        return (min1 + min2);
    }
}
