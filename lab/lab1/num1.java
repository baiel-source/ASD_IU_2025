package lab1;//Реализуйте перевод из римских чисел в арабские.

import java.util.Scanner;
public class num1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введи римское число: ");
        String rom = s.nextLine().toUpperCase();
        int res = 0;
        int prev = 0;
        for (int i = rom.length() - 1; i >= 0; i--) {
            char cChar = rom.charAt(i);
            int cValue = getValue(cChar);
            if (cValue < prev) {
                res -= cValue;
            } else {
                res += cValue;
            }
            prev = cValue;
        }
        System.out.println(rom + " = " + res);
        s.close();
    }
    public static int getValue(char romanChar) {
        switch (romanChar) {
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
}