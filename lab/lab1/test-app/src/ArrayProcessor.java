import java.util.Scanner;

public class ArrayProcessor {
    private static final int MIN_ARRAY_LENGTH = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] NumberArray = createNumberArray(scanner);
        printArray(NumberArray);
        scanner.close();
    }

    public static int[] createNumberArray(Scanner scanner) {
        int arrayLength = readArrayLength(scanner);
        int[] array = new int[arrayLength];
        fillArray(array, scanner);
        return array;
    }

    private static int readArrayLength(Scanner scanner) {
        int length;
        do {
            System.out.print("Введите длину массива: ");
            length = scanner.nextInt();
            if (length < 1) {
                System.out.print("Длина массива не может быть <1.");
            }
        } while(length < 1);

        return length;
    }

    private static void fillArray(int[] array, Scanner scanner) {
        for(int i = 0; i < array.length; ++i) {
            System.out.print("Введите элемент №" + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }

    }

    public static void printArray(int[] array) {
        System.out.print("Массив: ");

        for(int i = 0; i < array.length; ++i) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }

    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; ++i) {
            int currentElement = array[i];

            int j;
            for(j = i - 1; j >= 0 && array[j] > currentElement; --j) {
                array[j + 1] = array[j];
            }

            array[j + 1] = currentElement;
        }

    }
}