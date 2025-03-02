package AO_factor_multiple_2;
// 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
// 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.

// 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)
import java.util.Scanner;

public class Main_1934_2 {
    private static long gcd(long a, long b){
        long numerator = (a > b)? a : b;
        long denominator = (a > b)? b : a;
        return (numerator % denominator == 0)? denominator : gcd(denominator, numerator % denominator);
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int a, b;
        for(int i = 0; i < cnt; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println((a*b)/gcd(a, b));
        }
        sc.close();
    }
}
