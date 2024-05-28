package E_Letter;
// 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
// 크로아티아 알파벳	변경
// č	c=
// ć	c-
// dž	dz=
// đ	d-
// lj	lj
// nj	nj
// š	s=
// ž	z=
// 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
// dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.

// 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
// 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.

// 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

public class Main_2941 {
    //메인에 넣을 함수
    private static int countAlphabet(char ch[]){
        return countAlphabet(ch, 0, 0);
    }

    private static int countAlphabet(char ch[], int pos, int len){
        if(ch[pos] == 0){
            return len;
        }else{
            if(ch[pos] == 'c' && ch[pos+1] == '='){
                len++;
                pos += 2;
                return countAlphabet(ch, pos, len);
            }else if(ch[pos] == 'c' && ch[pos+1] == '-'){
                len++;
                pos += 2;
                return countAlphabet(ch, pos, len);
            }else if(ch[pos] == 'd' && ch[pos+1] == 'z' && ch[pos+2] == '='){
                len++;
                pos += 3;
                return countAlphabet(ch, pos, len);
            }else if(ch[pos] == 'd' && ch[pos+1] == '-'){
                len++;
                pos += 2;
                return countAlphabet(ch, pos, len);                
            }else if(ch[pos] == 'l' && ch[pos+1] == 'j'){
                len++;
                pos += 2;
                return countAlphabet(ch, pos, len);
            }else if(ch[pos] == 'n' && ch[pos+1] == 'j'){
                len++;
                pos += 2;
                return countAlphabet(ch, pos, len);
            }else if(ch[pos] == 's' && ch[pos+1] == '='){
                len++;
                pos += 2;
                return countAlphabet(ch, pos, len);
            }else if(ch[pos] == 'z' && ch[pos+1] == '='){
                len++;
                pos += 2;
                return countAlphabet(ch, pos, len);
            }else{
                len++;
                pos++;
                return countAlphabet(ch, pos, len);
            }
        }
    }

    private static char[] inputString() throws Exception{
        char[] result = new char[101];
        char tmp;
        for(int i = 0; i < 101; i++){
            tmp = (char)System.in.read();
            if(tmp < '!' || tmp > '~'){
                result[i] = 0;
                return result;
            }
            result[i] = tmp;
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        char[] ch = inputString();
        int lengthOfWord = countAlphabet(ch);
        System.out.print(lengthOfWord);
    }

}
