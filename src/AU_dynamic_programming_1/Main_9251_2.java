package AU_dynamic_programming_1;
// LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
// 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
// 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
// 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

import java.util.Arrays;
import java.util.Scanner;
// 시간 초과
public class Main_9251_2 {
    private static int[][] lenOfCS;
    private static String a;
    private static String b;
    private static int getLenOfCS(int ia, int ib){
        if(ia >= a.length() || ib >= b.length()) return 0;
        if(lenOfCS[ia][ib] != -1) return lenOfCS[ia][ib];
        int next = b.indexOf(a.charAt(ia), ib);
        if(next == -1) return lenOfCS[ia][ib] = 0;
        else return lenOfCS[ia][ib] = getLenOfLCS(ia + 1, next+1) + 1;
    }
    private static int getLenOfLCS(int ia, int ib){
        int max = 0;
        for(int i = ia; i < a.length(); i++)
            if(max < getLenOfCS(i, ib))
                max = getLenOfCS(i, ib);
        return max;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        b = sc.nextLine();
        lenOfCS = new int[a.length()][b.length()];
        for(int[] cs : lenOfCS) Arrays.fill(cs, -1);
        System.out.println(getLenOfLCS(0, 0));
        // for(int[] cs : lenOfCS) System.out.println(Arrays.toString(cs));
        sc.close();
    }
}
