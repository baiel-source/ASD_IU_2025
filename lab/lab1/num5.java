package lab1;//Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
//число, которое является суммой двух наименьших положительных чисел.

import java.util.Scanner;

public class num5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("Введите 5 чисел:");
        for (int i = 0; i < 5; i++) {
            arr[i] = s.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        int count = 0;
        int sum = 0;
        for (int i = 0; i < 5 && count < 2; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
                count++;
            }
        }
        System.out.println("Сумма 2х наименьших положительных: " + sum);
        s.close();
    }
}
