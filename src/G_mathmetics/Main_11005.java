package G_mathmetics;

import java.util.Scanner;

public class Main_11005 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String result = "";
        int num = sc.nextInt();
        int n = sc.nextInt();
        char digit = 0;
        int tmp;
        while(num > 0){
            tmp = num%n;
            num /= n;
            if(tmp >= 0 && tmp <= 9){
                digit = (char)(tmp + '0');
            }else if(tmp >= 10 && tmp < 36){
                digit = (char)(tmp + 'A' - 10);
            }
            result = digit + result;
        }       
        System.out.print(result);
        sc.close();
    }
}
