package AE_Letter;
//알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.
// 첫째 줄에 영어 소문자와 대문자로만 이루어진 단어가 주어진다. 단어의 길이는 최대 100이다.
public class Main_2743 {
    private static char[] inputString() throws Exception{
        char[] result = new char[101];
        for(int i = 0; i < 101; i++){
            result[i] = (char)System.in.read();
            if(result[i] == 10) continue;
            if(result[i] < 'A' || result[i] > 'z'){
                result[i] = 0;
                return result;
            }
        }
        return result;
    }
    public static void main(String[] args) throws Exception{
        char[] str = inputString();        
        for(int i = 0; i < 101; i++){
            if(str[i] == 0){
                System.out.print(i);
                break;
            }   
        }
    }

}
