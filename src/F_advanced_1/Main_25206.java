package F_advanced_1;
import java.util.Scanner;
public class Main_25206 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        double sumOfCredit = 0;
        double sumOfScore = 0;
        double credit, score;
        String atof;
        for(int i = 0; i < 20; i++){
            sc.next();
            credit = sc.nextDouble();
            sumOfCredit += credit;
            atof = sc.next();
            if(atof.equals("A+")){
                score = 4.5d;
            }else if(atof.equals("A0")){
                score = 4.0d;
            }else if(atof.equals("B+")){
                score = 3.5d;
            }else if(atof.equals("B0")){
                score = 3.0d;
            }else if(atof.equals("C+")){
                score = 2.5d;
            }else if(atof.equals("C0")){
                score = 2.0d;
            }else if(atof.equals("D+")){
                score = 1.5d;
            }else if(atof.equals("D0")){
                score = 1.0d;
            }else if(atof.equals("F")){
                score = 0.0d;
            }else if(atof.equals("P")){
                score = 0.0d;
                sumOfCredit -= credit;
            }else{
                score = 0.0d;
            }
            
            sumOfScore += credit*score;
        }
        System.out.print(sumOfScore/sumOfCredit);
        sc.close();
    }
}
