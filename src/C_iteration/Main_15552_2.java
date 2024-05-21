package C_iteration;
//빠른 덧셈
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//System.in.read() 대신 BufferedReader로 입력
//메모리 236280KB, 시간 868ms
//System.in.read()가 낫다.
public class Main_15552_2 {
    public static void main(String[] args) throws Exception {        
        int a, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bw.write(a+b + "\n");            
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
