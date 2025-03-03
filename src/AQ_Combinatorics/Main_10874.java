package AQ_Combinatorics;

// 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
// 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
// 첫째 줄에 N!을 출력한다.

import java.util.Scanner;

public class Main_10874 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fac = 1;
        while(n > 0) fac *= n--;
        System.out.println(fac);
        sc.close();
    }
}