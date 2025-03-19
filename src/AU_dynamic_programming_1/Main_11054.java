package AU_dynamic_programming_1;
// 수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.
// 예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만, {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.
// 수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.
// 첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)
// 첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.

import java.util.Scanner;

public class Main_11054 {
    private static int[] series;
    private static int[] lenOfLIS;
    private static int[] lenOfLDS;
    private static int getLengthOfLIS(int pos){
        if(lenOfLIS[pos] != 0) return lenOfLIS[pos];
        int max = 0;
        for(int i = 0; i < pos; i++)
            if(series[pos] > series[i])
                if(getLengthOfLIS(i) > max)
                    max = getLengthOfLIS(i);
        return lenOfLIS[pos] = max + 1;
    }
    private static int getLengthOfLDS(int pos){
        if(lenOfLDS[pos] != 0) return lenOfLDS[pos];
        int max = 0;
        for(int i = pos + 1; i < series.length; i++)
            if(series[pos] > series[i])
                if(getLengthOfLDS(i) > max)
                    max = getLengthOfLDS(i);
        return lenOfLDS[pos] = max + 1;
    }
    private static int getLengthOfLBS(){ 
        int max = 0;
        for(int i = 0; i < series.length; i++)
            if(getLengthOfLDS(i) + getLengthOfLIS(i) > max)
                max = getLengthOfLDS(i) + getLengthOfLIS(i);
        return max - 1;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        series = new int[size];
        lenOfLIS = new int[size];
        lenOfLDS = new int[size];
        for(int i = 0; i < size; i++) series[i] = sc.nextInt();
        System.out.println(getLengthOfLBS());
        sc.close();
    }
}
