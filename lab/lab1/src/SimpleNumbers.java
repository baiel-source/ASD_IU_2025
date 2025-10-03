import java.util.Scanner;

/*Дано целое число. Реализуйте метод, который находит N первых простых
чисел. Используйте алгоритм «Решето Эратосфена».*/
public class SimpleNumbers {

    public static void main() {

        final Scanner in = new Scanner(System.in);

        System.out.print("Введите, сколько простых чисел хотите получить: ");
        final int countSimpleNumbers = in.nextInt();

        boolean[] isSimple = new boolean[countSimpleNumbers];
        isSimple = sieve(countSimpleNumbers);

        output(isSimple, countSimpleNumbers);

        in.close();
    }

    static boolean[] sieve(int n) {
        int max = n * (int) (Math.log(n) + Math.log(Math.log(n))) + 10000; //n простых чисел находятся примерно в диапазоне [1,n*ln(n)+ln(ln(n))], возьмем с запасом
        boolean[] arr = new boolean[max];

        for (int i = 1; i < max; i++) {
            arr[i] = true;
        }

        arr[0] = false;

        for (int i = 2; i < max; i++) {
            if (arr[i]) {
                for (int j = 2 * i; j < max; j += i) {
                    arr[j] = false;
                }
            }
        }

        return arr;
    }

    static void output(boolean[] arr, int countSimpleNumbers) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] && count < countSimpleNumbers) {
                System.out.print(i + " ");
                count++;
                if (count == countSimpleNumbers) {
                    break;
                }
            }
        }
    }
}