package D_1dim_array;
// N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

// 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
// 첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

public class Main_10818 {
    private static int input() throws Exception{
        int a = 0;
        int result = 0;
        int neg = 1;        
        while(true){
            a = System.in.read();
            if(a == 45){
                neg = -1;
                continue;
            }else if(a > '9' || a < '0'){
                return result*neg;
            }
            result *= 10;
            result += a - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        int n = input();
        int tmp;
        int min = 1000000;
        int max = -1000000;
        for(int i = 0; i < n; i++){
            tmp = input();
            if(min > tmp) min = tmp;
            if(max < tmp) max = tmp;
        }
        System.out.print(min + " " + max);
    }
}
