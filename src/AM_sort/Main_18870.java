package AM_sort;
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

    public static int[] mergeSort(int[] arr){
        int[] sortedArr = new int[1];
        if(arr.length > 1){            
            int[] a = new int[arr.length/2];
            int[] b = new int[arr.length - a.length];
            for(int i = 0; i < a.length; i++)
                a[i] = arr[i];
            for(int i = 0; i < b.length; i++)
                b[i] = arr[i + a.length];
            a = mergeSort(a);
            b = mergeSort(b);
            sortedArr = mergeArray(a, b);
        }else{
            sortedArr[0] = arr[0];
        }
        return sortedArr;
    }
    public static int[] mergeArray(int[] a, int[] b){
        int[] arr = new int[a.length + b.length];
        int fingerA = 0;
        int fingerB = 0;
        int size = 0;
        while(fingerA < a.length || fingerB < b.length){
            if(fingerA >= a.length){
                arr[size] = b[fingerB];
                fingerB++;
            }else if(fingerB >= b.length){
                arr[size] = a[fingerA];
                fingerA++;
            }else if(a[fingerA] > b[fingerB]){
                arr[size] = b[fingerB];
                fingerB++;
            }else if(a[fingerA] < b[fingerB]){
                arr[size] = a[fingerA];
                fingerA++;
            }else{
                arr[size] = a[fingerA];
                fingerA++;
                fingerB++;
            }
            size++;
        }
        int[] result = new int[size];
        for(int i = 0; i < size; i++)
            result[i] = arr[i];              
        return result;
    }

    public static int searchIndexOf(int[] sortedArr, int key, int from, int to){
        if(to != from){
            int half = (from + to)/2;
            if(sortedArr[half] == key)
                return half;
            else if(sortedArr[half] > key)
                return searchIndexOf(sortedArr, key, from, half);
            else if(sortedArr[half] < key)
                return searchIndexOf(sortedArr, key, half + 1, to);
        }
        return -1;
    }
    public static void main(String[] args) throws Exception{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < cnt; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int[] sortedArr = mergeSort(arr);
        // for(int el : sortedArr)
        //     System.out.print(el + " ");
        // System.out.println();
        for(int el : arr){
            bw.write(searchIndexOf(sortedArr, el, 0, sortedArr.length) + " ");            
        }
        bw.flush();
        bw.close();
    }
}
