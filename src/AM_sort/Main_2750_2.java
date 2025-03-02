package AM_sort;
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

import java.util.Scanner;

public class Main_2750_2 {
    private static int[] mergeSort(int[] arr){
        if(arr.length > 1){
            int[] fArray = new int[arr.length/2];
            int[] bArray = new int[arr.length - arr.length/2];
            for(int i = 0; i < fArray.length; i++) 
                fArray[i] = arr[i];
            for(int i = 0; i < bArray.length; i++)
                bArray[i] = arr[fArray.length + i];
            fArray = mergeSort(fArray);
            bArray = mergeSort(bArray);
            arr = mergeArray(fArray, bArray);
        }
        return arr;
    }
    private static int[] mergeArray(int[] arr1, int[] arr2){
        int pos1 = 0;
        int pos2 = 0;
        int[] arr = new int[arr1.length + arr2.length];
        for(int i = 0; i < arr.length; i++){
            if(pos1 == arr1.length){
                arr[i] = arr2[pos2];
                pos2++;
            }else if(pos2 == arr2.length){
                arr[i] = arr1[pos1];
                pos1++;
            }else if(arr1[pos1] > arr2[pos2]){
                arr[i] = arr2[pos2];
                pos2++;
            }else{
                arr[i] = arr1[pos1];
                pos1++;
            }
        }
        return arr;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        for(int i = 0; i < cnt; i++)
            arr[i] = sc.nextInt();
        arr = mergeSort(arr);
        for(int i = 0; i < cnt; i++)
            System.out.println(arr[i]);
        sc.close();
    }
}
