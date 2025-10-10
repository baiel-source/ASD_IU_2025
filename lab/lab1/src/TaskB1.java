import java.util.Scanner;

/*
Дан целочисленный массив. Верните число, частота встречи которого в
массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
таких чисел несколько, вернуть наибольшее.
*/

public class TaskB1 {

    public static void main(String[] args) {
        //Ввод
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a length of the array: \n");
        int n = scanner.nextInt();
        int[] array = ArrayTools.arrayInput(n);
        //Вывод
        System.out.println(countFrequency(n, array));
    }

    public static int countFrequency(int n, int[] array) {
        int result = -1;
        for (int i = 0; i < n; i++) {
            int current = array[i];
            if (current > n) continue;
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (current == array[j]) count++;
            }
            if (current == count) result = Math.max(result, current);
        }
        return result;
    }
}