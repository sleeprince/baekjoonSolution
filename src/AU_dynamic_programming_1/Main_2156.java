package AU_dynamic_programming_1;
// 효주는 포도주 시식회에 갔다. 그 곳에 갔더니, 테이블 위에 다양한 포도주가 들어있는 포도주 잔이 일렬로 놓여 있었다. 효주는 포도주 시식을 하려고 하는데, 여기에는 다음과 같은 두 가지 규칙이 있다.
// 포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
// 1. 연속으로 놓여 있는 3잔을 모두 마실 수는 없다.
// 2. 효주는 될 수 있는 대로 많은 양의 포도주를 맛보기 위해서 어떤 포도주 잔을 선택해야 할지 고민하고 있다. 1부터 n까지의 번호가 붙어 있는 n개의 포도주 잔이 순서대로 테이블 위에 놓여 있고, 각 포도주 잔에 들어있는 포도주의 양이 주어졌을 때, 효주를 도와 가장 많은 양의 포도주를 마실 수 있도록 하는 프로그램을 작성하시오. 
// 예를 들어 6개의 포도주 잔이 있고, 각각의 잔에 순서대로 6, 10, 13, 9, 8, 1 만큼의 포도주가 들어 있을 때, 첫 번째, 두 번째, 네 번째, 다섯 번째 포도주 잔을 선택하면 총 포도주 양이 33으로 최대로 마실 수 있다.
// 첫째 줄에 포도주 잔의 개수 n이 주어진다. (1 ≤ n ≤ 10,000) 둘째 줄부터 n+1번째 줄까지 포도주 잔에 들어있는 포도주의 양이 순서대로 주어진다. 포도주의 양은 1,000 이하의 음이 아닌 정수이다.
// 첫째 줄에 최대로 마실 수 있는 포도주의 양을 출력한다.
import java.util.Scanner;
public class Main_2156 {
    private static int maxVol = 0;
    private static int[] wineVol;
    private static int[] maxVols;
    private static int findMaxVol(int step){
        if(step < wineVol.length){
            if(step == 0) maxVols[step] = wineVol[step];
            else if(step == 1) maxVols[step] = wineVol[step] + wineVol[step - 1];
            else if(step == 2) maxVols[step] = wineVol[step] + max(wineVol[step-2], wineVol[step-1]);
            else if(step == 3) maxVols[step] = wineVol[step] + max(maxVols[step-2], wineVol[step-1] + maxVols[step-3]);
            else maxVols[step] = wineVol[step] + max(maxVols[step-2], wineVol[step-1] + maxVols[step-3], wineVol[step-1] + maxVols[step-4]);
            if(maxVols[step] > maxVol) maxVol = maxVols[step];
            return findMaxVol(step + 1);
        }else{
            return maxVol;
        }
    }
    private static int max(int ...nums){
        if(nums.length == 0) return 0;
        int max = nums[0];
        for(int num : nums) if(num > max) max = num;
        return max;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        wineVol = new int[size];
        maxVols = new int[size];
        for(int i = 0; i < size; i++) wineVol[i] = sc.nextInt();
        System.out.println(findMaxVol(0));
        sc.close();
    }
}
