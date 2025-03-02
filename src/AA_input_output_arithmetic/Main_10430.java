package AA_input_output_arithmetic;
// A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
// (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
// 세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.

// 첫째 줄에 A, B, C가 순서대로 주어진다. (2 ≤ A, B, C ≤ 10000)
// 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.

public class Main_10430 {
    private static int input() throws Exception{
        int result = 0;
        int a = 0;
        while(true){
            a = System.in.read();
            if(a > '9' || a < '0') return result;
            result *= 10;
            result += (a - '0');
        }
    }
    public static void main(String[] args) throws Exception{
        int a = input();
        int b = input();
        int c = input();
        System.out.println((a+b)%c);
        System.out.println(((a%c) + (b%c))%c);
        System.out.println((a*b)%c);
        System.out.println(((a%c) * (b%c))%c);
    }
}
