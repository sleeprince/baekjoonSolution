package O_factor_multiple_2;
// 한 줄에 두 정수 A와 B가 공백으로 분리되어 주어진다.
// 50%의 입력 중 A와 B는 1000(103)보다 작다. 다른 50%의 입력은 1000보다 크고 100000000(10^8)보다 작다.
// 추가: 큰 수 입력에 대하여 변수를 64비트 정수로 선언하시오. C/C++에서는 long long int를 사용하고, Java에서는 long을 사용하시오.
import java.util.Scanner;

public class Main_13241 {
    private static long gcd(long a, long b){
        long numerator = (a > b)? a : b;
        long denominator = (a > b)? b : a;
        return (numerator % denominator == 0)? denominator : gcd(denominator, numerator % denominator);
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        System.out.print((a*b)/gcd(a, b));
        sc.close();
    }
}
