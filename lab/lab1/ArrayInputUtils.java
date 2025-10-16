package lab1;

import java.util.Scanner;

public class ArrayInputUtils {

    // Метод для ввода любого массива (используется в Num5)
    public static int[] inputArray(Scanner s, int n) {
        int[] array = new int[n];
        System.out.println("Введи " + n + " чисел:");
        for (int i = 0; i < n; i++) {
            array[i] = s.nextInt();
        }
        return array;
    }

    // Метод для ввода упорядоченного массива
    public static int[] inputSortedArray(Scanner scanner, int size) {
        int[] array = new int[size];
        System.out.println("Введи " + size + " числа по возрастанию:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    // Метод для суммы двух наименьших положительных
    public static int sumTwoSmallestPositive(int[] arr) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > 0) {
                if (num < firstMin) {
                    secondMin = firstMin;
                    firstMin = num;
                } else if (num < secondMin) {
                    secondMin = num;
                }
            }
        }

        if (secondMin == Integer.MAX_VALUE) {
            if (firstMin == Integer.MAX_VALUE) {
                System.out.println("Положительных чисел не найдено");
                return 0;
            } else {
                System.out.println("Найдено только одно положительное число: " + firstMin);
                return firstMin;
            }
        }

        return firstMin + secondMin;
    }
}