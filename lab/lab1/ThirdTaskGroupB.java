package lab1;

// Дан массив целых чисел. Минимальное количество элементов – 5.
// Вернуть число, которое является суммой двух наименьших положительных чисел.

public class ThirdTaskGroupB {

    public static void main() {
        int[] arr = Utils.inputArray();
        String result = sumOfTwoSmallestPositives(arr);
        System.out.println(result);
    }

    public static String sumOfTwoSmallestPositives(int[] arr) {
        if (!isValidArray(arr)) {
            return "Ошибка: массив должен содержать минимум 5 элементов";
        }

        int[] positiveNumbers = extractPositiveNumbers(arr);
        if (positiveNumbers.length < 2) {
            return "Ошибка: массив должен содержать минимум 2 положительных числа";
        }

        Utils.insertionSort(positiveNumbers);
        int sum = calculateSumOfTwoSmallest(positiveNumbers);

        return "Сумма 2-х положительных чисел: " + sum;
    }

    private static boolean isValidArray(int[] arr) {
        return arr != null && arr.length >= 5;
    }

    private static int[] extractPositiveNumbers(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num > 0) count++;
        }

        int[] positives = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num > 0) positives[index++] = num;
        }

        return positives;
    }

    // Считает сумму двух наименьших элементов массива
    private static int calculateSumOfTwoSmallest(int[] arr) {
        return arr[0] + arr[1];
    }
}
