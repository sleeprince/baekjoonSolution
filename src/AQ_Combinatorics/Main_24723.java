package AQ_Combinatorics;

import java.util.Scanner;

public class Main_24723 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 1;
        for(int i = 0; i < n; i++) result *= 2;
        System.out.println(result);
        sc.close();
    }
}
