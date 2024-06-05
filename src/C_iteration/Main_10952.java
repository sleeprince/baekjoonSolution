package C_iteration;

// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

// 입력은 여러 개의 테스트 케이스로 이루어져 있다.
// 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
// 입력의 마지막에는 0 두 개가 들어온다.

// 각 테스트 케이스마다 A+B를 출력한다.

public class Main_10952 {
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
    public static void main(String[] args) throws Exception{
        int a, b;
        while(true){
            a = input();
            b = input();
            if(a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }
}
