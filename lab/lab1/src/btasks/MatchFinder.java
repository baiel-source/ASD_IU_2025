//Дан целочисленный массив. Верните число, частота встречи которого в
//массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
//таких чисел несколько, вернуть наибольшее.

package btasks;

import array.Array;

public class MatchFinder {
    public static void main(String[] args) {
        int[] array = Array.inputArray();

        System.out.print("result: " + findMatch(array));
    }

    static int countNumber(int[] arr, int num) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                count++;
            }
        }

        return count;
    }

    static int findMatch(int[] arr) {
        int result = -1;

        for (int i = 0; i < arr.length; i++) {
            int counter = countNumber(arr, arr[i]);
            if (counter == arr[i] & counter > result) {
                result = arr[i];
            }
        }

        return result;
    }
}
