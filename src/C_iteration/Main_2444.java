package C_iteration;
// 별 찍기-7
import java.util.Scanner;

public class Main_2444 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
	    int len = sc.nextInt();
	    for(int i = 0; i < len; i++) {
	    	for(int j = 0; j < len + i; j++) {
	    		if(j >= len - i - 1 && j <= len + i - 1) {
	    			System.out.print("*");
	    		}else {
	    			System.out.print(" ");
	    		}
	    	}
	    	System.out.println();
	    }
	    for(int i = 1; i < len; i++) {
	    	for(int j = 0; j < 2*len -  i - 1 ; j++) {
	    		if(j < i || j > 2*len - i - 2) {
	    			System.out.print(" ");
	    		}else {
	    			System.out.print("*");
	    		}
	    	}
	    	System.out.println();
	    }
        sc.close();
	}    
}
