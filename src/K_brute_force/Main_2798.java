package K_brute_force;

public class Main_2798 {

    private static int input() throws Exception{
        int tmp;
        int result = 0;
        while(true){
            tmp = System.in.read();
            if(tmp > '9' || tmp < '0') return result;
            result *= 10;
            result += tmp - '0';
        }
    }
    private static int findLeastSum(int[] card, int m){
        boolean[] check = new boolean[card.length];

        return 
    }

    private static int findLeastSum(int[] card, boolean check, int m, int pos, int step, int min){
        if(step == 0){
            return min;
        }else{
            return min;
        }        
    }
    
    public static void main(String[] args) throws Exception{
        int n = input();
        int m = input();
        int sum = 0;
        int mean = m;
        int[] card = new int[n];
        for(int i = 0; i < n; i++){
            card[i] = input();
        }
        

    }
}
