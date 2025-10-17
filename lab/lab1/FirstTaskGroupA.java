package lab1;

import java.util.Scanner;

//Реализуйте метод, входными данными которого являются два числа N и M,
//где N – число в десятичной системе исчисления, а M – число в диапазоне от
//2 до 9, основание системы исчисления, в которое надо перевести исходное
//число. Метод должен возвращать строку с преобразованным значением.


public class FirstTaskGroupA {
    public static void main() {
        System.out.println("Введите число в десятичной системе счисления: ");
        int decimalNumber = inputVoid();
        System.out.println("Введите систему счисления: ");
        int foundationNumber = inputVoid();

        translation(decimalNumber, foundationNumber);

        System.out.println("Получившееся значение: " + translation(decimalNumber, foundationNumber));
    }

    public static int inputVoid() {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        return number;
    }

    public static String translation(int decimalNumber, int foundationNumber) {

        int number = Math.abs(decimalNumber);

        if (foundationNumber < 2 || foundationNumber > 9) {
            return "Вы ввели неверное значение M";
        } else if (number == 0) {
            return "0";
        }

        String str = "";

        while (number > 0) {
            str = String.format("%d", number % foundationNumber) + str;
            ;
            number /= foundationNumber;

            if (decimalNumber < 0) {
                str = "-" + str;
            }
        }
        return str;
    }
}
