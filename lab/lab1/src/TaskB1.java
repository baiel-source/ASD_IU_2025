import tools.Tools;

import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter length of array: ");
        int length = scanner.nextInt();
        int[] array = Tools.getArray(length, scanner);
        Tools.sortArray(array);
        Tools.printArray(array);

        System.out.println("number: " + findMaxNumber(array));
    }

    public static int countNumberInArray(int n, int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                count++;
            }
        }
        return count;
    }

    public static int findMaxNumber(int[] array) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == countNumberInArray(array[i], array) && array[i] > result) {
                result = array[i];
            }
        }

        return result;
    }
}
