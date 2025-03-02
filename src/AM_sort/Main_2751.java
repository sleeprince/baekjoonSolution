package AM_sort;
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2751 {
        private static int[] mergeSort(int[] arr){
        if(arr.length > 1){
            int[] fArr = new int[arr.length/2];
            int[] bArr = new int[arr.length - fArr.length];
            for(int i = 0; i < fArr.length; i++)
                fArr[i] = arr[i];
            for(int i = 0; i < bArr.length; i++)
                bArr[i] = arr[fArr.length + i];
            fArr = mergeSort(fArr);
            bArr = mergeSort(bArr);
            arr = mergeArray(fArr, bArr);
        }
        return arr;
    }
    private static int[] mergeArray(int[] fArr, int[] bArr){
        int fps = 0;
        int bps = 0;
        int[] arr = new int[fArr.length + bArr.length];
        for(int i = 0; i < arr.length; i++){
            if(fps == fArr.length){
                arr[i] = bArr[bps];
                bps++;
            }else if(bps == bArr.length){
                arr[i] = fArr[fps];
                fps++;
            }else if(fArr[fps] < bArr[bps]){
                arr[i] = fArr[fps];
                fps++;
            }else{
                arr[i] = bArr[bps];
                bps++;
            }
        }
        return arr;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[cnt];
        for(int i = 0; i < cnt; i++)
            arr[i] = Integer.parseInt(br.readLine());
        arr = mergeSort(arr);
        for(int i = 0; i < cnt; i++)
            bw.write(arr[i] + "\n");
        bw.flush();
        bw.close();
    }
}
