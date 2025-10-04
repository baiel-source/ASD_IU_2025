import java.util.Arrays;
import java.util.Scanner;

public class ArrayMultiplication {

    public static int[] multiplyNumbers(int[] num1, int[] num2) {
        if (num1 == null || num2 == null) {
            throw new IllegalArgumentException("Массивы не могут быть null");
        }

        for (int digit : num1) {
            if (digit < 0 || digit > 9) throw new IllegalArgumentException("Некорректная цифра");
        }
        for (int digit : num2) {
            if (digit < 0 || digit > 9) throw new IllegalArgumentException("Некорректная цифра");
        }

        if ((num1.length == 1 && num1[0] == 0) || (num2.length == 1 && num2[0] == 0)) {
            return new int[]{0};
        }

        int len1 = num1.length;
        int len2 = num2.length;
        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int product = num1[i] * num2[j];
                int sum = product + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        int firstNonZero = 0;
        while (firstNonZero < result.length && result[firstNonZero] == 0) {
            firstNonZero++;
        }

        if (firstNonZero == result.length) {
            return new int[]{0};
        }

        return Arrays.copyOfRange(result, firstNonZero, result.length);
    }

    public static String arrayToString(int[] number) {
        StringBuilder sb = new StringBuilder();
        for (int digit : number) {
            sb.append(digit);
        }
        return sb.toString();
    }

    public static int[] readNumberArrayFromUser(String numberName) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество цифр в " + numberName + ": ");
        int size = scanner.nextInt();

        while (size <= 0) {
            System.out.print("Размер должен быть положительным: ");
            size = scanner.nextInt();
        }

        int[] number = new int[size];
        System.out.println("Введите " + size + " цифр:");

        for (int i = 0; i < size; i++) {
            System.out.print("Цифра " + (i + 1) + ": ");
            int digit = scanner.nextInt();

            while (digit < 0 || digit > 9) {
                System.out.print("Цифра должна быть от 0 до 9: ");
                digit = scanner.nextInt();
            }

            number[i] = digit;
        }

        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        System.out.println("=== Умножение чисел-массивов ===");

        while (continueProgram) {
            try {
                int[] number1 = readNumberArrayFromUser("первом числе");
                int[] number2 = readNumberArrayFromUser("втором числе");

                System.out.println("Первое число: " + arrayToString(number1));
                System.out.println("Второе число: " + arrayToString(number2));

                int[] result = multiplyNumbers(number1, number2);
                System.out.println("Результат: " + arrayToString(result));

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }

            System.out.print("Продолжить? (да/нет): ");
            String answer = scanner.next();

            if (!answer.equalsIgnoreCase("да")) {
                continueProgram = false;
            }
        }

        scanner.close();
    }
}