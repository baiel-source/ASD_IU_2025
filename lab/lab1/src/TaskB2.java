import java.beans.PropertyEditorSupport;
import java.util.Scanner;


/*
Пусть любое число – это массив его цифр слева направо. Пример, число
1234 – это массив [1,2,3,4].
Дан массив целых чисел. Реализовать умножение двух чисел.
Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
Результат – число, представленное массивом.
 */


public class TaskB2 {
    public static void main(String[] args) {
        // Ввод двух массивов
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the first array: ");
        int len1 = scanner.nextInt();
        int[] array1 = ArrayTools.arrayInput(len1);
        System.out.println("Enter the length of the second array: ");
        int len2 = scanner.nextInt();
        int[] array2 = ArrayTools.arrayInput(len2);

        // Вывод
        multiplyTwoArrays(array1, array2);

    }

    public static void multiplyTwoArrays(int[] arr1, int[] arr2) {

        // Проверка
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            System.out.println("The input array is null or empty");
            return;
        }


        // Создание конечного массива
        int[] result = new int[arr1.length + arr2.length];

        for (int i = arr1.length - 1; i >= 0; i--) {
            for (int j = arr2.length - 1; j >= 0; j--) {
                int mul = arr1[i] * arr2[j];
                int p1 = i + j;         // старший разряд
                int p2 = i + j + 1;     // младший разряд

                int sum = mul + result[p2]; // добавляем к текущему значению

                result[p2] = sum % 10;      // оставляем последнюю цифру
                result[p1] += sum / 10;     // переносим старшую часть
            }
        }

        // Проверяем на ведущие нули
        int start = 0;
        while (start < result.length - 1 && result[start] == 0) {
            start++;
        }

        // Копируем результат без ведущих нулей
        int[] resultFinal = new int[result.length - start];
        System.arraycopy(result, start, resultFinal, 0, resultFinal.length);

        for (int j : resultFinal) {
            System.out.print(j + " ");
        }
    }
}
