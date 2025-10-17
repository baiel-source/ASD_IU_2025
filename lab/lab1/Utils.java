package lab1;

import java.util.Scanner;
import java.math.BigInteger;

public class Utils { //Класс по работе с массивами

    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество элементов в массиве: ");   //Ввод массива
        int countNum = scanner.nextInt();
        System.out.println("Введите элементы массива: ");
        int[] arr = new int[countNum];
        for (int i = 0; i < countNum; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static String[] inputStrings(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько строк вы хотите ввести? ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Введите строку " + (i + 1) + ": ");
            arr[i] = scanner.nextLine().trim();
        }

        return arr;
    }


    public static void printStartArray(int[] arr) {      //Вывод начального массива
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printFinalArray(int[] arr) {       //Вывод отсортированного массива
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArray(int[] arr) { //Вывод массива обычного
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void insertionSort(int[] arr) {     //Сортировка вставками
        for (int left = 0; left < arr.length; left++) {
            int value = arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }
    }

    public static int[] multiplyArrays(int[] a, int[] b) {
        BigInteger num1 = translateToNumbers(a);
        BigInteger num2 = translateToNumbers(b);

        BigInteger product = num1.multiply(num2);

        return numberToArray(product);
    }


    public static BigInteger translateToNumbers(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str = str + arr[i];
        }
        return new BigInteger(str);
    }


    public static int[] numberToArray(BigInteger num) {
        String str = num.toString();
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        return arr;
    }

}
