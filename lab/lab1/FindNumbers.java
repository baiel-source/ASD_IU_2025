import java.util.Scanner;

/*Дан целочисленный массив. Верните число, частота встречи которого в
массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
таких чисел несколько, вернуть наибольшее.*/
class FindNumbers {

    public static void main() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите длину массива : ");
        int arrayLen = in.nextInt();
        int[] arr = new int[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            System.out.print("Введите элемент: ");
            arr[i] = in.nextInt();
        }

        int[] countArray = findNumbers(arr);

        output(countArray);

        in.close();
    }

    private static int[] findNumbers(int[] arr) {
        int n = arr.length;
        int[] countArray = new int[n];//нам не нужно учитывать числа, которые больше, чем длина массива, так как они не будут удовлетворять условиям задачи

        for (int j : arr) {
            if (j < n && j > 0) {
                countArray[j]++;
            }
        }

        return countArray;
    }

    private static void output(int[] countArray) {
        int flag = 0;
        int maxNumber = 0;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] == i && countArray[i] != 0) {
                maxNumber = i;
                flag++;
            }
        }

        if (flag == 0) {
            System.out.print("-1");
        } else {
            System.out.print(maxNumber + " ");
        }
    }
}

