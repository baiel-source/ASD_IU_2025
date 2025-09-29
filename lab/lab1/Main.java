import java.util.Scanner;

//Реализовать алгоритм бинарного поиска двумя способами.
class binary_search{

    static void sort(int[] arr,int n){
        int flag=0;
        for (int i=0;i<n-1;i++){
            if(arr[i]>=arr[i+1]){
                flag++;
            }
            if(arr[i]<=arr[i+1]){
                flag--;
            }
        }

        if (flag!=n-1 && flag!=1-n) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    static void binary_search_1(int[] arr, int n, int x) {
        int left = 0;
        int right = n - 1;
        int found = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) {
                found = 1;
                break;
            }
            if (arr[mid] < x) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        if (found==1) {
            System.out.println("Элемент есть");
        }
        else {
            System.out.println("Элемента нет");
        }
    }

    static int binary_search_2(int[] arr, int x, int left, int right) {

        if (left > right) {
            return -1;
        }

        int middle = left + (right - left) / 2;

        if (arr[middle] < x) {
            return binary_search_2(arr, x, middle + 1, right);
        }

        if(arr[middle] > x) {
            return binary_search_2(arr, x, left, middle - 1);
        }

        return middle;
    }

    static void output(int[] arr, int index){
        if (index!=-1){
            System.out.println("Элемент есть");
        }
        else {
            System.out.println("Элемента нет");
        }
    }

    static void main(){

        Scanner in = new Scanner(System.in);

        System.out.print("Введите длину массива : ");
        int n=in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Введите элемент: ");
            arr[i]=in.nextInt();
        }

        sort(arr, n);

        System.out.print("Введите элемент, который хотите найти в массиве: ");
        int x = in.nextInt();

        binary_search_1(arr, n, x);

        int index=binary_search_2(arr,x,0,n-1);
        output(arr,index);

        in.close();
    }
}

/*Дан целочисленный массив. Верните число, частота встречи которого в
массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
таких чисел несколько, вернуть наибольшее.*/
class B1{

    static void find_numbers(int[] arr, int n){
        int[] count = new int[n];//нам не нужно учитывать числа, которые больше, чем длина массива, так как они не будут удовлетворять условиям задачи

        for(int i=0;i<n;i++){
            if (arr[i]<n && arr[i]>0){
                count[arr[i]]++;
            }
        }

        int flag=0;
        for(int i=0;i<n;i++){
            if (count[i]==i && count[i]!=0){
                System.out.print(i+" ");
                flag++;
            }
        }

        if (flag==0){
            System.out.print("-1");
        }
    }

    static void main() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите длину массива : ");
        int n=in.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Введите элемент: ");
            arr[i]=in.nextInt();
        }

        find_numbers(arr, n);

        in.close();
    }
}

/*Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
число, которое является суммой двух наименьших положительных чисел.*/
class B3{

    static void summary(int[] arr, int n){
        int min1=1000000000;
        int min2=1000000000;
        for(int i=0;i<n;i++){
            if (arr[i]>0 && arr[i]<min2){
                min2=arr[i];
                if(min1>min2){
                    min2=min1;
                    min1=arr[i];
                }
            }
        }
        if (min1!=1000000000 && min2!=1000000000){
            System.out.print(min1+min2);
        }
        else{
            System.out.print("в массиве меньше 2 положительных чисел");
        }
    }

    static void main() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите длину массива(не меньше 5) : ");
        int n = in.nextInt();
        if (n<5){
            System.out.print("Длина меньше 5");
            return;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент: ");
            arr[i] = in.nextInt();
        }

        summary(arr,n);

        in.close();
    }
}

/*Дано целое число. Реализуйте метод, который находит N первых простых
чисел. Используйте алгоритм «Решето Эратосфена».*/
class A4{

    static void sieve(int n){
        int max = n * (int)(Math.log(n) + Math.log(Math.log(n))) + 10000; //n простых чисел находятся примерно в диапазоне [1,n*ln(n)+ln(ln(n))], возьмем с запасом
        boolean[] arr=new boolean[max];

        for(int i=0;i<max;i++){
            arr[i]=true;
        }

        arr[0]=false;

        for(int i=2;i<max;i++){
            if(arr[i]==true){
                for (int j=2*i;j<max;j+=i){
                    arr[j]=false;
                }
            }
        }

        int count=0;
        for(int i=0;i<max;i++){
            if (arr[i]==true && count<n){
                System.out.print(i+" ");
                count++;
            }
        }
    }

    static void main() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите, сколько простых чисел хотите получить: ");
        int n = in.nextInt();

        sieve(n);

        in.close();
    }
}

/*Дан массив целых чисел, представляющий двоичное число.
Пример, дан массив bi_arr = [1, 1, 0]. Этот массив в десятичной системе
выглядит так: arr = [1, 3, 6]. То есть:
• arr[0] = bi_arr[0] = 1! = 1"#,
• arr[1] = bi_arr[0] bi_arr[1] =11! = 3"#,
• arr[2] = bi_arr[0] bi_arr[1] bi_arr[2] =110! = 6"#
Так же дано целое положительное число – n. Вернуть массив Boolean, где
true – число делится на N, false – нет.
Пусть n = 6, тогда для предыдущего примера результат должен выглядеть
так: [false, false, true].
Примечание. Делитель тоже необходимо ввести с клавиатуры.*/
class B4{

    static int[] conventing(int[] arr, int n){
        int[] new_arr = new int[n];

        new_arr[0]=arr[0];
        for (int i = 1; i < n; i++) {
            new_arr[i]=arr[i]+new_arr[i-1]*2;
        }
        return new_arr;
    }

    static boolean[] division(int[] new_arr, int n, int divisor){
        boolean[] bool_arr = new boolean[n];
        for(int i=0;i<n;i++){
            bool_arr[i]=false;
            if (new_arr[i]%divisor==0){
                bool_arr[i]=true;
            }
        }
        return bool_arr;
    }

    static void output(boolean[] arr, int n){
        System.out.print("[");
        for(int i=0;i<n;i++) {
            if (i == n - 1) {
                System.out.print(arr[i] + "]");
                break;
            }
            System.out.print(arr[i] + ", ");
        }
    }

    static void main() {

        Scanner in = new Scanner(System.in);

        System.out.print("Введите длину массива : ");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент: ");
            arr[i] = in.nextInt()%2;
        }

        System.out.print("Введите делитель: ");
        int divisor = in.nextInt();

        int[] new_arr=conventing(arr,n);

        boolean[] bool_arr=division(new_arr,n,divisor);

        output(bool_arr,n);

        in.close();
    }
}
