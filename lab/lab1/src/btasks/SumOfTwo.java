//Дан массив целых чисел. Минимальное количество элементов – 5. Вернуть
//число, которое является суммой двух наименьших положительных чисел.

package btasks;

import arrays.ArraysMethods;

public class SumOfTwo {
    public static void main(String[] args) {
        int[] array = ArraysMethods.inputArray();
        if (array.length < 5) {
            System.out.println("Array must have 5 or more elements");
        } else {
            int result = findSumOfTwoMinNumbers(array);

            if (result == -1) {
                System.out.println("There is not enough positive numbers");
            } else {
                System.out.println("Summary: " + result);
            }
        }
    }

    static int findSumOfTwoMinNumbers(int[] arr) {
        int firstMinNumber = Integer.MAX_VALUE;
        int secondMinNumber = Integer.MAX_VALUE;

        int positiveNumbersCounter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0 & arr[i] < firstMinNumber) {
                secondMinNumber = firstMinNumber;
                firstMinNumber = arr[i];
                positiveNumbersCounter++;
            }

            if (arr[i] > firstMinNumber & arr[i] < secondMinNumber) {
                secondMinNumber = arr[i];
                positiveNumbersCounter++;
            }
        }

        if (positiveNumbersCounter < 2) {
            return -1;
        }

        return (firstMinNumber + secondMinNumber);
    }
}
