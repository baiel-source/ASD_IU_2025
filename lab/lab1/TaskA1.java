package lab1;

public class TaskA1 {

    /**
     * Реализуйте метод, входными данными которого являются два числа N и M,
     * где N – число в десятичной системе исчисления, а M – число в диапазоне от
     * 2 до 9, основание системы исчисления, в которое надо перевести исходное
     * число. Метод должен возвращать строку с преобразованным значением.
     */

    public static void main(String[] args) {
        int number = MainTask.readIntSafe("Число в десятичной системе: ", false);
        int system = MainTask.readIntSafe("Новая система счисления: ", false);
        System.out.println(convertFromDecimal(number, system));
    }

    private static String convertFromDecimal(int number, int system) {
        if (system < 2 || system > 9) throw new IllegalArgumentException("Illegal numeral system");

        int coefficient = number < 0 ? -1 : 1;
        number *= coefficient;
        StringBuilder value = new StringBuilder();

        while (number != 0) {
            value.insert(0, number % system);
            number /= system;
        }

        return coefficient == 1 ? value.toString() : '-' + value.toString();
    }
}
