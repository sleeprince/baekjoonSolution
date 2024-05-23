package E_Letter;
// 문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.
// 입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 각 테스트 케이스는 한 줄에 하나의 문자열이 주어진다. 문자열은 알파벳 A~Z 대문자로 이루어지며 알파벳 사이에 공백은 없으며 문자열의 길이는 1000보다 작다.
public class Main_9086 {
    private static char[] inputString() throws Exception{
        char[] result = new char[1001];
        for(int i = 0; i < 1001; i++){
            result[i] = (char)System.in.read();
            // if(result[i] == 10) {
            //     i--;
            //     continue;
            // }
            if(result[i] < 'A' || result[i] > 'z'){
                result[i] = 0;
                return result;
            }
        }
        return result;
    }
    private static int stringLength(char[] str){
        int n = 0;
        for(; n < 1001; n++){
            if(str[n] == 0) return n;
        }
        return 1001;
    }
    private static int inputInt() throws Exception{
        int tmp;
        int result = 0;
        while(true){
            tmp = System.in.read();
            //if(tmp == 10) continue;        
            if(tmp > '9' || tmp < '0') return result;
            result *= 10;
            result += tmp - '0';
        }
    }
    public static void main(String[] args) throws Exception{
        int n = inputInt();
        char[] str;
        for(int i = 0; i < n; i++){
            str = inputString();
            System.out.println(str[0]+""+str[stringLength(str)-1]);
        }
    }
}
