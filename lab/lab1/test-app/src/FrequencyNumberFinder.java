/*Группа Б, задание 1: Дан целочисленный массив. Верните число, частота встречи которого в
массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
таких чисел несколько, вернуть наибольшее.*/

import java.util.Scanner;

public class FrequencyNumberFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberArray = ArrayProcessor.createNumberArray(scanner);
        System.out.print("Исходный массив: ");
        ArrayProcessor.printArray(numberArray);
        int result = findFrequencyNumber(numberArray);
        if (result == -1) {
            System.out.println(result);
        } else {
            System.out.println("Найдено число: " + result);
        }

        scanner.close();
    }

    public static int findFrequencyNumber(int[] array) {
        int maxValidNumber = -1;

        for(int i = 0; i < array.length; ++i) {
            int currentNumber = array[i];
            int frequency = countFrequency(array, currentNumber);
            if (currentNumber == frequency && currentNumber > maxValidNumber) {
                maxValidNumber = currentNumber;
            }
        }

        return maxValidNumber;
    }

    private static int countFrequency(int[] array, int targetNumber) {
        int count = 0;

        for(int i = 0; i < array.length; ++i) {
            if (array[i] == targetNumber) {
                ++count;
            }
        }

        return count;
    }
}