import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Реализовать алгоритм бинарного поиска двумя способами.

public class SimpleRomanConverter {

    private static final Map<Character, Integer> ROMAN_MAP = createRomanMap();

    private static Map<Character, Integer> createRomanMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    public static int romanToArabic(String roman) {
        if (roman == null || roman.isEmpty()) {
            throw new IllegalArgumentException("Римское число не может быть пустым");
        }

        String upperRoman = roman.toUpperCase();
        int result = 0;
        int prevValue = 0;

        for (int i = upperRoman.length() - 1; i >= 0; i--) {
            char currentChar = upperRoman.charAt(i);

            if (!ROMAN_MAP.containsKey(currentChar)) {
                throw new IllegalArgumentException("Недопустимый символ: " + currentChar);
            }

            int currentValue = ROMAN_MAP.get(currentChar);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Простой конвертер римских чисел ===");

        while (true) {
            System.out.print("\nВведите римское число (или 'выход' для завершения): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("выход")) {
                System.out.println("Программа завершена!");
                break;
            }

            try {
                int result = romanToArabic(input);
                System.out.println("Результат: " + input.toUpperCase() + " = " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}