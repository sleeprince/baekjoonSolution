package AL_brute_force;
// 카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
// 한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
// 김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
// 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
// N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

// 첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
// 합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

// 첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

//재귀호출로 풀이
public class Main_2798_2 {

    private static int input() throws Exception{
        int tmp;
        int result = 0;
        while(true){
            tmp = System.in.read();
            if(tmp == 10) continue;
            if(tmp > '9' || tmp < '0') return result;
            result *= 10;
            result += tmp - '0';
        }
    }
    private static int findMaxSum(int[] card, int limit){     
        return findMaxSum(card, limit, 0, 3);
    }

    private static int findMaxSum(int[] card, int limit, int pos, int step){
        if(step != 0){            
            int sum = 0;
            int maxSum = 0;
            for(int i = pos; i < card.length - step + 1; i++){                
                sum = card[i] + findMaxSum(card, limit - card[i], i + 1, step - 1);
                if(sum <= limit && sum > maxSum) maxSum = sum;
            }
            if(limit == 0){
                return sum;
            }else{
                return maxSum;
            }
        }
        return 0;
    }
    
    public static void main(String[] args) throws Exception{
        int n = input();
        int m = input();
        int[] card = new int[n];
        for(int i = 0; i < n; i++){
            card[i] = input();
        }
        System.out.print(findMaxSum(card, m));

    }
}
