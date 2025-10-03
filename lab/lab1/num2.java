package lab1;//Изограмма – это слово, в котором нет повторяющихся букв,
//последовательных или непоследовательных. Реализуйте функцию, которая
//определяет, является ли строка, изограммой. Пустая строка является
//изограммой.

import java.util.Scanner;

public class num2 {
    public static boolean Isogram(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        str = str.toLowerCase();
        boolean[] seenLetters = new boolean[59];
        for (int i = 0; i < str.length(); i++) {
            char cChar = str.charAt(i);
            int index = -1;
            if (cChar >= 'а' && cChar <= 'я') {
                index = cChar - 'а';
            }
            else if (cChar >= 'a' && cChar <= 'z') {
                index = cChar - 'a' + 33;
            }
            if (index != -1 && seenLetters[index]) {
                return false;
            }
            if (index != -1) {
                seenLetters[index] = true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введи слово: ");
        String word = s.nextLine();
        boolean res = Isogram(word);
        if (res) {
            System.out.println("'" + word + "' - изограмма");
        } else {
            System.out.println("'" + word + "' - не изограмма");
        }
        s.close();
    }
}
