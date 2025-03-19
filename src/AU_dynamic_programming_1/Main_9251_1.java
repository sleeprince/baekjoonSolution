package AU_dynamic_programming_1;
// LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
// 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
// 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
// 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.

import java.util.Scanner;
// 재귀 함수로만 구현. 시간 초과
public class Main_9251_1 {
    private static int getLenOfLCS(String a, String b, int i_a, int i_b, int lcs){
        if(i_a < a.length()){
            int next = i_b;
            while(next < b.length()){
                if(a.charAt(i_a) == b.charAt(next)) break;
                next++;
            }
            if(next != b.length()){  
                int max = 0;              
                for(int i = i_a + 1; i < a.length(); i++){
                    int len = getLenOfLCS(a, b, i, next+1, 0);
                    if(max < len) max = len;
                }
                if(max + 1 > lcs) lcs = max + 1;
            }
            return getLenOfLCS(a, b, i_a + 1, i_b, lcs);
        }else{
            return lcs;
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(getLenOfLCS(a, b, 0, 0, 0));
        sc.close();
    }
}
