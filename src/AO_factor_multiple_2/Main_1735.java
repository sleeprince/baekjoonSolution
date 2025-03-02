package AO_factor_multiple_2;
// 분수 A/B는 분자가 A, 분모가 B인 분수를 의미한다. A와 B는 모두 자연수라고 하자.
// 두 분수의 합 또한 분수로 표현할 수 있다. 두 분수가 주어졌을 때, 그 합을 기약분수의 형태로 구하는 프로그램을 작성하시오. 기약분수란 더 이상 약분되지 않는 분수를 의미한다.

// 첫째 줄과 둘째 줄에, 각 분수의 분자와 분모를 뜻하는 두 개의 자연수가 순서대로 주어진다. 입력되는 네 자연수는 모두 30,000 이하이다.
// 첫째 줄에 구하고자 하는 기약분수의 분자와 분모를 뜻하는 두 개의 자연수를 빈 칸을 사이에 두고 순서대로 출력한다.
import java.util.Scanner;
public class Main_1735 {
    private static int gcd(int a, int b){
        int numerator = (a > b)? a : b;
        int denominator = (a > b)? b : a;
        return (numerator % denominator == 0)? denominator : gcd(denominator, numerator % denominator);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int num_a = sc.nextInt();
        int den_a = sc.nextInt();
        int num_b = sc.nextInt();
        int den_b = sc.nextInt();
        int num_c = num_a * den_b + num_b * den_a;
        int den_c = den_a * den_b;
        int gcd = gcd(num_c, den_c);
        System.out.println((num_c/gcd) + " " + (den_c/gcd));
        sc.close();
    }
}
