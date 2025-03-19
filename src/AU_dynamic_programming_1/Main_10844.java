package AU_dynamic_programming_1;
// 45656이란 수를 보자.
// 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
// N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
// 첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.
// 첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
import java.util.Scanner;
public class Main_10844 {
    private static int[][] series;
    private static int countNum(int step){
        if(step == 0){
            for(int i = 1; i < 10; i++)
                series[step][i] = 1;
            return countNum(step+1);
        }else if(step < series.length){
            series[step][0] = series[step-1][1];
            for(int i = 1; i < 9; i++)
                series[step][i] = sum(series[step-1][i-1], series[step-1][i+1]);
            series[step][9] = series[step-1][8];
            return countNum(step+1);
        }else{
            return sum(series[step-1]);
        }
    }
    private static int sum(int ...num){
        int sum = 0;
        for(int i : num)
            sum = (sum + i) % 1_000_000_000;
        return sum;
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        series = new int[num][10];
        System.out.println(countNum(0));
        sc.close();
    }
}
