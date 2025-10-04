/* Дан целочисленный массив. Верните число, частота встречи которого в
        массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
        таких чисел несколько, вернуть наибольшее. */

import java.util.Scanner;

public class FindNumberWithFrequency {
    static final Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = ArrayUtil.inputArray();
        ArrayUtil.selectionSortWane(array);
        int searchNumber = findNumberWithFrequency(array);
        System.out.println("Число, удовлетворяющее условию: " + (searchNumber != -1 ? searchNumber : "не найдено"));
    }

    static int findNumberWithFrequency(int[] array) {
        int length = array.length;
        int countNum = 1;
        int lastIndex = 0; // Индекс последнего элемента с заданной частотой

        if (length > 1) {
            for (int i = 0; i < length - 1; ) {
                if (array[i] == array[i + 1]) {
                    countNum++;
                    i++;
                } else {
                    if (countNum == array[lastIndex]) {
                        return countNum;
                    }
                    countNum = 1;
                    lastIndex = i + 1;
                    i++;
                }
            }
        }
        if (countNum == array[lastIndex]) {
            return countNum;
        }

        return -1;
    }
}
