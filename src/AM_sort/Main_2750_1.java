package AM_sort;
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

import java.util.Scanner;

public class Main_2750_1 {
    private static int[] insertionSort(int[] arr, int len){
        if(len > 1){
            arr = insertionSort(arr, len - 1);
            int i = len - 1;
            while(arr[i] < arr[i-1]){
               arr = switchElement(arr, i, i - 1);
               i--;
                if(i < 1) break;
            }
        }
        return arr;
    }
    private static int[] switchElement(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return arr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for(int i = 0; i < cnt; i++){
            arr[i] = sc.nextInt();
        }
        arr = insertionSort(arr, arr.length);
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);    
        }
        sc.close();
    }    
}
