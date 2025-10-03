package lab1;//Дано целое число. Реализуйте метод, который находит N первых простых
//чисел. Используйте алгоритм «Решето Эратосфена».

import java.util.Scanner;

public class num4 {
    public static void find(int N) {
        int max = 50;
        boolean[] primes = new boolean[max + 1];
        for (int i = 2; i <= max; i++) primes[i] = true;
        for (int i = 2; i <= max; i++) {
            if (primes[i]) {
                for (int j = i + i; j <= max; j += i) primes[j] = false;
            }
        }
        if (N >= 1 && N <= 15) {
            System.out.println("Первые " + N + " простых чисел до 50:");
            int count = 0;
            for (int i = 2; i <= max && count < N; i++) {
                if (primes[i]) {
                    System.out.print(i + " ");
                    count++;
                }
            }
            System.out.println();
        }
        if (N>=16) {
            System.out.println("Неа, только до 15");
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Введи N: ");
        int N = s.nextInt();
        find(N);
        s.close();
    }
}
