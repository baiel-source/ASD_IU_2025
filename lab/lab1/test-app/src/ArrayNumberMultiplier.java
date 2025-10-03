/*Группа Б, задание 2: Пусть любое число – это массив его цифр слева направо. Пример, число
1234 – это массив [1,2,3,4].
Дан массив целых чисел. Реализовать умножение двух чисел.
Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
Результат – число, представленное массивом.*/

import java.util.Scanner;

public class ArrayNumberMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число (массив цифр):");
        int[] firstNumberArray = ArrayProcessor.createNumberArray(scanner);
        System.out.println("Введите второе число (массив цифр):");
        int[] secondNumberArray = ArrayProcessor.createNumberArray(scanner);
        System.out.print("Первое число: ");
        ArrayProcessor.printArray(firstNumberArray);
        System.out.print("Второе число: ");
        ArrayProcessor.printArray(secondNumberArray);
        int[] resultArray = multiplyArrayNumbers(firstNumberArray, secondNumberArray);
        System.out.print("Результат умножения: ");
        ArrayProcessor.printArray(resultArray);
        scanner.close();
    }

    public static int[] multiplyArrayNumbers(int[] firstArray, int[] secondArray) {
        return convertNumberToArray(convertArrayToNumber(firstArray) * convertArrayToNumber(secondArray));
    }

    private static int convertArrayToNumber(int[] digitArray) {
        int number = 0;

        for(int i = 0; i < digitArray.length; ++i) {
            number = number * 10 + digitArray[i];
        }

        return number;
    }

    private static int[] convertNumberToArray(int number) {
        if (number == 0) {
            return new int[]{0};
        } else {
            int tempNumber = number;

            int digitCount;
            for(digitCount = 0; tempNumber > 0; tempNumber /= 10) {
                ++digitCount;
            }

            int[] resultArray = new int[digitCount];
            tempNumber = number;

            for(int i = digitCount - 1; i >= 0; --i) {
                resultArray[i] = tempNumber % 10;
                tempNumber /= 10;
            }

            return resultArray;
        }
    }
}