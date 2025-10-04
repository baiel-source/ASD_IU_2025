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
            answer += romanNumeralToArabic(
                    roman.charAt(i),
                    i == length - 1 ? '.' : roman.charAt(i + 1)
            );
        }

        return answer;
    }

    private static int romanNumeralToArabic(char numeral, char nextNumeral) {
        switch (numeral) {
            case 'M' -> {
                return 1000;
            }
            case 'D' -> {
                return 500;
            }
            case 'C' -> {
                return nextNumeral == 'D' || nextNumeral == 'M' ? -100 : 100;
            }
            case 'L' -> {
                return 50;
            }
            case 'X' -> {
                return nextNumeral == 'L' || nextNumeral == 'C' ? -10 : 10;
            }
            case 'V' -> {
                return 5;
            }
            case 'I' -> {
                return nextNumeral == 'V' || nextNumeral == 'X' ? -1 : 1;
            }
        }

        return 0;
    }
}
