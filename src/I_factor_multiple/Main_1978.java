package I_factor_multiple;
// 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
// 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

import java.util.Scanner;

public class Main_1978 {
public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int result = cnt;
        int n;        
        for(int i = 0; i < cnt; i++){
            n = sc.nextInt();
            if(n == 1){
                result--;
                continue;
            }
            for(int j = 2; j < n; j++){
                if(n%j==0){
                    result--;
                    break;
                }
            }
        }
        System.out.print(result);
        sc.close();
    }
}
