package lab1;

import java.util.Scanner;

public class ArrayInputUtils {
    public static int[] inputArray(int size, Scanner scanner) {
        int[] arr = new int[size];
        System.out.println("Введи " + size + " чисел:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
