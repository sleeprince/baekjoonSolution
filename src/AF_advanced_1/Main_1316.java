package AF_advanced_1;
// 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
// 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

// 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 단어가 들어온다. 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
public class Main_1316 {

    private static boolean checkGroupWord(char[] str){
        boolean[] arr = new boolean[26];
        return checkGroupWord(str, arr, 0);
    }

    private static boolean checkGroupWord(char[] str, boolean[] arr, int pos){
        if(str[pos] == 0){
            return true;
        }else{
            if(str[pos] == str[pos + 1]){
                pos++;
                return checkGroupWord(str, arr, pos);
            }else if(arr[str[pos] - 'a']){
                return false;
            }else{
                arr[str[pos] - 'a'] = true;
                pos++;
                return checkGroupWord(str, arr, pos);
            }
        }
    }

    private static char[] inputString() throws Exception{
        char[] result = new char[101];
        char tmp;
        for(int i = 0; i < 101; i++){
            tmp = (char)System.in.read();
            if(tmp == 10) {
                i--;
                continue;
            }
            if(tmp < 'a' || tmp > 'z'){
                result[i] = 0;
                return result;
            }
            result[i] = tmp;
        }
        return result;
    }

    private static int inputInt() throws Exception{
        int result = 0;
        int tmp;
        while(true){
            tmp = System.in.read();
            if(tmp < '0' || tmp > '9') return result;
            result *= 10;
            result += tmp - '0';
        }
    }

    public static void main(String[] args) throws Exception{
        int cnt = inputInt();
        int result = 0;
        char[] str = new char[1];
        for(int i = 0; i < cnt; i++){
            str = inputString();
            if(checkGroupWord(str)) result++;
        }
        System.out.print(result);
    }
}
