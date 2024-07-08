package N_set_map;
// 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
// 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
// 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
// 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_10816 {
    public static class MyInteger {
        private int value;
        public MyInteger(){
            this.value = 0;
        }
        public MyInteger(int num){
            this.value = num;
        }
        public MyInteger(String str){
            this.value = Integer.parseInt(str);
        }
        public int getValue(){
            return this.value;
        }
        public void setValue(int num){
            this.value = num;
        }
        public void setValue(String str){
            setValue(Integer.parseInt(str));
        }
        public void incrementValue(){
            this.value++;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Map<String, MyInteger> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            String num = st.nextToken();
            if(map.containsKey(num)){                
                map.get(num).incrementValue();
            }else{
                MyInteger times = new MyInteger(1);
                map.put(num, times);
            }            
        }
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            String num = st2.nextToken();
            if(map.containsKey(num))
                bw.write(map.get(num).getValue() + " ");
            else
                bw.write("0 ");
        }
        bw.flush();
        bw.close();
    }
}
