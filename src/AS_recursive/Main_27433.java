package AS_recursive;
// 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
// 첫째 줄에 정수 N(0 ≤ N ≤ 20)이 주어진다.
// 첫째 줄에 N!을 출력한다.

import java.util.Scanner;

public class Main_27433 {
    private static long factorial(int n){
        return (n == 0)? 1 : n*factorial(n-1);
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
        sc.close();
    }
}