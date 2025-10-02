package lab1.recursive;
import lab1.Arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchRecursive {
    public static int binarySearch(int[] arr, int key, int left, int right){
        if (left>right) {return -1;}
        int mid = left + (right - left) / 2;
        if (arr[mid] == key) {return mid;}
        else if (key < arr[mid]) {
            return binarySearch(arr, key, left, mid+1);
        }
        else {
            return binarySearch(arr, key, mid+1, right);
        }
    }

    public static int getTarget() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите элемент для поиска: ");
        return Integer.parseInt(br.readLine());
    }

    public static void outputResult(int result, Arr arr){
        System.out.println("Остортированный массив: \n");
        arr.printArray();
        if (result != -1){
            System.out.println("Элемент найден на позиции: " + result);
        }
        else{
            System.out.println("Элемент не найден");
        }
    }

    public static void main(String[] args) throws IOException {
        Arr arr = new Arr();
        arr.inputArray();
        arr.bubbleSort();
        outputResult(binarySearch(arr.getArr(), getTarget(), 0,  arr.getLen()), arr);


    }
}
