import java.util.Arrays;
import java.util.Scanner;

// Реализуйте перевод из римских чисел в арабские.

public class PositiveNumbersSumWithInput {

    public static int findSumOfTwoSmallestPositive(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }

        if (numbers.length < 5) {
            throw new IllegalArgumentException("Массив должен содержать минимум 5 элементов");
        }

        int[] positiveNumbers = filterPositiveNumbers(numbers);

        if (positiveNumbers.length < 2) {
            throw new IllegalArgumentException("В массиве должно быть хотя бы 2 положительных числа");
        }

        Arrays.sort(positiveNumbers);

        return positiveNumbers[0] + positiveNumbers[1];
    }

    private static int[] filterPositiveNumbers(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (number > 0) {
                count++;
            }
        }

        int[] positiveNumbers = new int[count];
        int index = 0;

        for (int number : numbers) {
            if (number > 0) {
                positiveNumbers[index] = number;
                index++;
            }
        }

        return positiveNumbers;
    }

    public static int[] readArrayFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество элементов в массиве (минимум 5): ");
        int size = scanner.nextInt();

        while (size < 5) {
            System.out.print("Массив должен содержать минимум 5 элементов. Повторите ввод: ");
            size = scanner.nextInt();
        }

        int[] numbers = new int[size];

        System.out.println("Введите " + size + " целых чисел:");
        for (int i = 0; i < size; i++) {
            System.out.print("Элемент " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        return numbers;
    }

    public static void displayArray(int[] numbers) {
        System.out.print("Ваш массив: [");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Программа для поиска суммы двух наименьших положительных чисел ");

        try {

            int[] numbers = readArrayFromUser();

            displayArray(numbers);

            int result = findSumOfTwoSmallestPositive(numbers);

            System.out.println("\nРезультат:");
            System.out.println("Сумма двух наименьших положительных чисел: " + result);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}