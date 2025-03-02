package AC_iteration;
//빠른 덧셈
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
//BufferedReader 대신 System.in.read()로 입력
//메모리 49512KB, 시간 540ms
//BufferedReader보다 낫다.
public class Main_15552_1 {
    private static int input() throws Exception{
        int a = 0;
        int result = 0;
        while(true){
            a = System.in.read();
            //if(a == 10) continue;
            if(a < '0' || a > '9') return result;
            result *= 10;
            result += a - '0';
        }
    }
    public static void main(String[] args) throws Exception {        
        int cnt = input();
        int a, b;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < cnt; i++){
            a = input();
            b = input();
            bw.write(a+b + "\n");
        }
        bw.flush();
        bw.close();
    }
}
