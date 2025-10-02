package lab1.b3;

import lab1.Arr;
import java.io.IOException;


public class B3 {

    public static int searchSumMin(int[] arr){
        int min1 = 1000000;
        int min2 = 1000000;
        for (int i = 0; i<arr.length; i++){
            if (arr[i] > 0){
                if (arr[i] < min1){
                    min2 = min1;
                    min1 = arr[i];
                }
                else if (arr[i] < min2){
                    min2 = arr[i];
                }
            }
        }
        if (min1==min2 & min2==1000000){
            return -1;
        }
        return min1+min2;
    }

    public static void main (String[] args) throws IOException{
        Arr arr = new Arr();
        arr.inputArray();
        if (arr.getLen() < 5) return;
        System.out.println(searchSumMin(arr.getArr()));


    }
}
