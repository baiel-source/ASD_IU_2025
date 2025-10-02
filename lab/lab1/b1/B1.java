package lab1.b1;
import lab1.Arr;

import java.io.IOException;


public class B1 {

    public static int find(int[] arr, int num){
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == num){
                count++;
            }
        }
        return count;
    }

    public static int max (int n1, int n2){
        if (n1 > n2) {return n1;}
        else {
            return n2;
        }
    }


    public static void main() throws IOException {
        Arr arr = new Arr();
        arr.inputArray();
        int res = -1;
        for (int i = 0; i<arr.getArr().length; i++){
            if (arr.getArr()[i] == find(arr.getArr(), arr.getArr()[i])){
                res = max(res, arr.getArr()[i]);
            }
        }
        System.out.println(res);



    }

}
