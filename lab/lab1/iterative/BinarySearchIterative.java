package lab1.iterative;
import lab1.Arr;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchIterative {
    public static int binarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length-1;

        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) { return mid;}
            else if (arr[mid] < key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
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

    public static void main (String[] args) throws IOException {
        Arr arr = new Arr();
        arr.inputArray();
        arr.bubbleSort();
        outputResult(binarySearch(arr.getArr(), getTarget()), arr);
    }
}
