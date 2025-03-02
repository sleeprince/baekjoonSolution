package AF_advanced_1;
// 알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
// 팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. 
// level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.

// 첫째 줄에 단어가 주어진다. 단어의 길이는 1보다 크거나 같고, 100보다 작거나 같으며, 알파벳 소문자로만 이루어져 있다.

// 첫째 줄에 팰린드롬이면 1, 아니면 0을 출력한다.
public class Main_10988 {
    public static void main(String[] args) throws Exception{
        char[] ch = new char[100];
        int length = 0;
        int result = 1; //한 글자일 때 default
        for(int i = 0; i < 100; i++){
            ch[i] = (char)System.in.read();
            if(ch[i] > 'z' || ch[i] < 'a'){
                length = i - 1;
                break;
            }
        }
        for(int i = 0; i < length - i; i++){
            if(ch[i] == ch[length - i]){
                result = 1;
            }else{
                result = 0;
                break;
            }
        }
        System.out.print(result);
    }
}
