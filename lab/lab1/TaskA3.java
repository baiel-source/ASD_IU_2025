package lab1;

import java.util.HashSet;
import java.util.Scanner;

public class TaskA3 {

    /**
     * Изограмма – это слово, в котором нет повторяющихся букв,
     * последовательных или непоследовательных. Реализуйте функцию, которая
     * определяет, является ли строка, изограммой. Пустая строка является
     * изограммой.
     */

    public static void main(String[] args) {
        System.out.println("Введите строку:");
        String s = new Scanner(System.in).nextLine();

        System.out.println("Решение с HashSet:");
        System.out.println("Строка " + (isIsogram(s) ? "" : "не ") + "является изограммой");

        System.out.println("Решение без HashSet:");
        System.out.println("Строка " + (isIsogramAlt(s) ? "" : "не ") + "является изограммой");
    }

    private static boolean isIsogram(String s) {
        if (s.length() < 2) return true;

        HashSet<Character> letters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (letters.contains(s.charAt(i))) return false;
            letters.add(s.charAt(i));
        }

        return true;
    }

    // Альтернативное решение без использования HashSet
    private static boolean isIsogramAlt(String s) {
        if (s.length() < 2) return true;

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, i).contains(s.charAt(i) + "")) return false;
        }

        return true;
    }
}
