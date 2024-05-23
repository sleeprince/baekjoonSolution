package E_Letter;
// 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
// QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

// 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다. 

// 각 테스트 케이스에 대해 P를 출력한다.
public class Main_2675 {

    private static char[] inputString() throws Exception{
        char[] result = new char[1000];
        for(int i = 0; i < 1000; i++){
            result[i] = (char)System.in.read();
            //if(result[i] == 10) continue;
            if(result[i] < '!' || result[i] > '~'){
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
            if(tmp == 10) continue;        
            if(tmp > '9' || tmp < '0') return result;
            result *= 10;
            result += tmp - '0';
        }
    }

    public static void main(String[] args) throws Exception{
        int n = inputInt();
        int cnt;
        char[] str;
        for(int i = 0; i < n; i++){
            cnt = inputInt();
            str = inputString();
            for(int j = 0; j < stringLength(str); j++){
                for(int k = 0; k < cnt; k++){
                    System.out.print(str[j]);
                }
            }
            System.out.println("");
        }
    }
}
