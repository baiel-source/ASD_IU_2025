import java.util.Arrays;
import java.util.Scanner;

//Реализовать алгоритм бинарного поиска двумя способами.

public class TaskBinSearch {

    public static void main(String[] args) {
        //Ввод
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a length of the array: \n");
        int n = scanner.nextInt();
        //Вводим и сразу сортируем массив
        int[] array = ArrayTools.arrayInput(n);
        ArrayTools.arrayInsertionSort(array);
        System.out.println("Input a number that you want to find: \n");
        int number = scanner.nextInt();

        //Вывод массива
        System.out.println(Arrays.toString(array));

        System.out.println("Index of your number is " + iterBinSearch(array, number, 0, array.length - 1));
        System.out.println("Index of your number is " + recBinSearch(array, number, 0, array.length - 1));
    }

    //Реализация бинарного поиска итеративным методом
    public static int iterBinSearch(int[] sortedArray, int valueToFind, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            } else if (sortedArray[mid] > valueToFind) high = mid - 1;
            else if (sortedArray[mid] < valueToFind) low = mid + 1;
        }
        return index;
    }

    //Реализации бинарного поиска через рекурсию
    public static int recBinSearch(int[] sortedArray, int valueToFind, int low, int high) {
        if (low > high) return -1;
        if (low == high) return (sortedArray[low] == valueToFind) ? low : -1;
        int mid = low + (high - low) / 2;
        if (sortedArray[mid] < valueToFind) return recBinSearch(sortedArray, valueToFind, mid + 1, high);
        if (sortedArray[mid] > valueToFind) return recBinSearch(sortedArray, valueToFind, low, mid - 1);
        return mid;
    }


}