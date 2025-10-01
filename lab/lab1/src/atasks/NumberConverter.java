//Изограмма – это слово, в котором нет повторяющихся букв,
//последовательных или непоследовательных. Реализуйте функцию, которая
//определяет, является ли строка, изограммой. Пустая строка является изограммой.

package atasks;

import java.util.Scanner;

public class NumberConverter {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input N:");
        int N = scanner.nextInt();
        System.out.println("Input M from 2 to 9:");
        int M = scanner.nextInt();

        System.out.println("Number " + N + " in base " + M + " is " + convert(N, M));
    }

    static String convert(int num, int base) {
        String result = "";
        while (num > 0) {
            result = (num % base) + result;
            num = num / base;
        }

        return result;
    }
}
