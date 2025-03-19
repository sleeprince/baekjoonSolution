package AU_dynamic_programming_1;
// LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
// 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
// 첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
// 첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를, 둘째 줄에 LCS를 출력한다.
// LCS가 여러 가지인 경우에는 아무거나 출력하고, LCS의 길이가 0인 경우에는 둘째 줄을 출력하지 않는다.
import java.util.Scanner;
// 시간 초과
public class Main_9252_1 {
    private static String[][] lcs;
    private static String a;
    private static String b;
    private static String getLCS(int idxA, int idxB){
        if(idxA >= a.length() || idxB >= b.length()) return "";
        if(lcs[idxA][idxB] != null) return lcs[idxA][idxB];
        return lcs[idxA][idxB] = getLongestString(getLCS(idxA+1, idxB), getLCS(idxA, idxB+1), ((a.charAt(idxA) == b.charAt(idxB))? a.charAt(idxA) : "") + getLCS(idxA+1, idxB+1));
    }
    private static String getLongestString(String... texts){
        String str = "";
        for(String txt : texts)
            if(str.length() < txt.length()) str = txt;
        return str;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        b = sc.nextLine();
        lcs = new String[a.length()][b.length()];
        String answer = getLCS(0, 0);
        System.out.println(answer.length());
        System.out.println(answer);
        sc.close();
    }
}
