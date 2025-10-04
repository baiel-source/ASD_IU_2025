import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class IsogramChecker {

    public static boolean isIsogram(String str) {
        if (str == null) {
            return false;
        }

        if (str.isEmpty()) {
            return true;
        }

        String lowerStr = str.toLowerCase();
        Set<Character> seenLetters = new HashSet<>();

        for (char c : lowerStr.toCharArray()) {
            if (Character.isLetter(c)) {
                if (seenLetters.contains(c)) {
                    return false;
                }
                seenLetters.add(c);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        System.out.println("=== Проверка изограмм ===");

        while (continueProgram) {
            System.out.print("Введите слово для проверки: ");
            String word = scanner.nextLine();

            boolean result = isIsogram(word);

            if (result) {
                System.out.println("✓ '" + word + "' является изограммой");
            } else {
                System.out.println("✗ '" + word + "' не является изограммой");
            }

            System.out.print("Проверить еще одно слово? (да/нет): ");
            String answer = scanner.nextLine();

            if (!answer.equalsIgnoreCase("да")) {
                continueProgram = false;
                System.out.println("Программа завершена!");
            }
        }

        scanner.close();
    }
}
