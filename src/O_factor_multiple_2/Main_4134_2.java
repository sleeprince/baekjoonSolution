package O_factor_multiple_2;
// 정수 n(0 ≤ n ≤ 4*10^9)가 주어졌을 때, n보다 크거나 같은 소수 중 가장 작은 소수 찾는 프로그램을 작성하시오.

// 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다.
// 각각의 테스트 케이스에 대해서 n보다 크거나 같은 소수 중 가장 작은 소수를 한 줄에 하나씩 출력한다.
import java.util.Scanner;

public class Main_4134_2 {
    private static boolean isPrimeNumber(long num){
        if(num == 2) return true;
        if(num < 2 || num % 2 == 0) return false;
        for(long i = 3; i*i <= num; i += 2){
            if(num % i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for(int i = 0; i < cnt; i++){
            long num = sc.nextLong();
            while(true){
                if(isPrimeNumber(num)){
                    System.out.println(num);
                    break;
                }
                num++;
            }
        }
        sc.close();
    }
}
