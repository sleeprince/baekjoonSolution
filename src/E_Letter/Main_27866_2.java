package E_Letter;
// 단어 $S$와 정수 $i$가 주어졌을 때, $S$의 $i$번째 글자를 출력하는 프로그램을 작성하시오.
import java.util.Scanner;

public class Main_27866_2{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        System.out.print(str.charAt(n-1));
        sc.close();
    }
}