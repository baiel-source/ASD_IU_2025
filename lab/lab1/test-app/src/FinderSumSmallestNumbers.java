import java.util.Scanner;

public class FinderSumSmallestNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberArray = ArrayProcessor.createNumberArray(scanner);
        if (numberArray.length < 5) {
            System.out.println("Элементов в массиве должно быть не меньше 5. (");
            scanner.close();
        } else {
            System.out.print("Исходный массив: ");
            ArrayProcessor.printArray(numberArray);
            int result = findSumOfTwoSmallestPositiveNumbers(numberArray);
            if (result == 0) {
                System.out.println("Не найдено двух положительных чисел.(");
            } else {
                System.out.println("Сумма двух наименьших положительных чисел: " + result);
            }

            scanner.close();
        }
    }

    public static int findSumOfTwoSmallestPositiveNumbers(int[] array) {
        int smallestPositive = Integer.MAX_VALUE;
        int secondSmallestPositive = Integer.MAX_VALUE;

        for(int i = 0; i < array.length; ++i) {
            if (array[i] > 0) {
                if (array[i] < smallestPositive) {
                    secondSmallestPositive = smallestPositive;
                    smallestPositive = array[i];
                } else if (array[i] < secondSmallestPositive) {
                    secondSmallestPositive = array[i];
                }
            }
        }

        if (secondSmallestPositive != Integer.MAX_VALUE) {
            return smallestPositive + secondSmallestPositive;
        } else {
            return 0;
        }
    }
}