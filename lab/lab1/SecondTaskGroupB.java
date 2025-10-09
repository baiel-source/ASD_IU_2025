package lab1;

public class SecondTaskGroupB {

    public static void main(String[] args) {
        int[] multiplierNum1 = {1, 2, 3, 4, 5};
        int[] multiplierNum2 = {1, 2, 3};

        int[] result = multiplyArrays(multiplierNum1, multiplierNum2);
        printArray(result);
    }

    public static int[] multiplyArrays(int[] a, int[] b) {
        int num1 = translateToNumbers(a);
        int num2 = translateToNumbers(b);
        int product = num1 * num2;
        return numberToArray(product);
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


    public static int translateToNumbers(int[] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            str = str + arr[i];
        }
        int num = Integer.parseInt(str);
        return num;
    }


    public static int[] numberToArray(int num) {
        String str = String.valueOf(num);
        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }

        return arr;
    }
}
