package E_Letter;
// N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
// 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
// 입력으로 주어진 숫자 N개의 합을 출력한다.
public class Main_11720 {
        private static int inputInt() throws Exception{
            int tmp;
            int result = 0;
            while(true){
                tmp = System.in.read();     
                if(tmp > '9' || tmp < '0') return result;
                result *= 10;
                result += tmp - '0';
            }
        }
        public static void main(String[] args) throws Exception{
            int cnt = inputInt();
            int sum = 0;
            for(int i = 0; i < cnt; i++){
                sum += System.in.read() - '0';
            }
            System.out.print(sum);
        }
}
