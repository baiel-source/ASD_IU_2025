import java.util.Scanner;

/*Дан массив целых чисел, представляющий двоичное число.
Пример, дан массив bi_arr = [1, 1, 0]. Этот массив в десятичной системе
выглядит так: arr = [1, 3, 6]. То есть:
• arr[0] = bi_arr[0] = 1! = 1"#,
• arr[1] = bi_arr[0] bi_arr[1] =11! = 3"#,
• arr[2] = bi_arr[0] bi_arr[1] bi_arr[2] =110! = 6"#
Так же дано целое положительное число – n. Вернуть массив Boolean, где
true – число делится на N, false – нет.
Пусть n = 6, тогда для предыдущего примера результат должен выглядеть
так: [false, false, true].
Примечание. Делитель тоже необходимо ввести с клавиатуры.*/

public class DivisionBinaryArray {

    public static void main() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите длину массива : ");
        int arrayLen = in.nextInt();
        int[] arr = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            System.out.print("Введите элемент: ");
            arr[i] = in.nextInt() % 2;
        }

        System.out.print("Введите делитель: ");
        int divisor = in.nextInt();

        int[] newArr = conventing(arr);

        boolean[] boolArr = division(newArr, divisor);

        output(boolArr);

        in.close();
    }

    static int[] conventing(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];

        newArr[0] = arr[0];
        for (int i = 1; i < n; i++) {
            newArr[i] = arr[i] + newArr[i - 1] * 2;
        }
        return newArr;
    }

    static boolean[] division(int[] newArr, int divisor) {
        int n = newArr.length;
        boolean[] boolArr = new boolean[n];
        for (int i = 0; i < n; i++) {
            boolArr[i] = false;
            if (newArr[i] % divisor == 0) {
                boolArr[i] = true;
            }
        }
        return boolArr;
    }

    static void output(boolean[] arr) {
        int n = arr.length;
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(arr[i] + "]");
                break;
            }
            System.out.print(arr[i] + ", ");
        }
    }
}
