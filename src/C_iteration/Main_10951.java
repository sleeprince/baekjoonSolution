package C_iteration;
//EOF 문제
import java.util.Scanner;

public class Main_10951{
    public static void main(String[] args) throws Exception{
        int a, b;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a + b);
        }
        sc.close();
    }
}
