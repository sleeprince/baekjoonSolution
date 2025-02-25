package O_factor_multiple_2;
// M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
// 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
// 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
import java.util.Scanner;
public class Main_1929 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        boolean[] isCompositeNum = new boolean[n + 1];
        for(int i = 2; i < n + 1; i++){
            if(isCompositeNum[i]){
                continue;
            }else{
                if(m <= i)
                    System.out.println(i);
                for(int j = 2*i; j < n + 1; j+=i)
                    isCompositeNum[j] = true;
            }
        }
    }
}
