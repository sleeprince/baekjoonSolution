package E_Letter;
// 단어 $S$와 정수 $i$가 주어졌을 때, $S$의 $i$번째 글자를 출력하는 프로그램을 작성하시오.
public class Main_27866_1 {

    private static char[] inputString() throws Exception{
        char[] result = new char[1000];
        for(int i = 0; i < 1000; i++){
            result[i] = (char)System.in.read();
            //if(result[i] == 10) continue;
            if(result[i] < 'A' || result[i] > 'z'){
                result[i] = 0;
                return result;
            }
        }
        return result;
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
        char[] str = inputString();
        int num = inputInt();
        System.out.print(str[num-1]);
    } 
}
