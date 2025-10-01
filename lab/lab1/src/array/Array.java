package array;

import java.util.Scanner;

public class Array {
    static Scanner scanner = new Scanner(System.in);

    public static int[] inputArray() {
        System.out.println("Input array's length:");
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Input element " + i + ":");
            array[i] = scanner.nextInt();
        }
    return array;
    }

    public static int[] bubbleSort(int[] arr) {
        boolean flag;

        for (int i = 0; i < arr.length - 1; i++) {
            flag = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    flag = true;
                }
            }

            if (!flag) {
                break;
            }
        }

        return arr;
    }
}
