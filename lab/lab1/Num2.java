package lab1;//Изограмма – это слово, в котором нет повторяющихся букв,
//последовательных или непоследовательных. Реализуйте функцию, которая
//определяет, является ли строка, изограммой. Пустая строка является
//изограммой.

import java.util.Scanner;

public class Num2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введи слово: ");
        String word = s.nextLine();

        boolean res = isIsogram(word);

        if (res) {
            System.out.println("'" + word + "' - изограмма");
        } else {
            System.out.println("'" + word + "' - не изограмма");
        }
        s.close();
    }

    public static boolean isIsogram(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        str = str.toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);

            if (Character.isLetter(currentChar) || Character.isDigit(currentChar)) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == currentChar) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}