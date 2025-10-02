package lab1.b2;

import lab1.Arr;
import java.io.IOException;

public class B2 {

    public static void dataInput(){

    }

    public static int converterArrToInt (int[] arr){
        String s = "";
        int n;
        for (int i = 0; i<arr.length; i++){
            s += Integer.toString(arr[i]);
        }
        n = Integer.parseInt(s);
        return n;
    }

    public static int[] converterIntToArr (int n){
        String s = Integer.toString(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            arr[i] = Character.getNumericValue(s.charAt(i));
        }
        return arr;
    }

    public static void main(String[] args) throws IOException{
        Arr arr1 = new Arr();
        Arr arr2 = new Arr();
        arr1.inputArray();
        arr2.inputArray();
        int n1 = converterArrToInt(arr1.getArr());
        int n2 = converterArrToInt(arr2.getArr());
        int n = n1 * n2;
        int[] arr = converterIntToArr(n);
        Arr result = new Arr();
        result.setArray(arr);
        result.printArray();

    }
}
