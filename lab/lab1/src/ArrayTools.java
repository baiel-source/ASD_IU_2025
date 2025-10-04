import java.util.Arrays;
import java.util.Scanner;

public class ArrayTools {

    public static int[] arrayInput(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[n];
        System.out.println("Input elements of the array: \n");
        for (int i = 0; i < n; i++) array[i] = scanner.nextInt();
        return array;
    }


    public static void arrayReverseOutput(int[] array) {
        for (int i = array.length - 1; i > -1; i--)
            System.out.print(array[i] + " ");
    }


    public static int[] arrayInsertionSort(int[] array) {
        //Сортировка вставками
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (array[i] > value) array[i + 1] = array[i];
                else break;
            }
            array[i + 1] = value;
        }
        return array;
    }
}
