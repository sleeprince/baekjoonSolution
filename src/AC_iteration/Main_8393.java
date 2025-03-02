package AC_iteration;
// n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
// 첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
// 1부터 n까지 합을 출력한다.
public class Main_8393 {
    private static int input() throws Exception{
        int a = 0;
        int result = 0;
        while(true){
            a = System.in.read();
            if(a < '0' || a > '9') return result;
            result *= 10;
            result += a - '0';
        }
    }
    public static void main(String[] args) throws Exception {
        int cnt = input();
        System.out.print(cnt*(cnt+1)/2);
    }
}
