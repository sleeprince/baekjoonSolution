package O_factor_multiple_2;
// 서강대학교 컴퓨터공학과 실습실 R912호에는 현재 N개의 창문이 있고 또 N명의 사람이 있다. 1번째 사람은 1의 배수 번째 창문을 열려 있으면 닫고 닫혀 있으면 연다.  2번째 사람은 2의 배수 번째 창문을 열려 있으면 닫고 닫혀 있으면 연다. 이러한 행동을 N번째 사람까지 진행한 후 열려 있는 창문의 개수를 구하라. 단, 처음에 모든 창문은 닫혀 있다.
// 예를 들어 현재 3개의 창문이 있고 3명의 사람이 있을 때,
// 1번째 사람은 1의 배수인 1,2,3번 창문을 연다. (1, 1, 1)
// 2번째 사람은 2의 배수인 2번 창문을 닫는다. (1, 0, 1)
// 3번째 사람은 3의 배수인 3번 창문을 닫는다. (1, 0, 0)
// 결과적으로 마지막에 열려 있는 창문의 개수는 1개이다.

// 첫 번째 줄에는 창문의 개수와 사람의 수 N(1 ≤ N ≤ 2,100,000,000)이 주어진다.
// 마지막에 열려 있는 창문의 개수를 출력한다.

// 작성하다 보니 이렇게까지 할 필요가 없었지만 하던 거라 마저 만들었다.
import java.util.Scanner;
public class Main_13909_2 {
    private static int size = 2;
    private static boolean[] isNotPrimeNum = new boolean[]{true, true, false};
    private static void updatePrimeNum(int newSize){
        if(newSize > size){
            boolean[] newArray = new boolean[newSize + 1];
            for(int i = 0; i < size + 1; i++)
                newArray[i] = isNotPrimeNum[i];
            isNotPrimeNum = newArray;

            for(int i = 2; i < newSize + 1; i++){
                if(isNotPrimeNum[i]) continue;
                for(int j = (size/i == 0)? 2*i : (size/i + 1)*i; j < newSize + 1; j += i)
                    isNotPrimeNum[j] = true;
            }
            size = newSize;
        }
    }
    private static int countAliquot(int n){
        if(n == 1) return 1;
        int result = 1;
        int cnt = 0;
        int newSize = n/2;
        updatePrimeNum(newSize);
        for(int i = 2; i <= newSize; i++){
            if(n == 1) break;
            if(isNotPrimeNum[i]) continue;
            cnt = 1;
            while(n%i == 0){
                cnt++;
                n /= i;
            }
            result *= cnt;
        }
        return (result == 1)? 2 : result; 
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int cnt = 0;
        for(int i = 1; i < num + 1; i++)
            if(countAliquot(i) % 2 == 1) cnt++;
        
        System.out.println(cnt);
        sc.close();
    }
}
