package lab1;//Дано целое число. Реализуйте метод, который находит N первых простых
//чисел. Используйте алгоритм «Решето Эратосфена».

import java.util.Scanner;

public class Num4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введи n: ");
        int n = s.nextInt();
        find(n);
        s.close();
    }

    public static void find(int n) {
        if (n <= 0) {
            System.out.println("n должно быть положительным числом");
            return;
        }

        int max = calculateLimit(n);
        boolean[] primes = new boolean[max + 1];

        for (int i = 2; i <= max; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= max; j += i) {
                    primes[j] = false;
                }
            }
        }

        System.out.println("Первые " + n + " простых чисел:");
        int count = 0;
        for (int i = 2; i <= max && count < n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
    }

    public static int calculateLimit(int n) {
        if (n <= 0) return 100;
        return n * 15 + 50;
    }
}