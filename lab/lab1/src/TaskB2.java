import tools.Tools;

import java.util.Scanner;

public class TaskB2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter length for first array: ");
        int length1 = scanner.nextInt();
        int[] array1 = Tools.getArray(length1, scanner);

        System.out.print("enter length for second array: ");
        int length2 = scanner.nextInt();
        int[] array2 = Tools.getArray(length2, scanner);

        Tools.printArray(array1);
        Tools.printArray(array2);

        Tools.printArray(integerToArray(arrayToInteger(array1) * arrayToInteger(array2)));
    }

    public static int arrayToInteger(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            int k = 1;
            for (int j = i + 1; j < array.length; j++) {
                k = k * 10;
            }
            result += array[i] * k;
        }
        return result;
    }

    public static int[] integerToArray(long number) {
        int arrayLength = String.valueOf(number).length();
        int[] array = new int[arrayLength];
        for (int i = arrayLength - 1; i >= 0; i--) {
            array[i] = (int) number % 10;
            number = number / 10;
        }
        return array;
    }
}
