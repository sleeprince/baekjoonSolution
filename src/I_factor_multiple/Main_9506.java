package I_factor_multiple;
// 어떤 숫자 n이 자신을 제외한 모든 약수들의 합과 같으면, 그 수를 완전수라고 한다.
// 예를 들어 6은 6 = 1 + 2 + 3 으로 완전수이다.
// n이 완전수인지 아닌지 판단해주는 프로그램을 작성하라.

// 입력은 테스트 케이스마다 한 줄 간격으로 n이 주어진다. (2 < n < 100,000)
// 입력의 마지막엔 -1이 주어진다.

// 테스트케이스 마다 한줄에 하나씩 출력해야 한다.
// n이 완전수라면, n을 n이 아닌 약수들의 합으로 나타내어 출력한다(예제 출력 참고).
// 이때, 약수들은 오름차순으로 나열해야 한다.
// n이 완전수가 아니라면 n is NOT perfect. 를 출력한다.

import java.util.Scanner;

public class Main_9506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sum;
        String str;     
        while((n = sc.nextInt()) != -1){
            sum = 1;
            str = n + " = 1";            
            for(int i = 2; i < n; i++){
                if(n%i == 0) {
                    str += " + " + i;
                    sum += i;
                }
            }
            if(n == sum){                
                System.out.println(str);
            }else{
                System.out.println(n + " is NOT perfect.");
            }
        }
        sc.close();
    }
}
