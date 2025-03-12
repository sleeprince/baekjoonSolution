package AU_dynamic_programming_1;
// 오늘도 서준이는 동적 프로그래밍 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
// 오늘은 n의 피보나치 수를 재귀호출과 동적 프로그래밍으로 구하는 알고리즘을 배웠다. 재귀호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해 보자. 아래 의사 코드를 이용하여 n의 피보나치 수를 구할 경우 코드1 코드2 실행 횟수를 출력하자.
// 첫째 줄에 n(5 ≤ n ≤ 40)이 주어진다.
// 코드1 코드2 실행 횟수를 한 줄에 출력한다.

import java.util.Scanner;

public class Main_24416 {
    private static int recursive = 0;
    private static int dynamic = 0;
    private static int recursiveFibonacci(int n){
        if(n == 1 || n == 2){
            recursive++;
            return 1;
        }else{
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }
    private static int[] fib_series;
    private static int dynamicFibonacci(int n){
        fib_series[1] = 1;
        fib_series[2] = 2;
        for(int i = 3; i <= n; i++){
            dynamic++;
            fib_series[i] = fib_series[i - 1] + fib_series[i - 2];
        }
        return fib_series[n];
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib_series = new int[n + 1];
        recursiveFibonacci(n);
        dynamicFibonacci(n);
        System.out.println(recursive + " " + dynamic);
        sc.close();
    }
}
