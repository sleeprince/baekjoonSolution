package AA_input_output_arithmetic;
// 꼬마 정민이는 이제 A + B 정도는 쉽게 계산할 수 있다. 이제 A + B + C를 계산할 차례이다!
// 첫 번째 줄에 A, B, C (1 ≤ A, B, C ≤ 1012)이 공백을 사이에 두고 주어진다.
// A+B+C의 값을 출력한다.

public class Main_11382 {
    private static long input() throws Exception{
        int k = 0;
        long result = 0;
        while(true){
            k = System.in.read();
            if(k > '9' || k < '0') return result;
            result *= 10;
            result += (k - '0');
        }
    }
    public static void main(String[] args) throws Exception{
        long a = input();
        long b = input();
        long c = input();
        System.out.print(a + b + c);
    }
}
