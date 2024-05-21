package C_iteration;
//별 찍기-1
public class Main_2438 { 
    private static int input() throws Exception{
        int a = 0;
        int result = 0;
        while(true){
            a = System.in.read();
            if(a < '0' || a > '9') return result;
            result *= 10;
            result += a - '0';
        }
    }
    public static void main(String[] args) throws Exception {
        int cnt = input();
        for(int i = 0; i < cnt; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
