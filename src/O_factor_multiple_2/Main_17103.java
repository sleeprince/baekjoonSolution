package O_factor_multiple_2;
// 골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
// 짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.
// 첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 N은 짝수이고, 2 < N ≤ 1,000,000을 만족한다.
// 각각의 테스트 케이스마다 골드바흐 파티션의 수를 출력한다.
import java.util.Scanner;
public class Main_17103 {
    private static int lastNum = 2;
    private static boolean[] isCompositeNum = new boolean[]{true, true, false};
    private static void updateCompositeNum(int newLastNum){
        if(lastNum < newLastNum){
            boolean[] newArray = new boolean[newLastNum + 1];
            for(int i = 2; i < lastNum + 1; i++)
                newArray[i] = isCompositeNum[i];
            isCompositeNum = newArray;

            for(int i = 2; i < newLastNum + 1; i++){
                if(isCompositeNum[i]) continue;
                for(int j = (lastNum/i == 0)? 2*i : (lastNum/i + 1)*i; j < newLastNum + 1; j += i)
                    isCompositeNum[j] = true;
            }
            lastNum = newLastNum;
        }        
    }
    private static int countGoldbachPartition(int num){
        int sum = 0;
        updateCompositeNum(num);
        if(!isCompositeNum[num - 2])
            sum++;
        for(int i = 3; i <= num/2; i += 2){
            if(!isCompositeNum[i] && !isCompositeNum[num - i])
                sum++;
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        for(int i = 0; i < cnt; i++)
            System.out.println(countGoldbachPartition(sc.nextInt()));
        sc.close();
    }
}
