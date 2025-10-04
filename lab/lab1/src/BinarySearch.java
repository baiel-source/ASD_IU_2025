import java.util.Scanner;

//Реализовать алгоритм бинарного поиска двумя способами.
public class BinarySearch {

    public static void main() {

        final Scanner in = new Scanner(System.in);

        System.out.print("Введите длину массива : ");
        final int arrayLen = in.nextInt();
        int[] arr = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            System.out.print("Введите элемент: ");
            arr[i] = in.nextInt();
        }

        sort(arr);

        System.out.print("Введите элемент, который хотите найти в массиве: ");
        int x = in.nextInt();

        binarySearch1(arr, x);

        int index = binarySearch2(arr, x, 0, arrayLen - 1);
        output(index);

        in.close();
    }

    static void sort(int[] arr) {
        int flag = 0;

        boolean isNotSorted = check(flag, arr);

        if (isNotSorted) {
            bubbleSort(arr);
        }
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static boolean check(int flag, int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                flag++;
            }
            if (arr[i] <= arr[i + 1]) {
                flag--;
            }
        }
        return flag != n - 1 && flag != 1 - n;
    }

    static void binarySearch1(int[] arr, int x) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int found = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                found = 1;
                break;
            }
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (found == 1) {
            System.out.println("Элемент есть");
        } else {
            System.out.println("Элемента нет");
        }
    }

    static int binarySearch2(int[] arr, int x, int left, int right) {

        if (left > right) {
            return -1;
        }

        int middle = left + (right - left) / 2;

        if (arr[middle] < x) {
            return binarySearch2(arr, x, middle + 1, right);
        }

        if (arr[middle] > x) {
            return binarySearch2(arr, x, left, middle - 1);
        }

        return middle;
    }

    static void output(int index) {
        if (index != -1) {
            System.out.println("Элемент есть");
        } else {
            System.out.println("Элемента нет");
        }
    }

}
