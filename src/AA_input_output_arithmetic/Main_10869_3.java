package AA_input_output_arithmetic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10869_3 {
    private static int a;
    private static int b;
    //입출력을 Buffered*로 받고 보냄
    //메모리 15916KB 시간 144ms
    //준수한 메모리 크기 및 속도
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        a = Integer.parseInt(tk.nextToken());
        b = Integer.parseInt(tk.nextToken());
        bw.write(a+b + "\n");
        bw.write(a-b + "\n");
        bw.write(a*b + "\n");
        bw.write(a/b + "\n");
        bw.write(a%b + "\n");
        bw.flush();
        bw.close();
    }
}
