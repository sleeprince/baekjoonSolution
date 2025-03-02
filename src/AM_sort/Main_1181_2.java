package AM_sort;
// 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
// 1. 길이가 짧은 것부터
// 2. 길이가 같으면 사전 순으로
// 단, 중복된 단어는 하나만 남기고 제거해야 한다.

// 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
// 조건에 따라 정렬하여 단어들을 출력한다.

public class Main_1181_2 {
//char 배열로
    private static final int max_len = 50;
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

    private static char[][] countingSortByAlph(char[][] arr, int num){
        char[][][] alph = new char[27][arr.length][max_len];
        for(int i = 0; i < arr.length; i++){
            if(arr[i][num] == 0){
                int j = 0;
                while(alph[0][j][0] != 0) j++;
                for(int k = 0; k < max_len; k++)
                    alph[0][j][k] = arr[i][k];
            }else{
                int j = 0;
                while(alph[arr[i][num] - 'a' + 1][j][0] != 0) j++;
                for(int k = 0; k < max_len; k++)
                    alph[arr[i][num] - 'a' + 1][j][k] = arr[i][k];
            }
        }
        int loc = 0;
        for(int i = 0; i < 27; i++){
            if(alph[i][0][0] == 0) continue;
            for(int j = 0; j < arr.length; j++){
                if(alph[i][j][0] == 0) break;
                for(int k = 0; k < max_len; k++){                
                    arr[loc][k] = alph[i][j][k];
                }
                loc++;
            }
        }
        return arr;
    }

    private static char[][] countingSortByLen(char[][] arr){
        char[][][] len = new char[max_len][arr.length][max_len];
        for(int i = 0; i < arr.length; i++){
            int size = 0;
            int j = 0;
            while(arr[i][size] != 0) size++;
            while(len[size-1][j][0] != 0) j++;
            for(int k = 0; k < size; k++)
                len[size-1][j][k] = arr[i][k];
        }
        int loc = 0;
        for(int i = 0; i < max_len; i++){
            if(len[i][0][0] == 0) continue;
            for(int j = 0; j < arr.length; j++){
                if(len[i][j][0] == 0) break;
                for(int k = 0; k < max_len; k++){                
                    arr[loc][k] = len[i][j][k];
                }
                loc++;
            }
        }
        return arr;
    }

    private static void printArray(char[][] arr){
        for(int i = 0; i < arr.length; i++){
            int j = 0;
            if(i > 0 && matchString(arr[i], arr[i-1])) continue;
            System.out.print(i + ": ");
            while(arr[i][j] != 0){
                System.out.print(arr[i][j]);
                j++;
            }
            System.out.println();
        }
    }

    private static boolean matchString(char[] a, char[] b){
        int i = 0;
        while(i < a.length && i < b.length){
            if(a[i] != b[i]) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{ 
           
        int cnt = inputInt();
        System.in.read();
        char tmp;
        char[][] str = new char[cnt][50];
        for(int i = 0; i < cnt; i++){
            for(int j = 0; j < 50; j++)
                str[i][j] = 0;
            for(int j = 0; j < 50; j++){
                tmp = (char)System.in.read();
                if(tmp > 'z' || tmp < 'a') {
                    System.in.read();
                    break;
                }
                str[i][j] = tmp;
            }
        }
        for(int i = max_len-1; i >= 0; i--)
            str = countingSortByAlph(str, i);

        str = countingSortByLen(str);
        printArray(str);
    }
}
