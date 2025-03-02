package AC_iteration;
//별 찍기-2
public class Main_2439 {
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
        for(int i = cnt; i > 0; i--){
            for(int j = 1; j <= cnt; j++){
                if(i<=j){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}
