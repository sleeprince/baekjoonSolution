package AU_dynamic_programming_1;
// 수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
// 예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
// 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
// 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
// 첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
import java.util.Scanner;
public class Main_11053 {
    private static int[] series;
    private static int[] lenOfIS;
    private static int lis = 0;
    private static int getLengthOfLIS(int size){
        if(size-- > 0){
            int max = 0;
            for(int i = size+1; i < series.length; i++)
                if(series[size] < series[i])
                    if(max < lenOfIS[i]) max = lenOfIS[i];
            lenOfIS[size] = max + 1;
            if(lenOfIS[size] > lis) lis = lenOfIS[size];
            return getLengthOfLIS(size);
        }else{
            return lis;
        }
    }
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        series = new int[size];
        lenOfIS = new int[size];
        for(int i = 0; i < size; i++) series[i] = sc.nextInt();
        System.out.println(getLengthOfLIS(size));
        sc.close();
    }
}
