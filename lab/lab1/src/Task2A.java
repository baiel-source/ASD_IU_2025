import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task2A {

    public static void main(String[] args) throws IOException {
        String romanNumber = readRomanNumber();
        int arabicNumber = convertNumber(romanNumber);
        numberResult(romanNumber, arabicNumber);
    }

    public static String readRomanNumber() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите римское число: ");
        String number = reader.readLine();
        return number;
    }

    public static int getRomanNumber(char romanNumber) {
        switch (romanNumber) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static int convertNumber(String roman) {
        int result = 0;
        int value = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            int currentValue = getRomanNumber(currentChar);
            if (currentValue < value) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            value = currentValue;
        }
        return result;
    }

    public static void numberResult(String roman, int arabic) {
        System.out.println("Результат перевода:");
        System.out.println(roman + " = " + arabic);
    }
}