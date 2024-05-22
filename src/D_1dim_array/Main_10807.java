package D_1dim_array;
//총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.

// 첫째 줄에 정수의 개수 N(1 ≤ N ≤ 100)이 주어진다. 둘째 줄에는 정수가 공백으로 구분되어져있다. 
// 셋째 줄에는 찾으려고 하는 정수 v가 주어진다. 입력으로 주어지는 정수와 v는 -100보다 크거나 같으며, 100보다 작거나 같다.
public class Main_10807 {
    private static int input() throws Exception {
        int a = 0;
        int result = 0;
        int neg = 1;
        while(true){
            a = System.in.read();
            //if(a == 10) continue;
            if(a == 45) {
                neg = -1;
                continue;
            }else if(a < '0' || a > '9') {
                return result*neg;
            }
            result *= 10;
            result += a - '0';            
        }
    }
    //배열에 직접 대응 O(n)
    public static void main(String[] args) throws Exception{
        int cnt = input();
        int[] arr = new int[201];
        int tmp, num;
        for(int i = 0; i < cnt; i++){
            tmp = input() + 100;
            arr[tmp]++;
        }
        num = input() + 100;
        System.out.print(arr[num]);
    }
}
