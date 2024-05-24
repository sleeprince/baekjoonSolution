package E_Letter;
// 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
// 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
// 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
public class Main_1175 {
    public static void main(String[] args) throws Exception{
        int[] alph = new int[26];
        int lttr = 0;
        int max = 0;
        boolean flag = false;
        for(int i = 0; i < 1000000; i++){
            lttr = System.in.read();
            if(lttr > 'z' || lttr < 'A'){
                break;
            }else if(lttr <= 'z' && lttr >= 'a'){
                alph[lttr - 'a']++;
            }else if(lttr <= 'Z' && lttr >= 'A'){
                alph[lttr - 'A']++;
            }            
        }
        for(int i = 0; i < 26; i++){
            if(alph[i] == 0){
                continue;
            }else if(alph[i] == max){
                flag = true;
            }else if(alph[i] > max){
                max = alph[i];
                lttr = i + 'A';
                flag = false;
            }
        }
        if(flag){
            System.out.print("?");
        }else{
            System.out.print((char)lttr);
        }
    }

}
