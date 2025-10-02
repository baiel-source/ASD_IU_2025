package lab1;

import java.util.Scanner;

public class TaskA2 {

    /**
     * Реализуйте перевод из римских чисел в арабские.
     */

    public static void main(String[] args) {
        System.out.print("Введите римское число: ");
        System.out.println(romanToArabic(new Scanner(System.in).next()));
    }

    private static int romanToArabic(String roman) {
        int answer = 0;
        int length = roman.length();

        for (int i = 0; i < length; i++) {
            switch (roman.charAt(i)) {
                case 'M' -> answer += 1000;
                case 'D' -> answer += 500;
                case 'C' -> {
                    if (i == length - 1 || (roman.charAt(i + 1) != 'D' && roman.charAt(i + 1) != 'M')) {
                        answer += 100;
                    } else answer -= 100;
                }
                case 'L' -> answer += 50;
                case 'X' -> {
                    if (i == length - 1 || (roman.charAt(i + 1) != 'L' && roman.charAt(i + 1) != 'C')) {
                        answer += 10;
                    } else answer -= 10;
                }
                case 'V' -> answer += 5;
                case 'I' -> {
                    if (i == length - 1 || (roman.charAt(i + 1) != 'V' && roman.charAt(i + 1) != 'X')) {
                        answer += 1;
                    } else answer -= 1;
                }
            }
        }

        return answer;
    }
}
