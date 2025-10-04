import java.util.Arrays;
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
        //Ввод двух массивов
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the first array: ");
        int len1 = scanner.nextInt();
        int[] array1 = ArrayTools.arrayInput(len1);
        System.out.println("Enter the length of the second array: ");
        int len2 = scanner.nextInt();
        int[] array2 = ArrayTools.arrayInput(len2);

        //Вывод
        multiplyNumFromTwoArrays(array1, array2);
    }

    //Перевод числа в массив
    public static void numToArray(int n) {

        //Поиск длины числа, для создания массива нужной длины
        int length = 0;
        int lengthCalcN = n;
        while (lengthCalcN != 0) {
            lengthCalcN /= 10;
            length++;
        }
        //Запись числа в массив (задом на перед)
        int[] array = new int[length];
        int i = 0;
        while (n != 0) {
            array[i] = n % 10;
            n = n / 10;
            i++;
        }
        System.out.println("\nThe result is: ");
        ArrayTools.arrayReverseOutput(array);
    }


    public static void multiplyNumFromTwoArrays(int[] arr1, int[] arr2) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an index in the first array: ");
        int index1 = scanner.nextInt();
        System.out.println("Enter an index in the second array, to multiply it with the number from the first array: ");
        int index2 = scanner.nextInt();

        numToArray((arr1[index1] * arr2[index2]));
    }
}
