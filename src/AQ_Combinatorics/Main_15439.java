package AQ_Combinatorics;
// 베라는 상의 N 벌과 하의 N 벌이 있다. i 번째 상의와 i 번째 하의는 모두 색상 i를 가진다. N 개의 색상은 모두 서로 다르다.
// 상의와 하의가 서로 다른 색상인 조합은 총 몇 가지일까?
import java.util.Scanner;
public class Main_15439 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n*(n-1));
        sc.close();
    }
}
