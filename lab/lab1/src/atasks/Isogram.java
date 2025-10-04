//Реализуйте метод, входными данными которого являются два числа N и M,
//где N – число в десятичной системе исчисления,
//а M – число в диапазоне от 2 до 9, основание системы исчисления,
//в которое надо перевести исходное число.
//Метод должен возвращать строку с преобразованным значением.

package atasks;

import java.util.Scanner;

public class Isogram {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input text:");
        String text = scanner.nextLine();

        if (isIsogram(text)) {
            System.out.println("This string is isogram");
        } else {
            System.out.println("This string is not isogram");
        }
    }

    static boolean isIsogram(String str) {
        if (str.isBlank()) {
            return true;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

}
