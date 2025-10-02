package lab1;

public class TaskB4 {

    /**
     * Дан массив целых чисел, представляющий двоичное число.
     * <p>
     * Пример, дан массив bi_arr = [1, 1, 0]. Этот массив в десятичной системе
     * выглядит так: arr = [1, 3, 6]. То есть:
     * • arr[0] = bi_arr[0] = 1 = 1,
     * • arr[1] = bi_arr[0] bi_arr[1] = 11 = 3,
     * • arr[2] = bi_arr[0] bi_arr[1] bi_arr[2] = 110 = 6
     * <p>
     * Так же дано целое положительное число – n. Вернуть массив Boolean, где
     * true – число делится на N, false – нет.
     * <p>
     * Пусть n = 6, тогда для предыдущего примера результат должен выглядеть
     * так: [false, false, true].
     * <p>
     * Примечание. Делитель тоже необходимо ввести с клавиатуры.
     */

    public static void main(String[] args) {
        int[] bi_arr = MainTask.readArray();
        System.out.println();
        int divider = MainTask.readIntSafe("Введите делитель: ", false);
        System.out.println(writeBooleanArray(divides(toDecimal(bi_arr), divider)));
    }

    private static int[] toDecimal(int[] bi_arr) {
        int[] arr = new int[bi_arr.length];
        if (arr.length == 0) return arr;

        arr[0] = bi_arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = bi_arr[i] + arr[i - 1] * 2;
        }

        return arr;
    }

    private static boolean[] divides(int[] arr, int divider) {
        boolean[] answer = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i] % divider == 0;
        }

        return answer;
    }

    private static String writeBooleanArray(boolean[] array) {
        if (array.length == 0) return "[]";

        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++) {
            s.append(array[i]).append(", ");
        }
        s.append(array[array.length - 1]).append(']');

        return s.toString();
    }
}
