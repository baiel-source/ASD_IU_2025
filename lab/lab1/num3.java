package lab1;//Реализуйте метод, входными данными которого являются два числа N и M,
//где N – число в десятичной системе исчисления, а M – число в диапазоне от
//2 до 9, основание системы исчисления, в которое надо перевести исходное число.
// Метод должен возвращать строку с преобразованным значением.

import java.util.Scanner;

public class num3 {
    public static String Num(int N, int M) {
        if (M < 2 || M > 9) {
            return "Ошибка";
        }
        if (N == 0) {
            return "0";
        }
        boolean Neg = false;
        if (N < 0) {
            Neg = true;
            N = -N;
        }
        String res = "";
        while (N > 0) {
            int rem = N % M;
            res = rem + res;
            N = N / M;
        }
        if (Neg) {
            res = "-" + res;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Число в десятичной системе: ");
        int N = s.nextInt();
        System.out.print("Введи основание системы 2-9: ");
        int M = s.nextInt();
        String result = Num(N, M);
        System.out.println("Число " + N + " в системе с основанием " + M + " = " + result);
        s.close();
    }
}
