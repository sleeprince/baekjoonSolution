package M_sort;
// 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
// Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
// X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

// 첫째 줄에 N이 주어진다.
// 둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

// 첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_18870 {

    public static Integer[] mergeSort(Integer[] arr){
        if(arr.length > 1){            
            Integer[] a = new Integer[arr.length/2];
            Integer[] b = new Integer[arr.length - a.length];
            for(int i = 0; i < a.length; i++)
            a[i] = arr[i];
            for(int i = 0; i < b.length; i++)
            b[i] = arr[i + a.length];
            a = mergeSort(a);
            b = mergeSort(b);
            arr = mergeArray(a, b);
        }
        return arr;
    }
    public static Integer[] mergeArray(Integer[] a, Integer[] b){
        Integer[] arr = new Integer[a.length + b.length];
        int fingerA = 0;
        int fingerB = 0;        
        for(int i = 0; i < arr.length; i++){
            if(fingerA >= a.length){
                arr[i] = b[fingerB];
                fingerB++;
            }else if(fingerB >= b.length){
                arr[i] = a[fingerA];
                fingerA++;
            }else if(a[fingerA] > b[fingerB]){
                arr[i] = b[fingerB];
                fingerB++;
            }else{
                arr[i] = a[fingerA];
                fingerA++;
            }
        }                  
        return arr;
    }

    public static int[] makeUnique(Integer[] arr){
        int size = arr.length;
        int j = 0;   
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == arr[j]){
                arr[i] = null;
                size--;
            }else{
                j = i + 1;
            }
        }
        int[] result = new int[size];
        int k = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                result[k] = arr[i];
                k++;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cnt; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int[] arrNew = new int[1];
        arr = mergeSort(arr);
        for(int i = 0; i < cnt; i++)
            System.out.print(arr[i] + " ");
        arrNew = makeUnique(arr);
        System.out.println();
        for(int i = 0; i < arrNew.length; i++)
            System.out.print(arrNew[i] + " ");
    }
}
