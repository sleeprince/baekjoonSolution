package A_input_output_arithmetic;

import java.util.Scanner;

public class Main_10869_2{
    private static int a;
    private static int b;
    //input을 Scanner로 받음
    //메모리 17696KB 시간 212ms
    //세 가지 입력 메소드 가운데 가장 느리다.
    public static void main(String[] args) throws Exception{
        Scanner num = new Scanner(System.in);
        a = num.nextInt();
        b = num.nextInt();
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        num.close();
    }
}