package lab1;//Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
//число, которое является суммой двух наименьших положительных чисел.

import java.util.Scanner;

public class Num5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Сколько чисел введешь? ");
        int size = s.nextInt();
        int[] arr = ArrayInputUtils.inputArray(size, s);

        int sum = sumTwoSmallestPositive(arr);
        System.out.println("Сумма 2х наименьших положительных: " + sum);
        s.close();
    }

    public static int sumTwoSmallestPositive(int[] arr) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : arr)
            if (num > 0) {
                if (num < firstMin) {
                    secondMin = firstMin;
                    firstMin = num;
                } else if (num < secondMin) {
                    secondMin = num;
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