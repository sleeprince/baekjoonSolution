package AM_sort;
// 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
// 1. 길이가 짧은 것부터
// 2. 길이가 같으면 사전 순으로
// 단, 중복된 단어는 하나만 남기고 제거해야 한다.

// 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.
// 조건에 따라 정렬하여 단어들을 출력한다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1181_1 {
    // 알파벳 순서로 정렬, arr: 정렬할 배열, num: 정렬할 문자열 자릿수
    private static String[] countingSort(String[] arr, int num){
        String[][] alph = new String[27][arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i].length() <= num){
                int j = 0;
                while(alph[0][j] != null) j++;
                alph[0][j] = arr[i];
            }else{
                int j = 0;
                while(alph[arr[i].charAt(num) - 'a' + 1][j] != null) j++;
                alph[arr[i].charAt(num) - 'a' + 1][j] = arr[i];
            }
        }
        int loc = 0;
        for(int i = 0; i < 27; i++){
            for(int k = 0; k < arr.length; k++){
                if(alph[i][k] == null) break;
                arr[loc] = alph[i][k];
                loc++;
            }
        }
        return arr;
    }
    // 문자열 길이 순서로 정렬
    private static String[] countingSort(String[] arr){
        String[][] len = new String[51][arr.length];
        for(int i = 0; i < arr.length; i++){
            int j = 0;
            while(len[arr[i].length()][j] != null) j++;
            len[arr[i].length()][j] = arr[i];
        }
        int loc = 0;
        for(int i = 0; i < 51; i++){
            for(int k = 0; k < arr.length; k++){
                if(len[i][k] == null) break;
                arr[loc] = len[i][k];
                loc++;
            }
        }
        return arr;
    }
    // 중복 문자열 제외하고 출력
    private static void printArray(String[] arr) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(arr[0] + "\n");
        for(int i = 1; i < arr.length; i++){
            if(arr[i].equals(arr[i-1])) continue;
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int cnt = Integer.parseInt(br.readLine());
        String[] arr = new String[cnt];
        for(int i = 0; i < arr.length; i++)
            arr[i] = br.readLine();
        for(int i = 49; i > -1; i--)
            arr = countingSort(arr, i);
        arr = countingSort(arr);
        printArray(arr);        
    }
}
