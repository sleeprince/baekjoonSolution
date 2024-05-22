package D_1dim_array;
// 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

// 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
// 둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.

// X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
public class Main_1087 {
    private static int input() throws Exception{
        int a = 0;
        int result = 0;
        while(true){
            a = System.in.read();
            if(a == 10) continue;
            if(a < '0' || a > '9') return result;
            result *= 10;
            result += a - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        int n = input();
        int x = input();
        int tmp;
        for(int i = 0; i < n;i++){
            tmp = input();
            if(tmp < x) System.out.print(tmp + " ");
        }

    }
}
