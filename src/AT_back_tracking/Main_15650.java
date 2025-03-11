package AT_back_tracking;
// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
// 고른 수열은 오름차순이어야 한다.
// 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
// 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
// 수열은 사전 순으로 증가하는 순서로 출력해야 한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15650 {
    private static int n;
    private static int[] arr;
    private static void printCombination(BufferedWriter bw, int next) throws Exception{
        if(next < arr.length){
            for(int i = (next == 0)? 0 : arr[next-1]; i < n; i++){
                arr[next++] = i + 1;
                printCombination(bw, next--);
            }
        }else{
            for(int i : arr) bw.write(i + " ");
            bw.write("\n");
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[Integer.parseInt(st.nextToken())];
        printCombination(bw, 0);
        bw.flush();
        bw.close();
    }
}
