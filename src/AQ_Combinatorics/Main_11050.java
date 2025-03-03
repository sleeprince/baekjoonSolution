package AQ_Combinatorics;
// 자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수 \(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.
// 첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 10, 0 ≤\(K\) ≤ \(N\))
// \(\binom{N}{K}\)를 출력한다.
import java.util.Scanner;

public class Main_11050 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int com = 1;
        int dem = 1;
        while(k > 0){
            com *= n--;
            dem *= k--;
        }
        System.out.println(com/dem);
        sc.close();
    }
}