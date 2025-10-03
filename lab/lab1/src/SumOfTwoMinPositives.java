// Группа Б. Дан массив целых чисел. Минимальное количество элементов – 5.
// Вернуть число, которое является суммой двух наименьших положительных чисел.
import java.util.Scanner;

public class SumOfTwoMinPositives {
    private static int sumTwoMinPositive(int[] arr) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i > 0) {
                if (i < min1) {
                    min2 = min1;
                    min1 = i;
                } else if (i < min2) {
                    min2 = i;
                }
            }
        }

        if (min2 == Integer.MAX_VALUE) {
            System.out.println("Массив должен содержать как минимум два положительных числа");
        }

        return min1 + min2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = ArrayFunctions.createArray(in, 5);
        System.out.print("Массив: ");
        ArrayFunctions.printArray(arr);
        System.out.printf("Сумма двух наименьших положительных чисел: %d", sumTwoMinPositive(arr));
    }
}
