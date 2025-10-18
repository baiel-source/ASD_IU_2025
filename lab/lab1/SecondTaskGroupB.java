package lab1;

public class SecondTaskGroupB {

    public static void main(String[] args) {
        int[] multiplierNum1 = Utils.inputArray();
        int[] multiplierNum2 = Utils.inputArray();

        int[] result = Utils.multiplyArrays(multiplierNum1, multiplierNum2);
        Utils.printArray(result);
    }

}
