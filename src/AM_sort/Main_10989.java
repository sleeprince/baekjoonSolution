package AM_sort;
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10989 {
        public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i = 0; i < arr.length; i++)
            arr[i] = 0;
        for(int i = 0; i < cnt; i++)
            arr[Integer.parseInt(br.readLine())]++;
        for(int i = 0; i < arr.length; i++){
            while(arr[i] > 0){ 
                bw.write(i + "\n");
                arr[i]--;
            }
        }
        bw.flush();
        bw.close();
    }
}
