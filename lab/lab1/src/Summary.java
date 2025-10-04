import java.util.Scanner;

/*Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
число, которое является суммой двух наименьших положительных чисел.*/
public class Summary {

    public static void main() {

        final Scanner in = new Scanner(System.in);

        System.out.print("Введите длину массива(не меньше 5) : ");
        final int arrayLen = in.nextInt();
        if (arrayLen < 5) {
            System.out.print("Длина меньше 5");
            return;
        }
        int[] arr = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            System.out.print("Введите элемент: ");
            arr[i] = in.nextInt();
        }

        int sum = summary(arr);

        output(sum);

        in.close();
    }

    static int summary(int[] arr) {
        int n = arr.length;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] < min2) {
                min2 = arr[i];
                if (min1 > min2) {
                    min2 = min1;
                    min1 = arr[i];
                }
            }
        }

        if (min1 != Integer.MAX_VALUE && min2 != Integer.MAX_VALUE) {
            return min1 + min2;
        } else {
            return 0;
        }
    }

    static void output(int sum) {
        if (sum == 0) {
            System.out.print("В массиве меньше двух положительных чисел");
        } else {
            System.out.print(sum);
        }
    }
}