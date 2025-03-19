package AU_dynamic_programming_1;
// LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
// 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
// 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
// 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

import java.util.Arrays;
import java.util.Scanner;

public class Main_9252_2 {
    private static int[][] lenOfLCS;
    private static int[][] trace;
    private static String a;
    private static String b;
    private static int getLenOfLCS(int ia, int ib){
        if(ia >= a.length() || ib >= b.length()) return 0;
        if(lenOfLCS[ia][ib] != -1) return lenOfLCS[ia][ib];
        int[] max = findMax(getLenOfLCS(ia+1, ib), getLenOfLCS(ia, ib+1), getLenOfLCS(ia+1, ib+1) + ((a.charAt(ia) == b.charAt(ib))? 1 : 0));
        trace[ia][ib] = max[0];
        return lenOfLCS[ia][ib] = max[1];
    }
    private static int[] findMax(int... nums){
        int index = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        return new int[]{index, max};
    }
    private static void printLCS(int ia, int ib){
        if(ia >= a.length() || ib >= b.length()){
            System.out.println("");
            return;
        }
        switch (trace[ia][ib]) {
            case 0:
                printLCS(ia+1, ib);
                break;
            case 1:
                printLCS(ia, ib+1);
                break;
            case 2:
                if(a.charAt(ia) == b.charAt(ib)) System.out.print(a.charAt(ia));
                printLCS(ia+1, ib+1);
                break;
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        b = sc.nextLine();
        lenOfLCS = new int[a.length()][b.length()];
        trace = new int[a.length()][b.length()];        
        for(int[] cs : lenOfLCS) Arrays.fill(cs, -1);
        System.out.println(getLenOfLCS(0, 0));
        printLCS(0, 0);
        sc.close();
    }
}
