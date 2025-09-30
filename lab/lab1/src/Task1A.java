import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Task1A {

    public static void main(String[] args) throws IOException {
        int numberN = readNumberN();
        int numberM = readNumberM();
        String convertNumber = convertNumber(numberN, numberM);
        numberResult(numberN, numberM, convertNumber);
    }

    public static int readNumberN() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите число в десятичной системе: ");
        String number = reader.readLine();
        return Integer.parseInt(number);
    }

    public static int readNumberM() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите основание системы счисления от 2 до 9: ");
        String number = reader.readLine();
        return Integer.parseInt(number);
    }

    public static String convertNumber(int N, int M) {
        if (N == 0) {
            return "0";
        }
        int number = Math.abs(N);
        int length = resultLength(number, M);

        char[] resultArray = new char[length];
        int index = length - 1;
        while (number > 0) {
            int remainder = number % M;
            resultArray[index] = (char)('0' + remainder);
            number = number / M;
            index--;
        }
        String result = new String(resultArray);

        return result;
    }

    public static int resultLength(int number, int base) {
        int length = 0;
        int number2 = number;

        while (number2 > 0) {
            number2 = number2 / base;
            length++;
        }

        return length;
    }

    public static void numberResult(int originalNumber, int base, String convertNumber) {
        System.out.println("Результат перевода:");
        System.out.println(originalNumber + " (10) = " + convertNumber + " (" + base + ")");
    }
}